## [Python] 튜플 자료형
튜플 자료형은 리스트와 비슷하다. 리스트가 `[`과 `]`로 둘러싸여 있고, 튜플은 `(`와 `)`로 둘러싸여 있다. 또한 리스트는 생성, 추가, 수정, 삭제 등 값의 변경이 가능 하지만 튜플은 불가능하다.

### 사용 방법
``` python
>>> t1 = () 
>>> t2 = (1,) 
>>> t3 = 1, 
>>> t4 = (1, 2, 3) 
>>> t5 = 1, 2, 3  
>>> t6 = ('a', 'b', ('ab', 'cd'))
```
튜플은 위와 같이 사용하는데 요소가 한 개일 경우 뒤에 콤마를 꼭 붙여야 한다. 콤마 없이 쓰면 변수에 값 대입하는 것과 똑같아 튜플로 인식하지 않는다. 또한 `t3 = 1,` `t4 = 1, 2, 3`처럼 괄호 없이 선언해줄 수도 있다.

### 인덱싱
``` python
>>> t = (1, 2, 3)
>>> t[0]
1
```
리스트와 같이 인덱싱이 가능하다.

### 슬라이싱
``` python
>>> t = (1, 2, 'a', ('aa', 'bb'))
>>> t[:3]
(1, 2, 'a')
>>> t[2:]
('a', ('aa', 'bb'))
```
리스트와 같이 슬라이싱도 가능하다.

### 튜플 더하기
``` python
>>> t1 = (1, 2, 'a', ('aa', 'bb'))
>>> t2 = ('apple', 'banana')
>>> t1 + t2
(1, 2, 'a', ('aa', 'bb'), 'apple', 'banana')
```
튜플끼리 더하면 요소들이 합쳐진다.

### 튜플 곱하기
``` python
>>> t = ('apple', 'banana')
>>> t * 3
('apple', 'banana', 'apple', 'banana', 'apple', 'banana')
```
튜플 곱하기 숫자는 해당 숫자만큼 반복해서 나타낸다.


### 값 수정, 삭제
``` python
>>> t = (1, 2)
>>>> t[0] = 5
Traceback (most recent call last):
  File "<pyshell#17>", line 1, in <module>
    t[0] = 5
TypeError: 'tuple' object does not support item assignment
>>> del(t[0])
Traceback (most recent call last):
  File "<pyshell#16>", line 1, in <module>
    del(t[0])
TypeError: 'tuple' object doesn't support item deletion
```
값을 수정하거나 삭제를 시도하면 오류가 나는 것을 볼 수 있다.  
따라서 값의 수정과 삭제는 불가능하다.