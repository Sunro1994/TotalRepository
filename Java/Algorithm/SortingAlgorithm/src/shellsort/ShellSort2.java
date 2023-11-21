package shellsort;

public class ShellSort2 {
	//버전1의 문제점 : h의 값이 서로 배수가 되면 정렬 알고리즘이 작동하지 않는다. 
	//h의 값을 1, 4, 13, 40, 121, ...으로 정한다.
	//1부터 시작하여 값을 3배하고 1을 더하면서 n/9를 넘지 않는 가장 큰 값을 h에 대입한다.
	//기존의 시간 복잡도는 O(n²)이지만 셀 정렬 시간 복잡도는 O(n^1.25), 안정적이지는 않음
static void shellSort(int[] a, int n) {
	int h;
	for(h=1;h<n/9;h=h*3+1)
		;
	
	for(; h>0; h/=3) {
		for(int i=h; i<n ; i++) {
			int j;
			int tmp= a[i];
			for (j=i-h; j>=0 && a[j] > tmp; j-=h) a[j+h] = a[j];
		a[j+h]  = tmp;
		}
		
		
	}
}
	
	
	
	public static void main(String[] args) {
		int x = 7;
		int[] arr = {7,5,11,32,120,68,70};
		
		shellSort(arr, x);
		
		for(int i : arr) System.out.println(i);
	
	}
}
