package quickSort;
//퀵 정렬은 서로 이웃하지 않고 멀리 떨어져 있는 요소를 교환해야 하므로 안정적이지 않다.
public class QuickSort {
static void swap(int[] a, int idx1, int idx2) {
	int tmp = a[idx1];
	a[idx1] =  a[idx2];
	a[idx2] = tmp;
}

static void quickSort(int[] a, int left, int right) {
	int pl = left;
	int pr = right;
	int x = a[(pl+pr)/2];
	
	System.out.printf("a[%d]~a[%d]: {",left,right);
	for( int i=left; i < right;i++) System.out.printf("%d , ",a[i]);
	System.out.printf("%d}\n",a[right]);
	
	do {
		while(a[pl]<x) pl++;
		while(a[pr]>x) pr--;
		if(pl<=pr) swap(a, pl++, pr--);
	}while(pl<=pr);
	
	// left가 pr보다 작은 경우 한번더 left부터 pr사이를 분할, 요소가 2개이상인경우 수행
	if(left<pr) quickSort(a, left, pr);
	// right가 pl보다 큰경우 한번더 pl부터 right 사이를 분할, 요소가 2개 이상인 경우 수행
	if(pl<right) quickSort(a, pl, right);
}
public static void main(String[] args) {
	int length = 9;
	int[] arr = {5,8,4,2,6,1,3,9,7};
	
	quickSort(arr, 0, length-1);
	
	for(int k: arr) System.out.println(k);
}
}
