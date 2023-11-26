# [Design Pattern] - Decorator패턴

작성일시: 2023년 9월 26일 오후 2:56
복습: No

# Decorator 패턴?

대상 객체에 대한 기능 확장이나 변경이 필요할 떄 객체의 결합을 통해서 서브 클래싱대신 쓸 수 있는 대안 구조 패턴

마치 기본 제품에 포장지나 외부 디자인을 살짝 변경해서 새로운 기능을 부여하는 것과 같다.

데코레이터 패턴을 이용하면 필요한 추가 기능의 조합을 런타임에서 동적으로 생성가능하다.

## 데코레이터 패턴구조

## 구조

1. Component(Interface) : 원본 객체와 장식된 객체 모두를 묶는 역할
2. ConcreteComponent : 원본 객체(데코레이팅 할 객체)
3. Decorator : 추상화된 장식자 클래스
    1. 원본 객체를 합성(composition)한 wrappee 필드와 인터페이스의 구현 메소드를 가지고 있다
4. ConcreteDecorator : 구체적인 장식자 클래스
    1. 부모 클래스가 감싸고 있는 하나의 Component를 호출하면서 호출 전/후로 부가적인 로직을 추가 가능하다.

![Untitled](https://github.com/Sunro1994/Java_DesignPattern/assets/132982907/4ef81e8d-3279-47ca-8762-76b273a80300)

## 예시 코드

✅Decorator(abstract)

```java
package dec;

abstract class Decorator implements IComponent{
	
	IComponent wrapee; //원 본 객체를 composition
	public Decorator(IComponent component) {
		this.wrapee = component;
	}
	
	
	@Override
	public void operation() {
		wrapee.operation();//위임
	}
	
	
}
```

✅IComponent(Interface)

```java
package dec;

//원본 객체와 장식 객체를 모두 묶는 인터페이스
public interface IComponent {

	void operation();
}
```

✅ConcreteComponent(Class)

```java
package dec;

// 장식될 원본 객체
public class ConcreteComponent implements IComponent{

	@Override
	public void operation() {
	}
	
	
	
}
```

✅ConcreteDecorator1(Class)

```java
package dec;

public class ComponentDecorator1 extends Decorator{

	public ComponentDecorator1(IComponent component) {
		super(component);
	}
	

}
```

✅Main

```java
package dec;

public class Main {
	public static void main(String[] args) {
		//1. 원본 객체 생성
		IComponent obj = new ConcreteComponent();
		
		//2. 장식 1 하기
		IComponent deco1 = new ComponentDecorator1(obj);
		deco1.operation();
		//3. 장식 2하기
		IComponent deco2 = new ComponentDecorator2(obj);
		deco2.operation();
		
		//4. 장식1+2하기
		IComponent deco3 = new ComponentDecorator1(new ComponentDecorator2(obj));
	}
}
```

## 패턴 장단점

## 장점

✅ 데코레이터를 사용하면 서브클래스를 만들때보다 훨씬 유연하게 기능을 확장할 수 있다.

✅객체를 여러 데코레이터로 래핑하여 여러 동작을 결합할 수 있다.

✅컴파일 타임이 아닌 런타임에 동적으로 기능 변경 가능하다.

✅ 각 장식자 클래스마다 고유의 책임을 가져 단일 책임원칙을 준수한다.

✅ 클라이언트 코드 수정없이 기능 확장이 필요하면 장식자 클래스를 추가하면 되니 개방 폐쇄 원칙을 준수한다.

✅ 구현체가 아닌 인터페이스를 바라봄으로써 의존역전원칙을 준수한다.

## 단점

✅ 만일 장식자 일부를 제거하고 싶다면, Wrapper 스택에서 특정 wrapper를 제거하는 것은 어렵다.

✅ 데코레이터를 조합하는 초기 생성코드가 보기 안 좋을 수 있다. new A(new B(new C(new D())))

✅ 어느 장식자를 먼저 데코레이팅하느냐에 따라 데코레이터 스택 순서가 결정되게 되는데, 만일 순서에 의존하지 않는 방식으로 구현하기는 어렵다.

## 예시(총 파츠 추가하기)

**기본 기능만 있는 총(BaseWeapon)** 과 **여러 악세서리(Weapon Accessory)**를 **총에 장착(Decorator)**시킴으로써 다른 기능을 갖는 객체를 구성한다.

## 클린하지 않은 문제의 코드

모든 클래스를 따로 구현한 클래스

악세서리 종류가 많아질수록 클래스를 계속 추가해야 하는 문제점이 생긴다.

```java
class BaseWeapon implements Weapon {

    @Override
    public void aim_and_fire() {
        System.out.println("총알 발사");
    }
}

class GeneradeBaseWeapon implements Weapon {

    @Override
    public void aim_and_fire() {
        System.out.println("총알 발사");
    }

    public void generade_fire() {
        System.out.println("유탄 발사");
    }
}

class ScopedBaseWeapon implements Weapon {

    @Override
    public void aim_and_fire() {
        aiming();
        System.out.println("조준하여 총알 발사");
    }

    public void aiming() {
        System.out.println("조준 중..");
    }
}

class ButtstockScopedGeneradeBaseWeapon implements Weapon {

    @Override
    public void aim_and_fire() {
        holding();
        aiming();
        System.out.println("조준하여 총알 발사");
    }

    public void generade_fire() {
        System.out.println("유탄 발사");
    }

    public void aiming() {
        System.out.println("조준 중..");
    }

    public void holding() {
        System.out.println("견착 완료");
    }
}
```

## 데코레이터 패턴을 적용한 코드

✅ 먼저 대상 클래스와 장식 클래스를 모두 묶어 다형성 처리를 위한 Weapon 인터페이스를 선언한다.

✅ 데코레이터를 추상화한WeaponAccessory를 선언한다. 굳이 추상 클래스를 선언하는 이유는 동기화처리 외에 또 다른 처리기능이 추가되었을때 유연하게 확장시키기 위해서 이고 각 장식자 클래스의 중복되는 코드를 묶기 위해서이다.

```java
// 원본 객체와 장식된 객체 모두를 묶는 인터페이스
interface Weapon {
    void aim_and_fire();
}

// 장식될 원본 객체
class BaseWeapon implements Weapon {

    @Override
    public void aim_and_fire() {
        System.out.println("총알 발사");
    }
}

// 장식자 추상 클래스
abstract class WeaponAccessory implements Weapon {
    private Weapon rifle;

    WeaponAccessory(Weapon rifle) { this.rifle = rifle; }

    @Override
    public void aim_and_fire() {
        rifle.aim_and_fire(); // 위임
    }
}

/ 장식자 클래스 (유탄발사기)
class Generade extends WeaponAccessory {

    Generade(Weapon rifle) { super(rifle); }

    @Override
    public void aim_and_fire() {
        super.aim_and_fire(); // 부모 메서드를 호출함으로써 자신을 감싸고 있는 장식자의 메서드를 호출
        generade_fire();
    }

    public void generade_fire() {
        System.out.println("유탄 발사");
    }
}

// 장식자 클래스 (조준경)
class Scoped extends WeaponAccessory {

    Scoped(Weapon rifle) { super(rifle); }

    @Override
    public void aim_and_fire() {
        aiming();
        super.aim_and_fire(); // 부모 메서드를 호출함으로써 자신을 감싸고 있는 장식자의 메서드를 호출
    }

    public void aiming() {
        System.out.println("조준 중..");
    }
}

// 장식자 클래스 (개머리판)
class Buttstock extends WeaponAccessory {

    Buttstock(Weapon rifle) { super(rifle); }

    @Override
    public void aim_and_fire() {
        holding();
        super.aim_and_fire(); // 부모 메서드를 호출함으로써 자신을 감싸고 있는 장식자의 메서드를 호출
    }

    public void holding() {
        System.out.println("견착 완료");
    }
}

public class Client {
    public static void main(String[] args) {

        // 1. 유탄발사기가 달린 총
        Weapon generade_rifle = new Generade(new BaseWeapon());
        generade_rifle.aim_and_fire();

        // 2. 개머리판을 장착하고 스코프를 달은 총
        Weapon buttstock_scoped_rifle = new Buttstock(new Scoped(new BaseWeapon()));
        buttstock_scoped_rifle.aim_and_fire();

        // 3. 유탄발사기 + 개머리판 + 스코프가 달린 총
        Weapon buttstock_scoped_generade_rifle = new Buttstock(new Scoped(new Generade(new BaseWeapon())));
        buttstock_scoped_generade_rifle.aim_and_fire();
    }
}
```

## 데코레이터 원리 파악하기

## 코드

```java
Weapon buttstock_scoped_generade_rifle = new Buttstock(new Scoped(new Generade(new BaseWeapon())));
buttstock_scoped_generade_rifle.aim_and_fire();
```

✅위의 구성을 하면 각 장식자 클래스의 부모메서드 호출 부분 super.aim_and_fire()메서드가 각 상위 장식자의 메서드로 교체되어 위의 결과와 같이 결과값이 변하게 된다.

## 데코레이터 순서 주의사항

## 코드

데코레이터는 간단한 래핑(wrapping)원리 패턴인것 같지만, 어느 장식자를 먼저 감싸느냐에 따라 그에 대한 행동 패턴이 완전히 달라지게 된다.

```java
public static void main(String[] args) {

    // 1. 개머리판을 장착하고 스코프를 달은 총
    Weapon buttstock_scoped_rifle = new Buttstock(new Scoped(new BaseWeapon()));
    buttstock_scoped_rifle.aim_and_fire();

    // 2. 개머리판을 장착하고 스코프를 달은 총
    Weapon scoped_buttstock_rifle = new Scoped(new Buttstock(new BaseWeapon()));
    scoped_buttstock_rifle.aim_and_fire();
}
```

![Untitled 1](https://github.com/Sunro1994/Java_DesignPattern/assets/132982907/ffa0dad4-6624-431f-993f-f8547cfa1f98)

## 실전 자바 메서드의동기화 처리

Data클래스를 멀티 쓰레드 환경에서도 사용할 수 있도록 동기화 처리를 해주고 싶다.

## 코드

```java
class MyData {
    private int data;

    public void setData(int data) {
        this.data = data;
    }

    public int getData() {
        return data;
    }
}
```

## 클린하지 않은 문제의 코드

가장 심플한 방법은 MyData클래스를 상속하여 메서드를 오버라이딩하여 syncronized처리하는 로직

```java
class SynchronizedData extends MyData {
	private int data;
    
    public void setData(int data) {
    	// synchronized (대상 객체) {} 블럭
        synchronized (this) {
            this.data = data;
        }
    }

    public int getData() {
        synchronized (this) {
            return data;
        }
    }
}

public class Client {
    public static void main(String[] args) {
        SynchronizedData data = new SynchronizedData();
        data.setData(1);
        System.out.println(data.getData());
    }
}
```

❗코드에는 문제가 없지만 만일 동기화 처리 외에 다른 부가 처리 기능도 계속 요구사항이 들어온다면 서브 클래스 폭발이 일어난다. 더군다나 원본 필드변수가 private이기 때문에 상속으로 재사용도 불가능하여 서브 클래스에 또 변수를 선언하여 사용한다.

## 데코레이터 패턴을 적용한 코드

1. 먼저 동기화 처리가 안된 data 클래스와 동기화 처리가 된 data클래스 모두 묶어두는 IData인터페이스를 선언한다.
2. 데코레이터를 추상화한 MyDataDecorator를 선언한다. 굳이 추상화 클래스를 선언하는 이유는 동기화 처리 외에 또 다른 처리 기능이 추가되었을 때 유연하게 확장시키기 위해서이며 중복되는 코드를 묶기 위해서다.
3. MyDataDecorator 추상 클래스를 상속하는 서브 장식 클래스 구현체 SynchronizedDecorator를 선언한다.
4. 또다른 부가 기능을 장식할게 있다면 간단하게 MyDataDecorator를 상속한 장식자 클래스를 추가해주기만 하면 된다.

```java
// 원본 객체와 장식된 객체 모두를 묶는 인터페이스
interface IData{
    void setData(int data);
    int getData();
}

// 장식될 원본 객체
class MyData implements IData{
    private int data;

    public void setData(int data) {
        this.data = data;
    }

    public int getData() {
        return data;
    }
}

// 장식자 추상 클래스
abstract class MyDataDecorator implements IData {
    private IData mydataObj; // 최상위 인터페이스 타입으로 장식할 원본 객체 선언

    MyDataDecorator(IData mydataObj) {
        this.mydataObj = mydataObj;
    }

    public void setData(int data) {
        this.mydataObj.setData(data);
    }

    public int getData() {
        return mydataObj.getData();
    }
}

// 장식자 클래스
class SynchronizedDecorator extends MyDataDecorator {

    SynchronizedDecorator(IData mydataObj) {
        super(mydataObj);
    }

    public void setData(int data) {
        synchronized (this) {
            System.out.println("동기화된 data 처리를 시작합니다.");
            super.setData(data); // 부모 메서드를 호출함으로써 자신을 감싸고 있는 장식자의 메서드를 호출
            System.out.println("동기화된 data를 처리를 완료하였 습니다.");
        }
    }

    public int getData() {
        synchronized (this) {
            System.out.println("동기화된 data 처리를 시작합니다.");
            int result = super.getData(); 
            System.out.println("동기화된 data를 처리를 완료하였 습니다.");
            return result;
        }
    }
}

// 나중에 기능 추가 요구사항이 와도 코드 수정없이 유연하게 클래스를 정의만 해주면 된다.
class AnotherSkillDecorator extends MyDataDecorator {
    private IData mydataObj;

    AnotherSkillDecorator(IData mydataObj) {
        super(mydataObj);
    }

    // ...
}

public class Client {
    public static void main(String[] args) {
    
    	// 동시성이 필요없을 때
        IData data = new MyData(); 
        
    	// 동시성이 필요할 때
        IData dataSync = new SynchronizedDecorator(data);
        dataSync.setData(1);
        System.out.println(dataSync.getData()); // 1
    }
}
```

## 데코레이터 순서 파악하기

어느걸 먼저 장식하느냐에 따라 이행되는 효과가 완전히 달라진다.

‘동시성이 적용된 로직 안의 코드를 시간 측정’, ‘동시성이 적용된 코드를 시간 측정’은 중첩으로 장식된 코드 로직 부분들을 풀어내면 완전히 느낌이 다르다.

어떤 순서대로 데코레이팅 하느냐에 따라 완전히 달라지게 된다. 

![Untitled 2](https://github.com/Sunro1994/Java_DesignPattern/assets/132982907/69f5336b-147b-4cec-9a5c-9159c8638ce5)
![Untitled 3](https://github.com/Sunro1994/Java_DesignPattern/assets/132982907/f6c3ce80-e63e-431a-8f45-5ce20e86edeb)

## 실무에서 찾아보는 Decorator 패턴

✅**Java**

- InputStream, OutputStream, Reader, Writer의 생성자를 활용한 랩퍼
- java.util.Collections가 제공하는 메소드들 활용한 랩퍼
- javax.servlet.http.HttpServletRequest / ResponseWrapper
- java.io.InputStream, OutputStream, Reader, Writer의 모든 하위 클래스에 동일한 유형의 인스턴스를 사용하는 생성자
- java.util.Collections의 checkedXXX(), synchronizedXXX(), unmodifiableXXX() 메서드들
- javax.servlet.http.HttpServletRequestWrapper 그리고 HttpServletResponseWrapper
- javax.swing.JScrollPane

✅**자바 I/O 메서드**

- InputStream, OutputStream, Reader, Writer의 생성자를 활용한 파일 I/O 랩퍼 부분은 데코레이터 패턴의 대표적인 예이다.
- 자바 코드에서 파일을 읽어 들일 때 다음과 같이 객체 생성자를 중첩하여 사용해왔다.
- File → FileReader → BufferedReader 순으로 갈수록 점점 부가 기능이 가미되었다고 보면 된다.
- 이처럼 유연하게 기능을 확장하여 사용할 수 있겠지만 대신 각각 장식자 클래스들이 어떠한 기능을 수행하는지 알고 있어야하고 역시나 자잘한 클래스들이 많이 생기는 단점이 존재한다.

✅**java.util.Collections가 제공하는 메소드**

- checkedXXX() : 기존 컬렉션 인스턴스를 부가적인 기능을 추가해서 다른 타입으로 변환해주는 메소드
- synchronizedXXX() : 컬렉션의 메서드 로직을 동기화 처리하는 기능을 가미하는 메소드
- unmodifiableXXX() : 컬렉션을 불변 객체로 취급하게 함 (읽기 전용)

```java
class Book {
}

class Item {
}

//원하는 타입맨 담도록 재설정
public class Client {
    public static void main(String[] args) {
        // 어떠한 타입도 들어갈 수 있는 컬렉션
        List list = new ArrayList<>();
        list.add(new Book());
        list.add(new Hashtable());
        list.add(new Double(1));

        // list 컬렉션에서 Book 클래스에 해당하는 타입만 선별해서 books에 담도록 재설정
        list = Collections.checkedList(list, Book.class);
        list.add(new Book()); // 가능
        list.add(new Item()); // ! ClassCastException (타입 Cast 불가)
    }
}

//불변 객체 생성
public class Client {
    public static void main(String[] args) {
        /* Collections가 제공하는 데코레이터 메소드 */

        // 어떠한 타입도 들어갈 수 있는 컬렉션
        List list = new ArrayList<>();
        list.add(new Book());
        list.add(new Hashtable());
        list.add(new Double(1));

        List unmodifiableList = Collections.unmodifiableList(list);
        unmodifiableList.add(new Book()); // ! 넣기 불가능 (불변객체)
    }
}
```