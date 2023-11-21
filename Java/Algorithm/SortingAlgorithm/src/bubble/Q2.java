package bubble;

import java.util.Scanner;

public class Q2 {
	static void swap(int[] a, int idx1, int idx2) {
		for(int i=0; i<a.length; i++) {
			int tmp= a[idx1];
			a[idx1] = a[idx2];
			a[idx2] = tmp;
			
		}
	}
	static void bubbleSort(int[]a, int lx,int  comparCnt, int SwapCnt) {
		for(int i=0; i<lx-1;i++) {
			for(int j= lx-1; j > i; j-- ) {
				if(a[j] <a[j-1]) {
					swap(a, j, j-1);
					SwapCnt +=1;
				}
				comparCnt +=1; 
			}
			System.out.println();
		}
		
		System.out.println("compart: " +comparCnt+ " ");
		System.out.println("swapcnt:" + SwapCnt+ " ");
	}
	
public static void main(String[] args) {
	// 비교, 교환 과정을 자세히 출력하면서 버블정렬을 하는 프로그램을 작성하세요. 비교하는 두 요소 사이에 교환수행시 + 수행않으면 - 출력
//	정렬을 마치면 비교 횟수와 교환 횟수를 출력하세요
	int comparCnt = 0;
	int SwapCnt=0;
	
	Scanner sc = new Scanner(System.in);
	System.out.println("요소수 : ");
	int lx = sc.nextInt();
	int[] arr = new int[lx];
	
	for(int i=0; i<arr.length; i++) {
		System.out.println("x["+i+"] :");
			arr[i] = sc.nextInt();
	}
	bubbleSort(arr, lx, comparCnt, SwapCnt);
	
	for(int i : arr) System.out.print(i);
	System.out.println();
	
	
	
	
	
}
}
