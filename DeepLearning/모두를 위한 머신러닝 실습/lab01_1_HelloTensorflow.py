# Create a constant op
# This op is added as a node to the default graph

import tensorflow as tf

hello = tf.constant("Hello, TensorFlow!")

# seart a TF session
#sess = tf.Session()

# run the op and get result
#print(sess.run(hello))
tf.print(hello)
