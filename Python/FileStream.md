## [Python] 파일입출력

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
notepad.exe는 복사는 되지만 실행은 되지 않는다.