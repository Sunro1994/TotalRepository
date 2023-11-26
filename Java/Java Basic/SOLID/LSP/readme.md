# [객체지향]객체 지향 SOLID - LSP

작성일시: 2023년 9월 11일 오전 12:31
종류: SOLID, 객체지향개념
복습: No

## LSP(Liskov Substitution Principle)

📌서브 타입은 언제나 기반 타입으로 교체 할 수 있어야 한다.

📌자식 클래스는 최소한 자신의 부모 클래스에서 가능한 행위는 수행이 보장되어야 한다.

📌부모와 자식 사이에 일관성이 있다고 말한다.

📌 한마디로 다형성을 지원하기 위한 원칙

📌 LSP 원칙을 잘 적용한 예제가 컬렉션 프레임워크이다.

```java
oid myData() {
	// Collection 인터페이스 타입으로 변수 선언
    Collection data = new LinkedList();
    data = new HashSet(); // 중간에 전혀 다른 자료형 클래스를 할당해도 호환됨
    
    modify(data); // 메소드 실행
}

void modify(Collection data){
    list.add(1); // 인터페이스 구현 구조가 잘 잡혀있기 때문에 add 메소드 동작이 각기 자료형에 맞게 보장됨
    // ...
}
```

## LSP 원칙 위반 예제와 수정하기

📌 부모 클래스의 행동 규약을 자식 클래스가 위반하면 안된다.

📌 자식 클래스가 오버라이딩을 할 때, 잘못되게 재정의하면 리스코프치환원칙 위배를 할 수 있다.

📌 자식 클래스가 오버라이딩을 잘못하는 경우는 크게 두가지이다.

1. 자식 클래스가 부모 클래스의 메소드 시그너처를 자기 멋대로 변경
2. 자식 클래스가 부모 클래스의 의도와 다르게 메소드를 오버라이딩

```java
lass Animal {
    int speed = 100;

    int go(int distance) {
        return speed * distance;
    }
}

class Eagle extends Animal {
	//멋대로 오버라이딩
    String go(int distance, boolean flying) {
        if (flying)
            return distance + "만큼 날아서 갔습니다.";
        else
            return distance + "만큼 걸어서 갔습니다.";
    }
}

public class Main {
    public static void main(String[] args) {
        Animal eagle = new Eagle();
        eagle.go(10, true);
    }
}

// EAGLE에서 멋대로 오버라이딩하여 부모 클래스에서는 해당 메서드를 사용할 수 없게 되었다.
// 선언부는 그대로 두되, 바디를 변경하여 오버라이딩을 실행해야 한다.
```

## 잘못된 상속 관계 구성으로 인한 메서드 정의

📌물고기를 추가하고 물고기는 말할 수 없으므로 예외처리를 해두었다.

📌하지만 이 코드를 문서와 전달하지 않으면 다른 개발자는 잘 동작하던 코드가 갑자기 예외를 던지게 되어 당황한다.

📌이처럼 리스코프 치환원칙은 협업하는 개발자 사이의 신뢰를 위한 원칙이기도 하다.

```java
abstract class Animal {
    void speak() {}
}

class Cat extends Animal {
    void speak() {
        System.out.println("냐옹");
    }
}

class Dog extends Animal {
    void speak() {
        System.out.println("멍멍");
    }
}

class Fish extends Animal {
    void speak() {
        try {
            throw new Exception("물고기는 말할 수 없음");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

```

## 수정한 코드

```java
abstract class Animal {
}

interface Speakable {
    void speak();
}

class Cat extends Animal implements Speakable {
    public void speak() {
        System.out.println("냐옹");
    }
}

class dog extends Animal implements Speakable  {
    public void speak() {
        System.out.println("멍멍");
    }
}

class Fish extends Animal {
}
```

## 지켜야할 포인트

📌 자식 클래스로 부모 클래스의 내용을 상속하는데, 기존 코드에서 보장하던 조건을 수정하거나 적용시키지 않아서, 기존 부모 클래스를 사용하는 코드에서 예상하지 않는 오류를 발생시킨 것

📌 따라서 사전에 약속한 기획대로 구현하고, 상속 시 부모에서 구현한 원칙을 따라가야 한다.

## LSP 원칙 적용 주의점

LSP원칙의 핵심은 상속이다.

객체 지향 프로그래밍에서 상속은 기반 클래스와 서브 클래스 사이에 IS-A관계가 있어야 한다.

그 외 경우에는 합성을 이용하도록 권고되어 있다.

따라서 다형성을 이용하고 싶다면 EXTENDS 대신 인터페이스로 IMPLEMENT하여 사용하기를 권하며 , 상위 클래스의 기능을 이용하거나 재사용하고 싶다면 상속보단 합성으로 구성하기를 권한다.