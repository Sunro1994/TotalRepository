package simpleInsertion;

public class Q7 {
//단순 삽입 정렬에서 배열의 첫 번째 요소(a[0])부터 데이터를 저장하지 않고 a[1]부터 데이터를 저장하면 a[0]을 보초로하여 삽입을 마치는 조건을 줄일 수 있다.
	// 이 아이디어를 이용한 단순 삽입 메서드를 수정하세요.
	static void SimpleInsertion(int[] a, int n){
		for(int i=1; i<n; i++) {
			int tmp = a[i];							//바꿀 위치에 있던 값
			int j;									//for 내부에서 사용하면 지역변수로 외부에서 사용못하므로 미리 j생성
			for(j= i; j>0 && a[i-1]> tmp;j--) { // a[i-1]이 a[i]보다 크면 반복문 실행
				a[j] = a[j-1];						// a[i-1]의 값을 a[i]에 대입
				
			}
			a[j] = tmp;							//원래 위치에 있던 값을 a[j]에 대입
		}
	}
	public static void main(String[] args) {
		
	}
	
}
