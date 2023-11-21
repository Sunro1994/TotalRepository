package concept;

import java.util.Scanner;

//위쪽부터 분석하는 하향식 분석과는 대조적으로 아래쪽부터 분석하는 방법이 상향식 분석이다.
public class BottomUpAnalysis {

	static void recur(int n) {
		if(n>0) {
			recur(n-1);			
			//recur(1)부터 생각해본다. 	//recur(0)을 수행, 1을 출력 recur(-1)을 수행 =1
			//recur(2)				//recur(1)을 수행, 2를 출력 , recur(0)을 수행 =12
			//recur(3)				//recur(2)을 수행, 3을 출력, recur(1)을 수행 = 1231
			//recur(4)				//recur(3)을 수행, 4를 출력, recur(2)을 수행 =1231412 
			System.out.println(n);	
			
			recur(n-2);			
			
		}
	}
	
public static void main(String[] args) {
Scanner sc = new Scanner(System.in);

System.out.println("정수를 입력하세요");
int x = sc.nextInt();

recur(x);
}
}

