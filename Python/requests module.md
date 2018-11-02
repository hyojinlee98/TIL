# [Python] requests 모듈
python에서 HTTP 요청을 보내는 모듈이다.
### 기본적인 사용 방법
``` python
import requests
url = 'https://github.com/hyojinlee98'
res = requests.get(url)
print(res.text)
```
위의 코드는 https://github.com/hyojinlee98 라는 주소로 GET 요청(request)을 보내고 서버에서는 그 요청을 받아 뭔가를 처리한 후 요청자인 나에게 응답(response)을 준다. 위의 코드에서 정상적인 응답을 보내줬다면 해당 url의 html 코드가 출력된다. 

### GET 요청할 때 파라미터 전달 방법
``` python
params = {'id' : 'admin', 'pw' : 'admin1'}
res = requests.get(url, params=params)
```
GET 방식으로 전달할 파라미터를 딕셔너리로 전달해주면 된다.

### POST 요청할 때 파라미터 전달 방법
GET 으로 요청 방법에서 params를 data로 바꿔주면 된다.
``` python
data = {'id' : 'admin', 'pw' : 'admin1'}
res = requests.get(url, data=data)
```
### 헤더와 쿠키 추가
헤더와 쿠키도 딕셔너리 형태로 이름, 내용을 대응시켜 저장한 뒤 headers, cookies에 전송하면 된다.
``` python
res = requests.get(url, headers=headers, cookies = cookies)
```
### 응답(Response) 객체
``` python
res.status_code # 상태 코드를 반환
res.raise_for_status() # HTTP Error 하나가 발생하면 저장된 것을 발생, 없으면 None
res.url # 요청 url 반환
res.text # 응답을 text 형식으로 출력
```
