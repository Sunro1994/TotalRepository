# SQLD [과목1] 1장 4절 관계

작성일시: 2023년 8월 20일 오전 2:05
종류: SQL
복습: No

## 🟰관계의 개념

- [ ]  관계의 정의
    
    ![https://postfiles.pstatic.net/20151204_132/liberty264_14492117569223wMXl_JPEG/SQL_038.jpg?type=w3](https://postfiles.pstatic.net/20151204_132/liberty264_14492117569223wMXl_JPEG/SQL_038.jpg?type=w3)
    
- [ ]  관계의 페어링
    
    `**페어링**` 
    
    엔터티 안에 인스턴스가 개별적으로 관계를 가지는 것
    
    `**관계의 페어링`** 
    
    페어링의 집합을 관계로 표현하는 것
    
    각각의 엔터티의 인스턴스들은 자신이 관련된 인스턴스들과 관계의 어커런스로 참여하는 형태
    
    개별인스턴스가 각각 다른 종류의 관계를 가지고 있다면 엔터티 사이에 두 개 이상의 관계가 형성될 수 있다.
    
    ![https://postfiles.pstatic.net/20151204_88/liberty264_1449211820267poEdW_JPEG/SQL_039.jpg?type=w3](https://postfiles.pstatic.net/20151204_88/liberty264_1449211820267poEdW_JPEG/SQL_039.jpg?type=w3)
    
    `**관계 페어링**`에 대한 예시
    
    📌강사(엔터티)에서 정성철(인스턴스)는 수강생(엔터티)의 이춘식,황종하(인스턴스)를 가르친다.
    
    📌강사(엔터티)에서 조시형(인스턴스)는 수강생(엔터티)의 황종하(인스턴스)를 가르친다.
    
    엔터티는 인스턴스의 집합을 논리적으로 표현했다면, 관계는 관계 페어링의 집합을 논리적으로 표현한 것
    

## 🟰관계의 분류

![https://postfiles.pstatic.net/20151204_74/liberty264_1449211894346Pl9lu_JPEG/SQL_040.jpg?type=w3](https://postfiles.pstatic.net/20151204_74/liberty264_1449211894346Pl9lu_JPEG/SQL_040.jpg?type=w3)

- [ ]  존재에 의한 관계
    
    행위에 따른 이벤트에 의해 발생되는 것이 아닌 존재의 형태에 의해 관계가 형성되는것
    
    예시 : 황경빈 사원은 DB팀에 속해있는 상태
    
- [ ]  행위에 의한 관계
    
    행위에 의해 발생되는 두 엔터티 사이의 관계
    
    예시 : 김경재라는 손님이 ‘주문한다’라는 행위를 통해 CTA201이라는 주문번호를 생성
    
    주문 엔터티의 CTA201은 김경재 고객이 ‘주문’이라는 행위에 의해 생성된 행위에 의한 관계
    

## 🟰관계의 표기법

표기명이 상당히 복잡하고 여러가지 의미를 가지고 있다.

3가지 표기법을 개념과 함께 이해해야 한다.

1. 관계명(Membership) : 관계의 이름
2. 관계차수(Cardinality) : 1:1, 1:M, M:N 
3. 관계선택사양(Optionality) : 필수관계, 선택관계

- [ ]  관계명(Membership)
    
    엔터티가 관계에 참여하는 형태
    
    각각의 관계는 두 개의 관계명을 가지고 있다.
    
    각각의 관계명에 의해 두 가지 관점으로 표현될 수 있다.
    
    ![https://postfiles.pstatic.net/20151204_243/liberty264_1449211982686LBHlX_JPEG/SQL_041.jpg?type=w3](https://postfiles.pstatic.net/20151204_243/liberty264_1449211982686LBHlX_JPEG/SQL_041.jpg?type=w3)
    
    관계 시작점(The Beginning) : 관계가 시작되는 편
    
    관계끝점(The End) : 받는 편
    
    관계 시작점과 끝점 모두 관계이름을 가져야 한다
    
    참여자의 관점에 따라 관계이름을 능동적이거나 수동적으로 명명
    
    다음과 같은 명명규칙에 따라 작성해야한다.
    
    📌애매한 동사를 피한다. ( `관계된다 , 관련이 있다, 이다, 한다` 등은 구체적이지 않다)
    
    📌현재형으로 표현한다.(`수강을 신청했다, 강의를 할 것이다` x , `수강 신청한다` o )
    
- [ ]  관계차수(Degree/Cardinality)
    
    두 개의 엔터티간 관계에서 참여자의 수를 표현하는 것
    
    📌1:1관계 표시법
    
    ![https://postfiles.pstatic.net/20151204_101/liberty264_1449212043933CbWXE_JPEG/SQL_042.jpg?type=w3](https://postfiles.pstatic.net/20151204_101/liberty264_1449212043933CbWXE_JPEG/SQL_042.jpg?type=w3)
    
    📌1:M관계 표시법
    
    ![https://postfiles.pstatic.net/20151204_143/liberty264_1449212066807EaUfn_JPEG/SQL_043.jpg?type=w3](https://postfiles.pstatic.net/20151204_143/liberty264_1449212066807EaUfn_JPEG/SQL_043.jpg?type=w3)
    
    📌M:N관계 표시법
    
    ![https://postfiles.pstatic.net/20151204_299/liberty264_1449212091060KrDlC_JPEG/SQL_044.jpg?type=w3](https://postfiles.pstatic.net/20151204_299/liberty264_1449212091060KrDlC_JPEG/SQL_044.jpg?type=w3)
    
    이렇게 M:N관계로 표현된 데이터의 모델은 이후에 두 개의 주 식별자를 상속받은 관계 엔터티를 이용하여 3개의 엔터티로 구분하여 표현한다.
    
- [ ]  관계선택사양(Optionality)
    
    ![https://postfiles.pstatic.net/20151204_226/liberty264_1449212142636YRwbX_JPEG/SQL_045.jpg?type=w3](https://postfiles.pstatic.net/20151204_226/liberty264_1449212142636YRwbX_JPEG/SQL_045.jpg?type=w3)
    
    📌지하철 문이 닫혀야 출발한다 : 필수참여(Mandatory Membership)
    
    📌지하철에서 방송이 나온다 : 선택참여(Optional Membership)
    
    필수참여
    
    참여하는 모든 참여자가 반드시 관계를 가지는, 타 엔터티의 참여자와 연결이 되어야 하는 관계
    
    예시 : 주문서는 반드시 주문목록을 가져야 한다.
    
    선택참여
    
    물리속성에서 FK로 연결된 경우 Null을 허용할 수 있는 항목이 된다.
    
    ERD에서 관계를 나타내는 선에서 선택참여하는 엔터티쪽을 원으로 표시
    
    양쪽이 모두 선택참여가 되는 경우에는 잘못될 확률이 많으므로(0:0의 관계) 관계설정이 잘 못 되었는지 확인해본다.
    
    예시 : 목록은 주문이 될 수도이쏙 주문이 되지 않을수도 있다.
    
    ![https://postfiles.pstatic.net/20151204_67/liberty264_1449212236002Fla89_JPEG/SQL_046.jpg?type=w3](https://postfiles.pstatic.net/20151204_67/liberty264_1449212236002Fla89_JPEG/SQL_046.jpg?type=w3)
    

🟰관계의 정의 및 읽는 방법

- [ ]  관계 체크사항
    
    두 개의 엔터티 사이에서 관계를 정의할 때 다음 사항을 체크한다.
    
    📌두 개의 엔터티 사이에 관심있는 연관규칙이 존재하는가?
    
    📌두 개의 엔터티 사이에 정보의 조합이 발생되는가?
    
    📌업무기술서, 장표에 관계연결에 대한 규칙이 서술되어 있는가?
    
    📌업무기술서, 장표에 관계연결을 가능하게 하는 동사가 있는가?
    
- [ ]  관계 읽기
    
    관계에 참여하는 기준 엔터티를 하나 또는 각 엔터티로 읽고 대상 엔터티의 개수를 읽고 관계선택사양과 관계명을 읽도록 한다.
    
    ![https://postfiles.pstatic.net/20151204_122/liberty264_14492122993060rviD_JPEG/SQL_047.jpg?type=w3](https://postfiles.pstatic.net/20151204_122/liberty264_14492122993060rviD_JPEG/SQL_047.jpg?type=w3)