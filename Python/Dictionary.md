
# [Python] 딕셔너리 (Dictionary)

### 딕셔너리란?
딕셔너리의 사전적 의미는 **사전**이다.
영한사전에서는 "사과" = "apple", "복숭아" = "peach" 처럼 대응 관계를 가진다.
이처럼 딕셔너리는 Key와 Value라는 것을 한 쌍으로 갖는 자료형이다.
딕셔너리는 리스트나 튜플처럼 순차적으로 해당 요소값을 구하지 않고 Key를 통해 Value를 얻는다.

### 딕셔너리 사용 방법
딕셔너리의 사용 방법은 아래와 같다.
``` python
>>> dic = {'사과' : 'apple', '복숭아' : 'peach'}
```
 위에서 Key는 각각 '사과', '복숭아'이고, 각각의 Key에 대응하는 Value는 'apple', 'peach'이다.
``` python
>>> dic = {1 : 2, 3 : 4}
```
 위와 같이 Key와 Value에 정수값이 들어갈 수 있다.
``` python 
>>> dic = {'list' : [1,2,3]}
```
 위처럼 Value에 리스트를 넣을 수도 있다.

### 딕셔너리에 쌍 추가하기
``` python
>>> dic = {'사과' : 'apple', '복숭아' : 'peach'}
>>> dic['바나나'] = 'banana'
>>> dic
{'사과': 'apple', '복숭아': 'peach', '바나나': 'banana'}
>>> dic['list'] = [1,2,3]
>>> dic
{'사과': 'apple', '복숭아': 'peach', '바나나': 'banana', 'list': [1, 2, 3]}
```

Key가 '바나나' 이고, Value가 'banana'인 딕셔너리 쌍이 추가되고, Key가 'list' 이고, Value가 [1, 2, 3] 인 리스트인 딕셔너리 쌍이 추가된다.

### 딕셔너리 요소 삭제하기
``` python
>>> dic = {'사과' : 'apple', '복숭아' : 'peach', '바나나' : 'banana'}
>>> del dic['복숭아']
>>> dic
{'사과' : 'apple', '바나나' : 'banana'}
```

위처럼 del 함수를 이용해서 del dic[Key]를 입력하면 지정한 Key에 해당하는 {Key : Value} 쌍이 삭제된다.

### 딕셔너리 값 수정하기
``` python
>>> dic = {'사과' : 'apple', '복숭아' : 'peach', '바나나' : 'banana'}
>>> dic['사과'] = 'APPLE'
>>> dic
{'사과': 'APPLE', '복숭아': 'peach', '바나나': 'banana'}
```
수정하고 싶은 값의 Key로 값을 추가하면 Value가 수정된다.

### 딕셔너리 결합하기
``` python
>>> dic1 = {'사과' : 'apple', '복숭아' : 'peach'}
>>> dic2 = {'사과': 'APPLE', '바나나': 'banana'}
>>> dic1.update(dic2)
>>> dic1
{'사과': 'APPLE', '복숭아': 'peach', '바나나': 'banana'}
```
딕셔너리 두개를 결합하는 방법은 위와 같다.

### 딕셔너리에서 Key 사용해 Value 얻기
``` python
>>> dic = {'사과' : 'apple', '복숭아' : 'peach', '바나나' : 'banana'}
>>> dic['사과']
'apple'
>>> dic['귤']
Traceback (most recent call last):
  File "<pyshell#19>", line 1, in <module>
    dic['귤']
KeyError: '귤'
>>> dic.get('귤')
```
딕셔너리에 존재하는 키라면 해당 값을 반환하지만 없을 경우 에러가 난다.  
이는 **get(key)** 함수를 사용하면 된다.

### 딕셔너리 관련 함수들
keys(), values(), items(), clear(), get() 등과 같이 딕셔너리를 다루는 다양한 함수들이 존재한다.
사용 용도는 다음과 같다.
#### Key 리스트 만들기
``` python
>>> dic = {'사과' : 'apple', '복숭아' : 'peach', '바나나' : 'banana'}
>>> dic.keys()
dict_keys(['사과', '복숭아', '바나나'])
```
dic.keys() 함수는 딕셔너리 dic의 Key만 모아 dict_keys라는 객체를 리턴한다.
``` python
>>> for k in dic.keys() :
	    print(k)

사과
복숭아
바나나
```
#### Value 리스트 만들기
``` python
>>> dic.values()
dict_values(['apple', 'peach', 'banana'])
```
Key를 얻는 것처럼 Value만 얻고 싶다면 dic.values() 처럼 values() 함수를 사용하면 된다.
values() 함수를 호출하면 dict_values 객체가 리턴된다.

