package quiz;

import java.util.Scanner;

public class Q4 {
	static void recur2(int n) {
		if(n>0) {
			
		//recur(1) = 1
		//recur(2) = recur(0) 2 recur(1)  2 1
		//recur(3) = recur(1) 3 recur(2)  1 3 2 1
		//recur(4) = recur(2) 4 recur(3)  2 1 4 1 3 2 1
		//recur(5) = recur(3) 5 recur(4)  1 3 2 1 5 2 1 4 1 3 2 1
		//recur(6) = recur(4) 6 recur(5)  2 1 4 1 3 2 1 6 1 3 2 1 5 2 1 4 1 3 2 1
		recur2(n-2);
		System.out.println(n);
		recur2(n-1);
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("정수를 입력하세요 :");
		int num = sc.nextInt();
		
		recur2(num);
	}
	
}
