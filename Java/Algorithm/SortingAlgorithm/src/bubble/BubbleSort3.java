package bubble;

import java.util.Scanner;

public class BubbleSort3 {
	public static void main(String[] args) {
	Scanner sc  = new Scanner(System.in);
	
	System.out.println("버블 정렬(버전3)");
	System.out.println("요솟수 : ");
	int nx = sc.nextInt();
	int[] x = new int[nx];
	// x배열에 담을 요소들을 입력
	for(int i=0; i< nx; i++) {
		System.out.println("x["+i+"] :");
		x[i] = sc.nextInt();
	}
	
	bubbleSort(x,nx);
	
	System.out.println("오름차순으로 정렬했습니다.");
	for(int i=0 ; i<nx; i++) {
		System.out.println("x["+i+"] :" + x[i]);
	}
	
	}
	static void swap(int[]a , int idx1,int idx2) {
		int tmp = a[idx1];
		a[idx1] = a[idx2];
		a[idx2] = tmp;
	}
	
	static void bubbleSort(int[] a, int n) {
			int k=0;				//k : 시작점
			while(k< n-1) {
				int last = n -1;		//마지막으로 교환이이루어진 위치
				
			for(int j =n-1; j>k ;j--)	{ //배열의 가장 뒤부터 검색 후  차례대로 교체
				if(a[j-1] > a[j]) {
					swap(a, j-1, j);	//a[j-1]보다 a[j]가 더 작으면 스왑
					last = j;
					}//if
				k  = last;
				}//for j
			}//while
			
	}//bubbleSort

	
}
