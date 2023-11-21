# SQLD [과목1] 2장 5절 데이터베이스 구조와 성능

작성일시: 2023년 8월 27일 오후 11:16
종류: SQL
복습: No

## 🟰슈퍼/서브타입 모델의 성능고려 방법

- [ ]  `**슈퍼/서브타입**` 데이터 모델(Extended ER Model)의 개요
    
    최근 가장 많이 쓰인다. 업무를 구성하는 데이터를 공통과 차이점을 특징을 고려하여 효과적으로 표현할 수 있기 때문이다.
    
    슈퍼 타입 : 공통의 부분
    
    서브 타입 : 공통으로부터 상속받아 다른 엔터티와 차이가 있는 속성
    
    논리적 데이터 모델에서 이용되는 형태, 분석단계에서 많이 쓰이는 모델
    
    물리적 데이터 모델로 설계시의 문제점이 나타남
    
    1:1타입이 되거나 All in one타입이 되어버려 성능저하가 일어남
    
- [ ]  슈퍼/서브타입 데이터 모델의 변환

![https://postfiles.pstatic.net/20151204_236/liberty264_1449230762464DLmTb_JPEG/1.jpg?type=w3](https://postfiles.pstatic.net/20151204_236/liberty264_1449230762464DLmTb_JPEG/1.jpg?type=w3)

성능저하 원인 3가지

1. 트랜잭션은 항상 일괄로 처리하는데 테이블은 개별로 유지되어 Union연산에 의해 성능이 저하될 수 있다.
2. 트랜잭션은 항상 서브타입을 개별로 처리하는데 테이블은 하나로 통합되어 있어 불필요하게 많은 양의 데이터가 집약되어 있어 성능이 저하되는 경우
3. 트랜잭션은 항상 슈퍼 + 서브타입을 공통으로 처리하는데 개별로 유지되어 있거나 하나의 테이블로 집약되어 있어 성능이 저하되는 경우

- [ ]  슈퍼/ 서브 타입의 변환 기준
    1. 데이터가 소량 : 데이터 처리의 유연성을 고려하여 가급적 1:1 관계를 유지하는 것이 좋다
    2. 데이터가 대량 : 3가지 변화방법이 있다.

- [ ]  슈퍼/서브 타입의 데이터 모델의 변환 기술
    1. 개별로 발생되는 트랜잭션에 대해서는 개별 테이블로 구성**`(One To One)`**
    업무적으로 발생되는 트랜잭션이 슈퍼타입과 서브타입 각각에 대해 발생하는 것
        
        ‘조회’버튼을 기준으로 각가그이 트랜잭션이 분리되어 실행
        
    
    ![https://postfiles.pstatic.net/20151204_166/liberty264_1449230948180tcRXi_JPEG/2.jpg?type=w3](https://postfiles.pstatic.net/20151204_166/liberty264_1449230948180tcRXi_JPEG/2.jpg?type=w3)
    
    1. 슈퍼타입 + 버스타입에 대해 발생되는 트랜잭션에 대해서는 슈퍼 + 서브타입 테이블로 구성`**(Plust Type)**`
        
        ![https://postfiles.pstatic.net/20151204_115/liberty264_14492309927551eRmf_JPEG/3.jpg?type=w3](https://postfiles.pstatic.net/20151204_115/liberty264_14492309927551eRmf_JPEG/3.jpg?type=w3)
        
    2. 전체를 하나로 묶어 트랜잭션이 발생할 떄는 **`하나의 테이블`**로 구성
        
        Union ALL 과 같은 SQL구문이 성능을 저하시킬 수 있으므로 테이블로 구성
        
    - [ ]  슈퍼/서브 타입 데이터 모델의 변환타입 비교
    
    ![https://postfiles.pstatic.net/20151204_185/liberty264_1449231067842GncYd_JPEG/4.jpg?type=w3](https://postfiles.pstatic.net/20151204_185/liberty264_1449231067842GncYd_JPEG/4.jpg?type=w3)
    

## 🟰 인덱스 특성을 고려한 PK/FK 데이터베이스 성능향상

- [ ]  PK/FK 컬럼 순서와 성능
    
    인덱스의 중요성  : 데이터를 조작할 떄 가장 효과적으로 처리될 수 있도록 접근경로를 제공하는 오브젝트
    
    PK/FK 설계의 중요성 : 데이터에 접근할 때 접근 경로를 제공한다는 측면에서 중요
    
    프로젝트시 설계단계 말에 컬럼의 순서를 조정하는 것이 필요하다
    
    ![https://postfiles.pstatic.net/20151204_209/liberty264_1449231182651BRkIz_JPEG/5.jpg?type=w3](https://postfiles.pstatic.net/20151204_209/liberty264_1449231182651BRkIz_JPEG/5.jpg?type=w3)
    
    PK 순서의 중요성 : 물리적인 데이터 모델링 단계에서는 스스로 생성된 PK 순서 이외에 다른 엔터티로 부터 상속받아 발생되는 PK 순서까지 항상 주의하여 표시하도록 해야 한다.
    
    FK의 중요성 : FK도 데이터를 조회할 때 조인의 경로를 제공하는 역할을 수행하므로 이에 대해 반드시 인덱스를 생성하도록 한다. 조회의 조건도 고려해야 한다.
    
- [ ]  PK컬럼의 순서를 조정하지 않을 때 성능이 저하되는 이유
    
    조회조건에 따라 인덱스를 처리하는 범위가 달라지게 된다.
    
    ![https://postfiles.pstatic.net/20151204_74/liberty264_1449231260008dSk8e_JPEG/6.jpg?type=w3](https://postfiles.pstatic.net/20151204_74/liberty264_1449231260008dSk8e_JPEG/6.jpg?type=w3)
    
    ![https://postfiles.pstatic.net/20151204_168/liberty264_1449231314400NMjpt_JPEG/7.jpg?type=w3](https://postfiles.pstatic.net/20151204_168/liberty264_1449231314400NMjpt_JPEG/7.jpg?type=w3)
    
    ✅맨 앞에 있는 컬럼이 제외된 상태에서 데이터를 조회할 경우 데이터를 비교하는 범위가 확장된다 > 성능저하
    
    PK의 순서를 인덱스 특징에 맞지 않게 생성하고 자동으로 생성하게되면 테이블에 접근하는 트랜잭션의 특징이 효율적이지 않은 인덱스가 생성되어 있으므로 인덱스의 범위를 넓히거나 풀 스캔을 유발해서 성능이 저하된다.
    
    ![https://postfiles.pstatic.net/20151204_229/liberty264_1449231347044Trl1w_JPEG/8.jpg?type=w3](https://postfiles.pstatic.net/20151204_229/liberty264_1449231347044Trl1w_JPEG/8.jpg?type=w3)
    
    - [ ]  PK 순서를 잘못 지정하여 성능이 저하된 경우 ( 간단한 오류)
        
        예시 ) 입시마스터 테이블(200만건, 4학기, 5년보관/ 한학기 평균 2만건)
        
        수험번호 + 년도 + 학기
        
        전형과목 실적 테이블
        
        (상속받은)수험번호 + 년도 + 학기 // 전형과목 코드(PK)
        
        ![https://postfiles.pstatic.net/20151204_86/liberty264_1449231448351RP4iD_JPEG/9.jpg?type=w3](https://postfiles.pstatic.net/20151204_86/liberty264_1449231448351RP4iD_JPEG/9.jpg?type=w3)
        
    - [ ]  PK 순서를 잘못 지정하여 성능이 저하된 경우(복잡한 오류)
        
        현급출급기실적 테이블
        
        거래일자 + 사무코드  + 출급기번호 + 명세표번호
        
        ![https://postfiles.pstatic.net/20151204_137/liberty264_1449231538525z2Cfw_JPEG/10.jpg?type=w3](https://postfiles.pstatic.net/20151204_137/liberty264_1449231538525z2Cfw_JPEG/10.jpg?type=w3)
        
        ![https://postfiles.pstatic.net/20151204_281/liberty264_14492315388055n9KN_JPEG/11.jpg?type=w3](https://postfiles.pstatic.net/20151204_281/liberty264_14492315388055n9KN_JPEG/11.jpg?type=w3)
        

## 🟰 물리적 테이블에 FK제약이 걸려있지 않은 경우 인덱스 미생성으로 성능저하

예) 학사기준(5만건) / 수강신청(500만건) 테이블

✅문제점

물리적으로는 두 테이블 사이의 FK참조 무결성 관계가 걸려있지 않다.

물리적으로 학사 기준과 수강신청이 연결되어 있지 않더라도 학사기준으로부터 상속받은 FK에 대해 FK인덱스를 생성함으로써 SQL문장 조인이 발생할 때 성능저하를 예방할 수 있다.

![https://postfiles.pstatic.net/20151204_156/liberty264_1449231579544Av730_JPEG/12.jpg?type=w3](https://postfiles.pstatic.net/20151204_156/liberty264_1449231579544Av730_JPEG/12.jpg?type=w3)