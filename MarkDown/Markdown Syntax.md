# 마크다운(Markdown) 문법

## 제목
HTML의 `<h1> ~ <h6>` 태그와 유사하다.    
`# <h1> 태그`  
`## <h2> 태그`  
`### <h3> 태그`  
`#### <h4> 태그`  
`##### <h5> 태그`  
`###### <h6> 태그`  

# \<h1> 태그
## \<h2> 태그
### \<h3> 태그
#### \<h4> 태그
##### \<h5> 태그
###### \<h6> 태그       


  

## 본문
HTML의 \<p>와 같은 본문은 텍스트를 그대로 작성하면 된다.

`Today I Learned`

Today I Learned    


## 인용
인용은 `>` 를 넣어 작성한다.

```
> TIL  
>> Today I Learned
```  

> TIL
>> Today I Learned    


## 리스트
### 순서가 없는 리스트
`*` 또는 `-`를 사용해서 작성하면 된다.  
또한 tab 또는 2칸 띄어쓰기를 통해 중첩된 항목을 작성할 수 있다.

```
* Programming Language
   * C
   * JAVA
   * Markup Language
     * HTML
	 * XML
	 
- Programming Language
  - C
  - JAVA
  - Markup Language
    - HTML
	- XML
```

* Programming Language
  * C
  * JAVA
  * Markup Language
    * HTML
	* XML
	 
- Programming Language
  - C
  - JAVA
  - Markup Language
    - HTML
	- XML    


### 순서가 있는 리스트

```
1. Apache
2. PHP
3. MySQL
```
1. Apache
2. PHP
3. MySQL

```
1. Apache
1. PHP
1. MySQL
```  
1. Apache
2. PHP
3. MySQL

```
1. Apache
2. PHP
3. MySQL
  1. Database
```
1. Apache
2. PHP
3. MySQL
  1. Database      
    
  
### 코드블럭
코드블럭은 일반 문장 사이에 단어, 짧은 문장 단위로 표현할 수 있는 방법과  
여러줄의 코드를 삽입하는 방법이 있다.
  
단어, 한 줄의 코드를 감싸는 경우 `를 앞뒤로 감싼다.  

`프로그래밍 언어에는 \`Python\`과 \`JAVA\` 등이 있다.`

프로그래밍 언어에는 `Python`과 `JAVA` 등이 있다.  


여러줄의 코드를 나타내는 코드블럭의 경우 시작과 끝을 \```으로 감싸고
시작 부분에서 \``` 뒤에 작성할 언어를 명시한 뒤 내부에 코드를 작성하면 된다.

``` python
for i in range(10) :
	print(i)
```	    


### 수평선
HTML의 \<hr>과 같이 동작한다.

```
* * *
***
*****
- - -
---------------
```
* * *
***
*****
- - -
---------------




### 링크

`[naver] (https://www.naver.com "naver")`

[naver] (https://www.naver.com "naver")
    

	

### 강조
HTML의 \<em>과 같은 동작을 하는 `*`, `_`  
\<strong>과 같은 동작을 하는 `**`, `__`을 사용한다.  
취소선은 `~~`을 사용한다.

```
*강조*한 텍스트
_강조_한 텍스트
**강조**한 텍스트
__강조__한 텍스트
~~취소~~한 텍스트
```

*강조*한 텍스트  
_강조_한 텍스트  
**강조**한 텍스트  
__강조__한 텍스트  
~~취소~~한 텍스트  

