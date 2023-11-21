package quickSort;

import java.util.Arrays;

public class QuickSortRightPivot {
static void sort(int[] a, int n) {
	r_pivot_sort(a,0,n-1);
}

static void r_pivot_sort(int[] a, int lo, int hi) {
	
	if(lo >= hi) return;
	
	int pivot = partition(a, lo, hi);
	
	r_pivot_sort(a, lo, pivot-1);
	r_pivot_sort(a, pivot+1, hi);
}
	private static int partition(int[] a , int left, int right) {
		int lo = left;
		int hi = right;
		int pivot = a[right];	//부분리스트의 오른쪽 요소를 피벗으로 설정
		
		while(lo<hi) {
			
			while(a[lo]<pivot && lo<hi) lo++;
			
			while(a[hi]>=pivot && lo <hi) hi--;
			
			swap(a,lo,hi);
		}
		swap(a,right,hi);
		return hi;
	}
	private static void swap(int[] a, int i,int j) {
		int tmp = a[i];
		a[i] = a[j];
		a[j]= tmp;
	}
	
	public static void main(String[] args) {
		int[] x = {1,21,44,25,16};
		int nx = x.length;
		
		r_pivot_sort(x, 0, nx-1);
		
		System.out.println(Arrays.toString(x));
	}
	
}

