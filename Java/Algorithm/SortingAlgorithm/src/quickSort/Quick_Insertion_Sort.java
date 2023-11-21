package quickSort;

import java.util.Arrays;

public class Quick_Insertion_Sort {
private static final int THRESHOLD = 4;//임계치 설정
private static void swap(int[] a, int i , int j) {
	int tmp = a[i];
	a[i] = a[j];
	a[j] = tmp;
}
public static void quicksort(int[] arr, int low, int high) {
	if(low < high) {
		if(high - low < THRESHOLD) {
			insertionSort(arr,low,high);
		}else {
			int partitionIndex = partition(arr,low,high);
			quicksort(arr, low, partitionIndex-1);
			quicksort(arr, partitionIndex+1, high);
		}
	}
}// quicksort

private static int partition(int[] arr, int low, int high) {
	int pivot = arr[high];
	int i = low-1;
	
	for(int j= low; j<high; j++) {
		if(arr[j] <= pivot) {
			i++;
			swap(arr,i,j);
		}
	}
	
	swap(arr, i+1, high);
	return i+1;
}

private static void insertionSort(int[] arr, int low, int high) {
	for(int i= low+1; i<=high; i++) {
		int key = arr[i];
		int j;
		for(j=i-1;j>=0 && arr[j] > key;j--) {
			arr[j+1]  = arr[j];
		}
		arr[j+1] = key;
	}
}

public static void main(String[] args) {
	int[] arr = {5,2,9,1,3,7,6,4,8};
	quicksort(arr, 0, arr.length-1);
	System.out.println(Arrays.toString(arr));
}
}
