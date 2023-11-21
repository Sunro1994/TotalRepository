package seqSearch;

import java.util.Scanner;

/*
 이진 검색
 
 	오름차순, 내림차순으로 정렬된 배열에서 검색하는 알고리즘
 	정렬이 가정되어 있는 경우에서 수행한다.
 	
 */
public class BinarySearch {
	
	static int binSearch(int[] a, int n, int key) {
		int pl=0;
		int pr = n-1;
		
		do {
			int pc = (pl+pr)/2;	//중앙인덱스
			if(a[pc]== key) return pc;
			else if(a[pc] < key) pl = pc+1; //찾는 값이 중앙보다 클때 pl은 중앙점보다 앞으로
			else pr = pc-1;					//찾는 값이 중앙보다 작을때에는 최대값을 중앙보다 앞으로
		}while(pl<=pr);
		
		return -1;
	}
public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	System.out.println("요솟수 : " );
	int num = sc.nextInt();

	int[] x = new int[num+1];
	for(int i=0; i<num;i++) {
		System.out.print("x["+i+"] :" );
		x[i] = sc.nextInt();
	}
	System.out.println();
	System.out.println("검색할 값 : ");
	int ky = sc.nextInt();
	
	int result = binSearch(x, num, ky);
	if(result==-1)System.out.println("검색 실패");
	else System.out.println("검색 결과" + result);
	

}
}
