package simpleInsertion;

public class AboutInsertion {
//	단순 삽입 정렬은 선택한 요소를 그보다 더 앞 쪽의 알맞은 위치에 삽입하는 작업을 반복하여 정렬하는 알고리즘
//	단순 선택정렬과 비슷해보이지만 값이 가장 작은 요소를 선택해 알맞은 위치로 옮긴다는 점이 다르다.
//	단순 삽입의 특징
//	1. 정렬을 마쳤거나 정렬을 마친 상태에 가까우면 정렬 속도가 매우 빨라진다.(장점)
//	2. 삽입할 위치가 멀리 떨어져 있으면 이동해야 하는 횟수가 많아진다.(단점)
	public static void main(String[] args) {
	int n = 10;		//길이가 10일때
//	n-1회의 정렬을 한다.
	for(int i=1; i<n; i++) {	//2번째 요소부터 시작한다. 1번째 요소에 집어 넣어야하기 때문
		
		//tmp = a[i]
		//a[0], ..., a[i-1]의 알맞은 곳에 tmp를 삽입하도록 한다.
	}
	
	//다시 말해 tmp에 a[i]를 대입하고 반복 제어용 변수 j 에 i-1을 대입한 다음 아래의 두 조건중 하나를 만족할 때까지 j를 1식 감소하면서 대입합니다.
	//1. 정렬된 열의 왼쪽 끝에 도달합니다.
	//2. tmp보다 작거나 같은key를 갖는 항목 a[i]를 발견합니다.
	
	// 이때 드모르간 법칙을 적용하면 아래의 두 조건이 모두 성립할때까지 반복한다고 할 수 있습니다.
	
	//1. j가 0보다 큽니다.
	//2. a[j-1]값이 tmp보다 큽니다.
	
	// 이 과정을 마치고 난 다음에 요소 a[j]에 tmp를 대입하면 한 요소에 대한 단순 삽입 정렬을 마치게 됩니다.
	
}	
	
}
