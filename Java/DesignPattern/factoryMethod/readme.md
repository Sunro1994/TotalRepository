# [Design Pattern] - Factory Method 패턴

작성일시: 2023년 9월 3일 오전 12:33
복습: No

## 🟰 Factory Method 패턴

Template Method에서는 상위 클래스에서 처리의 뼈대를 만들고, 하위 클래스에서 구체적인 살을 붙였다.

이 패턴을 인스턴스 생성 장면에 적용한 것이 Factory Method패턴 이다.

Factory Method패턴에서는 인스턴스 생성 방법을 상위 클래스에서 결정하되, 구체적인 클래스 이름까지는 결정하지 않는다.

구체적인 살은 모두 하위 클래스에서 붙인다.

인스턴스 생성을 위한 뼈대(**`프레임워크`**)와 **`실제 인스턴스를 생성하는 클래스`**를 나누어 생각할 수 있다.

## 예제 프로그램

📌신분증 카드를 만드는 공장으로 5개의 클래스가 등장한다.

📌Product 클래스와 Factory클래스는 인스턴스를 생성하는 뼈대역할(Framework 패키지)

📌IDCard 클래스와 IDCardFactory 클래스는 뼈대에 살을 붙여 구체적인 내용을 구현하는 역할(idcard패키지)

📌Main 클래스는 동작 테스트를 위한 클래스

## 🟰예제 프로그램의 클래스 다이어그램, 목록

![Untitled](https://github.com/Employment-Study/Team_StudyJava/assets/132982907/da63a416-0cad-4270-9797-dd20feb309f3)

## Factory Method 패턴의 등장인물

- [ ]  Product(제품) 역
    
    이 패턴으로 생성되는 인스턴스가 가져야 할 인터페이스를 결정하는 추상 클래스
    
    구체적인 내용은 하위 클래스 ConcreteProduct에서 결정한다.
    
- [ ]  Creator(작성자)역
    
    Product역을 생성하는 추상클래스(Factory)
    
    구체적인 내용은 하위클래스 ConcreteCreator가 결정
    
    new를 사용해 실제 인스턴스를 생성하는 대신에, 인스턴스를 생성하는 메서드를 호출하여 구체적인 클래스 이름에 의한 속박에서 상위 클래스를 자유롭게 한다.
    
- [ ]  ConcreteProduct(구체적인 제품)역
    
    구체적으로 살을 붙이는 쪽, 구체적인 제품을 결정(IDCard 클래스)
    
- [ ]  ConcreteCreator(구체적인 작성자)역
    
    구체적인 제품을 만들 클래스를 결정(IDCardFactory)
    

## 구현 코드

✅factory

```java
package framework;

/**
 * 
 * @param p : createProduct와 registerProduct를 구현한 Product 객체
 * @DesignPattern : Template Method가 사용된다. 추상메서드 createProduct로 제품을 만들고 registerProduct로 등록하는 절차가 구현되어 있다.
 * 구체적인 내용은 Factory Method패턴을 적용한 프로그램에 따라 달라진다.
 * Factory Method패턴에서는 인스턴스를 생성할 떄 Template Method를 사용한다.
 * 
 * @author Sunro
 *
 */
public abstract class Factory {
	public final Product create(String owner) {
		Product p = createProduct(owner);
		registerProduct(p);
		return p;
	}
	
	protected abstract Product createProduct(String owner);
	protected abstract void registerProduct(Product product);
	
}
```

✅product

```java
package framework;

/**
 * 제품을 표현한 클래스
 * @method use :  하위 클래스에서 구현하여 '사용할 수 있는 것'을 제품으로 규정
 * @author Sunro
 *
 */
public abstract class Product {
	public abstract void use();
}
```

✅IDCard

```java
package idcard;

import framework.Product;

public class IDCard extends Product{

	private String owner;
	public IDCard(String owner) {
		System.out.println(owner+"의 카드를 만듭니다.");
		this.owner = owner;
	}
	
	@Override
	public void use() {
		System.out.println(this+"을 사용합니다.");
	}
	
	@Override
	public String toString() {
		return "[IDCard:]"+owner+"]";
	}

	public String getOwner() {
		return owner;
	}
	
	

	
}
```

✅IDCardFactory

```java
package idcard;

import framework.Factory;
import framework.Product;

public class IDCardFactory extends Factory{

	@Override
	protected Product createProduct(String owner) {
		return new IDCard(owner);
	}

	@Override
	protected void registerProduct(Product product) {
		System.out.println(product+"을 등록했습니다.");
	}

}
```

## 프레임워크와 구체적인 내용

📌만약 같은 프레임워크로 다른 제품과 공장을 만든다면?

이 경우 framework 패키지를 import하는 별개의 패키지를 만들게 된다.

이 때, framework패키지 내용을 ***수정하지 않아도*** 전혀 다른 제품과 공장을 만들 수 있다는 점에 주의하자.

Product클래스나 Factory클래스에 IDCard나 IDCardFactory라는 구체적인 클래스 이름이 적혀 있지 않다. 따라서 새로운 클래스를 같은 프레임워크로 생성하는 경우에도 framework패키지 수정은 전혀 필요 없다.

이것을 framework패키지는 idcard패키지에 의존하지 않는다고 표현한다.

📌인스턴스 생성- 메서드 구현 방법

1. 추상 메서드로 기술한다.
    
    추상 메서드로 기술하면, 하위 클래스에서는 반드시 추상 메서드를 구현해야 한다.
    
    구현되어 있지 않으면 컴파일 수행 시 검출된다.
    
2. 디폴트 구현을 준비해둔다.
    
    하위클래스에서 구현하지 않은 경우 디폴트 구현이 사용된다.
    
    단, 이때에는 Product클래스에 대해 직접 new를 실행하므로 Product클래스를 추상 클래스로 둘 수 없다.
    

## 패턴이용과 개발자간의 의사소통

일반적으로 디자인 패턴을 사용해 어떤 클래스 군을 설계할 경우, 그 클래스 군을 보수하는 사람에게 설계자가 의도한 디자인 패턴이 무엇인지 잘 전달할 필요가 있다.

그렇지 않으면 설계자의 처음 의도에서 벗어난 수정이 가해질 수 있기 떄문이다.

프로그램의 주석이나 개발 문서 안의 실제로 사용되는 디자인 패턴의 명칭과 의도를 기술해 두는 것도 좋은 방법이다.

## 🟰static Factory Method

인스턴스 생성을 위한 클래스 메서드 전반을 Factory Method라고 부르는 경우가 있다.

이것은 GoF의 Factory Method패턴과는 다르지만, Java에서 인스턴스를 생성할 때 매우 자주 사용되는 기법이다.

Java API 레퍼런스에서도 인스턴스 생성을 위한 클래스 메서드를 static Factory Method로 표현한다.

static Factory Method로서는 create, newInstance, getInstance등의 이름이 자주 사용되지만, 그 밖의 이름이 사용되기도 한다.

getInstance, List.of, Arrays.asList(), String.valueOf, Instant.now등…

## 관련 패턴

📌Template Method

📌Singleton

📌Composite

📌Iterator