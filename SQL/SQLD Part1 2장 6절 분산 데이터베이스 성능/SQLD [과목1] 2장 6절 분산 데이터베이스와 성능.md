# SQLD [과목1] 2장 6절 분산 데이터베이스와 성능

작성일시: 2023년 8월 29일 오전 11:08
종류: SQL
복습: No

## 🟰 분산 데이터베이스

- [ ]  개념
    
    DB를 연결하는 **빠른 네트워크 환경**을 이용하여 DB를 **여러 지역 노드로 위치** 시켜 사용성/성능 등을 **극대화** 시킨 데이터베이스
    

## 🟰 분산 데이터베이스의 투명성(Transparency)

- [ ]  6종류
    1. **`분할투명성(단편화)`** : 하나의 논리적 Relation이 여러 단편으로 분할되어 각 단편의 사본이 여러 site에 저장
    2. **`위치 투명성`** : 사용하려는 데이터의 저장 장소 명시 불필요,  위치 정보가 System Catalog에 유지 되어야 함
    3. **`지역사상 투명성`** : 지역DBMS와 물리적 DB사이에 Mapping보장. 각 지역시스템의 이름과 무관한 이름 사용 가능
    4. **`중복 투명성`** : DB객체가 여러 site에 중복되어 있는지 알 필요가 없는 성질
    5. **`장애 투명성`** : 구성요소(DBMS, Computer)의 장애와 무관한 Transaction의 원자성 유지
    6. **`병행 투명성`** : 다수 Transaction 동시 수행시 결과의 일관성 유지, Time Stamp, 분산 2단계 Locking을 이용하여 구현

## 🟰 분산 DB의 적용 방법 및 장단점

- [ ]  분산 데이터베이스 적용 방법
    
    단순히 분산 환경에서 DB를 구축하는 것이 목적이 아니라, 업무의 특징에 따라 DB 분산구조를 선택적으로 설계
    

