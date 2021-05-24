import numpy as np
import matplotlib.pylab as plt

def relu(x) :
    return np.maximum(0, x)

x = np.arange(-6, 5.5, 0.1)
y = relu(x)
plt.plot(x, y)
plt.ylim(-1.5, 5.5)     # y축 범위 지정
plt.show()