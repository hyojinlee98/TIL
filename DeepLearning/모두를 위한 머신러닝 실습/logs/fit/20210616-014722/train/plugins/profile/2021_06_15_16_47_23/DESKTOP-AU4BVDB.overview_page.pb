� 	?�Ң>	�??�Ң>	�?!?�Ң>	�?	��dU��@��dU��@!��dU��@"{
=type.googleapis.com/tensorflow.profiler.PerGenericStepDetails:?�Ң>	�?��u?T�?A�������?Y�z�΅�?rEagerKernelExecute 0*	�&1���@2f
/Iterator::Model::ParallelMapV2::Zip[0]::FlatMaph@�5_�?!�݅w��O@) Uܸ���?1�����M@:Preprocessing2u
>Iterator::Model::ParallelMapV2::Zip[0]::FlatMap::Prefetch::Map�ص�ݒ�?!�����<@)b�aL�{�?1%*o�!�6@:Preprocessing2�
LIterator::Model::ParallelMapV2::Zip[0]::FlatMap::Prefetch::Map::FiniteRepeatc'���?!��I�2@)����n�?1�ʔ�P2@:Preprocessing2U
Iterator::Model::ParallelMapV2c��V��?!;��@)c��V��?1;��@:Preprocessing2v
?Iterator::Model::ParallelMapV2::Zip[0]::FlatMap[4]::Concatenate@a��+�?!|�<�g@)���8��?1%��fK� @:Preprocessing2p
9Iterator::Model::ParallelMapV2::Zip[0]::FlatMap::Prefetch�4-�2�?!V�%�n��?)�4-�2�?1V�%�n��?:Preprocessing2F
Iterator::Model2�=B͐�?!��ی��@)=���m�?1 w�x�B�?:Preprocessing2l
5Iterator::Model::ParallelMapV2::Zip[1]::ForeverRepeat.v��2S�?!'5��'��?)���	.V�?1����?:Preprocessing2v
?Iterator::Model::ParallelMapV2::Zip[0]::FlatMap[5]::Concatenate��D��?!��\ln�?)��Aȗ�?1!U�H�?:Preprocessing2Z
#Iterator::Model::ParallelMapV2::Zip�J&���?!�ڹ�\iP@)2t�w?1�{����?:Preprocessing2x
AIterator::Model::ParallelMapV2::Zip[1]::ForeverRepeat::FromTensor����g?!������?)����g?1������?:Preprocessing2�
SIterator::Model::ParallelMapV2::Zip[0]::FlatMap::Prefetch::Map::FiniteRepeat::RangeM�7�Q�c?!�M���?)M�7�Q�c?1�M���?:Preprocessing2�
NIterator::Model::ParallelMapV2::Zip[0]::FlatMap[5]::Concatenate[1]::FromTensor���y7T?!�LBvO��?)���y7T?1�LBvO��?:Preprocessing2�
NIterator::Model::ParallelMapV2::Zip[0]::FlatMap[4]::Concatenate[1]::FromTensorfL�g�A?!��p�N�?)fL�g�A?1��p�N�?:Preprocessing2�
OIterator::Model::ParallelMapV2::Zip[0]::FlatMap[5]::Concatenate[0]::TensorSlice����>?!�?� `�?)����>?1�?� `�?:Preprocessing:�
]Enqueuing data: you may want to combine small input data chunks into fewer but larger chunks.
�Data preprocessing: you may increase num_parallel_calls in <a href="https://www.tensorflow.org/api_docs/python/tf/data/Dataset#map" target="_blank">Dataset map()</a> or preprocess the data OFFLINE.
�Reading data from files in advance: you may tune parameters in the following tf.data API (<a href="https://www.tensorflow.org/api_docs/python/tf/data/Dataset#prefetch" target="_blank">prefetch size</a>, <a href="https://www.tensorflow.org/api_docs/python/tf/data/Dataset#interleave" target="_blank">interleave cycle_length</a>, <a href="https://www.tensorflow.org/api_docs/python/tf/data/TFRecordDataset#class_tfrecorddataset" target="_blank">reader buffer_size</a>)
�Reading data from files on demand: you should read data IN ADVANCE using the following tf.data API (<a href="https://www.tensorflow.org/api_docs/python/tf/data/Dataset#prefetch" target="_blank">prefetch</a>, <a href="https://www.tensorflow.org/api_docs/python/tf/data/Dataset#interleave" target="_blank">interleave</a>, <a href="https://www.tensorflow.org/api_docs/python/tf/data/TFRecordDataset#class_tfrecorddataset" target="_blank">reader buffer</a>)
�Other data reading or processing: you may consider using the <a href="https://www.tensorflow.org/programmers_guide/datasets" target="_blank">tf.data API</a> (if you are not using it now)�
:type.googleapis.com/tensorflow.profiler.BottleneckAnalysis�
both�Your program is MODERATELY input-bound because 5.2% of the total step time sampled is waiting for input. Therefore, you would need to reduce both the input time and other time.no*high2t30.1 % of the total step time sampled is spent on 'All Others' time. This could be due to Python execution overhead.9��dU��@I��JW�W@Zno>Look at Section 3 for the breakdown of input time on the host.B�
@type.googleapis.com/tensorflow.profiler.GenericStepTimeBreakdown�
	��u?T�?��u?T�?!��u?T�?      ��!       "      ��!       *      ��!       2	�������?�������?!�������?:      ��!       B      ��!       J	�z�΅�?�z�΅�?!�z�΅�?R      ��!       Z	�z�΅�?�z�΅�?!�z�΅�?b      ��!       JCPU_ONLYY��dU��@b q��JW�W@Y      Y@qe
��6F@"�

both�Your program is MODERATELY input-bound because 5.2% of the total step time sampled is waiting for input. Therefore, you would need to reduce both the input time and other time.b
`input_pipeline_analyzer (especially Section 3 for the breakdown of input operations on the Host)Q
Otf_data_bottleneck_analysis (find the bottleneck in the tf.data input pipeline)m
ktrace_viewer (look at the activities on the timeline of each Host Thread near the bottom of the trace view)"T
Rtensorflow_stats (identify the time-consuming operations executed on the CPU_ONLY)"Z
Xtrace_viewer (look at the activities on the timeline of each CPU_ONLY in the trace view)*�
�<a href="https://www.tensorflow.org/guide/data_performance_analysis" target="_blank">Analyze tf.data performance with the TF Profiler</a>*y
w<a href="https://www.tensorflow.org/guide/data_performance" target="_blank">Better performance with the tf.data API</a>2�
=type.googleapis.com/tensorflow.profiler.GenericRecommendation�
nohigh"t30.1 % of the total step time sampled is spent on 'All Others' time. This could be due to Python execution overhead.2no:
Refer to the TF2 Profiler FAQb�44.4% of Op time on the host used eager execution. Performance could be improved with <a href="https://www.tensorflow.org/guide/function" target="_blank">tf.function.</a>2"CPU: B 