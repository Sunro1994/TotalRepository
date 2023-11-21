# SQLD 정규화

작성일시: 2023년 8월 24일 오후 9:17
종류: SQL
복습: No

## 🟰제1 정규화

📌테이블의 컬럼이 원자값(Atomic Value,하나의 값)을 갖도록 테이블을 분해하는 것

✅문제의 테이블

☀️문제점 : 추신수와 박세리는 여러 개의 취미를 갖고 있기 때문에 제 1정규형을 만족하지 못한다.

[https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2FbNbQUm%2FbtqT18yag04%2FpTXJX3wB23ouk8az7EgWQ1%2Fimg.png](https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2FbNbQUm%2FbtqT18yag04%2FpTXJX3wB23ouk8az7EgWQ1%2Fimg.png)

✅해결한 테이블

[https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2FbMlNZj%2FbtqT17FWVot%2FjUKTAUyOdrH83pRraKw3K0%2Fimg.png](https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2FbMlNZj%2FbtqT17FWVot%2FjUKTAUyOdrH83pRraKw3K0%2Fimg.png)

## 🟰제2 정규화

📌제1 정규화를 진행한 테이블에 대해 완전 함수 종속을 만족하도록 테이블을 분해하는 것

📌완전함수종속?

기본키의 부분집합이 결정자가 되어선 안된다는 것

✅문제의 테이블

기본키 : 학생번호, 강좌이름

이 두개의 기본키는 성적을 결정하고 있다.

그런데 여기서 강의실이라는 컬럼은 기본키의 부분 집합인 강좌이름에 의해 결정될 수 있다.

(강좌이름)—→ 강의실

즉, 기본키의 부분키인 강좌이름이 결정자이기 때문에 위의 테이블의 경우 기존의 테이블에서 분리하여 별도의 테이블로 관리해야 한다.

![Untitled](https://github.com/Employment-Study/SQL_Study/assets/132982907/709c2a5b-bffe-4c18-8bfc-9ad295f45435)

✅해결한 테이블

![Untitled 1](https://github.com/Employment-Study/SQL_Study/assets/132982907/3901468d-d0af-4c4f-9024-975c79eaa6f3)

## 🟰제3 정규화

📌제2 정규화를 진행한 테이블에 대해 이행적 종속을 없애도록 데이터를 분해하는 것

📌 이행적 종속?

A→B B→C C→A가 성립하는 것

✅문제의 테이블

학생 번호는 강좌 이름을 결정

강좌 이름은 수강료를 결정

그러므로 학생번호, 강좌 이름 테이블과 강좌이름, 수강료 테이블로 분해해야 한다.

만약 501번 학생의 강좌이름이 스포츠경영학으로 바뀐다면 수강료가 20000원인 경영학을 듣는 것이다. 그러면 수강료 또한 변경이 되어야 한다.

이러한 번거로움을 해결하기 위해 제3정규화를 수행한다.

![Untitled 2](https://github.com/Employment-Study/SQL_Study/assets/132982907/85a0e3a7-e14d-4026-8dee-3f37d1683393)

✅해결한 테이블

![Untitled 3](https://github.com/Employment-Study/SQL_Study/assets/132982907/cebf63bd-dc21-47bb-9f19-75ef56779c8d)

## 🟰BCNF정규화

제3 정규화를 진행한 테이블에 대해 모든 결정자가 후보키가 되도록 테이블을 분해하는 것

✅문제의 테이블

![Untitled 4](https://github.com/Employment-Study/SQL_Study/assets/132982907/6d9d2040-dda3-4bd4-ba21-53ec4c4bea65)

 📌기본키는 (학생번호, 특강이름)이다. 그리고 기본키는 교수를 결정하고 있다. 

📌 또한 여기서 교수는 특강이름을 정하고 있다.

📌 문제는 교수가 특강 이름을 결정하는 결정자이지만, 후보키가 아니라는 점이다. 그러므로 테이블을 분해해야 한다.

✅해결한 테이블

![Untitled 5](https://github.com/Employment-Study/SQL_Study/assets/132982907/8e8fe31e-5db0-450b-94c9-bf4c16bbecb0)