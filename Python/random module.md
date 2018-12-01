## [Python] random 모듈 사용법(난수 생성)
파이썬에서 난수를 만들기 위해서는 random 모듈을 사용해야 한다.   
random 모듈 사용 방법은 다음과 같다.
``` python
>>> import random
>>> random.random()
0.9532140704594995
```
random() 범위는 0.0 이상 1.0 미만의 실수이다.
우선 random 모듈의 관련 함수들을 사용하기 위해서는 import 해줘야 한다.
``` python
import python
```
관련 함수는 아래와 같다.
- random() : **0.0 이상 1.0 미만**의 실수(Float)를 반환
- randint(1, 10) : **1 이상 10 이하**의 정수(Int)를 반환
- randrange(1, 10, 2) : **1이상 10 미만 2의 배수**를 반환
- choice([1,2,3,4,5]) : 리스트에 있는 값 중 하나를 반환
- sample(range(1, 10), 5) : **1 이상 10 미만의 5개 값을 중복 없이** 리스트 형식으로 반환
- shuffle(L) : 전달받은 시퀀스 자료형 변수 내용을 랜덤으로 섞는다 (변수 내용 바뀜)

이를 이용하여 로또 프로그램을 만들어볼 수 있다.
### 로또 프로그램
``` python
import random

def getNumber() :
    return random.randrange(1, 46)

lotto = []

## 메인 코드 부분
print("** 로또 추첨을 시작합니다. **\n")

while True :
    num = getNumber()
    if lotto.count(num) == 0 :
        lotto.append(num)
    if len(lotto) >= 6 :
        break

print("추첨된 로또 번호 ==> ", end = '')
lotto.sort()
for i in range(0, 6) :
    print("%-5d" % lotto[i], end = '')
```
#### Output
```
** 로또 추첨을 시작합니다. **

추첨된 로또 번호 ==> 1    2    7    16   24   32 
```