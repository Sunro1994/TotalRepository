# SQLD [과목1] 1장 5절 식별자

작성일시: 2023년 8월 20일 오전 2:41
종류: SQL
복습: No

## 🟰식별자(Identifies) 개념

식별자는 엔터티를 구분짓는 논리적인 이름

식별자는 엔터티를 대표할 수 있는 속성

엔터티에는 반드시 하나의 유일한 식별자가 존재한다

## 🟰식별자의 특징(유,최,불,존)

주 식별자에 의해 엔터티내에 모든 인스턴스들이 유일하게 구분되어야 한다

주식별자를 구성하는 속성의 수는 유일성을 만족하는 최소의 수가 되어야 한다

주식별자가 지정이 되면 반드시 값이 들어와야 한다.

![https://postfiles.pstatic.net/20151204_230/liberty264_1449212864025SJoLu_JPEG/1.jpg?type=w3](https://postfiles.pstatic.net/20151204_230/liberty264_1449212864025SJoLu_JPEG/1.jpg?type=w3)

## 🟰식별자 분류 및 표기법

- [ ]  식별자 분류
    
    ![https://postfiles.pstatic.net/20151204_180/liberty264_1449212899481SpMGA_JPEG/2.jpg?type=w3](https://postfiles.pstatic.net/20151204_180/liberty264_1449212899481SpMGA_JPEG/2.jpg?type=w3)
    
- [ ]  식별자 표기법
    
    ![https://postfiles.pstatic.net/20151204_169/liberty264_1449212986520SwlBR_JPEG/3.jpg?type=w3](https://postfiles.pstatic.net/20151204_169/liberty264_1449212986520SwlBR_JPEG/3.jpg?type=w3)
    

## 🟰주식별자 도출기준

- [ ]  해당 업무에서 자주 사용되는 속성을 지정한다.
    
    ![https://postfiles.pstatic.net/20151204_83/liberty264_1449213011615rUTVJ_JPEG/4.jpg?type=w3](https://postfiles.pstatic.net/20151204_83/liberty264_1449213011615rUTVJ_JPEG/4.jpg?type=w3)
    

예시 :

직원(엔터티) - 사원번호, 주민번호

주문자(엔터티) - 고객 등록번호, 주민번호, 이메일, 핸드폰번호

- [ ]  명칭, 내역 등과 같이 이름으로 기술되는 것들은 피한다.
    
    엔터티에서 구분자가 존재하지 않을 경우 새로운 식별자를 생성한다(일련번호, 코드)
    
    ![https://postfiles.pstatic.net/20151204_135/liberty264_1449213043852nQFWX_JPEG/5.jpg?type=w3](https://postfiles.pstatic.net/20151204_135/liberty264_1449213043852nQFWX_JPEG/5.jpg?type=w3)
    
- [ ]  복합으로 주식별자로 구성할 경우 너무 많은 속성이 포함되지 않도록 한다.
    
    주식별자의 개수가 많을 경우 새로운 인조식별자를 생성한다.
    
    ![https://postfiles.pstatic.net/20151204_66/liberty264_1449213087377xBB4U_JPEG/6.jpg?type=w3](https://postfiles.pstatic.net/20151204_66/liberty264_1449213087377xBB4U_JPEG/6.jpg?type=w3)
    

## 🟰식별자관계와 비식별자관계에 따른 식별자

- [ ]  식별자관계와 비식별자 관계의 결정
    
    외부식별자는 자기 자신의 엔터티에서 필요한 속성이 아니라 다른 엔터티와의 관계를 통해 자식 쪽에 엔터티에 생성되는 속성을 외부식별자라 한다.
    
    데이터 생성 시 FK역할
    
    엔터티에 주식별자가 지정되고 엔터티간의 관계를 연결하면 부모쪽의 주식별자를 자식엔터티의 속성으로 내려보낸다. 이 때 자식엔터티에서 부모엔터티로부터 받은 외부식별자를 자신의 주식별자로 이용할 것인지 또는 부모와 연결되는 속성으로서만 이용할 것인지 결정해야 한다
    
    - [ ]  식별자 관계
        
        자식엔터티의 주시별자로 부모의 주식별자가 상속되는 경우
        
        Null값이 오면 안된다
        
        1:1 관계 : 부모로부터 받은 속성을 자식엔터티가 모두 사용하고 그것만으로 주식별자로 사용할 경우
        
        1:M관계 : 부모로부터 받은 속성, 다른 부모엔터티에서 받은 속성, 스스로 가진 속성으로 주식별자가 구성된 경우
        
    - [ ]  비식별자 관계(Non-Identifying Relationship)
        
        부모엔터티로부터 속성을 받았지만 자식엔터티의 주식별자로 사용하지 않고 일반적인 속성으로 사용하는 경우
        
        예시
        
        자식엔터티에서 받은 속성이 반드시 필수가 아니기에 부모 없는 자식이 생성될 수 있는 경우
        
        엔터티별로 데이터의 생명주기를 다르게 할 경우
        
        여러 개의 엔터티가 하나의 엔터티로 통합되어 표현되었는데 각각의 엔터티가 별도의 관계를 가질 떄
        
        자식엔터티에서 별도의 주식별자를 생성하는 것이 더 유리한 경우
        
    - [ ]  식별자 관계로만 설정할 경우 문제점
        
        주식별자 속성이 지속적으로 증가한다
        
        주식별자 증가로 복잡성과 오류가능성을 유발시킬 수 있다.
        
    - [ ]  비식별자로만 설정할 경우 문제점
        
        자식엔터티로 상속되지 않는다
        
        속성이 자식엔터티로 상속되지 않아 부모엔터티까지 조인된다
        
        불필요한 조인 발생으로 SQL구문도 길어져 성능 저하 현상 발생
        
    - [ ]  식별자관계와 비식별자관계 모델링
        
        식별자관계 선택 프로세스
        
        다음 조건에 해당할 경우 비식별자관계로 조정
        
        ![https://postfiles.pstatic.net/20151204_215/liberty264_1449213222066379SE_JPEG/7.jpg?type=w3](https://postfiles.pstatic.net/20151204_215/liberty264_1449213222066379SE_JPEG/7.jpg?type=w3)
        
        식별자와 비식별자 관계 비교
        
        ![https://postfiles.pstatic.net/20151204_149/liberty264_1449213244091BixEa_JPEG/8.jpg?type=w3](https://postfiles.pstatic.net/20151204_149/liberty264_1449213244091BixEa_JPEG/8.jpg?type=w3)
        
        식별자와 비식별자를 적용한 데이터 모델
        
        ![https://postfiles.pstatic.net/20151204_189/liberty264_1449213275801kUrd4_JPEG/9.jpg?type=w3](https://postfiles.pstatic.net/20151204_189/liberty264_1449213275801kUrd4_JPEG/9.jpg?type=w3)