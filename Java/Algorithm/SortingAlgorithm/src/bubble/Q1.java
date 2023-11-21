package bubble;

import java.util.Scanner;

//버블 정렬의 각 패스에서 비교, 교환은 처음(왼쪽)부터 수행해도 됩니다.
// 각 패스에서 가장 큰 값의 요소가 끝으로 옮겨집니다. 그렇게 수정한 프로그램을 작성하세요.
public class Q1 {
	static void swap(int[] a, int idx1, int idx2) {
		int tmp = a[idx1];
		a[idx1] = a[idx2];
		a[idx2] = tmp;
	}
	static void bubbleSort(int[] a, int b) {
		for(int i=b; i>=1; i--) {
			System.out.println("i: "+ i);
			for(int j=0; j<i-1; j++) {
				System.out.println("a["+j+"]");
				if(a[j]>a[j+1]) swap(a,j, j+1);		//swap의 2~3번째 인자에 a[j]로 잘못 넣지 않도록 주의!
			}
		}
	}
public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	System.out.println("요소수 입력 : ");
	int length = sc.nextInt();
	int[] arr = new int[length];
	
	for(int i=0;i<arr.length;i++) {
		System.out.println("arr["+i+"] : ");
		arr[i] = sc.nextInt();
	}
	
	System.out.println("정렬을 수행합니다.");
	bubbleSort(arr, length);
	
	for(int i: arr) System.out.println(i);
	
}
}
