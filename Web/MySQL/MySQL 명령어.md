# [MySQL] 기본 명령어 정리
### 데이터베이스 접속
``` sql
mysql -u root -p
```
위의 명령어를 친 후 비밀번호를 입력하면 접속이 된다.

### 데이터베이스 생성/보기/삭제
``` sql
# 데이터베이스 생성
mysql> CREATE DATABASE 데이터베이스명;

# 현재 존재하는 데이터베이스 목록 보기
mysql> SHOW DATABASES;

# 특정 데이터베이스 사용하겠다고 선언
mysql> USE 데이터베이스명;

# 데이터베이스 삭제
mysql> DROP DATABASE 데이터베이스명;
```

### 테이블 생성/보기/삭제
``` sql
# 테이블 생성
mysql> CREATE TABLE 테이블명 (
	컬럼명1 INT PRIMARY KEY AUTO_INCREMENT,
	컬럼명2 VARCHAR(16) NOT NULL,
	컬럼명3 VARCHAR(32)
	);
	
# 현재 데이터베이스의 테이블 목록 보기
mysql> SHOW TABLES;

# 테이블 구조 보기
mysql> EXPLAIN 테이블명;
mysql> DESCRIBE 테이블명;
mysql> DESC 테이블명;

# 테이블 이름 변경
mysql> RENAME TABLE 테이블명 TO 새로운 테이블명;

# 테이블 삭제
mysql> DROP TABLE 테이블명;
```

### 데이터 삽입/수정/삭제
``` sql
# 데이터 삽입
mysql> INSERT INTO 테이블명 VALUES(값1, 값2, ...);

# 데이터 수정
mysql> UPDATE 테이블명 SET 컬럼명=새값 WHERE 조건;

# 데이터 삭제
mysql> DELETE FROM 테이블명 WHERE 조건;
```

### 데이터 조회
``` sql
# 테이블의 컬럼명1, 컬럼명2의 데이터 출력
mysql> SELECT 컬럼명1, 컬럼명2 FROM 테이블명;

# 테이블의 모든 값 출력
mysql> SELECT * FROM 테이블명

# DESC는 내림차순, ASC는 오름차순으로 출력
mysql> SELECT * FROM 테이블명 ORDER BY 컬럼명1 DESC;

# 결과 중 처음부터 10개 출력
mysql> SELECT * FROM 테이블명 LIMIT 10;

# 결과 중 5번째부터 10개 가져오기(첫 번째 레보트는 0번부터 시작)
mysql> SELECT * FROM 테이블명 LIMIT 4, 10;
```

### 테이블 컬럼 추가
``` sql
mysql> ALTER TABLE 테이블명 ADD 컬럼명 컬럼속성;
```

## LIKE 사용하여 검색
`LIKE`를 이용하여 데이터베이스에서 특정 문자가 들어간 데이터나 특정 문자가 들어가지 않은 데이터를 검색할 수 있다.  
```
\_ : 한 개의 문자 매칭  
% : 정해지지 않은 여러 문자 매칭
```
사용 형식은 아래와 같다.
``` sql
# adm로 시작하는 5글자의 단어 검색
mysql> SELECT * FROM 테이블명 WHERE 컬럼명 LIKE 'adm__';

# admi로 시작하는 5글자의 단어 검색
mysql> SELECT * FROM 테이블명 WHERE 컬럼명 LIKE 'admi_';

# dmi가 들어가는 단어 검색
mysql> SELECT * FROM 테이블명 WHERE 컬럼명 LIKE '%dmi%';

# dm이 들어가지 않는 단어 검색
mysql> SELECT * FROM 테이블명 WHERE 컬럼명 NOT LIKE '%dm%';