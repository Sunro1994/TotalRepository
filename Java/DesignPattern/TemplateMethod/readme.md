# [Design Pattern] - Template Method패턴

작성일시: 2023년 9월 1일 오전 1:18
종류: DesignPattern
복습: No

## 🟰 Templete Method란?

✅상위 클래스 쪽에 템플릿이 될 메서드가 정의되어 있고, 그 메서드 정의에 추상 메서드가 사용된다.

✅따라서 상위 클래스만 봐서는 최종적으로 어떻게 처리될 지 모른다.

✅상위 클래스로 알 수 있는 것은 추상  메서드를 호출하는 방법뿐

✅하위 클래스에서 상위 클래스의 추상 메서드를 구현하며 각 하위 클래스에서 다르게 구현하면 처리도 다르게 이루어진다.

✅하지만 처리의 큰 흐름은 상위 클래스에서 구성한대로 된다.

## 🟰예제 프로그램

📌문자나 문자열을 5번 반복하여 표시하는 프로그램

📌등장하는 클래스 

![Untitled](https://github.com/Employment-Study/Team_StudyJava/assets/132982907/583ef5b5-3069-44f8-8531-d9b68ab4f57f)

✅ AbstractDisplay클래스

구현된 메서드는 display메서드
display안에는 open , print, close라는 세 개의 추상메서드가 있다.
display메서드가 템플릿 메서드이다.

- [ ]  예제 프로그램의 클래스 다이어그램
    
![Untitled 1](https://github.com/Employment-Study/Team_StudyJava/assets/132982907/1fa63429-2d2d-4d38-bd07-ed7d3ef1d88c)
    

⏬AbstractDisplay 코드

```java
package template;

public abstract class AbstractDisplay {
	//open, print, close는 하위 클래스에 구현을 맡기는 추상 메서드
	public abstract void open();
	public abstract void print();
	public abstract void close();
	
	//display는 AbstactDisplay에서 구현하는 메서드
	public final void display() {
		open();
		for(int i=0; i<5; i++) {
			print();
		}
		close();
	}
}
```

⏬CharDisplay

```java
package template;
/**
 * AbstactDisplay를 상속받아 추상메서드를 구현한 클래스
 * @author Sunro
 *
 */
public class CharDisplay extends AbstractDisplay{
	private char ch; //표시해야 하는 문자
	
	public CharDisplay(char ch) {
		this.ch = ch;
	}

	@Override
	public void open() {
		System.out.print("<<");
	}

	@Override
	public void print() {
		System.out.print(ch);
	}

	@Override
	public void close() {
		System.out.print(">>");
	}
	
	
}
```

⏬StringDisplay

```java
package template;

public class StringDisplay extends AbstractDisplay{
	private String string;	//표시해야 하는 문자열
	private int width;		//문자열의 길이
	
	public StringDisplay(String string) {
		this.string = string;
		this.width = string.length();
	}

	@Override
	public void open() {
		printLine();
	}

	@Override
	public void print() {
		System.out.println("|" + string + "|");
	}

	@Override
	public void close() {
		printLine();
	}
	
	private void printLine() {
		System.out.print("+");
		for(int i=0; i<width;i++) {
			System.out.print("-");
		}
		System.out.print("+");
		System.out.println();
	}
	
	
}
```

⏬Main

```java
package template;

public class Main {
	public static void main(String[] args) {
		
	AbstractDisplay d1 = new CharDisplay('H');
	
	AbstractDisplay d2 = new StringDisplay("Hello, world");
	
	//d1,d2 모두 같은 클래스의 하위 클래스 인스턴스 이므로 상속한 display를 호출 가능
	// 실제 동작은 하위 클래스에서 정해진다.
	d1.display();
	System.out.println();
	d2.display();
	}
}
```

## 🟰Template Method패턴의 등장인물

- [ ]  AbstractClass(추상 클래스)역
    
    템플릿 메서드를 구현하며, 그 템플릿 메서드에서 사용할 추상 메서드를 선언한다.
    
    이 메서드는 하위 ConcreteClass에서 구현된다.
    
    예제의 AbstractDisplay와 같다.
    
- [ ]  ConcreteClass(구현 클래스)역
    
    AbstractClass 역에서 정의된 추상 메서드를 구체적으로 구현한다.
    
    여기서 구현하는 메서드는 AbstractClass의 템플릿 메서드에서 호출된다.
    
    예제의 CharDisplay와 StringDisplay클래스가 이 역할이다.
    

![Untitled 2](https://github.com/Employment-Study/Team_StudyJava/assets/132982907/ec50672a-f11a-4fa0-af18-b8b946cfbd42)

## 🟰 Template Method의 장점

✅로직의 공통화가 가능

템플릿 메서드에 알고리즘이 기술되어 있어 하위 클래스에서는 일일이 알고리즘을 기술할 필요가 없다.

예를 들어 Template Method패턴을 사용하지 않고 편집기의 복자, 붙여넣기 기능으로 ConcreteClass를 여러개 만든경우 만약 ConcreteClass클래스중 하나가 문제가 생길 경우 모두 일일이 수정해야 한다.

하지만 Template 패턴을 적용하면 오류가 발견되어도 템플릿 메서드만 수정하면 된다.

✅상위/하위 클래스의 연계플레이

상위 클래스에서 선언된 추상 메서드를 실제로 하위 클래스에서 구현할 떄는 그 메서드가 언제 호출되는지 이해해야만 한다.

✅하위 클래스를 상위 클래스와 동일시

예제에서는 AbstractDisplay형 변수에 CharDisplay, StringDisplay의 인스턴스 모두 대입해서 호출하고 있다.

상위 클래스형 변수가 있고 그 변수에 하위 클래스 인스턴스가 대입된다고 가정했을 때, 하위 클래스의 종류를 특정하지 않아도 프로그램이 동작하게 만드는 것이 좋다.

상위 클래스형 변수에 하위 클래스의 어느 것을 넣어도 동작할 수 있게 만드는 것이 **`LSP(리스코프 치환의 원칙)`**이다.

## 🟰관련 패턴

1. Factory method
    1. 인스턴스 생성에 응용한 것
2. Strategy
    1. Template는 상속을 사용하지만 Strategy는 위임을 사용하여 프로그램의 동작을 변경
    2. 프로그램 일부를 변경하기보다는 알고리즘 전체를 모두 전환한다.

## 🟰하위 클래스의 책임

📌상위 클래스에서 선언한 추상 메서드를 구현할 책임을 지는 것

📌Java프로그램에서 어노테이션을 통해 어떤 책임을 맡은 메서드인지 알고 주의할 것

## 🟰상위 클래스와 하위 클래스의 협조

📌상위 클래스에 많이 기술하면 하위 클래스를 작성하기 편하지만 자유가 줄어든다.

📌상위 클래스를 적게 기술하면 하위 클래스를 작성하기 힘들어지고, 각 하위 클래스에서 처리 기술이 중복될 수 있다.