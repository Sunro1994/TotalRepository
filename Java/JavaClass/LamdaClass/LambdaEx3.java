package ch14_Lamda;

class Outer{
	int val =10;	//Outer.this.val
	
	class Inner{
		int val =20; //thsi.val
	
		//1. 람다에서 참조하는 외부변수는 자동으로 fianl이 붙은 걸로 상주된다. 람다식 내에서 i와 val을 참조하고 있으므로 람다식 내에서나 다른 어느 곳에서도 이 변수들의
		//값을 변ㄱ여하는 일은 허용되지 않는다.
		//2. InnerClass와 OuterClass의 this.val과 Outer.this.val은 상수로 간주되지 않으므로 값을 변경해도 된다.
		//3. 그리고 외부 지역변수와 같은 이름의 람다식 매개변수는 허용되지 않는다.
		void method(int i) {	//void method(final int i) {
			int val =30;
//			i =10;				//Err 상수의 값을 변경할 수 없음;
			
			MyFunction2 f = () -> {
				System.out.println("		i:"+ i);
				System.out.println("		val:"+val);
				System.out.println("		this.val:"+ ++this.val);
				System.out.println("		Outer.this.val:" + ++Outer.this.val);
			};
			f.myMethod();
		}//method
	}//Inner
}//Outer
public class LambdaEx3 {
	public static void main(String[] args) {
		Outer outer = new Outer();
		Outer.Inner inner = outer.new Inner();
		inner.method(100);
	}
}
