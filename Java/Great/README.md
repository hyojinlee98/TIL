# 위인 검색 및 추가
great 패키지로 만들었다.  
우선 파일에 있는 위인을 읽어 입력 및 출력한다.  
파일의 입력 형태는 아래와 같다.  
```
일반 위인, 상세 위인(0, 1) - 상세 위인은 업적이 여러줄이다.
이름 - 위인의 이름
타입(0, 1, 2, 3, 4, 5, 6, 7) - 기타, 왕, 무인, 정치가, 예술가, 의사, 종교인
성별 - F, M
국가(0, 1, 2, 3, 4, 5, 6, 7, 8) - 없음, 고조선, 삼국, 신라, 고려, 조선, 식민지, 대한민국, 후삼국
태어난 연도
사망 연도
업적
```
그리고 키워드를 검색하여 이름, 성별, 연도, 업적 중 어느 키워드인지 구분 후 검색 한 내용을 출력한다.  
키워드가 **end** 일 경우 위인 추가하기로 넘어간다.  
추가할 위인이 없으면 **end**를 통해 종료하면 된다.