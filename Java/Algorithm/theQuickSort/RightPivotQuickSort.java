package theQuickSort;

public class RightPivotQuickSort {
	public static void sort(int[] a ) {
		r_pivot_sort(a,0,a.length-1);
	}
	
	
	/**
	 * 
	 * @param a : 정렬할 배열
	 * @param lo : 현재 배열에서 왼쪽
	 * @param hi  : 현재 배열에서 오른쪽
	 */
	
	private static void r_pivot_sort(int[] a, int lo, int hi) {
		
		/*
		 * lo가 hi보다 크거나 같다면 정렬할 원소가 1개 이하이므로 정렬하지 않는다.
		 */
		
		if(lo>=hi) {
			return;
		}
		
		/*
		 * 피벗을 기준으로 요소들이 왼쪽과 오른쪽으로 약하게 정렬된 상태로
		 * 만들어 준 뒤, 최종적으로 pivot의 위치를 얻는다.
		 * 
		 * [과정]
		 * 
		 * Partitioning:
		 *
		 *         left part                right part       a[right]   
		 * +---------------------------------------------------------+
		 * |    element < pivot    |    element >= pivot   |  pivot  |
		 * +---------------------------------------------------------+
		 *    
		 *    
		 *  result After Partitioning:
		 *  
		 *         left part         a[hi]          right part
		 * +---------------------------------------------------------+
		 * |   element < pivot    |  pivot  |    element >= pivot    |
		 * +---------------------------------------------------------+
		 *       
		 *       
		 *  result : pivot = hi     
		 *       
		 *
		 *  Recursion:
		 *  
		 * r_pivot_sort(a, lo, pivot - 1)     r_pivot_sort(a, pivot + 1, hi)
		 *  
		 *         left part                           right part
		 * +-----------------------+             +-----------------------+
		 * |   element <= pivot    |    pivot    |    element > pivot    |
		 * +-----------------------+             +-----------------------+
		 * lo          
		 */
		
		int pivot = partition(a,lo,hi);
		
		r_pivot_sort(a,lo,pivot-1);
		r_pivot_sort(a,pivot+1,hi);
	}
	
	/**
	 * 
	 * pivot을 기준으로 파티션을 나누기 위한 약한 정렬 메서드
	 * 
	 * @param a 정렬 할 배열
	 * @param left 현재 배열의 가장 왼쪽
	 * @param right 현재 배열의 가장 오른쪽
	 * @return 최종적으로 위치한 피벗의 위치(lo)를 반환
	 */
	
	private static int partition(int[] a, int left, int right) {
		
		int lo = left;
		int hi = right;
		int pivot = a[hi];
		
		//lo가 hi보다 작을 때까지만 반복한다.
		while(lo<hi) {
			
			/*
			 * hi가 lo보다 크면서, lo가 pivot보다 큰 원소를 찾을 때 까지 lo를 증가시킨다.
			 * 
			 */
			
			
			
			while(a[lo]<pivot && lo<hi) {
				lo++;
			}
			
			/*
			 * hi가 lo보다 크면서, hi의 요소가 pivot보다 작거나 같은 원소를 찾을 때까지 hi를 감소시킨다.
			 */
			while(a[hi] >=pivot && lo<hi) {
				hi--;
			}
			
			//교환 될  두 요소를 찾았으면 두 요소를 바꾼다.
			swap(a,lo,hi);
		}
			swap(a,right,hi);
		return lo;
	}
	public static void swap(int[] a, int lo, int hi) {
		int tmp = a[lo];
		a[lo] = a[hi];
		a[hi]=tmp;
	}
}
