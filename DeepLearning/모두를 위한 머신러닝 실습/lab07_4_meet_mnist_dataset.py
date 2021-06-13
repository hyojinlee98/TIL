import tensorflow as tf
import matplotlib.pyplot as plt
# import random

mnist = tf.keras.datasets.mnist
print("mnist download complete")
(x_train, y_train), (x_test, y_test) = mnist.load_data()
x_train, x_test = x_train/255.0, x_test/255.0
print("normalization done")

#linear classifier
model = tf.keras.models.Sequential([
    tf.keras.layers.Flatten(input_shape=(28,28)), #28 by 28 mnist input flatten
    tf.keras.layers.Dense(10,activation='softmax')
])

model.compile(optimizer='SGD',
             loss='sparse_categorical_crossentropy',
             metrics=['accuracy'])

model.fit(x_train, y_train, epochs=5)
model.evaluate(x_test, y_test, verbose=2)

'''
r = random.randint(0, mnist.test.num_examples-1)

plt.imshow(mnist.test.images[r:r + 1].reshape(28, 28), 
            camp='Greys', interpolation='nearest')
plt.show()
'''