# 4.2.4
import numpy as np

def cross_entropy_error(y, t) :
    if y.ndim == 1:
        t = t.reshape(1, t.size)
        y = y.reshape(1, y.size)

    batch_size = y.shape[0]
    #return -np.sum(t * np.log(y)) / batch_size
    return -np.sum(np.log(y[np.arange(batch_size), t])) / batch_size