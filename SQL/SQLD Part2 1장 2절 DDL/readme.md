# SQLD [과목2] 1장 2절 DDL

작성일시: 2023년 8월 29일 오후 12:36
종류: SQL
복습: No

## 🟰 데이터 유형

- [ ]  숫자 타입
    
    ANSI/ISO 기준 : NUBERIC, DECIMAL, DEC, SMALLINT, INTEGER, INT, BIGINT, FLOAT, REAL, DOUBLE, PRECISION
    
    SQL Server와 Sybase : 작은 정수형, 정수형, 큰 정수형, 실수 + MONEY, SMALLMONEY
    
    ORACLE : 숫자형 타입에 대해 NUMBER한 가지 숫자 타입의 데이터 유형만 지원
    
    벤더에서 ANSI/SIO 표준을 사용할 때는 기능을 중심으로 구현, 일반적으로 표준과 다른 용어를 사용하는 것을 허용
    
    테이블의 칼럼이 가지고 있는 대표적인 4가지 유형
    
    기타 유형 : ANSI/ISO 에서 Binary String Table, Binary Larget Object Type, National Character String Type, Boolean Type 등
    
    ![https://postfiles.pstatic.net/20151204_224/liberty264_1449235993588yvJRW_JPEG/1.jpg?type=w3](https://postfiles.pstatic.net/20151204_224/liberty264_1449235993588yvJRW_JPEG/1.jpg?type=w3)
    
    문자열 유형 : char유형과 varchar유형의 차이
    
    비교방법 : char에서는 문자열을 비교할 떄 공백을 채워서 비교
    
    varchar유형에서는 맨 처음부터 한 문자씩 비교하고 공빅도 하나의 문자로 취급
    
    char ⇒ ‘aa’ = ‘aa ‘          varchar ‘aa’ ≠ ‘aa ‘
    

## Create Table

- [ ]  테이블과 칼럼의 정의 : 후보키중에 하나를 선정하여 기본키 칼럼으로 지정

![https://postfiles.pstatic.net/20151204_187/liberty264_1449236055200pJvpa_JPEG/2.jpg?type=w3](https://postfiles.pstatic.net/20151204_187/liberty264_1449236055200pJvpa_JPEG/2.jpg?type=w3)

- [ ]  CREATE TABLE
    
    CREATE TABLE 테이블명(칼럼명1 DATATYPE DEFAULT 형식 …);
    
- [ ]  테이블 생성 규칙
    
    객체를 의미할 수 있는 적절한 의미 사용
    
    벤더에서 사전에 정의한 예약어를 사용할 수 없다.
    
    A-Z ,a-z, 0~9, _, $, #문자만 허용
    
    ![https://postfiles.pstatic.net/20151204_25/liberty264_1449236108928aoODp_JPEG/4.jpg?type=w3](https://postfiles.pstatic.net/20151204_25/liberty264_1449236108928aoODp_JPEG/4.jpg?type=w3)
    
    테이블 생성시 대/소문자 구분은 하지 않는다 기본적으로 대문자 사용
    
    DATETIME 데이터 유형에는 별도로 크기 지정X
    
    문자 데이터 유형은 반드시 최대 길이 표시
    
    칼럼과 칼럼의 구분은 콤마, 마지막 칼럼은 콤마X
    
    칼럼에 대한 제약조건이 있으면 CONSTRAINT를 이용하여 추가
    
- [ ]  제약조건
    
    데이터의 무결성을 유지하기 위한 데이터베이스의 보편적인 방법
    
    1. PK(기본키)
    2. UNIQUE KEY(고유키)
    3. NOT NULL
    4. CHECK
    5. FOREIGN KEY(외래키)

- [ ]  테이블 생성 Oracle과 SQL Server
    
    ```sql
    
    SQL Server
    CREATE TABLE TEAM (
    
    TEAM_ID CHAR(3) NOT NULL,
    
    REGION_NAME VARCHAR2(8) NOT NULL,
    
    TEAM_NAME VARCHAR2(40) NOT NULL,
    
    E_TEAM_NAME VARCHAR2(50),
    
    ORIG_YYYY CHAR(4),
    
    STADIUM_ID CHAR(3) NOT NULL,
    
    ZIP_CODE1 CHAR(3),
    
    ZIP_CODE2 CHAR(3),
    
    ADDRESS VARCHAR2(80),
    
    DDD VARCHAR2(3),
    
    TEL VARCHAR2(10),
    
    FAX VARCHAR2(10),
    
    HOMEPAGE VARCHAR2(50),
    
    OWNER VARCHAR2(10),
    
    CONSTRAINT TEAM_PK PRIMARY KEY (TEAM_ID),
    
    CONSTRAINT TEAM_FK FOREIGN KEY (STADIUM_ID) REFERENCES STADIUM(STADIUM_ID) );
    
    Oracle
    
    CREATE TABLE TEAM (
    
    TEAM_ID CHAR(3) NOT NULL,
    
    REGION_NAME VARCHAR(8) NOT NULL,
    
    TEAM_NAME VARCHAR(40) NOT NULL,
    
    E_TEAM_NAME VARCHAR(50),
    
    ORIG_YYYY CHAR(4),
    
    STADIUM_ID CHAR(3) NOT NULL,
    
    ZIP_CODE1 CHAR(3),
    
    ZIP_CODE2 CHAR(3),
    
    ADDRESS VARCHAR(80),
    
    DDD VARCHAR(3),
    
    TEL VARCHAR(10),
    
    FAX VARCHAR(10),
    
    HOMEPAGE VARCHAR(50),
    
    OWNER VARCHAR(10),
    
    CONSTRAINT TEAM_PK PRIMARY KEY (TEAM_ID),
    
    CONSTRAINT TEAM_FK FOREIGN KEY (STADIUM_ID) REFERENCES STADIUM(STADIUM_ID)
    
    );
    [출처] 제 2절 DDL|작성자 지그드시
    ```
    
- [ ]  생성된 테이블 구조 확인
    
    ```sql
    실행 결과 Oracle
    
    DESCRIBE PLAYER;
    
    실행 결과 SQL Server
    
    exec sp_help 'dbo.PLAYER' go
    ```
    
- [ ]  SELECT 문장을 통해 테이블 생성
    1. CTAS(CREATE TABLE ~ AS SELECT~) 기법
    2. CTAS기법 사용시 주의점 : 기존 테이블의 제약조건중 NOT NULL만 적용된다. 기본키, 외래키, CHECK 등의 다른제약 조건은 없어진다.
    3. 제약 조건을 추가하기 위해서는 ALTER TABLE의 기능을 사용한다.
    4. SQL Server 에서는 SELECT ~ INTO ~ 를 활용하며 INDENTITY까지 같이 적용된다.

```sql
-- ORACLE
CREATE TABLE TEAM_TEMP AS SELECT * FROM TEAM;

--SQL SERVER
SELECT * INTO_TEMP FROM TEAM(1개 행이 영향을 받음)
```

## 🟰 ALTER TABLE

- [ ]  ADD COLUMN
    1. ALTER TABLE 테이블명 ADD 추가할 칼럼명 데이터 유형;
    주의할 점 : 새롭게 추가된 칼럼은 테이블의 마지막 칼럼이 되며 칼럼의 위치를 지정할 수 없다.
        
        ```java
        --ORACLE
        ALTER TABLE PLAYER(ADDRESS VARCHAR2(80));
        
        --SQL SERVER
        ALTER TABLE PLAYER ADD ADDRESS VARCHAR2(90));
        ```
        
- [ ]  DROP COLUMN
    
    ```sql
    --ORACLE
    ALTER TABLE PLAYER DROP COLUMN ADDRESS;
    
    --SQL SERVER
    ALTER TABLE PLAYER DROP COLUMN ADDRESS;
    ```
    
- [ ]  MODIFY COLUMN
    1. 칼럼의 데이터 유형, 디폴트 값, NOT NULL 제약 조건에 대한 변경을 포함
    
    ```sql
    --ORACLE
    ALTER TABLE 테이블명 MODIFY (칼렴명1 데이터 유형 DEFAULT 식 NOT NULL,..)
    
    --SQL SERVER 동일
    ```
    
- [ ]  칼럼 변경 시 고려해야 할점
    1. 해당 칼럼의 크기는 늘릴 수 있지만 줄이지는 못한다.
    2. 해당 칼럼이 NULL값만 가지고 있거나 테이블에 아무 행도 없으면 칼럼의 폭을 줄일 수 있다.
    3. 해당 칼럼이 NULL값만 가지고 있으면 데이터 유형을 변경할 수 있다.
    4. 해당 칼럼의 DEFAULT값을 바꾸면 변경 작업 이후에 발생하는 행 삽입에만 영향을 미치게 된다.
    5. 해당 칼럼에 NULL값이 없을 경우에만 NOT NULL 제약조건을 추가할 수 있다.
    
    예제)
    
    TEAM 테이블의 ORIG_YYYY 칼럼의 데이터 유형을 CHAR(4)→VARCHAR2(8)으로 변경하고, 향후 입력되는 데이터의 DEFAULT 값으로 '20020129'을 적용하고, 모든 행의 ORIG_YYYY 칼럼에 NULL이 없으므로 제약조건을 NULL → NOT NULL로 변경한다.
    
    ```sql
    --ORACLE
    ALTER TABLE TEAM MODIFY (ORIG_YYYY VARCHAR(8) DEFAULT '20020129' NOT NULL);
    
    --SQL SERVER
    ALTER TABLE TEAM ALTER COLUMN ORIG_YYYY VARCHAR(8) NOT NULL;
    ALTER TABLE TEAM ADD CONSTRAINT DF_ORIG_YYYY DEFAULT '200220129' FOR ORIG_YYYY;
    ```
    
- [ ]  RENAME COLUMN
    1. ALTER TABLE 테이블명 RENAME COLUMN 변경해야 할 칼럼명 TO 새로운 칼럼명;
    2. 주의사항 : 엔터티 이름 부분을 변경하면 스크립트 및 저장 프로시저를 손상 시킬 수 있다.
    
    ```sql
    /*
    RENAME COLUMN으로 칼럼명이 변경되면, 해당 칼럼과 관계된 제약조건에 대해서도 
    자동으로 변경되는 장점이 있지만, 
    ADD/DROP COLUMN 기능처럼 ANSI/ISO에 명시되어 있는 기능이 아니고 
    Oracle 등 일부 DBMS에서만 지원하는 기능이다
    
    */
    
    --ORACLE
    ALTER TABLE PLAYER RENAME COLUMN PLAYER_ID TO TEMP_ID;
    ALTER TABLE PLAYER RENAME COLUMN TEMP_ID TO PLAYER_ID;
    
    --SQL SERVER
    SP_RENAME 변경해야 할 칼럼명, 새로운 칼럼명, 'COLUMN';
    SP_RENAME 'DBO.TEAM_TEMP_ID', 'TEAM_TEMP_ID','COLUMN';
    
    ```
    
- [ ]  DROP CONSTRAINT
    1. ALTER TABLE 테이블명 DROP CONSTRAINT 제약조건명;
    
    ```sql
    --ORACLE
    ALTER TABLE PLAYER DROP CONSTRAINT PLAYER_FK;
    
    --SQL SERVER
    ALTER TABLE PLATER DROP CONSTRAINT PLAYER_FK;
    ```
    
- [ ]  ADD CONSTARINT
    1. ALTER TABLE 테이블명 ADD CONSTRAINT 제약조건명 제약조건(칼럼명);
    
    예제) PLAYER 테이블에 TEAM테이블과의 외래키 제약조건을 추가
    
    제약조건명은 PLAYER_FK, PLAYER테이블의 TEAM_ID 칼럼이 TEAM테이블의 TEAM_ID를 참조
    
    ```sql
    --ORACLE
    
    ALTER PLSYER ADD CONSTRAINT PLAYER_FK FOREIGN KEY (TEAM_ID) REFERENCES TEAM(TEAM_ID);
    
    --SQL SERVER 동일
    ```
    
    예제) PLAYER테이블이 참조하는 TEAM테이블을 제거한다.
    
    ```sql
    --ORACLE
    DROP TABLE TEAM; --삭제되지 않는다. 외래 키에 의해 참조되는 고유/기본 키가 테이블에 있다.
    
    --SQL SERVER
    DROP TABLE TEAM; //엔터티 TAEM은 FOREIGN KEY제약조건을 참조하므로 삭제할 수 없다.
    ```
    
    예제) PLAYER테이블이 참조하는 TEAM테이블의 데이터를 삭제한다.
    
    ```sql
    --ORACLE
    DELETE TEAM WHERE TEAM_ID = 'K10' -- 무결성 제약조건이 위배된다. 자식 레코드가 발견됨
    
    --SQL SERVER
    DELETE TEAM WHERE TEAM_ID = 'K10' -- FOREIGN KEY제약 조건을 참조하므로 삭제 불가
    ```
    
