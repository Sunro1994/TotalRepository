# SQLD [과목2] 1장 1절 관계형 데이터베이스 개요

작성일시: 2023년 8월 29일 오후 12:27
종류: SQL
복습: No

## 🟰데이터 베이스

특정 기업이나 조직 또는 개인이 필요에 의해 데이터를 일정한 형태로 저장해 놓은 것

- [ ]  데이터베이스의 발전
    
    1960 : 플로우차트 중심의 개발
    
    1970 : 계층형 DB, 망형 DB
    
    1980 : 관계형 DB 상용화, Oracle,Sybase, DB2와 같은 제품
    
    1990 : 객체 관계형 DB로 Oralce, Sybase , Infomix, DB2, Teradata, SQL Server
    
- [ ]  관계형 DB (Relational DB)
    
    1970년 영국의 수학자 E.F Codd 박사의 논문에서 처음으로 관계형 DB가 소개
    
    파일 시스템의 단점
    
    동시에 입력, 수정, 삭제 불가능으로 정보의 관리가 어렵다
    
    복사본 파일을 만들어 사용할 경우 불일치성 발생
    
    관게형 DB의 장점
    
    정규화를 통해 이상 현상을 제거하고 데이터의 중복 회피
    
    동시성 관리, 병행 제어를 통해 데이터를 공유
    
    데이터의 표현 방법 등을 체계화 할 수 있고, 데이터 표준화, 데이터 품질을 확보
    
    보안 기능
    
    데이터 무결성 보장
    
    데이터를 회복/복구하는 기능
    

## SQL

- [ ]  DML : Data Manipulation Language
    
    SELECT(RETRIEVE), INSERT, UPDATE, DELETE
    
- [ ]  DDL : Data Definition Language
    
    CREATE ALTER DROP RENAME
    
- [ ]  DCL : Data Control Language
    
    GRANT, REVOKE
    
- [ ]  TCL : Transaction Control Language
    
    MOMMIT, ROLLBACK
    

## 🟰TABLE

데이터를 저장하는 객체로서 관계형 db의 기본단위

![https://postfiles.pstatic.net/20151204_116/liberty264_1449234764346aXy8W_JPEG/3.jpg?type=w3](https://postfiles.pstatic.net/20151204_116/liberty264_1449234764346aXy8W_JPEG/3.jpg?type=w3)

## 🟰ERD(Entitiy Relationship Diagram)

Entity, Relationship, Attribute로 구성