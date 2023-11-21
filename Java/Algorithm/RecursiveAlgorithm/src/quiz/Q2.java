package quiz;

public class Q2 {
public static void main(String[] args) {
	//재귀메서드를 호출하지 않고 gcd메서드를 작성
	
	int x = 8;
	int y= 22;
	int tmp;
	
	while(true) {
		tmp = y;
		y = x%y;
		x =tmp;
		if(y ==0 ) {System.out.println(x); break;}
		System.out.println("x : "+ x);
		System.out.println("y : "+ x%y);
		System.out.println();
	}
}
}
