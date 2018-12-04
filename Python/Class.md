## [Python] 클래스
### 클래스
파이썬은 객체 지향 언어의 종류 중 하나이다. 객체(Object)란 주변에 존재하는 모든 사물, 생명체를 의미한다. 이때 객체를 정의하는 틀 또는 설계도를 클래스라고 한다. 클래스는 객체의 상태를 나타내는 변수와 객체의 행동을 나타내는 함수로 구성된다.  
파이썬에서 클래스는 아래와 같은 방식으로 사용된다.
``` python
class 클래스 이름 :
```
다음은 클래스를 활용한 코드의 예이다.
``` python
class Car :
    def upSpeed(self, value) :
        self.speed += value
        
    def downSpeed(self, value) :
        self.speed -= value

myCar1 = Car()
myCar1.color = "빨간색"
myCar1.speed = 0

myCar2 = Car()
myCar2.color = "파란색"
myCar2.speed = 0

myCar3 = Car()
myCar3.color = "노란색"
myCar3.speed = 0

myCar1.upSpeed(30)
print("자동차1의 색상은 %s이며, 현재 속도는 %d km 입니다."
          % (myCar1.color, myCar1.speed))
myCar2.upSpeed(60)
print("자동차2의 색상은 %s이며, 현재 속도는 %d km 입니다."
          % (myCar2.color, myCar2.speed))

myCar3.upSpeed(0)
print("자동차3의 색상은 %s이며, 현재 속도는 %d km 입니다."
          % (myCar3.color, myCar3.speed))
```
Car 이름의 클래스를 만들고, 3개의 객체를 생성했다. myCar1, myCar2, myCar3와 같은 변수를 인스턴스 변수라고 한다.  
클래스로부터 객체를 선언하는 과정을 클래스의 인스턴스 화라고 한다. 또한, 이렇게 선언된 해당 클래스 타입의 객체를 인스턴스(instance)라고 한다.  즉, 인스턴스란 메모리에 할당된 객체를 의미한다.  
upSpeed() 함수의 매개변수는 두 개인데 호출할 때 인자를 한 개만 전달한다. 그 이유는 첫 번째 매개변수 self에 upSpeed 함수를 호출한 객체 myCar1이 자동으로 전달되기 때문이다. 
``` python
myCar1.upSpeed(30)
```
위의 코드를 보면 myCar1이 self로, 30이 value로 전달되게 되는 것이다. self 대신 다른 이름을 사용해도 상관 없다.  
위처럼 클래스는 기본적인 틀이 같고, 세부 내용이 다를 때 사용한다. 위 코드의 실행 결과는 다음과 같다.
#### Output
```
자동차1의 색상은 빨간색이며, 현재 속도는 30 km 입니다.
자동차2의 색상은 파란색이며, 현재 속도는 60 km 입니다.
자동차3의 색상은 노란색이며, 현재 속도는 0 km 입니다.
```

### 생성자
생성자는 객체를 생성할 때 호출되는 메소드이다.  
``` python
def __init__(self) :
```
형식은 위와 같이 사용하면 된다.  
``` python
class Car :
    def __init__(self) :
        self.color = "빨강"
        self.speed = 0

    def upSpeed(self, value) :
        self.speed += value
        
    def downSpeed(self, value) :
        self.speed -= value

myCar1 = Car()
myCar2 = Car()

print("자동차1의 색상은 %s이며, 현재 속도는 %d km 입니다."
          % (myCar1.color, myCar1.speed))
myCar2.upSpeed(60)
print("자동차2의 색상은 %s이며, 현재 속도는 %d km 입니다."
          % (myCar2.color, myCar2.speed))
```
생성자에서 color와 speed 값을 정해주었기 때문에 객체 생성할 때 color 값은 빨강, speed 값은 0이 된다.
#### Output
```
자동차1의 색상은 빨강이며, 현재 속도는 0 km 입니다.
자동차2의 색상은 빨강이며, 현재 속도는 0 km 입니다.
```
### 매개변수 있는 생성자
생성자에도 인자를 줄 수 있다. 일반 함수처럼 사용하면 된다.
``` python
class Car :
    def __init__(self, value1, value2) :
        self.color = value1
        self.speed = value2

myCar1 = Car("빨강", 30)
print("자동차1의 색상은 %s이며, 현재 속도는 %d km 입니다."
          % (myCar1.color, myCar1.speed))
myCar2 = Car("파랑", 60)
print("자동차2의 색상은 %s이며, 현재 속도는 %d km 입니다."
          % (myCar2.color, myCar2.speed))
```
인자로 넘긴 값을 객체의 color와 speed에 대입했다. 결과값은 다음과 같다.
#### Output
```
자동차1의 색상은 빨강이며, 현재 속도는 30 km 입니다.
자동차2의 색상은 파랑이며, 현재 속도는 30 km 입니다.
```

### 클래스 변수
위에서 볼 수 있듯이 객체변수는 다른 객체들에 의해 영향받지 않고 독립적으로 그 값을 유지한다. 객체변수와 다르게 클래스 변수는 모든 객체들이 같은 값을 가리키고 있다.
``` python
>>> class Car :
		name = "벤츠"

>>> print(Car.name)
벤츠
```
클래스 안에 선언해주면 되고, **클래스 이름.클래스 변수명**으로 접근할 수 있다.
``` python
>>> myCar1 = Car()
>>> myCar2 = Car()
>>> print(myCar1.name)
벤츠
>>> print(myCar2.name)
벤츠
```
위와 같이 Car 클래스에 의해 생성된 객체를 통해서도 클래스 변수를 사용할 수 있다.  
Car.name의 값을 바꿔주면 객체들의 name 값도 바뀌게 된다. 다음을 확인해보자.
``` python
>>> Car.name = "아우디"
>>> print(myCar1.name)
아우디
>>> print(myCar2.name)
아우디
```
이를 통해 클래스 변수는 클래스에 의해 생성된 모든 객체에 공유된다는 점을 알 수 있다.  
클래스 변수를 사용한 예를 살펴보자.
``` python
class Car :
    count = 0

    def __init__(self, value1, value2) :
        self.color = value1
        self.speed = value2
        Car.count += 1

myCar1 = Car("빨강", 30)
print("%s색 자동차의 현재 속도는 %d km, 생산된 자동차 숫자는 총 %d대 입니다"
          % (myCar1.color, myCar1.speed, Car.count))
myCar2 = Car("파랑", 60)
print("%s색 자동차의 현재 속도는 %d km, 생산된 자동차 숫자는 총 %d대 입니다"
          % (myCar2.color, myCar2.speed, myCar2.count))
```
클래스 변수인 count를 통해 몇 개의 객체가 생성되었는지 알 수 있다.
#### Output
```
빨강색 자동차의 현재 속도는 30 km, 생산된 자동차 숫자는 총 1대 입니다
파랑색 자동차의 현재 속도는 60 km, 생산된 자동차 숫자는 총 2대 입니다
```
