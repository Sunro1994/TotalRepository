
package quickSort;

import java.util.Arrays;
import java.util.stream.Stream;

//비재귀적인 퀵 정렬
public class QuickSort2 {
	static void swap(int[] a , int idx1, int idx2) {
		int tmp=0;
		a[idx1] = a[idx2];
		a[idx2] = tmp;
	}
	static void quickSort(int[] a, int left, int right) {
		InStack lstack = new InStack(right-left+1);
		InStack rstack = new InStack(right-left +1);
		
		lstack.push(left);
		rstack.push(right);
		
		
		while(lstack.isEmpty() != true) {
			int pl = left = lstack.pop();			//오른쪽 커서
			int pr = right = rstack.pop();			//왼쪽 커서
			int x = a[(left+right)/2];				//피벗
		
		
		do {
			while(a[pl]<x) pl++;
			while(a[pr] >x) pr--;
			if(pl<=pr) swap(a, pl++, pr--);
		} while (pl <= pr);
		
		if(left<pr) {
			lstack.push(left);
			rstack.push(pr);
		}
		if(pl< right) {
			lstack.push(pl);
			rstack.push(right);
			}
		}
	}
}