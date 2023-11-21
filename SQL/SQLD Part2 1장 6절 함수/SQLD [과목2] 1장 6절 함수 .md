# SQLD [과목2] 1장 6절 함수

작성일시: 2023년 9월 2일 오후 11:25
종류: SQL
복습: No

## 🟰내장 함수(BUILT-IN FUNCTION)개요

함수는 다양한 기준으로 분류할 수 있는데, 벤더에서 제공하는 함수인 **`내장함수`**와 **`사용자가 정의할 수 있는 함수`**(User Defined Function)으로 나눌 수 있다.

내장 함수는 SQL을 더욱 강력하게 해주고 데이터 값을 간편하게 조작하는데 사용된다.

내장함수는 벤더별로 가장 큰 차이를 보이는 부분이지만, 핵심적인 기능들은 이름이나 표현법은 다르더라도 대부분의 데이터베이스가 공통적으로 제공하고 있다.

내장 함수는 다시 함수의 입력 값이 단일행 값이 입력되는 **`단일행 함수`** 여러 행의 값이 입력되는 **`다중행 함수(Multi Function)`**으로 나눌 수 있다.

함수는 입력되는 값이 아무리 많아도 출력은 하나만 된다는 M:1 관계의 특징을 갖고 있다.

단일행 함수의 경우 단일행 내에 있는 하나의 값 또는 여러 값이 입력 인수로 표현될 수 있다.

다중행 함수의 경우도 여러 레코드의 값들을 입력 인수로 사용하는 것이다.

- [ ]  단일행 함수의 종류

