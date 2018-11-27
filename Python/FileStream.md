## [Python] 파일 입출력
파이썬으로 파일의 내용을 읽어 오거나 파일에 글을 쓸 수 있다.


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