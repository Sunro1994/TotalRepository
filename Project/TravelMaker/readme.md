# TravelMaker

# TravelMaker프로젝트

> 목차
> 
> - 프로젝트 소개
> - 팀원 소개
> - 서비스 소개
> - 주요 기능
> - 링크 모음
> - ERD
> - API 모아보기
> - 파일 구조
> - 시작 가이드
> - 기술 스택
> - BE 개발 주안점
> - 성능 최적화

## 프로젝트 소개

---

### 개발 동기 및 목적

![Untitled](https://github.com/Sunro1994/TotalRepository/assets/132982907/58a1983b-67e2-44ed-b85c-cd5d16cdb91c)
### 팀원 소개

---

| 이선로 | 최재만 | 조민병 | 황민우 | 이지혜 |
| --- | --- | --- | --- | --- |
| 팀장 | BE | BE | BE | BE |

### 서비스 소개

> 내가 만들어가는 여행.’TravelMaker’
> 
1. 🔍지역과 타입별로 검색할 수 있는 숙소
    - 날짜별로 예약 가능한 숙소를 확인할 수 있어요
    - 지역명 또는 숙소이름을 검색하여 찾을 수 있어요
    - 맘에 드는 숙소를 찜할 수 있어요
2. 🎆지역별로 확인 가능한 축제 및 행사
    - 지역별 축제에 대한 정보를 확인할 수 있어요
3. 🧑‍🤝‍🧑정보 공유 및 여행지에서 만나는 새로운 인연
    - 채팅방을 개설해서 채팅을 진행할 수 있어요
4. ✅ 쿠폰을 통한 할인 예약
    - 쿠폰을 발급받아 숙소를 싸게 예약할 수 있어요

### 개발 기간

2023.09 - 2023.11 (KG 아이티뱅크 국비훈련 진행 기간)

## 주요 기능

---

- 숙소 검색
- 축제 정보 확인
- 채팅
- 쿠폰 발급

### 링크 모음

---

| 기획 | 개발 | 배포 |
| --- | --- | --- |
| 노션 | ERD | 현재 동작하지 않습니다. |
| 디스코드 | API문서 |  |

### ERD

---

![Untitled 1](https://github.com/Sunro1994/TotalRepository/assets/132982907/861c687c-7214-49b6-af1f-a919395c223a)

## API 모아보기

---

| 구분 | 이름 | url | 메서드 |
| --- | --- | --- | --- |
| 회원 | 이메일아이디 인증번호 발송 | /ajax/sendAuthNumber | GET |
|  | 인증번호 검증 | /ajax/checkAuthNumber/{userNumber} | GET |
|  | 이메일아이디 중복확인 | /ajax/checkDuplacationId | GET |
|  | 닉네임 중복확인 | /ajax/checkDuplicationNickname | GET |
|  | 이메일 중복확인 체크 | /ajax/checkExistEmail | GET |
|  | 로그인 | /ajax/checkLogin | POST |
|  | 회원 탈퇴 | /ajax/myPage/secession | POST |
|  | 숙박 예약 리스트 로딩 | /ajax/getReservedList | POST |
|  | 쿠폰 리스트 로딩 | /ajax/getCouponList | POST |
| 숙소 | 필터 검색 결과 로딩 | /lodge/getSelectedList | POST |
|  | 랜덤 리스트 출력 | /lodge/getRandomList | GET |
|  | 숙소 검색 결과 출력 | /lodge/getSelectKeywordList | POST |
|  | 숙소 세부 정보 필터링 결과 출력 | /lodge/getSelectedRoom | POST |
|  | 찜목록 추가 | /lodge/insertSave | GET |
|  | 찜목록 출력 | /lodge/selectSaveList | GET |
| 쿠폰 | 쿠폰 저장 | /promotion/insertCoupon | POST |
| 축제 정보 | 축제 정보 출력 | /ajax/location | GET |
| 관리자 | 관리자 로그인 확인 | /ajax/adminCheck | POST |

### 파일구조

---

```jsx
├─src
│  ├─main
│  │  ├─java
│  │  │  └─com
│  │  │      └─TravelMaker
│  │  │          ├─component
│  │  │          ├─config
│  │  │          ├─controller
│  │  │          │  ├─admin
│  │  │          │  ├─lodge
│  │  │          │  ├─meeting
│  │  │          │  ├─member
│  │  │          │  ├─promotion
│  │  │          │  └─RecommendTravel
│  │  │          ├─Handler
│  │  │          ├─interceptor
│  │  │          ├─model
│  │  │          ├─repository
│  │  │          │  ├─admin
│  │  │          │  ├─lodge
│  │  │          │  ├─meeting
│  │  │          │  ├─member
│  │  │          │  ├─promotion
│  │  │          │  └─recommendTravel
│  │  │          └─service
│  │  │              ├─admin
│  │  │              ├─APIInteface
│  │  │              ├─lodge
│  │  │              ├─meeting
│  │  │              ├─member
│  │  │              ├─promotion
│  │  │              └─recommendTravel
│  │  ├─resources
│  │  │  ├─css
│  │  │  │  └─main_css
│  │  │  ├─img
│  │  │  │  └─UserImg
│  │  │  ├─js
│  │  │  │  ├─lodge
│  │  │  │  ├─member
│  │  │  │  ├─promotion
│  │  │  │  └─recommendTravel
│  │  │  ├─META-INF
│  │  │  └─mybatis
│  │  └─webapp
│  │      ├─resources
│  │      └─WEB-INF
│  │          ├─classes
│  │          ├─spring
│  │          │  └─appServlet
│  │          └─views
│  │              ├─Admin
│  │              ├─Lodge
│  │              ├─Meeting
│  │              ├─Member
│  │              ├─Promotion
│  │              └─recommend_travel
│  └─test
│      ├─java
│      │  └─com
│      │      └─TravelMaker
│      │          └─www
│      └─resources
└─target
    ├─classes
    │  ├─com
    │  │  └─TravelMaker
    │  │      ├─component
    │  │      ├─config
    │  │      ├─controller
    │  │      │  ├─admin
    │  │      │  ├─lodge
    │  │      │  ├─meeting
    │  │      │  ├─member
    │  │      │  ├─promotion
    │  │      │  └─RecommendTravel
    │  │      ├─Handler
    │  │      ├─interceptor
    │  │      ├─model
    │  │      ├─repository
    │  │      │  ├─admin
    │  │      │  ├─lodge
    │  │      │  ├─meeting
    │  │      │  ├─member
    │  │      │  ├─promotion
    │  │      │  └─recommendTravel
    │  │      └─service
    │  │          ├─admin
    │  │          ├─APIInteface
    │  │          ├─lodge
    │  │          ├─meeting
    │  │          ├─member
    │  │          ├─promotion
    │  │          └─recommendTravel
    │  ├─css
    │  │  └─main_css
    │  ├─img
    │  └─mybatis
    ├─generated-sources
    │  └─annotations
    ├─generated-test-sources
    │  └─test-annotations
    ├─m2e-wtp
    │  └─web-resources
    │      └─META-INF
    │          └─maven
    │              └─com.TravelMaker
    │                  └─www
    ├─test-classes
    │  └─com
    │      └─TravelMaker
    │          └─www
    └─www-1.0.0-BUILD-SNAPSHOT
        ├─META-INF
        └─WEB-INF
            ├─classes
            │  ├─com
            │  │  └─TravelMaker
            │  │      ├─component
            │  │      ├─config
            │  │      ├─controller
            │  │      │  ├─admin
            │  │      │  ├─lodge
            │  │      │  ├─meeting
            │  │      │  ├─member
            │  │      │  ├─promotion
            │  │      │  └─RecommendTravel
            │  │      ├─Handler
            │  │      ├─interceptor
            │  │      ├─model
            │  │      ├─repository
            │  │      │  ├─admin
            │  │      │  ├─lodge
            │  │      │  ├─meeting
            │  │      │  ├─member
            │  │      │  ├─promotion
            │  │      │  └─recommendTravel
            │  │      └─service
            │  │          ├─admin
            │  │          ├─APIInteface
            │  │          ├─lodge
            │  │          ├─meeting
            │  │          ├─member
            │  │          ├─promotion
            │  │          └─recommendTravel
            │  ├─css
            │  │  └─main_css
            │  ├─img
            │  └─mybatis
            ├─lib
            ├─spring
            │  └─appServlet
            └─views
                ├─Admin
                ├─Lodge
                ├─Meeting
                ├─Member
                ├─Promotion
                └─recommend_travel
```

### 기술 스택

---

![Untitled 2](https://github.com/Sunro1994/TotalRepository/assets/132982907/ab81272b-99ab-40b7-98bc-8c5838d4e651)

## 개발 주안점

---

### 유저별 기능 접근 제한

1. 로그인 유무에 따른 기능 접근 제한 - `Interceptor`

| 로그인 필요 ⭕ | 회원 | 회원가입, 로그인 |
| --- | --- | --- |
|  | 숙소 | 숙소 검색 |
|  | 축제 | 축제 정보 확인 |
|  |  |  |
| 로그인 필요 ❌ | 회원 | 회원 정보 조회, 회원 탈퇴, 숙소 예약 내역 확인 및 리뷰 쓰기, 쿠폰함 |
|  | 숙소 | 숙소 찜하기, 숙소 리뷰 쓰기 |
|  | 결제 | 숙소 결제 |
|  | 채팅 | 채팅방 생성 |
|  | 쿠폰 | 쿠폰 발급 |

### 이메일 검증

> 유저 이메일이 유효한지 검증을 할 필요가 있었습니다.
검증을 하지 않는다면 임의의 이메일을 무한으로 생성하여 악용할 수 있기 때문입니다. 
이를 방지하기 위하여 회원가입을 할 경우 실제 이메일을 사용하도록 하고, 이메일로 인증 코드를 발송하여 해당 인증 코드를 입력해야만 가입할 수 있도록 설계했습니다.
> 

### 결제

> 실제 결제를 수행하는 기능을 구현하기 어려워 아이엠포트를 사용하여 가상으로 결제를 진행하는 방식을 사용하였습니다.
> 

### 회원탈퇴

> 탈퇴한 회원은 DB 테이블에서 데이터를 삭제처리 하지 않고 “ISEXIST” 컬럼을 “N”으로 변경하여 연관관계에 있는 테이블에서 null이 발생되는 문제를 예방하고 실수로 탈퇴한 회원의 문의를 받아 복구를 원할경우 해당 컬럼의 값을 “Y”로 변경하여 복구하는 방법을 선택하였습니다.
또한, 해당 컬럼을 통해 탈퇴된 회원이 로그인시 발생하는 예외를 ExceptionHandler에서 처리하여 안내페이지로 이동하는 로직을 구현하였습니다.
> 

### 숙소

> 관리자 계정이 삭제한 숙소 데이터는 DB에서 “IS_DELETED” 컬럼을 “Y”로 변경하여 연관관계에 있는 테이블에서 null이 발생하는 문제를 예방하였습니다.
또한, 검색하는 숙소가 삭제된 테이블인지 확인하는 컬럼을 숙소 검색 로직의 WHERE절에 추가하여 삭제된 숙소가 보여지는 현상을 예방하였습니다.
> 

## CORS설정

## 성찰해야 하는 부분(앞으로의 수정 방안)
이전에 인지하지 못했던 여러 규칙과 문법들을 공부한 후 재수정단계를 거치려고 합니다.
확실히 공부하지 않고 사용했던 문법을 수정하고 MVC패턴 내의 확장성과 유연성을 높이고 결합도를 낮추는 작업을 수행하여 해당 프로젝트를 개선시키겠습니다.

1. 변수 명명 규칙 설정
    - 클래스 변수명은 모두 카멜케이스로 통일
2. JS 문법 수정
    - 동등성 확인하는 문법을 '==' 에서 '==='로 명확한 방법으로 변경
    - 컨텍스트 로딩 상황에 맞는 변수 생성 시점을 명확하게 설정하기
3. 로그인 API를 인터페이스화 하고 implement하여 유연성 및 확장성 제공하기
4. API 호출 규칙 설정
    - GET, POST, DELETE, PUT 과 호출규칙을 확실히 지킬수 있도록 호출 경로 재설정
    - Controller의 requestMapping 재설정(통일시키기)
5. 캐싱 사용
    - 데이터 처리 속도 향상을 위한 캐싱처리를 활용하기


---

### 

## 트러블슈팅 해결상황

---

1. 숙박기간에 따른 가격 변동이 되지 않음(2024.03.22)[해결]
    - 기간에 따른 가격이 아닌 고정된 값을 출력중 → 기간값을 곱하여 출력
    
    ```jsx
    roomDetailPrice.textContent = '가격 :' + e.lodge_Room_Type_price*daysDiff;
    ```
    

1. 축제 세부정보 페이지에서 지도API가 출력되지 않는 문제(2024.03.23)[해결]
    - REST API키가 아닌 JS키를 입력하여 해결