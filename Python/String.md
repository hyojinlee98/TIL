
## [Python] 문자열

### 사용 방법
``` python
>>> str = "abc"
>>> print(str[0])
a
>>> print(str[1])
b
>>> print(str[2])
c
```

### 숫자 문자열을 입력 받아 한 자리의 수만큼 하트 출력

``` python
## 변수 선언 부분
i, k, heartNum = 0, 0, 0
numStr, ch, heartStr = "", "", ""

## 메인 코드 부분
numStr = input("숫자를 여러 개 입력하세요 : ")
print()

while i < len(numStr) :
    ch = numStr[i]
    heartNum = int(ch)
    heartStr = ""
    for k in range (0, heartNum) :
        heartStr += "\u2665"
    print(heartStr)
    i += 1
```

#### Output
```	
숫자를 여러 개 입력하세요 : 12598

♥
♥♥
♥♥♥♥♥
♥♥♥♥♥♥♥♥♥
♥♥♥♥♥♥♥♥
```