- [ ]  분산 데이터베이스 장점
    
    ![https://postfiles.pstatic.net/20151204_122/liberty264_1449233719198WS018_JPEG/1.jpg?type=w3](https://postfiles.pstatic.net/20151204_122/liberty264_1449233719198WS018_JPEG/1.jpg?type=w3)
    
- [ ]  분산 DB의 활용 방향성
    
    업무적인 특성에 따라 분산 DB를 활용하는 기술 필요
    
    ![https://postfiles.pstatic.net/20151204_19/liberty264_1449233743786tVoK4_JPEG/2.jpg?type=w3](https://postfiles.pstatic.net/20151204_19/liberty264_1449233743786tVoK4_JPEG/2.jpg?type=w3)
    
- [ ]  DB분산 구성의 가치
    
    통합된 DB에서 제공할 수 없는 **빠른 성능**을 제공
    
    **원거리 또는 다른 서버에 접속**하여 처리하므로 인해 발생되는 네트워크 부하 및 트랜잭션 집중에 따른 **성능 저하의 원인**을 분산된 DB환경을 구축해 빠른 성능 제공
    
    ![https://postfiles.pstatic.net/20151204_233/liberty264_1449233778489rbOyK_JPEG/3.jpg?type=w3](https://postfiles.pstatic.net/20151204_233/liberty264_1449233778489rbOyK_JPEG/3.jpg?type=w3)
    
- [ ]  적용 기법
    1. 테이블 위치 분산
        
        테이블 **구조가 변하지 않음**
        
        테이블이 다른 DB에 **중복 생성되지 않음**
        
        정보를 이용하는 형태가 각 위치별로 차이가 있을 경우
        
        테이블 위치를 파악할 수 있는 **도식화된 위치별 DB문서가 필요**
        
        ![https://postfiles.pstatic.net/20151204_191/liberty264_1449233810333pdVJ8_JPEG/4.jpg?type=w3](https://postfiles.pstatic.net/20151204_191/liberty264_1449233810333pdVJ8_JPEG/4.jpg?type=w3)
        
        ![https://postfiles.pstatic.net/20151204_184/liberty264_14492338346309eil6_JPEG/5.jpg?type=w3](https://postfiles.pstatic.net/20151204_184/liberty264_14492338346309eil6_JPEG/5.jpg?type=w3)
        
    - [ ]  테이블 분할(Fragmentation) 분산
        
        위치만 다른 곳에 두는 것이 아니라 각각의 테이블을 쪼개어 분산
        
        📌 수평분할
        
        특정 칼럼의 값을 기준으로 Row단위로 분리
        
        칼럼은 분리되지 않음
        
        Primary Key에 의해 중복이 발생되지 않음
        
        지사별로 사용하는 Row가 다를때 사용
        
        데이터 수정 : 타 지사에 있는 데이터를 원칙적으로 수정하지 않고 자신의 데이터에 대해서 수정
        
        각 지사의 테이블 통합처리 : 조인이 발생하여 성능 저하 예상, 통합처리 프로세스가 많은지를 먼저 검토한 후 많지 않은 경우 수평분할
        
        데이터 무결성 보장 : 데이터가 지사별로 존재하므로 중복은 발생하지 않는다. 타 지사 데이터의 지사 구분이 변경되면 단순히 수정하는 것 이외에 변경된 지사로 데이터를 이송해야 한다.
        
        한 시점에는 한 지사(Node)에서 하나의 데이터만 존재
        
        지사별로 DB를 운영하는 경우 : DB가 속한 서버가 지사에 존재하거나 본사에 통합해서 존재하든 간에 DB테이블은 수평 분할하여 존재
        
        ![https://postfiles.pstatic.net/20151204_245/liberty264_144923392094025BKr_JPEG/7.jpg?type=w3](https://postfiles.pstatic.net/20151204_245/liberty264_144923392094025BKr_JPEG/7.jpg?type=w3)
        
        📌수직 분할(Vertical Fragmentation)
        
        칼럼 단위로 분리
        
        각 테이블에는 동일한 PK구조와 값을 가지고 있어야 함
        
        한군데 데이터를 집합시켜 놓아도 동일한 PK는 하나로 표현하면 되므로 중복은 발생되지 않음
        
        테이블의 전체 칼럼 데이터 조회 : 가능하면 통합하여 처리하는 프로세스가 많은 경우 이용하지 않는다
        
        실제 프로젝트에서 수직분할 분산환경을 구성하는 사례는 드물다
        
        ![https://postfiles.pstatic.net/20151204_25/liberty264_1449233952379NNTo9_JPEG/8.jpg?type=w3](https://postfiles.pstatic.net/20151204_25/liberty264_1449233952379NNTo9_JPEG/8.jpg?type=w3)
        
        ![https://postfiles.pstatic.net/20151204_240/liberty264_1449233952793njNHB_JPEG/9.jpg?type=w3](https://postfiles.pstatic.net/20151204_240/liberty264_1449233952793njNHB_JPEG/9.jpg?type=w3)
        
        - [ ]  테이블 복제(Replication)분산
            
            동일한 테이블을 다른 지역이나 서버에서 동시에 생성하여 관리
            
            프로젝트에서 많이 사용하는 데이터베이스 분산 기법
            
            📌부분 복제(Segment Replication)
            
            마스터 DB에서 테이블의 일부 내용만 다른 지역이나 서버에 위치
            
            통합된 테이블을 한 군데에 가지고 있으면서 각 지사별로는 지사에 해당된 Row를 가지고 있는 형태
            
            본사 데이터 = 지사 데이터들의 합
            
            여러 테이블에 조인이 발생하지 않는 한 빠른 작업 수행 가능(각 지사에서 데이터 처리 용이, 전체 데이터에 대한 통합처리도 본사의 통합 테이블 이용)
            
            ![https://postfiles.pstatic.net/20151204_131/liberty264_1449234023244jGICA_JPEG/10.jpg?type=w3](https://postfiles.pstatic.net/20151204_131/liberty264_1449234023244jGICA_JPEG/10.jpg?type=w3)
            
            ![https://postfiles.pstatic.net/20151204_19/liberty264_1449234023692rM6tL_JPEG/11.jpg?type=w3](https://postfiles.pstatic.net/20151204_19/liberty264_1449234023692rM6tL_JPEG/11.jpg?type=w3)
            
            본사 데이터는 통계,이동 등을 관리
            
            지사 데이터를 이용하여 지사별 빠른 업무 수행
            
            다른 지역간의 데이터의 복제는 실시간 처리보다 배치 작업에 의해 수행(시간 소요, 데이터베이스와 서버에 부하 발생)
            
            데이터의 정합성을 일치시키는 것이 어렵기 때문에 가능하면 한쪽에서 데이터를 수정하고 본사로 복제하도록 한다.
            
            📌광역복제(BroadCast Replication)
            
            통합된 테이블을 한군데(본사)에 가지고 있으면서 각 지사에도 본사와 동일한 데이터를 가지고 있는 형태
            
            본사나 지사나 데이터처리에 특별한 제약을 받지는 않음
            
            본사에서 데이터 입력,수정,삭제가 되어 지사에서 이용하는 형태(부분 복제와 차이)
            
            다른 지역간의 데이터를 복제는 실시간 처리배치 작업보다 배치 작업에 의해 수행(시간소요, DB와 서버에 부하 발생)
            
            ![https://postfiles.pstatic.net/20151204_72/liberty264_1449234103685tTIuv_JPEG/12.jpg?type=w3](https://postfiles.pstatic.net/20151204_72/liberty264_1449234103685tTIuv_JPEG/12.jpg?type=w3)
            
            ![https://postfiles.pstatic.net/20151204_49/liberty264_1449234104166gaWKm_JPEG/13.jpg?type=w3](https://postfiles.pstatic.net/20151204_49/liberty264_1449234104166gaWKm_JPEG/13.jpg?type=w3)
            
            - [ ]  테이블 요약(Summarization) 분산
                
                지역/서버 간에 데이터가 비슷하지만 서로 다른 유형으로 존재하는 경우
                
                📌분석 요약(Rollup Replication)
                
                각 지사별로 존재하는 요약정보를 본사에 통합하여 다시 전체에 대해 요약정보 산출
                
                동일한 테이블 구조를 갖고 있으면서 분산되어 있는 동일한 내용의 데이터를 이용하여 통합된 데이터를 산출
                
                각 지사는 요약 내용이 동일하며 본사에서는 다시 통합한 데이터가 생성
                
                각종 통계 데이터 산정 : 모든 지사 데이터를 이용하여 처리하면 성능이 지연되고 각 지사에 부하를 주기 때문에 장애 발생 가능성 있음
                
                지사에 있는 데이터를 이용하여 본사에서 통합 요약 데이터 산정
                
                통합 통계 데이터에 대한 정보 제공에 용이
                
                본사에 분석 요약된 테이블 생성, 데이터는 일반 업무가 종료되는 야간에 수행하여 생성
                
                ![https://postfiles.pstatic.net/20151204_204/liberty264_14492341703505mjdp_JPEG/14.jpg?type=w3](https://postfiles.pstatic.net/20151204_204/liberty264_14492341703505mjdp_JPEG/14.jpg?type=w3)
                
                ![https://postfiles.pstatic.net/20151204_70/liberty264_14492341708918iUIv_JPEG/15.jpg?type=w3](https://postfiles.pstatic.net/20151204_70/liberty264_14492341708918iUIv_JPEG/15.jpg?type=w3)
                
                📌통합 요약(Consolidation Replication)
                
                각 지사별로 존재하는 다른 내용의 정보를 본사에 통합하여 다시 전체에 대해서 요약정보 산출
                
                ![https://postfiles.pstatic.net/20151204_253/liberty264_1449234217952bmKTV_JPEG/16.jpg?type=w3](https://postfiles.pstatic.net/20151204_253/liberty264_1449234217952bmKTV_JPEG/16.jpg?type=w3)
                
                ![https://postfiles.pstatic.net/20151204_297/liberty264_1449234218475Qnmm8_JPEG/17.jpg?type=w3](https://postfiles.pstatic.net/20151204_297/liberty264_1449234218475Qnmm8_JPEG/17.jpg?type=w3)
                
                본사에 통계데이터를 산정 : 분석 요약과 비슷하나 단지 지사에서 산출한 요약정보를 한 군데 취합하여 보여주는 형태
                
                모든 지사의 데이터를 이용하여 처리하면 성능이 지연되고 각 지사 서버에 부하 가능성
                
                지사에서 요약한 정보를 본사에서 취합하여 각 지사별 데이터를 비교하기 위해 이용
                
                통계데이터에 대한 정보제공 용이
                
                본사에 통합 요약된 테이블을 생성하고 데이터는 역시 일반 업무가 종료되는 야간에 수행
                
        
        ## 📌 분산 데이터베이스를 적용하여 성능이 향상된 사례
        
        분산 환경의 원리를 이해하지 않고 DB를 설계하여 성능이 저하되는 경우가 빈번하다
        
        ![https://postfiles.pstatic.net/20151204_133/liberty264_1449234284223eqiSv_JPEG/18.jpg?type=w3](https://postfiles.pstatic.net/20151204_133/liberty264_1449234284223eqiSv_JPEG/18.jpg?type=w3)
        
        분산이 안 된 경우 각 서버에 독립적으로 테이블이 있을 때 트랜잭션과 복제분산을 통해 테이블의 정보가 양쪽에 있을 때 트랜잭션 처리, 위의 원리가 복잡한 업무처리에서도 효과적으로 성능을 향상 시킬 수 있다.
        
        - [ ]  분산 설계를 적용하면 효과적인 사례
            
            성능이 중요한 사이트
            
            공통코드, 기준정보, 마스터 데이터 등에 대해 분산 환경을 구성하면 성능이 좋아짐
            
            실시간 동기화가 요구되지 않을 때 좋다.
            
            거의 실시간(Near Real Time)의 업무적인 특징을 가지고 있을 때도 분산 환경을 구성할 수 있다.
            
            특정 서버가 부하가 집중이 될 떄 부하를 분산할 때 좋다.
            
            백업 사이트를 구성시 간단하게 분산기능을 적용하여 구성