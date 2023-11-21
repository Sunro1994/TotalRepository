package ex;

import java.util.Scanner;

public class HanoiTower {
static void move(int no, int x , int y) {
	if(no >1) move(no-1, x, 6 -x -y) ; //가장 밑에있는 (큰숫자) 링을 빼고 시작자리에서(x) 6-x-y 중간자리로 옮김
	
	// 
	
	System.out.println("원반["+no+"]을"+ x+ "기둥에서 "+ y+"기둥으로 옮김");
	
	if(no >1)
		move(no -1, 6-x -y, y);  //가장밑에있는 링을 배고 중간자리에서 목표자리로 옮김
	}
public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
			
			System.out.println("하노이의 탑");
	System.out.println("원반 개수 :");
	int n = sc.nextInt();
	
	move(n,1,3);
}
}
