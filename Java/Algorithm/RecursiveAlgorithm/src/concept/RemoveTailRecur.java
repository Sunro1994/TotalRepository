package concept;

public class RemoveTailRecur {
//꼬리재귀의 제거
//	메서드의 꼬리에서 재귀 호출하는 메서드 recur(n-2)라는 말은 인자로 n-2를 전달하여 recur메서드를 호출한다는 의미이다.
//	호출하지 않고 바로 연산의 결과를 보여주는 것이 꼬리재귀
	
//	n-2는 쉽게 제거했으나 recur(n-1)은 쉽지 않다.
//	예를 들어 n이 4인경우 recur(3)의 처리가 완료되지 않으면 n의 값인 4를 저장해야 한다.
	
	static void recur(int n) {
		while( n>0) {
			recur(n-1);
//			과정
//			n의 값을 n-1로 업데이트하고 메서드의 시작 지점으로 돌아간다.
//			현재 n의 값을 잠시 저장한다.
//			recur(n-1)의 고자ㅓㅇ이 처리된 후 n값은 다시 저장했던 값을 꺼내 출력한다.
			
			
			
			System.out.println(n);
			n = n-2;			//꼬리재귀의 제거
		}
	}
}
