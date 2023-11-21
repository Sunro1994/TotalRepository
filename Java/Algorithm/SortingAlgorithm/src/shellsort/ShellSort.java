package shellsort;

import java.util.Scanner;

//셀 정렬 버전1
public class ShellSort {
	//셀 정렬
	static void shellSort(int[] a, int n) {
		for(int h= n/2; h>0; h/=2)				//h=3  배열을 반씩 나눈다.
//			==================================================
			for(int i=h ; i <n; i++) {			//i=3,4,5,6,7		나눈배열에서 1씩 증가하고 배열의 길이까지
				int j;
				int tmp= a[i];						//tmp = a[3...7]  임시변수에는 배열의 시작값을 담는다.
//				==============================================================
				for(j=i-h; j>=0 && a[j] > tmp; j-=h) //j=0...4		
					a[j+h] = a[j];					//a[3...7] = a[0...4] 
//				===============================================================
				a[j+h]  = tmp;						//a[3...7]  =tmp;
			}
//		==========================================================
	}
	public static void main(String[] args) {
	int length = 8;
	int[] arr = {1,22,5,11,32,120,68,70};
	
	System.out.println("셀 정렬(버전1) ");
	
	
	shellSort(arr, length);
	
	System.out.println("오름 차순 정렬완료");
	for(int k : arr) System.out.println(k);
}
}