![https://postfiles.pstatic.net/20151204_244/liberty264_1449239009535XkYsS_JPEG/1.jpg?type=w3](https://postfiles.pstatic.net/20151204_244/liberty264_1449239009535XkYsS_JPEG/1.jpg?type=w3)

- [ ]  단일행 함수의 중요한 특징
    
    SELECT, WHERE, ORDER BY절에 사용 가능
    
    각 행들에 대해 개별적으로 작용하여 데이터 값들을 조작하고, 각각의 행에 대한 조작 결과를 리턴
    
    여러 인자를 입력해도 단 하나의 결과만 리턴
    
    함수의 인자로 상수, 변수, 표현식이 사용 가능하고, 하나의 인수를 가지는 경우도 있지만 여러개의 인수를 가질 수도 있다.
    
    특별한 경우가 아니면 함수의 인자로 함수를 사용하는 함수의 중첩이 가능하다.
    
- [ ]  문자형 함수
    
    ![https://postfiles.pstatic.net/20151204_254/liberty264_1449239060675hzJu9_JPEG/2.jpg?type=w3](https://postfiles.pstatic.net/20151204_254/liberty264_1449239060675hzJu9_JPEG/2.jpg?type=w3)
    
- [ ]  단일행 문자형 함수 사례
    
    ![https://postfiles.pstatic.net/20151204_135/liberty264_1449239103901AhOju_JPEG/3.jpg?type=w3](https://postfiles.pstatic.net/20151204_135/liberty264_1449239103901AhOju_JPEG/3.jpg?type=w3)
    
- [ ]  SQL Expert 라는 문자형 데이터의 길이를 구하는 문자형 함수를 사용하기
    
    ```sql
    SELECT LENGTH('SQL Expert') FROM DUAL; 
    
    --결과 : 10;
    
    예제 및 실행 결과를 보면 함수에 대한 결과 값을 마치 테이블에서 값을 조회했을 때와 
    비슷하게 표현한다. Oracle은 SELECT 절과 FROM 절 두 개의 절을 SELECT 문장의 필수
     절로 지정하였으므로 사용자 테이블이 필요 없는 SQL 문장의 경우에도 필수적으로 
    DUAL이라는 테이블을 FROM 절에 지정한다.
    
    ```
    

## 🟰DUAL 테이블

DUAL테이블은 데이터 딕셔너리와 함께 ORALCE에 의해 자동으로 생성되는 테이블

DUAL테이블은 사용자SYS의 스키마에 있지만 모든 사용자는 DUAL이라는 이름으로 엑세스 할 수 있다.

DUAL테이블은 VARCHAR2(1)으로 정의된 DUMMY라는 하나의 열이 있으며 값을 가지는 하나의 행도 포함

DUAL테이블은 사용자가 계산이나 사용자 함수등을 실행하고자 할 경우 유용하다.

- [ ]  DUAL 테이블의 특성
    
    사용자 SYS가 소유하며 모든 사용자가 액세스 가능한 테이블
    
    SELECT ~ FROM  ~의 형식을 갖추기 위한 일종의 DUMMY 테이블이다.
    
    DUMMY라는 문자열 유형의 칼럼에 ‘X’라는 값이 들어 있는 행을 1건 포함하고 있다.
    

## CONCAT문자형 함수

특별한 제약 조건이 없다면 함수는 여러 개를 중첩하여 사용이 가능하다

함수 내부에 다른 함수를 사용하여 위치해 있는 함수부터 실행되어 그 결과 값이 바깥쪽의 함수에 인자로 사용되는 것

```sql
SELECT CONCAT(PLAYER_NAME, ' 축구선수') 선수명
FROM PLAYER;

CONCAT 함수는 Oracle의 '||' 합성 연산자와 같은 기능이다.
SELECT PLAYER_NAME || ' 축구선수' AS 선수명
FROM PLAYER;

 
SQL Server에서 위의 예제와 같은 결과를 얻으려면 아래와 같이 수행하면 된다.

예제 SQL Server
SELECT PLAYER_NAME + ' 축구선수' AS 선수명
FROM PLAYER;
 

실행 결과
PLAYER_ID       선수명
 ---------               ------------
2011075             김성환 축구선수
2012123             가비 축구선수
2010089             강대희 축구선수
2007051             고종수 축구선수
2012015            고창현 축구선수
2009089            정기범 축구선수
 2009083           정동현 축구선수
2011071            정두현 축구선수
2012025            정준 축구선수
 2007040           정진우 축구선수
2007069            데니스 축구선수
 2007274           서정원 축구선수
      .                           .
      .                            .
480개의 행이 선택되었다.
```

- [ ]  경기장의 지역번호와 전화번호를 합친 번호의 길이를 구하시오.
    
    연결연산자의 결과가 LENGTH(SQL Server는 len사용)함수의 인수가 된다.
    
    ```sql
    --ORACLE
    SELECT STADIUM_ID, DDD||TEL AS TEL, LENGTH(DDD|TEL) AS T_LEN FROM STADIUM;
    
    --SQL SERVER
    SELECT STATDIUM_ID, DDD+TEL AS TEL, LEN(DDD+TEL) AS T_LEN FROM STADIUM;
    
    STADIUM_ID      TEL                    T_LEN
     ---------                 ----------               -----
    D03                        063273-1763       11
    B02                        031753-3956       11
    C06                        054282-2002       11
    D01                        061792-5600       11
    B05                        022128-2973       11
    [출처] 제 6절 함수|작성자 지그드시
    ```
    

## 🟰숫자형 함수

![https://postfiles.pstatic.net/20151204_61/liberty264_1449239279526H6tiu_JPEG/4.jpg?type=w3](https://postfiles.pstatic.net/20151204_61/liberty264_1449239279526H6tiu_JPEG/4.jpg?type=w3)

![https://postfiles.pstatic.net/20151204_18/liberty264_1449239280218iXXjC_JPEG/5.jpg?type=w3](https://postfiles.pstatic.net/20151204_18/liberty264_1449239280218iXXjC_JPEG/5.jpg?type=w3)

## 🟰날짜형 함수

![https://postfiles.pstatic.net/20151204_28/liberty264_14492393693431fUAq_JPEG/6.jpg?type=w3](https://postfiles.pstatic.net/20151204_28/liberty264_14492393693431fUAq_JPEG/6.jpg?type=w3)

DATE변수가 DB에서는 내부적으로 숫자 형식으로 변환하여 저장한다.

![https://postfiles.pstatic.net/20151204_90/liberty264_1449239417758HWVl2_JPEG/7.jpg?type=w3](https://postfiles.pstatic.net/20151204_90/liberty264_1449239417758HWVl2_JPEG/7.jpg?type=w3)

- [ ]  예제 사원 테이블의 입사일자에서 년, 월, 일 데이터를 각각 출력한다.

```sql
SELECT ENAME, HIREDATE,
 EXTRACT(YEAR FROM HIREDATE) 입사년도,
 EXTRACT(MONTH FROM HIREDATE) 입사월,
 EXTRACT(DAY FROM HIREDATE) 입사일
 FROM EMP;
 

예제 Oracle 함수
SELECT ENAME, HIREDATE,
TO_NUMBER(TO_CHAR(HIREDATE,'YYYY')) 입사년도,
TO_NUMBER(TO_CHAR(HIREDATE,'MM')) 입사월,
TO_NUMBER(TO_CHAR(HIREDATE,'DD')) 입사일 FROM EMP;
cf) TO_NUMBER 함수 제외시 문자형으로 출력됨 (ex: 01,02,03,...)
 

예제 SQL Server 함수
SELECT ENAME, HIREDATE,
DATEPART(YEAR, HIREDATE) 입사년도,
DATEPART(MONTH, HIREDATE) 입사월,
DATEPART(DAY, HIREDATE) 입사일
FROM EMP;
 

예제 SQL Server 함수
SELECT ENAME, HIREDATE,
YEAR(HIREDATE) 입사년도,
MONTH(HIREDATE) 입사월,
DAY(HIREDATE) 입사일
FROM EMP;

실행 결과
ENAME   HIREDATE  입사년도  입사월  입사일
 ------- ---------- ------- ------ ------
SMITH     1980-12-17    1980    12    17
ALLEN    1981-02-20    1981    2    20
WARD     1981-02-22     1981     2    22
JONES     1981-04-02     1981    4      2
MARTIN  1981-09-28      1981   9    28
BLAKE    1981-05-01     1981    5     1
CLARK    1981-06-09     1981    6     9
SCOTT     1987-07-13     1987    7    13
KING        1981-11-17      1981   11   17
TURNER  1981-09-08      1981   9     8
ADAMS    1987-07-13      1987   7    13
 JAMES      1981-12-03     1981   12   3
FORD         1981-12-03     1981   12    3
MILLER     1982-01-23     1982    1    23

14개의 행이 선택되었다.
[출처] 제 6절 함수|작성자 지그드시
```

## 🟰변환형 함수

변환형 함수는 특정 데이터 타입을 다양한 형식으로 출력하고 싶은 경우 사용되는 함수

변환형 함수는 크게 두 가지 방식이 있다.

![https://postfiles.pstatic.net/20151204_194/liberty264_14492394848019v8dM_JPEG/8.jpg?type=w3](https://postfiles.pstatic.net/20151204_194/liberty264_14492394848019v8dM_JPEG/8.jpg?type=w3)

암시적 데이터 유형 변환의 경우 성능 저하가 발생할 수 있으며, 자동적으로 DB가 알아서 계산하지 않는 경우가 있어 에러가 발생 될 수 있으므로 명시적인 데이터 유형 변환 방법을 사용하는 것이 바람직하다.

![https://postfiles.pstatic.net/20151204_252/liberty264_1449239500573UQnKt_JPEG/9.jpg?type=w3](https://postfiles.pstatic.net/20151204_252/liberty264_1449239500573UQnKt_JPEG/9.jpg?type=w3)

- [ ]  예제 날짜를 정해진 문자 형태로 변환
    
    ```sql
    SELECT TO_CHAR(SYSDATE, 'YYYY/MM/DD') 날짜,
    TO_CHAR(SYSDATE, 'YYYY. MON, DAY') 문자형
    FROM DUAL;
    
     날짜                  문자형
     ---------               ----------------
     2012-07-19        2012. 7월 , 월요일
    
    예제 및 실행 결과 SQL Server
    SELECT CONVERT(VARCHAR(10),GETDATE(),111) AS CURRENTDATE
    CURRNETDATE
     ----------
     2012/07/19
    [출처] 제 6절 함수|작성자 지그드시
    ```
    

## 🟰 CASE표현

IF-THEN-ELSE 논리와 유사한 방식으로 표현식을 작성

SQL의 비교 연산 기능을 보완하는 역할

ANSI/ISO SQL 표준에는 CASE Expression이라고 표시되어 있는데, 함수와 같은 성격을 가지고 있으며 oracle의 decode함수와 같은 기능을 하므로 단일행 내장 함수에서 같이 설명을 한다.

- [ ]  예제
    
    ```sql
    IF SAL > 2000
    	THEN REVISED_SALARY = SAL
    ELSE REVISED_SALARY = 2000
    END-IF.
    
    같은 기능을 하는 CASE표현
    
    SELECT NAME,
    	CASE
    	WHEN SAL >2000
    	THEN SAL
    	ELSE 2000
    	END REVISED_SALARY
    FROM EMP;
    
    결과
    ENAME   REVISED_SALARY
    --------       -------------
    SMITH      2000
    ALLEN     2000
    WARD      2000
    JONES      2975
    MARTIN  2000
    BLAKE    2850
    CLARK    2450
    SCOTT     3000
    KING       5000
    TURNER 2000
    ADAMS  2000
    JAMES    2000
    FORD      3000
    MILLER 2000
    14개의 행이 선택되었다.
    [출처] 제 6절 함수|작성자 지그드시
    ```
    
    CASE표현을 하기 위해서는 조건절을 표현하는 두가지 방법이 있고, ORACLE의경우 DECODE함수를 사용할 수도 있다.
    
    ![https://postfiles.pstatic.net/20151204_171/liberty264_1449239625905KaMSW_JPEG/10.jpg?type=w3](https://postfiles.pstatic.net/20151204_171/liberty264_1449239625905KaMSW_JPEG/10.jpg?type=w3)
    
    - [ ]  예시
        
        ```sql
        SIMPLE_CASE_EXPRESSION 의 예)
        
        CASE
                 EXPR WHEN COMPARISON_EXPR    THEN     RETURN_EXPR  
                 ELSE 표현절
        END
        
         
        예제 부서 정보에서 부서 위치를 미국의 동부, 중부, 서부로 구분하라.
        
        예제
         SELECT LOC,
        CASE LOC
                          WHEN 'NEW YORK'   THEN 'EAST'  
                          WHEN 'BOSTON' THEN 'EAST'
                          WHEN 'CHICAGO' THEN 'CENTER'
                          WHEN 'DALLAS' THEN 'CENTER'
                          ELSE 'ETC' END as AREA
         FROM DEPT;
        
        실행 결과
         LOC                  AREA
         ---------              --------
        NEW YORK      EAST
        DALLAS           CENTER
        CHICAGO        CENTER
        BOSTON          EAST
        4개의 행이 선택되었다.
        
         
        
        *형식)
        
        CASE
                 WHEN CONDITION THEN RETURN_EXPR
                 ELSE 표현절
        END
        
         
        예제 사원 정보에서 급여가 3000 이상이면 상등급으로, 1000 이상이면 중등급으로, 1000 미만이면 하등급으로 분류하라.
        
        예제
        SELECT ENAME,
                            CASE
                            WHEN SAL >= 3000 THEN 'HIGH'
                            WHEN SAL >= 1000 THEN 'MID'
                            ELSE 'LOW' END AS SALARY_GRADE
        FROM EMP;
        
        실행 결과
        ENAME         SALARY_GRADE
         --------           -------------
        SMITH          LOW
        ALLEN         MID
        WARD          MID
        JONES          MID
        MARTIN      MID
        BLAKE        MID
        CLARK        MID
        SCOTT         HIGH
        KING           HIGH
        TURNER     MID
        ADAMS      MID
        JAMES        LOW
        FORD          HIGH
        MILLER      MID
        14개의 행이 선택되었다.
        
        * CASE 표현은 함수의 성질을 가지고 있으므로, 다른 함수처럼 중첩해서 사용할 수 있다.
        
        P. 244의 예제 참조
        [출처] 제 6절 함수|작성자 지그드시
        ```
        

## 🟰NVL/ISNULL 함수

널 값은 아직 정의되지 않은 값으로 0 또는 공백과 다르다.

0은 숫자, 공백은 하나의 문자이다.

테이블을 생성할때 NOT NULL, PRIMARY KEY로 정의되지 않은 모든 데이터 유형은 널 값을 포함할 수 있다.

널 값을 포함하는 연산의 경우 결과 값도 널 값이다. 모르는 데이터에 수잦를 더하거나 빼도 결과는 마찬가지로 모르는 데이터인 것과 같다.

결과값을 NULL이 아닌 다른 값을 얻고자 할 때 NVL/ISNULL 함수를 사용한다.

NULL값의 대상이 숫자 유형 데이터인 경우는 주로 0으로, 문자 유형 데이터인 경우는 블래읔보다는 ‘X’같이 해당 시스템에서 의미없는 문자로 바꾸는 경우가 많다.

![https://postfiles.pstatic.net/20151204_266/liberty264_1449239759648uOhzk_JPEG/11.jpg?type=w3](https://postfiles.pstatic.net/20151204_266/liberty264_1449239759648uOhzk_JPEG/11.jpg?type=w3)

![https://postfiles.pstatic.net/20151204_251/liberty264_14492397715306IttY_JPEG/12.jpg?type=w3](https://postfiles.pstatic.net/20151204_251/liberty264_14492397715306IttY_JPEG/12.jpg?type=w3)

```sql
Oracle의 경우 NVL 함수를 사용한다.

형식) NVL (NULL 판단 대상,‘NULL일 때 대체값’)
 

예제 및 실행 결과 Oracle
SELECT NVL(NULL, 'NVL-OK') NVL_TEST
FROM DUAL;
 NVL_TEST ------- NVL-OK 1개의 행이 선택되었다.

예제 및 실행 결과 Oracle
SELECT NVL('Not-Null', 'NVL-OK') NVL_TEST
FROM DUAL;

NVL_TEST
 -------
 Not-Null 1개의 행이 선택되었다.

 
* SQL Server의 경우 ISNULL 함수를 사용한다.

형식) ISNULL (NULL 판단 대상,‘NULL일 때 대체값’)

예제 및 실행 결과 SQL Server
SELECT ISNULL(NULL, 'NVL-OK') ISNULL_TEST ;

ISNULL_TEST
 ---------
 NVL-OK
1개의 행이 선택되었다.

 

예제 선수 테이블에서 성남 일화천마(K08) 소속 선수의 이름과 포지션을 출력하는데, 
포지션이 없는 경우는 '없음'으로 표시한다.

예제 Oracle
SELECT PLAYER_NAME 선수명, POSITION, NVL(POSITION,'없음') 포지션
FROM PLAYER
WHERE TEAM_ID = 'K08'

예제 SQL Server
SELEC PLAYER_NAME 선수명, POSITION, ISNULL(POSITION,'없음') 포지션
FROM PLAYER
WHERE TEAM_ID = 'K08'

 
예제 NVL 함수와 ISNULL 함수를 사용한 SQL 문장은 
벤더 공통적으로 CASE 문장으로 표현할 수 있다

예제 SQL Server
SELECT PLAYER_NAME 선수명, POSITION,
                CASE
                         WHEN  POSITION IS NULL
                         THEN   '없음'
                         ELSE    POSITION
                END AS 포지션
FROM PLAYER 
WHERE TEAM_ID = 'K08'

실행 결과
선수명   POSITION  포지션
--------       ---------     ------
차경복        DF           DF
정학범                       없음
안익수                       없음
차상광                       없음
권찬수         GK           GK
정경두         GK           GK
정해운         GK           GK
양영민         GK           GK
가이모토      DF            DF
정두영          DF             DF
정명휘         DF             DF
정영철         DF             DF
곽치국        MF             MF
정상식        MF            MF
서관수        FW            FW
김성운        FW            FW
김정운        FW            FW
장동현        FW             FW
45개의 행이 선택되었다.

 
예제 급여와 커미션을 포함한 연봉을 계산하면서 NVL 함수의 필요성을 알아본다.

예제
SELECT  ENAME 사원명,     SAL 월급,     COMM 커미션,
                (SAL * 12) + COMM 연봉A, (SAL * 12) + NVL(COMM,0) 연봉B
 FROM EMP;

실행 결과
사원명     월급      커미션      연봉A      연봉B
 -------        -----         ------          -----          -----
SMITH      800                                           9600
ALLEN    1600          300           19500     19500
WARD      1250         500           15500     15500
JONES      2975                                         35700
MARTIN   1250       1400           16400    16400
BLAKE     2850                                        34200
CLARK     2450                                        29400
SCOTT      3000                                        36000
KING         5000                                        60000
TURNER    1500        0                18000   18000
ADAMS      1100                                       13200
JAMES         950                                       11400
 FORD        3000                                       36000
MILLER     1300                                       15600
14개의 행이 선택되었다.

 

 실행 결과에서 월급에 커미션을 더해서 연봉을 계산하는 산술식이 있을 때 커미션에 NULL 값이 있는 경우 커미션 값에 NVL() 함수를 사용하지 않으면 연봉A의 계산 결과가 NULL이 되어서 잘못 계산한 결과를 확인할 수 있다. 따라서 연봉B 결과와 같이 NVL(COMM,0)처럼 NULL 값을 0으로 변환하여 연봉을 계산해야 하는 것이다.

 
[출처] 제 6절 함수|작성자 지그드시
```

## 공집합의 NVL/ISNULL 함수 사용

SELECT 1 FROM DUAL WHERE 1 = 2;와 같은 조건이 대표적인 공집합을 발생시키는 쿼리이다.

위와 같이 조건에 맞는 데이터가 한 건도 없는 경우를 공집합 이라고 하고, NULL 데이터와는 또 다르게 이해해야 한다.

```sql
공집합을 발생시키기 위해 사원 테이블에 존재하지 않는 'JSC'라는 이름으로 데이터를 검색한다.

예제 및 실행 결과
SELECT MGR
FROM EMP
WHERE ENAME='JSC';
 
데이터를 찾을 수 없다.
 ☞ EMP 테이블에 ENAME이‘JSC’란 사람은 없으므로 공집합이 발생한다.

 
STEP2. NVL/ISNULL 함수를 이용해 공집합을 9999로 바꾸고자 시도한다.

예제 및 실행 결과
SELECT NVL(MGR, 9999) MGR
FROM EMP
WHERE ENAME='JSC';

데이터를 찾을 수 없다.
☞ 많은 분들이 공집합을 NVL/ISNULL 함수를 이용해서 처리하려고 하는데, 
인수의 값이 공집합인 경우는 NVL/ISNULL 함수를 사용해도 역시 공집합이 출력된다.
 ☞ NVL/ISNULL 함수는 NULL 값을 대상으로 다른 값으로 바꾸는 함수이지 
공집합을 대상으로 하지 않는다.

 
STEP3. 적절한 집계 함수를 찾아서 NVL 함수 대신 적용한다.

예제 및 실행 결과
SELECT MAX(MGR) MGR FROM EMP WHERE ENAME='JSC';

MGR
-----
1개의 행이 선택되었다.
☞ 빈 칸으로 표시되었지만 실 데이터는 NULL이다.
☞ 다른 함수와 달리 집계 함수와 Scalar Subquery의 경우는 
인수의 결과 값이 공집합인 경우에도 NULL을 출력한다.
참고) Scalar Subquery? http://blog.naver.com/nakarac?Redirect=Log&logNo=100126016921

STEP4. 집계 함수를 인수로 한 NVL/ISNULL 함수를 이용해서 공집합인 경우에도 
빈칸이 아닌 9999로 출력하게 한다.

예제 및 실행 결과
SELECT NVL(MAX(MGR), 9999) MGR
FROM EMP WHERE ENAME='JSC';

 MGR
-----
9999
1개의 행이 선택되었다.
☞ 공집합의 경우는 NVL 함수를 사용해도 공집합이 출력되므로, 
그룹함수와 NVL 함수를 같이 사용해서 처리한다. 
예제는 그룹함수를 NVL 함수의 인자로 사용해서 인수의 값이 공집합인 경우에도 
원하는 9999라는 값으로 변환한 사례이다.

 
Oracle의 SQL*PLUS 같이 화면에서 데이터베이스와 직접 대화하는 환경이라면, 
화면상에서 “데이터를 찾을 수 없다.”라는 문구로 공집합을 구분할 수 있지만, 
다른 개발 언어 내에 SQL 문장이 포함된 경우에는 NULL과 공집합을 쉽게 구분하기 힘들다. 
개발자들은 NVL/ISNULL 함수를 사용해야 하는 경우와, 
집계 함수를 포함한 NVL/ISNULL 함수를 사용해야 하는 경우와, 
1장 7절에서 설명할 NVL/ISNULL 함수를 포함한 집계 함수를 사용하지 않아야 될 경우까지 
잘 이해해서 NVL/ISNULL 함수를 정확히 사용해야 한다.

다. NULLIF

NULLIF 함수는 EXPR1이 EXPR2와 같으면 NULL을, 같지 않으면 EXPR1을 리턴한다. 
특정 값을 NULL로 대체하는 경우에 유용하게 사용할 수 있다.

NULLIF (EXPR1, EXPR2)

예제) p.252 참고

 
라. 기타 NULL 관련 함수 (COALESCE)

COALESCE 함수는 인수의 숫자가 한정되어 있지 않으며, 
임의의 개수 EXPR에서 NULL이 아닌 최초의 EXPR을 나타낸다. 
만일 모든 EXPR이 NULL이라면 NULL을 리턴한다.

COALESCE (EXPR1, EXPR2, …)

예제 사원 테이블에서 커미션을 1차 선택값으로,
급여를 2차 선택값으로 선택하되 두 칼럼 모두 NULL인 경우는 NULL로 표시한다.

예제
SELECT ENAME, COMM, SAL, COALESCE(COMM, SAL) COAL
FROM EMP;

COALESCE 함수는 두개의 중첩된 CASE 문장으로 표현할 수 있다.
예제) P.253 참조
[출처] 제 6절 함수|작성자 지그드시
```