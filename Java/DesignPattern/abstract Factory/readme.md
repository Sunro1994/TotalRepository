# [Design Pattern] -  Abstract Factory

작성일시: 2023년 9월 13일 오전 1:17
종류: DesignPattern
복습: No

## Abstract Factory 패턴

📌 연관성이 있는 객체 군이 여러개 있을 경우 이들을 묶어 추상화하고, 어떤 구체적인 상황이 주어지면 팩토리 객체에서 집합으로 묶은 객체 군을 구현화하는 생성 패턴

📌클라이언트에서 특정 객체를 사용할 때 팩토리 클래스만을 참조하여 특정 객체에 대한 구현부를 감추어 역할과 구현을 분리시킬 수 있다.

📌 추상 팩토리의 핵심은 제품’군’ 집합을 타입 별로 찍어낼 수 있다는 점이다

📌예시) 모니터, 마우스, 키보드를 묶은 제품군이 있는데 이를 또 삼성/애플/로지텍에 따라 집합이 브랜드명으로 여러갈래로 나뉘게 될때, 복잡하게 묶이는 이러한 제품군들을 관리와 확장하기가 용이하게 패턴화한 것

![Untitled](https://github.com/Employment-Study/Algorithm_Study/assets/132982907/b0340ea9-d48e-42c4-bc99-d4b270c6df77)

1. AbstractFactory : 최상위 공장 클래스, 여러개의 제품들을 생성하는 여러 메서드를 추상화한다.
2. ConcreteFactory : 서브 공장 클래스들은 타입에 맞는 제품 객체를 반환하도록 메서드들을 재정의한다.
3. AbstractProduct : 각 타입의 제품들을 추상화한 인터페이스
4. ConcreteProduct(ProductA ~ ProductB) : 각 타입의 제품 구현체들. 이들은 팩토리 객체로부터 생성된다.
5. Client : Client는 추상화된 인터페이스만을 이용하여 제품을 받기 때문에, 구체적인 제품, 공장에 대해서는 모른다.

## Abstract Factory와 Factory Method의 차이

- [ ]  공통점
    
    📌 객체 생성 과정에서 추상화한 인터페이스를 제공
    
    📌 객체 생성을 캡슐화함으로써 구체적인 타입을 감추고 느슨한 결합 구조를 표방
    
- [ ]  차이점
    
    ✅ 팩토리 메서드 패턴
    
    1. 구체적인 객체 생성과정을 하위 또는 구체적인 클래스로 옮기는것이 목적
    2. 한 Factory당 한 종류의 객체 생성 지원
    3. 메서드 레벨에서 포커스를 맞춤으로써, 클라이언트의 ConcreteProduct인스턴스의 생성 및 구성에 대한 의존을 감소
    
    ✅추상 팩터리 패턴
    
    1. 관련 있는 여러 객체를 구체적인 클래스에 의존하지 않고 만들 수 있게 해주는 것이 목적
    2. 한 Factory에서 서로 연관된 여러 종류의 객체 생성을 지원(제품군 생성 지원)
    3. 클래스(Factory)레벨에서 포커스를 맞춤으로써 클라이언트의 Concrete Product인스턴스 군의 생성 및 구성에 대한 의존을 감소

## 클래스 구성

![Untitled 1](https://github.com/Employment-Study/Algorithm_Study/assets/132982907/7dc56546-3705-4917-be42-9a14549e48d2)

## 패턴 사용시기

📌**관련 제품**의 다양한 제품군과 함께 작동해야 할때, 해당 제품의 **구체적인 클래스에 의존하고 싶지 않은 경우**

📌 여러 제품군 중 하나를 선택해서 시스템을 설정해야하고 **한 번 구성한 제품을 다른 것으로 대체할 수 도있을때**

📌 제품에 대한 **클래스 라이브러리**를 제공하고, 그들의 구현이 아닌 **인터페이스를 노출시키고 싶을 때**

## 패턴 장점

📌 객체를 생성하는 코드를 분리하여 클라이언트 코드와 결합도를 낮출 수 있다.

📌제품 군을 쉽게 대체할 수 있다.

📌 단일 책임 원칙 준수

📌 개방/폐쇄 원칙 준수

## 패턴 단점

📌 각 구현체마다 팩토리 객체들을 모두 구현해주어야 하기 때문에 객체가 늘어날때마다 클래스가 증가하여 코드의 복잡성이 증가한다.(팩토리 패턴의 공통적인 문제점)

📌 기존 추상 팩토리의 세부사항이 변경되면 모든 팩토리에 대한 수정이 필요해진다.

이는 추상 팩토리와 모든 서브클래스의 수정을 가져온다.

📌 새로운 종류의 제품을 지원하는 것이 어렵다. 새로운 제품이 추가되면 팩토리 구현 로직 자체를 변경해야 한다.

## 예제를 통해 알아보는 추상 팩토리 패턴

📌컴퓨터 화면에 컴포넌트 요소들을 화면에 그리는 로직을 구현

📌 버튼, 체크박스, 텍스트 에딧 3가지 요소를 화면에 그리기 위해 각기 객체 지정

📌 컴퓨터는 OS에서 Window와 Mav으로 나뉘므로 각기 구현해야 한다.

📌 정리하자면 3가지 객체들은 하나틔 컴포넌트 군으로 묶을 수 있으며 또한 OS별로 나뉘게 된다.

![Untitled 2](https://github.com/Employment-Study/Algorithm_Study/assets/132982907/721dbfcb-3124-4394-9bd0-c374cabcc7dc)

![Untitled 3](https://github.com/Employment-Study/Algorithm_Study/assets/132982907/1490056a-8281-4c8e-a536-78e88d715b9c)

## 위의 기능들을 만든 코드

```java
interface Component {
    void render(); // 요소 그리기
}

/* ---------------------------------------------------------- */

abstract class Button implements Component {
}

class WindowButton extends Button {
    @Override
    public void render() {
        System.out.println("윈도우 버튼 생성 완료");
    }
}

class MacButton extends Button {
    @Override
    public void render() {
        System.out.println("맥 버튼 생성 완료");
    }
}

/* ---------------------------------------------------------- */

abstract class CheckBox implements Component {
}

class WindowCheckBox extends CheckBox {
    @Override
    public void render() {
        System.out.println("윈도우 체크박스 생성 완료");
    }
}

class MacCheckBox extends CheckBox {
    @Override
    public void render() {
        System.out.println("맥 체크박스 생성 완료");
    }
}

/* ---------------------------------------------------------- */

abstract class TextEdit implements Component {
}

class WindowTextEdit extends TextEdit {
    @Override
    public void render() {
        System.out.println("윈도우 텍스트박스 생성 완료");
    }
}

class MacTextEdit extends TextEdit {
    @Override
    public void render() {
        System.out.println("맥 텍스트박스 생성 완료");
    }
}
```

## 팩토리 메서드 패턴으로 구현

한 가지 종류의 컴포넌트만 생성하는 구조

팩토리 메서드의 초점은 추상화된 팩토리 메서드를 각 서브 공장 클래스가 재정의하여 걸맞는 제품 객체를 생성하는 것이기 때문

그렇기 때문에 버튼을 생성한다 하더라도 어느 OS실행환경인지 메서드내 분기문을 통해 구분해줘야 한다.

```java
interface ComponentFactoryMethod {
    Component createOperation(String type); // 템플릿
    Component createComponent(String type); // 팩토리 메서드
}

class ButtonFactory implements ComponentFactoryMethod {

    public Button createOperation(String type) {
        Button button = createComponent(type);
        button.추가설정();
        return button;
    }

    public Button createComponent(String type) {

        Button button = null;

        switch (type.toLowerCase()) {
            case "window":
                button = new WindowButton();
                break;

            case "mac":
                button = new MacButton();
                break;
        }

        return button;
    }
}

class CheckBoxFactory implements ComponentFactoryMethod {
    public CheckBox createOperation(String type) {
        CheckBox checkbox = createComponent(type);
        checkbox.추가설정();
        return checkbox;
    }

    public CheckBox createComponent(String type) {

        CheckBox checkbox = null;

        switch (type.toLowerCase()) {
            case "window":
                checkbox = new WindowCheckBox();
                break;

            case "mac":
                checkbox = new MacCheckBox();
                break;
        }

        return checkbox;
    }
}

class TextEditFactory implements ComponentFactoryMethod {
    public TextEdit createOperation(String type) {
        TextEdit txtedit = createComponent(type);
        txtedit.추가설정();
        return txtedit;
    }

    public TextEdit createComponent(String type) {

        TextEdit txtedit = null;

        switch (type.toLowerCase()) {
            case "window":
                txtedit = new WindowTextEdit();
                break;

            case "mac":
                txtedit = new MacTextEdit();
                break;
        }

        return txtedit;
    }
}

public static void main(String[] args) {
    ComponentFactoryMethod factory = null;
    Button btn = null;
    CheckBox chkBox = null;

    // 윈도우 버튼 생성
    factory = new ButtonFactory();
    btn = (Button) factory.createOperation("Window");
    btn.render();

    // 맥 버튼 생성
    btn = (Button) factory.createOperation("Mac");
    btn.render();

    // 윈도우 체크 박스 생성
    factory = new CheckBoxFactory();
    chkBox = (CheckBox) factory.createOperation("Window");
    chkBox.render();

    // 맥 체크 박스 생성
    chkBox = (CheckBox) factory.createOperation("Mac");
    chkBox.render();
}
```

## 팩토리 메서드의 문제점

실행 자체에는 문제가 없어보이지만, 만일 기능을 확장할 필요가 있을때 문제가 생긴다.

예를 들어 OS종류에 Linux를 새로 추가한다고 생각해보자.

그러면 각 메서드마다 있는 분기문 로직을 일일히 수정해야 하는데, 그러면 **`OCP원칙`**에 위배된다.

## 추상 팩토리 패턴으로 구현

📌 팩토리 메서드는 한 종류의 컴포넌트만 생성하지만, 추상 팩토리 공장 객체는 하나의 객체에서 여러 종류의 컴포넌트들을 골라 생산할 수 있도록 구성한다. 

![Untitled 4](https://github.com/Employment-Study/Algorithm_Study/assets/132982907/a9b65b22-1af6-4b3b-8f69-44d99b261835)

```java
interface ComponentAbstractFactory {
    Button createButton();
    CheckBox createCheckBox();
    TextEdit createTextEdit();
}

class WindowFactory implements ComponentAbstractFactory {

    @Override
    public Button createButton() {
        return new WindowButton();
    }

    @Override
    public CheckBox createCheckBox() {
        return new WindowCheckBox();
    }

    @Override
    public TextEdit createTextEdit() {
        return new WindowTextEdit();
    }
}

class MacFactory implements ComponentAbstractFactory {

    @Override
    public Button createButton() {
        return new MacButton();
    }

    @Override
    public CheckBox createCheckBox() {
        return new MacCheckBox();
    }

    @Override
    public TextEdit createTextEdit() {
        return new MacTextEdit();
    }
}

public static void main(String[] args) {
    ComponentAbstractFactory factory = null;

    // 윈도우 버튼 생성
    factory = new WindowFactory();
    Button WindowBtn = createBtn(factory);
    WindowBtn.render();

    // 맥 버튼 생성
    factory = new MacFactory();
    Button MacBtn = createBtn(factory);
    MacBtn.render();
}

// 추상 팩토리에서 객체를 생성하는 부분 코드는 같기 때문에 따로 메서드로 묶음 분리
public static Button createBtn(ComponentAbstractFactory fac) {
    return fac.createButton();
}
```

📌기존 팩토리 메서드에서는 다른 OS의 컴포넌트를 생성하기 위해 **문자열을 인자**로 주어 메서드 내에서 분기문으로 객체 생성을 처리하였지만, 추상 팩토리에선 **어떤 팩토리 객체를 생성하느냐**에 따라 똑같은 메서드를 호출해도 반환되는 결과가 다르다.

📌 추상 패곹리가 팩토리 메서드보다 무조건 좋다는 말이 아니다. 이 예제처럼 어떠한 제품들에 대한 군을 묶어 생성해야 할 때 추상 팩토리로 구성하는 것이 유지보수와 확장에 있어 더 유리하다는 것을 보여준다.

## 추상 팩토리의 유연한 확장

예시) Linux OS환경이 추가된다 하더라도 기존의 코드 수정 없이 리눅스 컴포넌트 구현체 클래스와 리눅스 팩토리 클래스만 적절하게 추가해주면 확장이 완료된다.

이는 OCP 원칙의 수정에는 닫혀있고 확장에는 열려 있다는 말이 일치한다.

## DocumentBuilderFacotry의 newInstance()

📌Java 는 xml형식의 문서를 객체화 시켜 살펴볼 수 있는 DocumentBuilder객체를 제공하는데 이 객체는 바로 DocumentBuilderFactory로부터 얻어올 수 있다.

📌 new Instance()를 통해 얻어오는 DocumentBuilderFacotry타입의 객체가 ConcreteFactory에 해당하고 ConcreteFactory가 제공하는 DocumentBuilder가 추상화된 객체에 해당하게 된다.

```java
public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {
    // 1. 공장 객체 생성
    DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
    
    // 2. 공장 객체를 통해 추상화된 제품 객체 생성
    DocumentBuilder builder = factory.newDocumentBuilder();
    
    // 3. 구현체 메소드 실행
    Document document = builder.parse("src/main/resources/config.xml");
    System.out.println(document.getDocumentElement());
}
```

## Spring Framework

- [ ]  Factory Bean
    
    기본으로 제공되는 스프링 구문으로는 생성 및 관리할 수 없는 객체를 Bean으로 활용할 수 있게끔 어댑터 역할을 한다.
    
    여기서 생성 및 관리할 수 없는 객체란 생성자가 private한 싱글톤 객체 또는 정적 팩토리 메서드를 통해 얻어오는 객체이다.
    
    ✅예시
    
    ```java
    //싱글톤 처리된 객체
    public class Ship {
        private static final Ship INSTANCE = new Ship();
    
        private String name = "Singleton_TurtleShip";
        private String color = "Green";
        private String logo = "\uD83D\uDC22";
     
        private Ship(){}
        
        public static Ship getInstance() {
            return INSTANCE;
        }
    }
    
    //FactoryBean의 구현체
    public class ShipFactory implements FactoryBean<Ship> {
        @Override
        public Ship getObject() throws Exception {
            return Ship.getInstance();
        }
     
        @Override
        public Class<?> getObjectType() {
            return Ship.class;
        }
    }
    ```
    
    만약 싱글톤 객체를 Bean으로 활용하고 싶다면 **`FactoryBean`**을 이용해 등록할 수 있다. FactoryBean의 구현체(ShipFactory)를 만들고 구현체를 Bean으로 등록하면, ShipFactory의 getObject()에서 반환하는 객체가 최종적으로 Bean으로 등록되게 된다.
    
    즉, 여기서 FactoryBean은 **`추상 팩토리`**의 `**AbstractFactory**`에 해당하고 **ShipFactory**는 **`ConcreteFactory`**에 해당한다.
    
    ✅xml 파일에서 bean으로 싱글톤 객체 등록하기
    
    ```xml
    <!-- config.xml -->
    <bean id="myShip" class="ShipFactory">
    
    </bean>
    ```
    
    ✅실행 코드
    
    ```java
    public static void main(String[] args) throws Exception {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("config.xml");
        
        Ship myShip = applicationContext.getBean("myShip");
        System.out.println(myShip);
    }
    ```