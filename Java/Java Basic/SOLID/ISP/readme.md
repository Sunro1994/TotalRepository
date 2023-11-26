# [객체지향]객체 지향 SOLID- ISP

작성일시: 2023년 9월 11일 오전 12:53
종류: SOLID, 객체지향개념
복습: No

## 인터페이스 분리 원칙 - ISP(Interface Segregation Principle)

📌 ISP 원칙이란 범용적인 인터페이스보다는 클라이언트가 실제로 사용하는 Interface를 만들어야 한다는 의미

📌  인터페이스를 잘게 분리하여, 클라이언트의 목적과 용도에 적합한 인터페이스만을 제공하는 것

## 예시 기능에 맞는 pet의 기능을 분리하기

![Untitled](https://github.com/Sunro1994/TotalRepository/assets/132982907/56bea678-b6f9-4011-ad4c-981c8dffc1cd)

SRP가 클래스의 단일 책임을 강조한다면, ISP는 인터페이스의 단일 책임을 강조한다

하지만 인터페이스는 클래스와 다르게 여러개의 역할을 가지는데 제약이 없다

핵심은 관련 있는 기능끼리 모으되 지나치게 커지지 않도록 크기를 제약하라는 점이다.

## ISP 원칙 위반 예제와 수정

✅스마트폰 인터페이스 (구현 기능 모음)

```java
interface ISmartPhone {
    void call(String number); // 통화 기능
    void message(String number, String text); // 문제 메세지 전송 기능
    void wirelessCharge(); // 무선 충전 기능
    void AR(); // 증강 현실(AR) 기능
    void biometrics(); // 생체 인식 기능
}
```

✅인터페이스를 구현한 핸드폰 기종

```java
class S20 implements ISmartPhone {
    public void call(String number) {
    }

    public void message(String number, String text) {
    }

    public void wirelessCharge() {
    }

    public void AR() {
    }

    public void biometrics() {
    }
}

class S21 implements ISmartPhone {
    public void call(String number) {
    }

    public void message(String number, String text) {
    }

    public void wirelessCharge() {
    }

    public void AR() {
    }

    public void biometrics() {
    }
}
```

✅문제의 기종

❗구형 기종은 지원되지 않는 기능이 있다.

❗필요하지 않은 기능을 어쩔수 없이 구현하며 낭비가 발생된다.

📌 각각의 기능에 맞게 인터페이스를 잘게 분리한다.

```java
class S3 implements ISmartPhone {
    public void call(String number) {
    }

    public void message(String number, String text) {
    }

    public void wirelessCharge() {
        System.out.println("지원 하지 않는 기능 입니다.");
    }

    public void AR() {
        System.out.println("지원 하지 않는 기능 입니다.");
    }

    public void biometrics() {
        System.out.println("지원 하지 않는 기능 입니다.");
    }
}
```

✅각각 분리한 인터페이스

```java
interface IPhone {
    void call(String number); // 통화 기능
    void message(String number, String text); // 문제 메세지 전송 기능
}

interface WirelessChargable {
    void wirelessCharge(); // 무선 충전 기능
}

interface ARable {
    void AR(); // 증강 현실(AR) 기능
}

interface Biometricsable {
    void biometrics(); // 생체 인식 기능
}
```

✅해결된 코드

```java
class S21 implements IPhone, WirelessChargable, ARable, Biometricsable {
    public void call(String number) {
    }

    public void message(String number, String text) {
    }

    public void wirelessCharge() {
    }

    public void AR() {
    }

    public void biometrics() {
    }
}

class S3 implements IPhone {
    public void call(String number) {
    }

    public void message(String number, String text) {
    }
}
```

## 인터페이스 분리는 한번만

📌 한 번 인터페이스를 분리하여 구성해놓고 나중에 무언가 수정사항이 생겨서 또 인터페이스들을 분리하는 행위를 가하지 말아야 한다.

📌 한 번 구성하였으면 왠만해선 변하면 안되는 정책같은 개념이다.

📌 이미 구현되어 있는 프로젝트에 또 인터페이스를 분리한다면 구현하고 있는 온갖 클래스들과 이를 사용하는 클라이언트에서 문제가 일어날 수 있기 때문에