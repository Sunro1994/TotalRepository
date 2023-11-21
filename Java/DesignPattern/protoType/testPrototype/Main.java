package testPrototype;


public class Main {
	public static void main(String[] args) {
		Manager manager = new Manager();
		UnderLinePen upen = new UnderLinePen('-');
		MessageBox mbox = new MessageBox('*');
		MessageBox sbox = new MessageBox('/');
		
		//manager라는 product와 product를 구현한 클래스를 이어주는 중간 객체
		manager.register("storage message", upen);
		manager.register("warning box", mbox);
		manager.register("slash box", sbox);
		
		Product p1 = manager.create("storage message");
		p1.use("hello, world");
		Product p2 = manager.create("warning box");
		p2.use("hello, world");
		Product p3 = manager.create("slash box");
		p3.use("hello, world");
		
		//생성자로도 복사가 가능하다.
		Product p4 = upen.creatCopy();
		p4.use("this is prototype");
		
	}
	
	
}
