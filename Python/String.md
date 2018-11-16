

## [Python] 문자열

### 사용 방법
``` python
>>> string = "abc"
>>> string[0]
'a'
>>> string[1]
'b'
>>> string[2]
'c'
```

### 문자열 길이 구하기
``` python
>>> string = "abc"
>>> len(string)
3
```

### 입력 받은 문자열 반대로 출력
``` python
inStr, outStr = "", ""
count, i = 0, 0

inStr = input("문자열을 입력하세요 : ")
count = len(inStr)

for i in range(0, count) :
    outStr += inStr[count-(i+1)]

print("내용을 거꾸로 출력 --> %s" % outStr)
```
 #### Output
 ```
 문자열을 입력하세요 : Python String
내용을 거꾸로 출력 --> gnirtS nohtyP
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

### 문자열 관련 함수
- upper() : 소문자를 대문자로 변경
- lower() : 대문자를 소문자로 변경
- swapcase() : 대소문자를 상호 변환
- title() : 각 단어의 제일 앞 글자만 대문자로 변환
- split() : 문자열을 공백이나 다른 문자로 분리해서 리스트를 반환
- splitlines() : 행 단위로 분리
- join() : 문자열을 합함
``` python
>>> s = "Python is easy, so it's fun\n문자열 관련 함수 예제"
>>> s.upper()
"PYTHON IS EASY, SO IT'S FUN\n문자열 관련 함수 예제"
>>> s.lower()
"python is easy, so it's fun\n문자열 관련 함수 예제"
>>> s.swapcase()
"pYTHON IS EASY, SO IT'S FUN\n문자열 관련 함수 예제"
>>> s.title()
"Python Is Easy, So It'S Fun\n문자열 관련 함수 예제"
>>> s.split()
['Python', 'is', 'easy,', 'so', "it's", 'fun', '문자열', '관련', '함수', '예제']
>>> s.splitlines()
["Python is easy, so it's fun", '문자열 관련 함수 예제']
>>> s.join("**")
"*Python is easy, so it's fun\n문자열 관련 함수 예제*"
```
- strip() : 양 옆 공백 삭제
- rstrip() : 오른쪽 공백 삭제
- lstrip() : 왼쪽 공백 삭제
- replace(a, b) : 'a' 값을 'b' 값으로 변경
``` python
>>> s = "     P     Y    T     H     O     N     "
>>> s.strip()
'P     Y    T     H     O     N'
>>> s.rstrip()
'     P     Y    T     H     O     N'
>>> s.lstrip()
'P     Y    T     H     O     N     '
>>> s.replace(' ', '*')
'*****P*****Y****T*****H*****O*****N*****'
```

