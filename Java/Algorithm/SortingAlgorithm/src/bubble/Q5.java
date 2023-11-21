package bubble;

import java.util.Scanner;

public class Q5 {
	static void swap(int[] a, int idx1, int idx2) {
		int tmp= a[idx1];
		a[idx1] = a[idx2];
		a[idx2] = tmp;
	}
	
	static void bubbleSortOdd(int[] a,int lx) {
		for(int i=0; i<lx-1; i+=2) {
			int change = 0;
			for( int j= lx-1; j>i ; j--) {
				if(a[j-1]>a[j]) swap(a, j-1, j);
				change +=1;
			}
			if(change ==0) break;
		}
	}
	static void bubbleSortEven(int[] a,int lx) {
		for( int j= lx-1; j>1; j--) {
			int change = 0;
			for(int i=1; i<lx-1; i+=2) {
				if(a[i]>a[i+1]) swap(a, i, i+1);
				change +=1;
			}
			if(change ==0) break;
		}
	}
	
	
	public static void main(String[] args) {
		/*
		이 배열의 두 번째 요소부터는 정렬은 되어 있지만 버전3의 버블 정렬 알고리즘을 사용해도 빠른 시간 안에 해결 할 수없습니다.
		왜냐하면 가장 큰수가 가장 앞에 있기 때문입니다.(1회의 패스를 거쳐도 한 칸씩만 뒤로 옮겨짐)
		그래서 홀 수 번째 패스는 가장 작은 요소를 맨 앞으로 옮기고 짝수 번째 패스는 가장 큰 요소를 맨 뒤로 옮기는 방식을 사용하면 더 적은 횟
		수로 실행할 수 있습니다. 
		해당 알고리즘은 양방향 버블 정렬, 칵테일 정렬, 세이커 정렬이라는 이름으로 알려져 있다.
		양방향 버블 정렬을 수행하는 프로그램을 작성하세요*/
		
		//짝수일때 교환과
		//홀수일때 교환을 따로 사용한다. 
		
		Scanner stdIn = new Scanner(System.in);

		System.out.println("단순교환정렬(버블 정렬)");
		System.out.print("요솟수 : ");
		int nx = stdIn.nextInt();
		int[] x = new int[nx];

		for (int i = 0; i < nx; i++) {
			System.out.print("x[" + i + "] : ");
			x[i] = stdIn.nextInt();
		}
		for(int i=0; i<nx; i++) {
		bubbleSortEven(x, nx);
		bubbleSortOdd(x, nx);
		}
		System.out.println("오름차순으로 정렬하였습니다.");
		for (int i = 0; i < nx; i++)
			System.out.println("x[" + i + "]＝" + x[i]);
	}
			
	}

