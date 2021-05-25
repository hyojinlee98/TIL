import numpy as np

def softmax(a) :
    c = np.max(a)
    exp_a = np.exp(a - c)   # 오버플로 대책
    sum_exp_a = np.sum(exp_a)
    y = exp_a / sum_exp_a

    return y
    
    
    