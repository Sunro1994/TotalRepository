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
