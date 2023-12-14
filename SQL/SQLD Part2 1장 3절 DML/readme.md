# SQLD [과목2] 1장 3절 DML

작성일시: 2023년 8월 30일 오전 11:20
종류: SQL
복습: No

## 🟰 INSERT

## 🟰UPDATE

## 🟰DELETER

## 🟰SELECT

1. SELECT 기본형태 : SELECT ALL/DISTINCT 칼럼,칼럼… FROM 테이블명
2. ALIAS 부여하기 : 칼럼명과 ALIAS 사이에 AS키워드를 사용한다.
이중 인용부호(DOUBLE QUOTATION)는 ALIAS가 공백, 특수문자를 포함할 경우와 대소문자 구분이 필요한 경우 사용 ( AS를 꼭사용하지 않아도 사용 가능)

## 🟰 산술 연산자와 합성 연산자

1. 산술 연산자는 NUMBER와 DATE자료형에 적용
2. 수학의 사칙연산과 동일
3. (),*,/,+,- 의 우선순위를 가진다.
- [ ]  합성(CONCATENATION)연산자의 특징 :
    1. 문자와 문자를 연결하는 경우 2개의 수빅 바(||)에 의해 이뤄진다.(ORACLE)
    2. 문자와 문자를 연결하는 경우 + 표시에 의해 이뤄진다.(SQL SERVER)
    3. 두 벤더 모두 공통적으로 CONCAT (STRING1, STRING2)함수를 사용
    4. 칼럼과 문자 또는 다른 칼럼과 연결
    5. 문자 표현식에 의해 새로운 컬럼 생성
    
    ```sql
    --ORACLE
    SELECT PLAYER_NAME || '선수', '||HEIGHT||'CM',||WEIGHT|| 'KG'체격정보 FROM 체격정보
    
    --SQL SERVER
    SELECT PLAYER_NAME +'선수, '+HEIGHT +'cm, '+WEIGHT +'kg'체격정보 FROM    PLAYER;
    
    ```