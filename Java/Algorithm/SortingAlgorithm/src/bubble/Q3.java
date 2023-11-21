package bubble;

import java.util.Scanner;

public class Q3 {
	public static void main(String[] args) {
	Scanner sc  = new Scanner(System.in);
	
	System.out.println("버블 정렬(버전2)");
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
		int cnt =0;
		int swapcnt =0;
		for(int i=0; i<n-1; i++) {	//배열의 첫번째부터 가장 작은 수를 집어넣는다.(n-1까지 하는 이유 : 맨 마지막은 알아서 가장 큰 숫자로 정렬)
			int change =0;
			for(int j =n-1; j>i;j--) {	//검색은 배열의 뒤부터 차례대로 교체
				cnt++;
				if(a[j-1] > a[j]) {
					swapcnt++;
					swap(a, j-1, j);	//a[j]보다 a[j-1]이 더 작으면 스왑
					change +=1;
				}
			}
			if(change == 0) break; 
		}
		System.out.printf("cnt : %d%n swapcnt : %d%n",cnt, swapcnt);
	}

	
}
