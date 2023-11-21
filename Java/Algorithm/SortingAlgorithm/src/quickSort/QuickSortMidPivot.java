package quickSort;

import java.util.Arrays;

public class QuickSortMidPivot {
	static void swap(int[] a, int i, int j) {
		int tmp = a[i];
		a[i] = a[j];
		a[j] = tmp;
	}
	
	public static void sort(int[] a) {
		m_pivot_sort(a, 0, a.length-1);
	}
	
	private static void m_pivot_sort(int[] a, int lo, int hi) {
		
		if(lo>= hi) return;
		
		int pivot = partition(a, lo, hi);
		
		m_pivot_sort(a, lo, pivot);
		m_pivot_sort(a, pivot+1, hi);
	}
	
	private static int partition(int[] a, int left, int right) {
		int lo = left;
		int hi = right;
		int pivot = a[(left+right)/2];
		
		
		while(true) {
			while(a[lo]<pivot) lo++;
		
			while(a[hi]>pivot && lo <= hi) hi--;
			
			if(lo>=hi) {
				return hi;
			}
			
			swap(a,lo,hi);
		
		}
	}
	public static void main(String[] args) {
	int[] x = {10,50,9,4,70,88,125};
	int nx = x.length;
	
	m_pivot_sort(x, 0, nx-1);
	System.out.println(Arrays.toString(x));
}
}
