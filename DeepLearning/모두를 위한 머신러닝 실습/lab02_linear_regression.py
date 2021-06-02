import tensorflow as tf
import numpy as np

# H(x) = Wx + b
# X and Y data
x_train = [1,2,3,4]
y_train = [0,-1,-2,-3]

'''
W = tf.Variable(tf.random_normal([1]), name='weight')
b = tf.Variable(tf.random_normal([1]), name='bias')

# Our Hypothesis Wx + b
hypothesis = x_train * W + b

# cost/Loss function
cost = tf.reduce_mean(tf.square(hypothesis - y_train))
# reduce_mean() 전체 평균 구함, square() 제곱
'''

# keras의 다차원 계층 모델인 Sequential 모델(순차적으로 레이어층 더해줌)을 만든다.
model = tf.keras.Sequential()

# 입력이 1차원이고 출력이 1차원임을 뜻함 - Dense는 레이어의 종류
# units == output shape, input_dim == input shape
model.add(tf.keras.layers.Dense(units=1, input_dim = 1))

# Optimizer - Stochastic gradient descent - 확률적 경사 하강법
sgd = tf.keras.optimizers.SGD(learning_rate=0.01)

# cost/loss funcion
# loss를 mean_squared_error 방식을 사용한다는 의미로 mse 라고 써도 인식한다.
# mse == mean_squared_error, 1/m * sig (y'-y)^2
model.compile(loss='mean_squared_error',optimizer=sgd)

model.summary()

#fit the line
# 텐서 플로우 1과 다르게 세션을 만들어서 돌릴 필요가 없다.
# 간단하게 만들어서 학습을 시작한다.
model.fit(x_train,y_train,epochs=200)

# x 값이 5면 예상값이 얼마인지 확인하는 부분
print(model.predict(np.array([5])))

