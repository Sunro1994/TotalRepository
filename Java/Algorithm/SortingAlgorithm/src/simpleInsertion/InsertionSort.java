package simpleInsertion;

import java.util.Scanner;

public class InsertionSort {
static void insertionSort(int[] a, int n) {
	for(int i=1; i<n;i++) {						// 0  1  2 3   4  5  6
		int tmp=a[i];							//{22,5,11,32,120,68,70};
		int j;
		for(j=i; j>0 && a[j-1] > tmp; j--){
			a[j] = a[j-1];
		}
		a[j] = tmp;
	}//for
	
	}//insertionSort

public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	System.out.println("단순 삽입 정렬");
	int nx= 7;
	int[] x= {22,5,11,32,120,68,70};
	
	insertionSort(x, nx);
	
	System.out.println("오름차순 정렬 후 :");
	for(int i=0; i<nx;i++) 
	System.out.println("x["+i+"] : "+x[i]);
}
}//class
