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