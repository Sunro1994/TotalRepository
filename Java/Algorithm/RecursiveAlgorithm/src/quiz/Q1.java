package quiz;

public class Q1 {
public static void main(String[] args) {
	//재귀메서드를 호출하지 않고 실습 factorial메서드를 작성하기
	//5,4,3,2,1
	int n=5;
	int answer =1;
	while(n!=0) {
		answer *= n;
		n -=1;
		System.out.println("n : " + n);
	}
	System.out.println(answer);
}
}
