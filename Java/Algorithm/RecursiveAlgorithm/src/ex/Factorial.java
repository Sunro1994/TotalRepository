package ex;

import java.util.Scanner;

// factorial을 구하는 프로그램
// 0! =1
// n>0이면 n! = n * n-1;


public class Factorial {
	static int factorial(int n ) {
		if(n>0) return n*factorial(n-1);
		else return 1;
	}
public static void main(String[] args) {
Scanner sc = new Scanner(System.in);

System.out.println("정수 입력");
int x = sc.nextInt();

System.out.println(x + "의 팩토리얼은 " + factorial(x) + "입니다.");			
/*
 	과정
 	
 	factorial(5)입력시
 	1.factorial(5)*factorial(4)*factorial(3)*factorial(2)*factorial(1)*factorial(0)
 	2. 5*factorial(4)
 	3. 5*4*factorial(3)
 	..
 	4.factorial(0)은 n<0이므로 1을 반환하고 재귀 종료.
 	3. 결과 : 5*4*3*2*1 = 120
 	
 */

	}
}
