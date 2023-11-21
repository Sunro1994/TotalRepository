package theQuickSort;

public class MiddlePivotQuickSort {
	/**
	 * 
	 * @param a : 배열
	 * @param lo : 배열의 가장 왼쪽
	 * @param hi : 배열의 가장 오른쪽
	 */
	public static void sort(int[] a ) {
		m_pivot_sort(a,0,a.length-1);
	}
	
	private static void m_pivot_sort(int[] a , int lo, int hi) {
		
		if(lo>=hi) {
			return;
		}
		
		int pivot = partition(a,lo,hi);
		
		m_pivot_sort(a,lo,pivot);
		m_pivot_sort(a,pivot+1,hi);
		
	}
	
	private static int partition(int[] a , int left, int right) {
		
		int lo = left-1;
		int hi = right+1;
		int pivot = a[(left+right)/2];
		
		while(true) {
			
			
			do {
				lo++;
			}while(a[lo]<pivot);
			
			do {
				hi--;
			}while(a[hi]>pivot && lo<=hi);
			
			if(lo>=hi) {
				return hi;
			}
			
			swap(a,lo,hi);
		}
	}
	
	private static void swap(int[] a , int n1, int n2) {
		int tmp = a[n1];
		a[n1] = a[n2];
		a[n2] = tmp;
	}
}
