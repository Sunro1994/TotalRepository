package mergeSort;

import java.util.Arrays;

// 정렬을 마친 배열의 병합
public class MergeArray {
	//정렬을 마친 배열 a,b를 병합하여 배열c에 저장합니다.
	// na,nb는 각 배열의 길이
	static void merge(int[] a,int na, int[] b,int nb, int[] c) {
		//각 배열의 인덱스 (0부터 시작)
		int pa=0;
		int pb=0;
		int pc=0;
		
		//작은 값을 저장
		// na,nb에 도달하기까지 수행
		while(pa<na && pb < nb) 
			c[pc++] = (a[pa] <= b[pb])? a[pa++] : b[pb++];
	
		//a에 남아있는 요소를 복사
		while(pa < na) c[pc++] = a[pa++];
		
		//b에 남아있는 요소를 복사
		while(pb < nb) c[pc++] = b[pb++];
	}
public static void main(String[] args) {
	int[] a = {2,4,6,8,11,13};
	int[] b = {1,2,3,4,9,16,21};
	int[] c = new int[13];
	
	System.out.println("두 배열의 병합");
	merge(a, a.length, b, b.length, c);
	
	System.out.println("배열저장 완료");
	System.out.println(Arrays.toString(c));
}
}
