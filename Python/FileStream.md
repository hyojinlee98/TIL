
## [Python] 파일 입출력
파이썬으로 파일의 내용을 읽어 오거나 파일에 글을 쓸 수 있다.  

### 파일 입력 관련 함수
- read() 
- readline()
- readlines()

### 파일 출력 관련 함수
- write()
- writelines()

### 파일 열기 모드
- 생략 : r과 동일
- r : 읽기 모드, 기본값
- w : 쓰기 모드, 기존에 파일이 있으면 덮어쓴다
- r+ : 읽기/쓰기 겸용 모드
- a : 쓰기 모드, 기존에 파일이 있으면 이어서 쓴다(Append의 약자)
- t : 텍스트 모드, 기본값, 텍스트 파일을 처리한다
- b : 바이너리 모드, 바이너리 파일(이진 파일)을 처리한다

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