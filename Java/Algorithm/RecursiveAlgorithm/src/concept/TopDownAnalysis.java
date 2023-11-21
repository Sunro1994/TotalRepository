package concept;

import java.util.Scanner;

// 재귀 알고리즘 분석
// 재귀 알고리즘 분석을 위한 상향식 분서고가 하향식 분석이 있다.

//recur메서드는 팩토리얼이나 gcd메서드와 달리 재귀 호출을 2회 실행한다.
// 이처럼 재귀호출을 여러 회 실행하는 메서드를 순수하게 재귀적이라 하며, 실제 동작은 매우 복잡하다.


// 7. 그 이후 System.out.println(4)가 4를 출력한다.

public class TopDownAnalysis {
		//재귀 함수
	// 하향식 분석
	// 매개변수 n으로 4를 전달하면 recur메서드는 아래 과정을 순서대로 수행한다.
	
	
		static void recur(int n) {
			if(n>0) {
				recur(n-1);			
				// 1. recur(3)을 호출하면 sysout(4)를 하기전에 recur(3)의 재귀 호출에 대한 작업 수행을 모두 마쳐야 한다.
				// 2. recur(3) 은 recur(2)와 recur(1)을 호출한다.
				// 3. recur(2) 는 recur(1)과 recur(0)을 호출한다.
				// 4. recur(1) 은 recur(0)과 recur(-1)을 호출한다.
				// 5. recur(0)과 recur(-1)은 값을 반환하지 않으므로 recur(1)로돌아가 1을 출력한다.
				// 6. recur(2)는 2를 출력하고 recur(3)은 3을 출력한다
				// 7. recur(3)에서  같이 호출된 recur(1)은 1을 출력한다.
				System.out.println(n);	//7. 4를 출력한다.
				
				recur(n-2);			//recur(2) >> recur(1);
				//8. recur(2)는 다시 recur(1)과 recur(0)을 출력하므로 
				//9. 1을 반환후 2를 반환한다.
				
				//결론 . 1231412
			}
		}
		//가장 위쪽에 위치한 상자의 메서드 호출부터 시작해 계단식으로 자세히 조사하는 분석 기법을 하향식 분석이라고 한다.
		//하지만 꼭대기부터 분석하면 이렇게 같은 메서드의 호출이 여러 번 나올 수 있기 때문에 반드시 효율적이다 라곤 할 수 없다.
public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	
	System.out.println("정수를 입력하세요");
	int x = sc.nextInt();
	
	recur(x);
}
}
