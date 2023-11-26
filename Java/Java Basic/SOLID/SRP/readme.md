# [객체지향] 객체 지향SOLID -  SRP

작성일시: 2023년 9월 10일 오후 11:33
종류: SOLID, 객체지향개념
복습: No

## SRP

📌 객체는 단 하나의 책임만 가져야 한다는 원칙

📌 **`책임`** 이라는 의미는 단 하나의 기능 담당

📌 하나의 클래스는 하나의 기능을 담당하여 하나의 책임을 수행하는데 집중되어야 한다.

- [ ]  SRP책임 원칙 주수 유무의 가장 큰 척도
    
    📌 기능 변경(수정)이 일어났을 때의 파급 효과
    
    📌 한 객체에 책임이 많아질수록 클래스 내부에서 서로 다른 역할을 수행하는 코드끼리 강하게 결합된다.
    
    📌 그래서 그 객체의 기능에 변경사항이 생기면 기능을 사용하는 부분의 코드를 모두 다시 테스트해야할 수도 있다.
    

## SRP원칙을 지키며 코드가 길어져도, 여러 개의 클래스를 사용하는 것이 더 효율적

📌유지보수 용이, 코드의 가독성 향상, 다른 설계 원리들을 적용하는 기초

## 결론

✅ 모듈이 변경되는 이유는 한가지여야 한다.

## 예시 코드

✅문제점이 발생하는 코드

❗하나의 클래스(Emplyee)에서 한개의 메서드를 회계와 인사팀에서 사용하고 기술팀도 해당 클래스를 사용중이다.

❗해당 클래스에서 초과근무시간을 계산하는 메서드 내용이 변동될 경우 회계팀과 인사팀의 메서드에도 영향을 준다.

❗Employee 클래스에서 회계팀, 인사팀, 기술팀 3개의 액터에 대한 책임을 한꺼번에 갖고 있기 때문이다.

```java
Employee(String name, String position) {
        this.name = name;
        this.positon = position;
    }

	// * 초과 근무 시간을 계산하는 메서드 (두 팀에서 공유하여 사용)
    void calculateExtraHour() {
        // ...
    }

    // * 급여를 계산하는 메서드 (회계팀에서 사용)
    void calculatePay() {
        // ...
        this.calculateExtraHour();
        // ...
    }

    // * 근무시간을 계산하는 메서드 (인사팀에서 사용)
    void reportHours() {
        // ...
        this.calculateExtraHour();
        // ...
    }

    // * 변경된 정보를 DB에 저장하는 메서드 (기술팀에서 사용)
    void saveDababase() {
        // ...
    }
}
```

✅수정한 코드

❗각 책임(기능 담당)에 맞게 클래스를 분리하여 구성하면 끝이다.

❗각기 클래스(PayCaculator, HourReporter, EmployeeSaver 클래스)로 분리하고, 이를 통합적으로 사용하는 클래스인 EmployeeFacade클래스를 만든다.

❗EmployeeFacade클래스는 생성자로 인스턴스를 생성하고 각 클래스의 메서드를 사용하는 역할만 할 뿐이다.

```java
// * 통합 사용 클래스
class EmployeeFacade {
    private String name;
    private String positon;

    EmployeeFacade(String name, String position) {
        this.name = name;
        this.positon = position;
    }
    
    // * 급여를 계산하는 메서드 (회계팀 클래스를 불러와 에서 사용)
    void calculatePay() {
        // ...
        new PayCalculator().calculatePay();
        // ...
    }

    // * 근무시간을 계산하는 메서드 (인사팀 클래스를 불러와 에서 사용)
    void reportHours() {
        // ...
        new HourReporter().reportHours();
        // ...
    }

    // * 변경된 정보를 DB에 저장하는 메서드 (기술팀 클래스를 불러와 에서 사용)
    void EmployeeSaver() {
        new EmployeeSaver().saveDatabase();
    }
}

// * 회계팀에서 사용되는 전용 클래스
class PayCalculator {
    // * 초과 근무 시간을 계산하는 메서드
    void calculateExtraHour() {
        // ...
    }
    void calculatePay() {
        // ...
        this.calculateExtraHour();
        // ...
    }
}

// * 인사팀에서 사용되는 전용 클래스
class HourReporter {
    // * 초과 근무 시간을 계산하는 메서드
    void calculateExtraHour() {
        // ...
    }
    void reportHours() {
        // ...
        this.calculateExtraHour();
        // ...
    }
}

// * 기술팀에서 사용되는 전용 클래스
class EmployeeSaver {
    void saveDatabase() {
        // ...
    }
}
```

## SRP 원칙 적용 주의점

1. 클래스명은 책임의 소재를 알수있게 작명
    1. 각 클래스는 하나의 개념을 나타나게 구성하는 것이다.
2. 책임을 분리할 때 항상 결합도, 응집도 따져가며
3. 하지만 너무 많은 책임 분할로 인하여 책임이 여러군대로 파편화되어있는 경우에는 산탄총 수술로 다시 응집력을 높여주는 작업이 추가로 필요하다.
4. 하나의 클래스가 너무 많은 책임을 지진 않았는지, 분리할 수 있는 변수와 메서드가 많은 것은 아닌지 고려해본다.

## 하나의 책임 담당이 여러개의 클래스로 분산되어 변경해야 하는 케이스