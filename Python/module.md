## [Python] 모듈(module) 만들기
모듈이란 변수나 함수 또는 클래스들을 모아 놓은 팡리이다. 모듈은 다른 파이썬 프로그램에서 불러와 사용할 수 있게끔 만들어진 파이썬 파일이라고도 할 수 있다. 사용 방법은 아래와 같다.

``` python
## module_ex.py
## 함수 정의 부분
def func1() :
    print("module_ex의 func1()이 호출됨")

def func2() :
    print("module_ex의 func2()가 호출됨")

def func3() :
    print("module_ex의 func3()이 호출됨")
```
위의 코드는 module_ex.py 파일이다. 이를 import 하여 파일 안에 있는 함수를 호출할 수 있다.
``` python
from module_ex import *

## 메인 코드 부분
func1()
func2()
func3()
```
#### Output
```
module_ex.py의 func1()이 호출됨
module_ex.py의 func2()가 호출됨
module_ex.py의 func3()이 호출됨
```
