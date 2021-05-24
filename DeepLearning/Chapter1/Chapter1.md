# Chapter 1 헬로 파이썬  

## 1.5 넘파이
넘파이의 배열 클래스인 numpy.array에는 편리한 메소드가 많이 준비되어 있어 딥러닝을 구현할 때 배열이나 행렬 계산에 활용한다.

### 1.5.1 넘파이 가져오기
```python
>>> import numpy as np
```

### 1.5.2 넘파이 배열 생성하기
```python
>>> x = np.array([1.0, 2.0, 3.0])
>>> print(x)
[1. 2. 3.]
>>> type(x)
<class 'numpy.ndarray'>
```
np.array()는 파이썬의 리스트를 인수로 받아 넘파이 라이브러리가 제공하는 특수한 형태의 배열(numpy.ndarray)을 반환한다.

### 1.5.3 넘파이의 산술 연산
```python
>>> x = np.array([1.0, 2.0, 3.0])
>>> y = np.array([2.0, 4.0, 6.0])
>>> x + y   # 원소별 덧셈
array([3., 6., 9.])
>>> x - y   # 원소별 뺄셈
array([-1., -2., -3.])
>>> x * y   # 원소별 곱셈
array([ 2.,  8., 18.])
>>> x / y   # 원소별 나눗셈
array([0.5, 0.5, 0.5])
```
x와 y의 원소 수가 같아야 산술 연산이 각 원소에 대해서 행해진다. 원소 수가 다르면 오류 발생한다.  
넘파이 배열과 수치 하나(스칼라값)의 조합으로 된 산술 연산도 수행할 수 있다.

```python
>>> x = np.array([1.0, 2.0, 3.0]) 
>>> x / 2.0
array([0.5, 1. , 1.5])
```
이 경우 스칼라 값과의 계산이 넘파이 배열의 원소별로 한 번씩 수행된다. 이 기능을 **브로드캐스트**라고 한다.

### 1.5.4 넘파이의 N차원 배열
넘파이는 1차원 배열 뿐 아니라 다차원 배열도 작성할 수 있다. 예를 들어 2차원 배열은 다음처럼 착성한다.
```python
>>> A = np.array([[1,2], [3,4]]) 
>>> print(A)
[[1 2]
 [3 4]]
>>> A.shape
(2, 2)
>>> A.dtype
dtype('int32')
```
2x2의 A라는 행렬을 작성했고, 행렬의 형상(각 차원의 크기(원소 수))은 shape으로, 행렬에 담긴 원소의 자료형은 dtype으로 알 수 있다.
```python
>>> B = np.array([[3, 0], [0, 6]])
>>> A + B
array([[ 4,  2],
       [ 3, 10]])
>>> A * B
array([[ 3,  0],
       [ 0, 24]])
```
형상이 같은 행렬끼리면 행렬의 산술 연산도 대응하는 원소별로 계산된다. 행렬과 스클라값의 산술 연산도 가능하다. 이때도 배열과 마찬가지로 브로드캐스트 기능이 작동된다.

```python
>>> print(A)
[[1 2]
 [3 4]]
>>> A*10
array([[10, 20],
       [30, 40]])
```
### 1.5.5 브로드캐스트
넘파이에서는 형상이 다른 배열끼리도 계산할 수 있다. 앞의 예에서는 2x2 행렬 A에 스칼라값 10을 곱했다.  
그러면 10이라는 스칼라 값이 2x2 행렬로 확대된 후 연산이 이뤄진다. 이 기능을 **브로드캐스트**라고 한다.
```python
>>> A = np.array([[1,2], [3,4]])
>>> B = np.array([10, 20])
>>> A * B
array([[10, 40],
       [30, 80]])
```
### 1.5.6 원소 접근 
``` python
>>> x = np.array([[51, 55], [14, 19], [0, 4]])
>>> print(x)
[[51 55]
 [14 19]
 [ 0  4]]
>>> x[0]
array([51, 55])
>>> x[0][1]
55
```
for 문으로도 각 원소에 접근할 수 있다.
```python
>>> for row in x :
...     print(row)
[51 55]
[14 19]
[0 4]
```

```python
>>> x = x.flatten()     # x를 1차원 배열로 변환(평탄화)
>>> print(x)
[51 55 14 19  0  4]
>>> x[np.array([0, 2, 4])]      # 인덱스가 0, 2, 4인 원소 얻기
array([51, 14,  0])
```
x에서 15 이상인 값만 구할 수 있다.
```python
>>> x
array([51, 55, 14, 19,  0,  4])
>>> x > 15
array([ True,  True, False,  True, False, False])
>>> x[x>15]
array([51, 55, 19])
```
넘파이 배열에 부등호 연산자를 사용한 결과는 bool 배열이다.  
이 bool 배열을 사용해 배열 x에서 True에 해당하는 원소, 즉 값이 15보다 큰 원소만 꺼내고 있다.

## 1.6 matplotlib
딥러닝 실험에서는 그래프 그리기와 데이터 시각화도 중요하다. matplotlib은 그래프를 그려주는 라이브러리이다.

### 1.6.1 단순한 그래프 그리기
그래프를 그리려면 matplotlib의 pyplot 모듈을 이용한다. sin 함수를 그리는 예는 다음과 같다.
```python
import numpy as np
import matplotlib.pyplot as plt

# 데이터 준비
x = np.arange(0, 6, 0.1)      # 0에서 6까지 0.1 간격으로 생성
y = np.sin(x)

# 그래프 그리기
plt.plot(x, y)
plt.show()
```
넘파이의 arange 메서드로 [0, 0.1 0.2, ..., 5.8, 5.9,]라는 데이터를 생성하여 변수 x에 할당했다.  
그다음 줄에서는 x의 각 원소에 넘파이의 sin 함수인 np.sin()을 적용하여 변수 y에 할당한다.  
x와 y를 인수로 plt.plot 메서드를 호출해 그래프를 그리고, plt.show()를 호출해 그래프를 화면에 출력하고 끝난다.

### 1.6.2 pyplot의 기능
제목과 각 축의 이름(레이블) 표시 등 pyplot의 다른 기능을 사용해 cos 함수를 그려볼 수 있다.
```python
import numpy as np
import matplotlib.pyplot as plt

# 데이터 준비
x = np.arange(0, 6, 0.1) # 0에서 6까지 0.1 간격으로 생성
y1 = np.sin(x)
y2 = np.cos(x)

# 그래프 그리기
plt.plot(x, y1, label="sin")
plt.plot(x, y2, linestyle="--", label="cos")    # cos 함수는 점선으로 그리기
plt.xlabel("x") # x축 이름
plt.ylabel("y") # y축 이름
plt.title('sin & cos') # 제목
plt.legend()    # 범례
plt.show()
```

### 1.6.3 이미지 표시하기
pyplot에는 이미지를 표시해주는 메서드인` imshow()`도 있다.  
이미지를 읽어들일 때는 `matplotlib.image` 모듈의 `imread()` 메서드를 이용한다.
```python
import matplotlib.pyplot as plt
from matplotlib.image import imread

img = imread('model.jpg') # 이미지 읽어오기 (적절한 경로 설정)

plt.imshow(img)
plt.show()
```
위의 코드에서는 `model.jpg`라는 이미지 파일이 현재 작업 디렉터리에 있다.  
자신의 환경에 맞게 파일 이름과 경로를 적절히 수정해야 한다.



