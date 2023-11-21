package quiz;

import java.util.Scanner;

public class Q6 {
	static void move(int no,int x, int y){
		if(no>1) move(no-1, x, 6-x-y);
		//과정(no=3) move(3,1,3)
//		1. move(2,1,2) 호출 >> move(1,1,3)호출
//		2. move(1,1,3) : 1을 1에서 3으로
//		3. move(2,1,2) : 2를 1에서 2로
//		5. move(3,1,3) : 3을 1에서 3으로
		
		String a = x==2? " B" : x==1? "A":"C";
		String b = y==3? "C": y==2? "B": "A";
		System.out.println("원반["+no+"]을"
		+a+"기둥에서"
		+b+"기둥으로 옮긴다.");
		
		if(no>1) move(no-1, 6-x-y, y);
//		4. move(2,1,2)에서 : move(1,3,2)호출
//		6. move(2,2,3) : 2를 2에서 3으로
//		7. move(2,2,3)에서 (1,2,3)호출
//		8. move(1,2,3) : 1을 2에서 3으로
	}
public static void main(String[] args) {
	//숫자가 아닌 기둥 이름을 출력하도록 프로그램을 수정한다.
	Scanner sc= new Scanner(System.in);
	System.out.println("하노이의 탑 원반 개수 : ");
	int n = sc.nextInt();
	
	move(n,1,3);
	
}
}
