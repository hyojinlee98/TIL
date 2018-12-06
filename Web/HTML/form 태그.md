## [HTML] form 태그
form 태그는 입력된 데이터를 한 번에 서버로 전송해준다. 전송한 데이터는 웹 서버가 처리하고, 결과에 따른 또 다른 웹 페이지를 보여준다. 로그인 페이지나 회원가입 페이지를 예로 들 수 있다.

### form 태그 속성
- action : form을 전송할 서버 쪽 스크립트 파일을 지정한다.
- id : form의 고유한 식별값으로 중복 가능하지 않다.
- name : form을 편의상 부르는 명칭으로 같은 name이 여러개일 경우 배열로 가져올 수 있다.
- method : form을 서버에 전송할 http 메소드를 정한다.
	- `method = "get"` : GET 방식으로 전송
	- `method = "post"` : POST 방식으로 전송
- target : action에서 지정한 스크립트 파일을 현재 창이 아닌 다른 위치에 열도록 지정한다.
- accept-charset : form 전송에 사용할 문자 인코딩을 지정한다.
- enctype : 입력된 데이터를 서버로 보낼 때 어떤 타입으로 인코딩해야 하는지를 지정한다.
	- `enctype = "application/x-www-form-urlencoded"` : 서버에 보내기 전에 모든 문자를 인코딩 하는 방식으로 폼에 텍스트 데이터를 포함했을 때 지정(기본값)
	- `enctype = "multipart/form-data"` : 파일 업로드 컨트롤처럼 문자가 아닌 파일을 전송할 때 사용
	- `enctype = "text/plain"` : 일반 텍스트로 인코딩
 - novalidate : HTML5에 새롭게 추가된 속성으로, 유효성 미확인을 지정한다. 이 속성을 지정하면 폼에 입력된 데이터를 서버로 보낼 때 데이터를 체크하지 않는다.
 
### form 관련 요소
- fieldset : form 내에서 관련 컨트롤을 하나의 그룹으로 묶는다. legend 요소를 함께 사용해야 한다.
- legend : fieldset 요소의 제목을 표시한다. 이 요소를 사용하면 fieldset 요소로 묶인 영역 주변에 테두리 선이 나타난다.