## [HTML] Video 구성  요소
#### \<video> 태그  속성
-   height : 비디오  화면  높이(px)
-   width : 비디오  화면  너비(px)
-   autoplay : 이  속성을  지정하면  비디오가  로드  되자  마자  자동으로  재생됨
-   controls : 재생에  관한  조절  장치를  보여줌(palyback/pause/resume/volume 등)
-   loop : 비디오를  반복  재생함
-   muted : 비디오에  포함된  오디오를  음소거할  지  지정
-   poster : 비디오가  다운되는  동안이나  사용자가  재생  버튼을  누를  때까지  보일  이미지 url 지정
-   src : 삽입할  비디오의  주소

#### \<source> 태그  속성

\<video> \<audio> 태그와  함께  사용하며, 미디어  유형이나  코덱에  따라  자원을  선택할  수  있도록  지정
-   src : 파일  경로
-   type : 파일  형식  유형  
    

|Format|MIME-type  |
|--|--|
|mp4|video/mp4|
|ogg|video/ogg|
|webm|video/webm


## Audio 구성  요소

#### \<audio> 태그  속성

-   autoplay : 오디오가  준비  되자  마자  자동으로  재생을  시작
-   controls : 오디오  재생에  관한  조절  장치를  보여줌
-   loop: 음악을 반복  재생함
-   muted : 음소거  지정 (기본값은 false)
-   src : 재생할 오디오의 주소

#### \<source> 태그  속성
- src : 파일 경로
- type : 파일  형식  유형


|Format|MIME-type  |
|--|--|
|mp3|audio/mpeg|
|ogg|audio/ogg|
|wav|video/wav|

