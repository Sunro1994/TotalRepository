package simpleSelection;

//	단순 선택 정렬 알고리즘의 요솟값을 비교하는 횟수는 (n²-n)/2회 이다.
//	이 정렬은 서로 떨어져 있는 요소를 교환하는 것이기 때문에 안정적이지 않다.
//	왜냐하면 같은 수가 중복해서 있을 때 두 요소의 순서가 바뀌는 것을 알 수 있다.
public class SelectionSort {
	static void swap(int[] a, int idx1, int idx2) {
		int tmp= a[idx1];
		a[idx1] = a[idx2];
		a[idx2] = tmp;
	}
	static void selectionSort(int[] a,int n) {
		for(int i=0; i<n; i++) {
			int min =i; 
			for(int j= i+1; j<n; j++) {
				if(a[j] < a[min]) {
					min =j;
					swap(a,i,min);
				}
			}
		}
	}//selectionSort
	
}
