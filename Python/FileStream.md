
## [Python] 파일 입출력
파이썬으로 파일의 내용을 읽어 오거나 파일에 글을 쓸 수 있다.  

### 파일 열기 모드
- 생략 : r과 동일
- r : 읽기 모드, 기본값
- w : 쓰기 모드, 기존에 파일이 있으면 덮어쓴다
- r+ : 읽기/쓰기 겸용 모드
- a : 쓰기 모드, 기존에 파일이 있으면 이어서 쓴다(Append의 약자)
- t : 텍스트 모드, 기본값, 텍스트 파일을 처리한다
- b : 바이너리 모드, 바이너리 파일(이진 파일)을 처리한다

### 파일 입력 관련 함수
- read() 
- readline()
- readlines()

### 파일 입력 예시
``` python
inFp = open("./txt/data1.txt", "r", encoding='utf-8')

inList = inFp.readlines()
for inStr in inList :
    print(inStr, end="")

inFp.close()
```
읽기 형식으로 파일을 열고, 한줄씩 리스트 형식으로 반환된 값을 한 줄씩 출력한다.
 #### Output
 ```
 파이썬 파일 입출력
 t0paz & g0pher
 종강 했으면 좋겠다
 ```
 data1.txt 파일에 있는 내용이 출력된다.

### 도스의 type 명령 구현하기
도스의 명령어 중 하나인 `type 파일명` 은 파일의 내용을 출력해준다.
이를 구현하면 다음과 같다.
``` python
import os

fName = input("파일명을 입력하세요 : ")
if os.path.exists("./txt/"+fName) :
    inFp = open("./txt/"+fName, "r", encoding='utf-8')
    inList = inFp.readlines()
    for inStr in inList :
        print(inStr, end="")
    inFp.close()
else :
    print("%s 파일이 없습니다" % fName)
```
파일명을 입력했을 때 파일이 있으면 해당 파일의 내용을 출력하고, 파일명이 없으면 없다고 출력해준다.

### 파일 출력 관련 함수
- write()
- writelines()

### 파일 출력 예시
``` python
outFp = open("./txt/data1.txt", "w", encoding='utf-8')

while True :
    outStr = input("내용 입력 : ")
    if outStr != "" :
        outFp.writelines(outStr + '\n')
    else :
        break

outFp.close()
print("--- 정상적으로 파일에 써졌음 ---")
```
data1.txt란 이름의 파일에 입력한 내용이 써진다.  
만약 data1.txt란 파일이 있으면 덮어 써진다.  
파일 열기 모드가 w가 아닌 a라면 기존 내용에 추가된다.

### 파일 입출력으로 실행 파일 복사하기
``` python
inFp = open('C:/Windows/write.exe', 'rb')
outFp = open("./txt/write.exe", "wb")

while True :
    inStr = inFp.read()
    if not inStr :
        break
    outFp.write(inStr)

inFp.close()
outFp.close()
print("--- 정상적으로 바이너리 파일이 복사되었습니다 ---")
```

#### Output
```
--- 정상적으로 파일이 복사되었음 ---
```

해당 경로에 write.exe 파일이 생기고 실행도 된다.  