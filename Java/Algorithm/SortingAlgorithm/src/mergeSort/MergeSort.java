package mergeSort;

import java.util.Arrays;
import java.util.Scanner;

/*
 	병합 정렬 알고리즘
 	1. 배열의 요소개수가 2개 이상인경우
 	2. 배열의 앞부분 정렬
 	3. 배열의 뒷부분 정렬
 	4. 배열의 앞부분과 뒷부분을 병합
 	
 	//배열 병합의 시간 복잡도 :  O(n), 데이터의 요소 개수가 n개
	//배열의 정렬 단계는 logn만큼 필요하므로 전체 시간 복잡도는 O(nlogn)이라고 할 수 있다.
	//병합 정렬은 서로 떨어져 있는 것이 아니므로 안정적인 정렬 방법 
 */
public class MergeSort {
	static int[] buff;	//작업용 배열
	
	static void __mergeSort(int[] a, int left, int right) {
		if(left < right) {
			int i;
			int center = (left+right)/2;	//양쪽으로 나눌 기준점
			int p=0;
			int j=0;
			int k=left;
			
			__mergeSort(a, left, center);	//배열의 앞부분 정렬
			__mergeSort(a, center+1, right);	//배열의 뒷부분 정렬
			
			for(i=left;i<=center;i++) 	buff[p++] = a[i];	//작업용 배열에 왼쪽 배열을 담음
			
			// i = center-left+1 그래서 j는 p보다 작을 수 밖에 없다.
			// i는 오른쪽배열의 0번 j는 buff배열(왼쪽 배열)의 0번 
			while( i<= right && j <p)  
				a[k++] = (buff[j]<=a[i]) ? buff[j++] : a[i++];
			while(j<p) 
				a[k++] = buff[j++];
		}//if
	}// __mergeSort
	static void mergeSort(int[]a, int n) {
		buff = new int[n];
		
		__mergeSort(a, 0, n-1);
		
		buff =null;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("병합 정렬");
		System.out.println("요솟수 : ");
		int nx = sc.nextInt();
		int[] x = new int[nx];
		
		for(int i=0; i<nx;i++) 
			System.out.println("x["+i+"] : " + (x[i] = sc.nextInt()));
			
			mergeSort(x, nx);
			
			System.out.println("오름차순 정렬 완료");
			for(int i=0; i<nx;i++) System.out.println("x["+i+"] : "+ x[i]);
		}
	}