- [ ]  참조 무결성 옵션
    
    외부 테이블에서 참조되고 있다면 삭제가 불가능하게 제약 할 수 있다.
    
    외부키를 설정함으로써 실수에 의한 테이블 삭제나 데이터의 의도하지 않은 삭제와 같은 불상사를 방지하는 효과를 볼 수 있다.
    

## 🟰 RENAME TABLE

RENAME 변경 전 테이블명 TO 변경후 테이블명

1. SQL SERVER에서는 SP_RENAME을 이용하여 테이블 이름을 변경할 수 있다.
2. SP_RENAME 변경전 테이블명 ,변경 후 테이블명;

예제) RENAME문장을 이용하여 TEAM테이블 명을 다른 이름으로 변경하고, 다시 TEAM테이블로 변경

```sql
--ORACLE
RENAME TEAM TO TEAM_BACKUP;
RENAME TEAM_BACKUP TO TEAM;

--SQL SERVER
SP_RENAME 'DBO.TEAM', 'TEAM_BACKUP'; 주의: 엔터티 이름 변경시 스크립트 및 저장 프로시저 손상 가능

SP_RENAME 'TEAM_BACKUP' , 'DBO.TEAM';
```

## DROP TABLE

DROP TABLE 테이블명 CASCADE CONSTRAINT;

1. CASCADE CONSTRAINT옵션은 해당 테이블과 관계가 있었던 참조되는 제약조건에 대해서도 삭제한다는 것을 의미
2. SQL SERVER에는 CASCADE 옵션이 존재하지 않으면 테이블을 삭제하기 전에 참조하는 FOREIGN KEY제약 조건 또는 참조하는 테이블을 먼저 삭제해야 한다.

예제) PLAYER 테이블을 제거

```sql
--ORACLE
DROP TABLE PLAYER; 테이블이 삭제됨

--SQL SERVER
DROP TABLE PLAYER 
exec sp_help 'dbo.PLAYER' --삭제된 테이블이기 때문에 설정한 타입을 볼 수 없음
```

## 🟰TRUNCATE TABLE

TRUNCATE TABLE PLAYER

1. 테이블 자체의 삭제가 아닌 테이블에 들어있는 모든 행의 제거 및 저장 공간을 재사용하도록 해제
2. 데이터의 구조 변경 없이 데이터의 일괄 삭제로 DML로 구분할 수 있지만 내부처리 방식이나 Auto Commit 특성으로 DDL에 분류되었다.
3. 한번 수행하면 AUTO COMMIT 으로 복구가 불가능하다.