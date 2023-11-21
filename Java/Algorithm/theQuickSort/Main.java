package theQuickSort;

import java.util.Arrays;

public class Main {
	public static void main(String[] args) {
		int[] left_a = {5,3,8,9,2,4,7};
		int[] right_a = {5,3,8,9,2,4,7};
		int[] mid_a = {5,3,8,9,2,4,7};
		
		LeftPivotQuickSort.sort(left_a);
		System.out.println(Arrays.toString(left_a));
		RightPivotQuickSort.sort(right_a);
		System.out.println(Arrays.toString(right_a));
		MiddlePivotQuickSort.sort(mid_a);
		System.out.println(Arrays.toString(mid_a));
		
	        int[] arr = {5, 2, 9, 1, 3, 7, 6, 4, 8};
	        QuickSortWithInsertionSort.quickSort(arr, 0, arr.length - 1);
	        System.out.println(Arrays.toString(arr));
	        
	   
		
	}
}
