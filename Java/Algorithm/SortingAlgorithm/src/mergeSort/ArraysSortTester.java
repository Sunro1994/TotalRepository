package mergeSort;

import java.util.Arrays;

public class ArraysSortTester {
/*	arrays의 sort메서드는 기본 자료형의 배열을 정렬합니다.
	sort메서드가 사용하는 알고리즘은 퀵 정렬 알고리즘을 개선한것으로 안정적이지 않다. << 동일한 값이 있으면 위치가 바뀔 수 있다.
 	
 */
// sort메서드로 int형 배열을 정렬
	public static void main(String[] args) {
		int[] x = {22,5,11,32,120,68,70,70};
		int nx = x.length;
		
		Arrays.sort(x);
		
		System.out.println(Arrays.toString(x));
	}
}
