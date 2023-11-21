# 16. 엔터티 매핑

작성일시: 2023년 11월 20일 오후 8:14
복습: No

## Index

1. 객체와 테이블 매핑
2. 필드와 컬럼 매핑
3. 기본 키 매핑
4. 연관관계 매핑

## 객체와 테이블 매핑 
`**@Entity**`

`@**Entity**` : DB테이블에 대응하는 하나의 클래스

- Entity가 붙은 클래스는 JPA가 관리하며 **DB의 테이블과 자바 클래스가 매핑이 된다.**
- JPA를 사용해서 테이블과 매핑할 클래스는 @Entity 어노테이션이 필수다.

❗기본 생성자(public or protected)가 필수다.

❗final 클래스, enum, interface, inner클래스를 사용하지 않는다.

❗저장할 필드에 final을 사용하지 않는다.
![Untitled](https://github.com/Sunro1994/SpringFramework/assets/132982907/4e9d2979-40cc-4322-8957-381202f22f65)



### Entity속성 정리

1. name
    - JPA에서 사용할 엔티티 이름을 지정한다.
    - 기본값 : 클래스의 이름을 그대로
    - 다른 패키지에 같은 클래스 이름이 있다면 name속성을 통해 해당 테이블의 이름과 매핑시킨다.

## `**@Table**`

엔티티와 매핑할 테이블을 지정한다.

### Table속성 정리

1. name
    - 매핑할 테이블 이름
2. catalog
    - 데이터베이스 catalog 매핑
3. schema
    - 데이터베이스 schema 매핑
4. uniqueConstraints
    - DDL 생성시 유니크 제약 조건 생성

## 데이터베이스 스키마 자동 생성

- DDL을 애플리케이션 실행 시점에 자동 생성
- 테이블 중심 → 객체 중심
- 데이터베이스 방언을 활용해서 DB에 맞는 적절한 DDL생성
- 이렇게 생성된 DDL은 개발 장비에서만 사용
- 생성된 DDL은 운영서버에서는 사용하지 않거나, 적절히 다듬은 후 사용
- DDL을 자동 생성할 때만 사용되고 JPA의 실행 로직에는 영향을 주지 않는다.

![Untitled 1](https://github.com/Sunro1994/SpringFramework/assets/132982907/cde1af93-e1fc-47a8-a680-a0cff0ba1e73)
❗운영 장비에는 절대 create, create-drop, update를 사용하면 안된다.

## 필드와 컬럼 매핑

- hibernate.hbm2ddl.auto
    
   ![Untitled 2](https://github.com/Sunro1994/SpringFramework/assets/132982907/1001b7b0-2c3e-4142-913b-f7ed13d0a22b)

    
   ![Untitled 3](https://github.com/Sunro1994/SpringFramework/assets/132982907/0c8d5c1c-df48-4f99-b104-8b538dd42465)


    

### `@Enumerated`

1. 자바 enum타입을 매핑할 때 사용
2. 절대 ORDINAL 사용 하지 않는다.
- EnumType.ORDINAL : enum 순서를 데이터베이서에 저장
- EnumType.STRING : enum 이름을 데이터베이스에 저장

### `@Temporal`

1. 날짜 타입을 매핑할 떄 사용
    - [TemporalType.DATE](http://TemporalType.DATE) : 날짜, 데이터베이스 date타입과 매핑
        
        (2013-10-11)
        
    - TemporalType.TIME : 시간, 데이터베이스 time 타입과 매핑
        
        (11:11:11)
        
    - TemporalType.TIMESTAMP
        
        (2013-10-11 11:11:11)
        

### `@Lob`

1. @Lob에는 지정할 수 있는 속성이 없다.
2. 매핑하는 필드 타입이 문자면 CLOB, 나머지는 BLOB매핑
    - CLOB : String, char[], java.sql.CLOB
    - BLOB : byte[], java.sql.BLOB

### `@Transient`

1. 필드 매핑
2. 데이터베이스에 저장X, 조회X
3. 주로 메모리상에서 임시로 어떤 값을 보관하고 싶을 떄 사용

![Untitled 4](https://github.com/Sunro1994/SpringFramework/assets/132982907/ade4bdd5-f901-45b1-9e97-312b63c0a59d)


## 기본 키 매핑 어노테이션

- `@ID`
- `@GeneratedValue`

### 기본 키 매핑 방법

1. 직접 할당 : `**@Id**` 만 사용
2. 자동 생성`**(@GeneratedValue)**`
    - `**IDENTITY**` : 데이터베이스에 위임(MySQL)
        - 기본 키 생성을 DB에 위임
        - 주로  MySQL, PstgreSQL, SQL Server, DB2에서 사용
        - JPA는 보통 트랜잭션 커밋 시점에 INSERT SQL 실행
        - AUTO_INCREMENT는 데이터베이스에 INSERT SQL을 실행한 이후에 ID값을 알 수 있다.
        - **IDENTITY 전략은 em.persist() 시점에 즉시 INSERT SQL실행 하고 DB에서 식별자로 조회한다.**
    
    ![Untitled 5](https://github.com/Sunro1994/SpringFramework/assets/132982907/d4138cf7-7fe6-4646-9556-64e49568c975)

    ![Untitled 6](https://github.com/Sunro1994/SpringFramework/assets/132982907/0fb9280b-da30-4240-8dbe-b2d95b7699c8)

    
    - `**SEQUENCE**` : 데이터베이스 시퀀스 오브젝트 사용(ORACLE)
        - `**@SequenceGenerator**` 필요
        - 데이터베이스 시퀀스는 유일한 값을 순서대로 생성하는 특별한 DB오브젝트
        - 오라클,POSTGRESQL, DB2, H2 DB에서만 사용
        
        ![Untitled 7](https://github.com/Sunro1994/SpringFramework/assets/132982907/d503abb8-0a6e-4b69-a998-033c0a921474)
        ![Untitled 8](https://github.com/Sunro1994/SpringFramework/assets/132982907/50745f73-7087-46d0-8629-df9114859e13)
        ![Untitled 9](https://github.com/Sunro1994/SpringFramework/assets/132982907/97d8196c-918a-4411-a4c6-693b95099bb2)
        
    
    ![Untitled 10](https://github.com/Sunro1994/SpringFramework/assets/132982907/1e6e0c79-cee5-4cc6-a752-5d49efcfa76f)

    
    
    
    ❗name을 지정한 경우 Hibernate에서도 해당 이름으로 시퀀스를 생성해준다.
    
    ![Untitled 11](https://github.com/Sunro1994/SpringFramework/assets/132982907/dd9cc12c-62c3-4379-99c7-b9cd3b90de92)
    ![Untitled 12](https://github.com/Sunro1994/SpringFramework/assets/132982907/044e0fee-5470-4e72-8ebb-cbd15b9956b1)
    ![Untitled 13](https://github.com/Sunro1994/SpringFramework/assets/132982907/88720ca4-de6e-46bd-b719-c4f1ee451f44)
    ![Untitled 14](https://github.com/Sunro1994/SpringFramework/assets/132982907/00b2516b-299c-4668-af37-9802dfe5be05)
    
    - `**TABLE**` : 키 생성용 테이블 사용, 모든 DB에서 사용
        - `**@TableGenerator**`
        - 키 생성 전용 테이블을 하나 만들어서 데이터베이스 시퀀스를 흉내내는 전략
        - 모든 DB에서 적용가능
        - 성능면에서 떨어짐
        
        ![Untitled 15](https://github.com/Sunro1994/SpringFramework/assets/132982907/49302795-9d5a-44a2-9ad1-56430392f811)
        ![Untitled 16](https://github.com/Sunro1994/SpringFramework/assets/132982907/4d6385cf-8fdf-47e4-b4b1-65b322963a3d)
        ![Untitled 17](https://github.com/Sunro1994/SpringFramework/assets/132982907/2d21fff9-03ab-42c6-a92a-0f4247b3a5e6)
        ![Untitled 18](https://github.com/Sunro1994/SpringFramework/assets/132982907/4cb539d4-2ae7-403b-9461-774d72efd7e7)
        
    - `**AUTO**` : 방언에 따라 자동 지정, 기본값
    

## 권장하는 식별자 전략

- 기본 키 제약 조건 : NULL 아님, 유일, 변하면 안된다.
- 주민등록번호도 기본 키로 적절하지 않다.
- 권장 : LONG형 + 대체키 + 키 생성전략 사용

## Allocation Size란?

- 기본값 :50
- 미리 50개의 사이즈를 DB에 올려놓고 메모리상에서 1씩 사용하는 것
- 

![Untitled 19](https://github.com/Sunro1994/SpringFramework/assets/132982907/5d4ce962-1052-4332-bb61-10a7063bc2d6)
    ![Untitled 20](https://github.com/Sunro1994/SpringFramework/assets/132982907/d45e9f2b-2ada-45b6-a2aa-3d28ec5486e8)
    ![Untitled 21](https://github.com/Sunro1994/SpringFramework/assets/132982907/ddb5c16c-aa30-4438-bbe8-4f65d7c04188)
    ![Untitled 22](https://github.com/Sunro1994/SpringFramework/assets/132982907/a6313edf-abf0-46d3-bc5e-4d265cf080c5)

실습시 중심 학습점

![Untitled 23](https://github.com/Sunro1994/SpringFramework/assets/132982907/5d76da93-d9e0-4344-8edc-41065f47e471)