#### Key, Value 쌍 얻기
``` python
>>> dic.items()
dict_items([('사과', 'apple'), ('복숭아', 'peach'), ('바나나', 'banana')])
```
items() 함수는 Key와 Value의 쌍을 튜플로 묶은 값을 dict_items 객체로 리턴한다.

#### 리스트 형태로 반환하기
``` python
>>> list(dic.keys())
['사과', '복숭아', '바나나']
>>> list(dic.values())
['apple', 'peach', 'banana']
>>> list(dic.items())
[('사과', 'apple'), ('복숭아', 'peach'), ('바나나', 'banana')]
```
위의 함수의 결과에서 `dict_keys` `dict_values` `dict_items`를 뺀 리스트 형태로 반환된다.

#### Key:Value 쌍 모두 지우기
``` python 
>>> dic.clear()
>>> dic
{}
```
clear() 함수는 딕셔너리 안의 모든 요소를 삭제한다.
빈 리스트를 [], 빈 튜플을 ()로 표현하는 것과 마찬가지로 빈 딕셔너리도 {}로 표현한다.

#### Key로 Value 얻기 (Key 없을 경우 대처 가능)
``` python
>>> dic = {'사과' : 'apple', '복숭아' : 'peach', '바나나' : 'banana'}
>>> dic.get('none')
>>> dic['none']
Traceback (most recent call last):
  File "<pyshell#27>", line 1, in <module>
    dic['none']
KeyError: 'none'
```
딕셔너리 안에 찾으려는 Key 값이 없을 경우 미리 정해 둔 디폴트 값을 대신 가져오게 하고 싶을 때에는 get(Key, 'default value')를 사용하면 된다.
``` python
>>> a.get('none', 'no data')
'no data'
```

#### 해당 Key가 딕셔너리 안에 있는지 조사하기
``` python
>>> dic = {'사과' : 'apple', '복숭아' : 'peach', '바나나' : 'banana'}
>>> '사과' in dic
True
>>> '배' in dic
False
```
'사과'라는 문자열은 딕셔너리 dic의 Key 중 하나이기 때문에 'name' in dic의 결과값은 참(True)이다. 
반대로 '배'는 딕셔너리 dic 안에 존재하지 않는 Key 이므로 거짓(False)를 리턴한다.

#### 예시 코드
``` python
foods = {   "떡볶이" : "오뎅",
            "짜장면" : "단무지",
            "라면" : "김치",
            "피자" : "피클",
            "맥주" : "땅콩",
            "치킨" : "치킨무",
            "삼겹살" : "상추" }

print(foods.get("만두"))
print(foods.get("만두", "그런 음식은 없네요"))


while (True) :
    myfood = input(str(list(foods.keys())) + " 중 좋아하는 것은? ")
    if myfood in foods :
        print("<%s> 궁합 음식은 <%s> 입니다." %(myfood, foods.get(myfood)))
    elif myfood == "끝" :
        break
    else :
        print("그런 음식이 없네요. 확인해 보세요.")
    print()
```

#### Output
``` python
None
그런 음식은 없네요
['떡볶이', '짜장면', '라면', '피자', '맥주', '치킨', '삼겹살'] 중 좋아하는 것은? 맥주
<맥주> 궁합 음식은 <땅콩> 입니다.

['떡볶이', '짜장면', '라면', '피자', '맥주', '치킨', '삼겹살'] 중 좋아하는 것은? 떡볶이
<떡볶이> 궁합 음식은 <오뎅> 입니다.

['떡볶이', '짜장면', '라면', '피자', '맥주', '치킨', '삼겹살'] 중 좋아하는 것은? 닭발
그런 음식이 없네요. 확인해 보세요.

['떡볶이', '짜장면', '라면', '피자', '맥주', '치킨', '삼겹살'] 중 좋아하는 것은? 끝
```