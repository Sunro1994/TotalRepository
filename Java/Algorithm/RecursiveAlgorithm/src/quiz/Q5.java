package quiz;

import java.util.Scanner;

import stack.InStack;

public class Q5 {
public static void main(String[] args) {
	//recur3 메서드를  비재귀적으로 구현하세요.
	/*
	 static void recur3(int n) {
	 if(n>0) {
	 recur3(n-1);
	 recur3(n-2);
	 System.out.println(n);
	 }
	 */
	Scanner sc = new Scanner(System.in);
	System.out.println("정수를 입력 :");
	int n = sc.nextInt();
	InStack st = new InStack(n);
	while(true) {
		if(n>0) {
			st.push(n);
			System.out.println(n);
			n -=1;
			continue;
		}
		System.out.println("======");
		if(st.isEmpty()!=true) {
			n = st.pop();
			System.out.println(n);
			n -= 2;
			continue;
		}
		break;
	}
	
	
	
	
	
	
	
	
	
	
	
	}//main
}
