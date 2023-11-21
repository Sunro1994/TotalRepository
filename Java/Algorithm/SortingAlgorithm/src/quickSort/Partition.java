package quickSort;

public class Partition {
	//교환 메서드
	static void swap(int[] a, int idx1, int idx2) {
		System.out.println(a[idx1] + "과"+ a[idx2]+"를 변경합니다.");
		int tmp = a[idx1];
		a[idx1] = a[idx2];
		a[idx2] = tmp;
	}
	
	//배열 나누는 메서드
	static void partition(int[] a, int n) {
		int pl=0;
		int pr= n-1;
		int x = a[n/2];
		
		do {
			while(a[pl]<x) pl++;
			while(a[pr] >x) pr--;
			if(pl<=pr) swap(a, pl++, pr--);
		}	while(pl <= pr);
		
		System.out.println("피벗의 값은 " + x + "입니다.");
		System.out.println("pl: "+ pl);
		System.out.println("pr : "+ pr);
		
		//pl-1과 pr+1하는 이유 pl과pr=5로 공통되기 때문
		System.out.println("피벗 이하의 그룹 ");
		for(int i=0; i<=pl-1;i++) System.out.print(a[i] + " ");
		System.out.println();
		
		if(pl>=pr+1) {
			System.out.println("피벗과 일치하는 그룹");
			for(int i= pr+1; i<=pl -1 ; i++) System.out.print(a[i] + " ");
			System.out.println();
		}
		
		System.out.println("피벗 이상의 그룹");
		for(int i=pr +1; i<n; i++)System.out.print(a[i] + " ");
		System.out.println();
	
	}
	public static void main(String[] args) {
		int length =9;
		int[] arr = {1,8,7,4,5,2,6,3,9};
		
		partition(arr, length);
	}
}
