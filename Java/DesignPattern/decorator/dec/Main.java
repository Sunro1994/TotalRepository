package dec;

public class Main {
	public static void main(String[] args) {
		//1. 원본 객체 생성
		IComponent obj = new ConcreteComponent();
		
		//2. 장식 1 하기
		IComponent deco1 = new ComponentDecorator1(obj);
		
		//3. 장식 2하기
		IComponent deco2 = new ComponentDecorator2(obj);
	}
}
