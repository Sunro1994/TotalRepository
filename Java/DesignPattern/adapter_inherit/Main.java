package adapter_inherit;


/**
 * Main클래스는 어디까지나 Print인터페이스를 사용해서 프로그래밍하고 있다.
 * Banner클래스나 Banner내부의 메서드는 Main클래스의 코드에서는 완전히 숨겨져 있다.
 * PrintBanner클래스가 어떻게 구현되었는지 Main클래스는 모른다. 따라서 
 * Main클래스를 전혀 변경하지 않아도 PrintBanner클래스의 구현을 바꿀 수 있다.
 * @author Sunro
 *
 */
public class Main {
public static void main(String[] args) {
	Print p = new PrintBanner("Hello");
	p.printWeak();
	p.printStrong();
}
}
