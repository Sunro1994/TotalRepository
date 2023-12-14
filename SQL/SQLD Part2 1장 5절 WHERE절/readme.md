# SQLD [과목2] 1장 5절 WHERE절

작성일시: 2023년 9월 2일 오후 11:07
종류: SQL
복습: No

## 🟰WHERE절

사용자들은 자신이 원하는 자료만 검색하기 위해서 SQL문장에 WHERE 절을 이용하여 자료들에 대하여 제한

WHERE절에 조건이 없는 FTS(FULL TABLE SCAN)문장은 SQL튜닝의 1차적인 검토 대상이 된다.

(FTS가 무조건 나쁜 것은 아니며 병렬 처리 등을 위해 유용하게 사용하는 경우도 많다.)

- [ ]  연산자의 종류
    
    ![https://postfiles.pstatic.net/20151204_54/liberty264_14492383228617Ic7v_JPEG/1.jpg?type=w3](https://postfiles.pstatic.net/20151204_54/liberty264_14492383228617Ic7v_JPEG/1.jpg?type=w3)
    
- [ ]  문자 유형간의 비교 방법
    
    ![https://postfiles.pstatic.net/20151204_137/liberty264_1449238346946a6u9C_JPEG/2.jpg?type=w3](https://postfiles.pstatic.net/20151204_137/liberty264_1449238346946a6u9C_JPEG/2.jpg?type=w3)
    

- [ ]  연산자의 우선순위
    
    ![https://postfiles.pstatic.net/20151204_114/liberty264_1449238408706JcMjS_JPEG/3.jpg?type=w3](https://postfiles.pstatic.net/20151204_114/liberty264_1449238408706JcMjS_JPEG/3.jpg?type=w3)
    
    - [ ]  우선순위를 무시한 쿼리문 예시
        
        문제
        
        소속팀이 삼성블루윙즈이거나 전남드래곤즈에 소속된 선수들이어야 하고, 포지션이 미드필더(MF:Midfielder)이어야 한다. 키는 170 센티미터 이상이고 180 이하여야 한다. 1) 소속팀이 삼성블루윙즈 OR 소속팀이 전남드래곤즈 2) AND 포지션이 미드필더 3) AND 키는 170 센티미터 이상 4) AND 키는 180 센티미터 이하
        
        ✅잘못된 쿼리문
        
        ```sql
        SELECT PLAYER_NAME 선수이름, POSITION 포지션, 
        
                      BACK_NO 백넘버, HEIGHT 키
        
         FROM PLAYER
        
         WHERE TEAM_ID = 'K02' OR TEAM_ID = 'K07' << 괄호 누락으로 AND연산자가 먼저 수행되었다.
        
             AND POSITION = 'MF'
        
             AND HEIGHT >= 170 AND HEIGHT <= 180;
        
        ```
        
        ✅올바른 쿼리문
        
        ```sql
        SELECT PLAYER_NAME 선수이름, POSITION 포지션, 
        
                      BACK_NO 백넘버, HEIGHT 키
        
         FROM PLAYER
        
         WHERE (TEAM_ID = 'K02' OR TEAM_ID = 'K07')
        
             AND POSITION = 'MF'
        
             AND HEIGHT >= 170 AND HEIGHT <= 180;
        
        ```
        

## 🟰ROWNUM , TOP 사용

- [ ]  ROWNUM
    
    WHERE절에서 행의 개수를 제한하는 목적
    
    1건의 행만 가져오고 싶을 때 예시문
    
    ```sql
    SELECT PLAYER_NAME FROM PLAYER WHERE ROWNUM =1;
    SELECT PLAYER_NAME FROM PLAYER WHERE ROWNUM <= 1;
    
     SELECT PLAYER_NAME FROM PLAYER WHERE ROWNUM <2;
    
    ```
    
    2건의 행이상을 가져오고 싶을 떄 에는 ROWNUM = N처럼 사용할 수 없다.
    
    ```sql
    SELECT PLAYER_NAME FROM PLAYER WHERE ROWNUM <= N;
    ```
    
- [ ]  TOP절
    
    SQL SERVER는 TOP절을 사용하여 겨로가 집합으로 출력되는 행의 수를 제한할 수 있다.
    
    TOP(EXPRESSION) / PERCENT / WITH TIES
    
    - EXPRESSION : 반환할 행의 수를 지정하는 숫자
    - PERCENT : 쿼리 겨로가 집합에서 처음 EXPRESSION의 행만 반환됨
    - WITH TIES : ORDER BY 절이 지정된 경우에만 사용할 수 있으며, TOP N(PERCENT)의 마지막 행과 같은 값이 있는 경우 추가 행이 출력되도록 지정할 수 있다.
    - [ ]  예시 코드
        
        ```sql
        --한 건의 행만 가져오고 싶을 때
        SELECT TOP(1) PLAYER_NAME FROM PLAYER;
        
        --두 건이상의 행을 가져오고 싶을 때
        SELET TOP(N) PLAYER_NAME FROM PLAYER;
        ```