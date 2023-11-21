package stack;

import java.util.Scanner;

public class InStackTester {
public static void main(String[] args) {
	
	
	Scanner sc = new Scanner(System.in);
	InStack s = new InStack(64);
	
	while(true) {
		System.out.println("현재 데이터 수 :"+ s.size() + " / "+ s.capacity());
		System.out.print("(1)푸시 (2)팝 (3)피크 " + "(4)덤프 (5)클리어 (0)종료 :");
		
		int menu = sc.nextInt();
		if(menu==0) break;
		
		int x;
		switch (menu) {
		case 1:
			System.out.println("데이터 : ");
			x = sc.nextInt();
			try {
				s.push(x);
			}catch (InStack.OverflowStackException e) {
				System.out.println("스택이 가득 찼습니다.");
			}
			break;
		case 2:
			try {
			x = s.pop();
			System.out.println("팝한- 데이터는 "+ x+ "입니다.");
		} catch (InStack.EmptyInStackException e) {
			System.out.println("스택이 비어 있습니다.");
		}
			break;
		case 3:
		try {
			x= s.peek();
			System.out.println("피크한 데이터는 "+ x + "입니다.");
		}catch (InStack.EmptyInStackException e) {
			System.out.println("스택이 비어 있습니다.");
		}
		break;
		
		case 4:
			s.dump();
			break;
			
		case 5:
			s.clear();
			break;
		
			}//switch
		}//while
	}//main
}//class
