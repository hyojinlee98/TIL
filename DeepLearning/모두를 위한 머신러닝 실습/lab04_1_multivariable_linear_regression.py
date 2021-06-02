import tensorflow as tf
import numpy as np

x_data = [[73., 80., 75.],
          [93., 88., 93.],
          [89., 91., 90.],
          [96., 98., 100.],
          [73., 66., 70.]]
y_data = [[152.],
          [185.],
          [180.],
          [196.],
          [142.]]

tf.model = tf.keras.Sequential()

# input_dim=3은 multi-variable regression 제공
tf.model.add(tf.keras.layers.Dense(units=1, input_dim=3))
# linear activation이 기본값이므로, 생략해도 됨
tf.model.add(tf.keras.layers.Activation('linear'))

# loss/cost 함수, mse는 mean_squared_error / SGD는 확률적 경사 하강법
tf.model.compile(loss='mse', optimizer=tf.keras.optimizers.SGD(lr=1e-5))
tf.model.summary()
# 트레이닝
history = tf.model.fit(x_data, y_data, epochs=1000)

# 해당 값에 따른 y의 값 예상
y_predict = tf.model.predict(np.array([[72., 93., 90.]]))
print(y_predict)