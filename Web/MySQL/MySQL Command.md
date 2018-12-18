## [MySQL] 기본 명령어 정리
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