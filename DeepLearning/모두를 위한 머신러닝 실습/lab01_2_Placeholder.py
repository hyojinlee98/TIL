import tensorflow as tf

'''
a = tf.placeholder(tf.float32)
b = tf.placeholder(tf.float32)

adder_node = a + b

tf.print(adder_node, feed_dict={a:3, b:4.5})
tf.print(adder_node, feed_dict={a:[1,3], b:[2,4]})
'''

@tf.function
def adder(a1, a2) :
    return a1 + a2

a = tf.constant(1.0)
b = tf.constant(2.0)
print(adder(a,b))
tf.print(adder(a,b))

c = tf.constant([1,2])
d = tf.constant([3,4])
print(adder(c,d))
tf.print(adder(c,d))

e = tf.constant([[1,2,3], [4,5,6]])
f = tf.constant([[2,3,4], [5,6,7]])
print(adder(e, f))
tf.print(adder(e,f))
