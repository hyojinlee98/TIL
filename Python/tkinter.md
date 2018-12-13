## [Python] tkinter 모듈 사용 방법
### 윈도우 창 기본 구성
``` python
from tkinter import *

window = Tk()

window.mainloop()
```

tkinter 모듈을 사용하여 윈도우 창을 띄우는 기본적인 형태이다.

``` python
from tkinter import *

window = Tk()
window.title('윈도우 창 연습')
window.geometry('400x100')
window.resizable(width=FALSE, height=FALSE)

window.mainloop()
```
``` python
window.title('윈도우 창 연습') 
```
윈도우 창의 제목을 설정한다.
``` python
window.geometry('400x400')
``` 
윈도우의 창 크기를 400 * 400으로 바꿔준다.
``` python
window.resizable(width=FALSE, height=FALSE)
```
사용자가 윈도우 창 크기를 늘릴 수 있는 권한을 설정해준다. `width=TRUE, height=FALSE` 해주면 좌우로만 늘릴 수 있다.

#### Label
``` python
from tkinter import *
window=Tk()

label1 = Label(window, text="SWEDU~~ Python을")
label2 = Label(window, text="열심히", font=("궁서체", 30), fg="blue")
label3 = Label(window, text="공부 중입니다.", bg="magenta", width=20,
               height=5, anchor=SE)

label1.pack()
label2.pack()
label3.pack()

window.mainloop()
```
fg 속성은 글자 색을 나타낸다.
fg 속성에 RGB 값을 넣어도 된다.  
anchor의 속성은 방위값`(S:남, E:동, W:서, N:북)`을 통해 글자의 위치를 나타낸다. SE는 남동쪽이므로 오른쪽 아래에 위치하게 된다.

#### Button
``` python
from tkinter import *
window = Tk()

button1 = Button(window, text="파이썬 종료", fg="red", command=quit)

button1.pack()

window.mainloop()
```
**파이썬 종료** 라는 문구가 적힌 버튼이 생성된다. 해당 버튼을 누르면 파이썬이 종료된다.
