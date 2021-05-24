import numpy as np
import matplotlib.pylab as plt

def step_function(x) :
    '''
    넘파이 배열에 부등호 연산을 수행하면 배열의 원소 각각에 부등호 연산을 수행한 bool 배열 생성
    배열 x의 원소 각각이 0보다 크면 True, 0 이하면 False로 변환한 새로운 배열 y가 생성된다.
    하지만 0이나 1의 'int형'을 출력하는 함수기 때문에 astype() 메서드로 int형으로 바꿔준다.
    '''
    return np.array(x > 0, dtype=np.int)

x = np.arange(-5.0, 5.0, 0.1) 
y = step_function(x)
plt.plot(x, y)
plt.ylim(-0.1, 1.1)     # y축의 범위 지정
plt.show()