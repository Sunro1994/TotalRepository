# SQLD [과목1] 1장 3절 속성(Attribute)

작성일시: 2023년 8월 19일 오후 2:32
종류: SQL
복습: No

## 🟰속성의 개념

- [ ]  📌개념

업무에서 필요로 한다

의미상 더 이상 분리되지 않는다

엔터티를 설명하고 인스턴스의 구성요소가 된다

## 🟰엔터티, 인스턴스와 속성, 속성값에 대한 내용과 표기법

- [ ]  📌⭐⭐엔터티, 인스턴스, 속성, 속성값의 관계
    
    한 개의 엔터티는 두개 이상의 인스턴스 집합이다.
    
    한 개의 엔터티는 두 개 이상의 속성을 갖는다
    
    한 개의 속성은 한 개의 속성값을 갖는다.
    
    ![https://postfiles.pstatic.net/20151204_204/liberty264_14492110755720vnQh_JPEG/2.jpg?type=w3](https://postfiles.pstatic.net/20151204_204/liberty264_14492110755720vnQh_JPEG/2.jpg?type=w3)
    
    <aside>
    💡 예시
    
    사원(엔터티) 에는 홍길동(엔터티)가 있다. 홍길동이라는 사람의 이름(속성)은 홍길동(속성값)이고 주소(속성)은 강서구(속성값)이다.
    
    </aside>
    
- [ ]  📌속성의 표기법
    
    엔터티 내에 이름을 포함하여 표현
    
    ![출처 : [https://blog.naver.com/liberty264/220558732682](https://blog.naver.com/liberty264/220558732682)](https://postfiles.pstatic.net/20151204_134/liberty264_1449211101382jkJGx_JPEG/SQL_034.jpg?type=w3)
    
    출처 : [https://blog.naver.com/liberty264/220558732682](https://blog.naver.com/liberty264/220558732682)
    
- [ ]  📌속성의 분류
    
    `**기본 속성**`
    
    업무로부터 추출한 모든 속성
    
    엔터티에 **가장 일반적이고 많은 속성을 차지**
    
    **코드성 데이터**, 엔터티를 식별하기 위해 부여된 **일련번호**, 다른 속성을 계산하거나 **영향을 받아 생성된 속성**을 제외한 모든 속성
    
    업무로부터 분석한 속성이라도 이미 업무상 코드로 정의한 속성이 많다는 것을 주의(기본속성이 되지 않음)
    
    `**설계속성**`
    
    업무상 필요한 데이터 이외에 데이터 모델링
    
    업무를 **규칙화**하기 위해 속성을 새로 만들거나 변형하여 정의
    
    코드성 속성은 원래 속성을 **업무상 필요에 의해 변형하여 만든 설계속성**
    
    일련번호와 같은 속성은 단일한 식별자를 부여하기 위해 모델 상에서 새로 정의하는 설계속성
    
    **`파생속성`**
    
    다른 속성에 영향을 받아 발생하는 속성(계산된 값)
    
    다른 속성에 영향을 받기 때문에 프로세스 설계 시 데이터 정합성을 유지하기 위해 유의해야 할 점이 많다
    
    **가급적 적게 정의하는것이 좋다**
    
    ![https://postfiles.pstatic.net/20151204_279/liberty264_1449211160917P6A4b_JPEG/SQL_035.jpg?type=w3](https://postfiles.pstatic.net/20151204_279/liberty264_1449211160917P6A4b_JPEG/SQL_035.jpg?type=w3)
    
- [ ]  엔터티 구성방식에 따른 분류
    
    PK(Primary Key)
    
    엔터티를 식별할 수 있느 ㄴ속성
    
    FK(Foreign Key)
    다른 엔터티와의 관계에서 포함된 속성
    
    일반속성
    
    PK,FK에 포함되지 않은 속성
    
    ![https://postfiles.pstatic.net/20151204_50/liberty264_1449211312268W9VHk_JPEG/SQL_036.jpg?type=w3](https://postfiles.pstatic.net/20151204_50/liberty264_1449211312268W9VHk_JPEG/SQL_036.jpg?type=w3)
    

## 🟰도메인(Domain)

각 속성이 가질 수 있는 값의 범위

엔터티 내에서 속성에 대한 데이터 타입과 크기 그리고 제약사항을 지정하는 것

예시 : 학점 number check( between 0 and 10)

학점의 타입은 number, 제약사항은 0~10까지

 

## 🟰속성의 명명(Naming)

해당 업무에서 사용하는 이름을 부여

서술식 속성명은 사용하지 말것

약어사용은 가급적 제한

전체 데이터모델에서 유일성을 확보