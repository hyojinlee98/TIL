import tensorflow as tf
import numpy as np
import matplotlib.pyplot as plt

x_train = [1,2,3,4]
y_train = [1,2,3,4]

model = tf.keras.Sequential()
model.add(tf.keras.layers.Dense(units=1, input_dim=1))

#sgd = tf.keras.optimizers.SGD(lr=1000)  # loss 발산
sgd = tf.keras.optimizers.SGD(lr=0.1)
model.compile(loss='mse', optimizer=sgd)

model.summary()

# fit() trains the model and returns history of train
history = model.fit(x_train, y_train, epochs=100)

y_predict = model.predict(np.array([5]))
print(y_predict)


# Plot training & validation loss values
plt.plot(history.history['loss'])
plt.title('Model loss')
plt.ylabel('Loss')
plt.xlabel('Epoch')
plt.legend(['Train', 'Test'], loc='upper left') # 범례
plt.show()
