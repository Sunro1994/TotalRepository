# 23.Transactional Annotation

작성일시: 2023년 11월 30일 오전 2:28
복습: No

# 트랜잭션이란?

- 시스템에서 발생하는 연산들의 상호작용 단위
- 트랜잭션 내 연산은 모두 독립적으로 이루어지며, 그 과정 중간에 다른 연산을 수행할 수 없고, 하나의 연산이라도 오류가 생겼다면 해당 트랜잭션은 취소되고 모두 원래대로 되돌아가야한다.
- 반드시 모든 연산이 성공해야만 트랜잭션이 성공됐다고 본다.
- 트랜잭션은 ACID라는 원칙에 준거한다.

# @Transactional

- SpringFramework에서 제공하는 어노테이션
- 수행하는 작업에 대해 위 트랜잭션 원칙이 이뤄지도록 보장해주는 것
- 직접 객체를 만들지 않고, 선언만 해도 적용된다.
- 기본적으로 UnChecked Exception(예기치 못한 오류), Error만을 롤백시킴
- UnCheckedException이란 개발자가 정의한 오류가 아닌 프레임워크나 애플리케이션에 의해 발생되는 오류로 사용자의 잔액부족, 결제 실패, 카드 정지, 카드 유효기간 이슈 등으로 발생한 정의된 오류에 대해서는 롤백하지 않는다.
- 이러한 예외는 rollbackedFor파라미터로 롤백할 Exception클래스를 정의하면 된다.

## Transactional이 필요한 이유

- 데이터를 가져오는 도중, 다른 메서드나 함수에서 해당 값을 접근했을 때 잘못된 값을 가져오지 않도록 한다.
- 만약 해당 메서드에서 수정하려는 데이터를 접근하여 다른 메서드나 함수에서 데이터를 수정하는 행위를 했을 떄 오류가 발생한 경우, 해당 변경 사항이 커밋되지 않도록 한다.

## Transactional 작동 원리

- 본래 Spring Framework에서 지원하는 AOP방식의 어노테이션이며 Spring Data로 구현된 R2DBC나 JDBC에서도 적용된다.

![Untitled](https://github.com/Sunro1994/TotalRepository/assets/132982907/b9f43109-ebd2-4c28-aae4-3b9daee94c62)

- JPA의 영속성 컨텍스트를 통해 Entity객체를 영속하는 역할을 담당하고, 수행되는 트랜잭션은 Transactional어노테이션이 진행한다.
- 영속성 컨텍스트가 독립적으로 움직이기 때문에 본래 트랜잭션의 원칙을 정확히 지킬 수 있다.
- EntityManager인스턴스가 여러개라도 하나의 EntityManager로 동작한다.(propagation과 관련있음)

## Transactional 옵션

- Isolation
    - 트랜잭션에서 일관성 없는 데이터 허용 수준을 설정하는 값
- propagation
    - 트랜잭션 수행 중 다른 트랜잭션 수행에 끼치는 영향을  설정하는 값
- noRollbackFor
    - 특정 예외가 발생하는 클래스에 대해서 rollback을 수행하지 않는 옵션
- rollbackFor
    - 특정 예외가 발생하는 클래스에 대해 rollbakc을 수행(기본적으로 UnChekced를 포함)
- timeout
    - 지정한 시간 내에 메서드 수행이 완료되지 않는 경우, rollback
- readOnly
    - 트랜잭션을 읽기전용으로 사용(DML연산이 수행되는 경우 예외 발생)

## 추가로 알아야 할 것

- 본래 우리가 Transactional없이 애플리케이션 서버를 만들고 DB에 영속하려할 경우 아래 순서와 같다.
    - 커넥션 객체 생성
    - 영속하고자 하는 데이터를 클래스화 하거나 set으로 묶어 DB 서버로 보냄
    - 트랜잭션이 발생하는 일련의 과정을 직접 코드에 담아서 구현
    - Spring Configuration에 @EnableTransactionManagement어노테이션을 이용하여 DB연결 정보 객체인DataSource를 주입
- Spring Boot에서는 이러한 설정들을 모두 템플릿처럼 잘 만들어놨기에 편하게 사용할 수 있는 것