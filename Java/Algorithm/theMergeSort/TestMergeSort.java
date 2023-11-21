package theMergeSort;

/**
 * @param sorted = "정렬하여 넣을 빈 배열"
 * @param a = "정렬할 값들이 들어있는 배열"
 * 
 * sorted=null을 해주는 이유 : 명시적으로 null값을 주어 사용하지 않음을 표시하고 필요없는 메모리를 GC에 넘기기 위함
 * 
 * @author Sunro
 *
 */

public class TestMergeSort {
	
	private static int[] sorted;
	
	//병합 정렬을 시작하는 메서드
	public static void merge_sort(int[] a) {
		
		sorted = new int[a.length];
		merge_sort(a,0,a.length-1);
		sorted= null;
	}

	
	public static void merge_sort(int[] a, int left, int right) {
		//size는 1, 2, 4, 8로 두배로 증가하며 right를 넘지 않아야 한다.
		for(int size=1; size<=right; size+=size) {
			/*l : 정렬의 가장 처음 값
			/ mid : 정렬의 가운데 값
			/ high : right보다 작으면서 갖는 정리할 배열의 가장 큰 값
			/ 반복문은 l=0 , 2 ,4,8로 돈다. 즉 l은 right-size가 0이상일때만 작동
			/ l=0일때 low=0, mid = 1 high는 1이다.
			 * 
			 */
			for(int l=0; l<=right-size ; l+=(2*size)) {
				int low=l;
				int mid= l+size-1;
				int high = Math.min(l+(2*size)-1, right);
				merge(a,low,mid,high);
			}
		}
	}
	
	public static void merge(int[] a, int left, int mid ,int right) {
		int l =left;
		int r = mid+1;
		int idx= left;
		
		while(l<=mid && r<=right) {
			
			if(a[l]<=a[r]) {
				sorted[idx]=a[l];
				idx++;
				l++;
			}else {
				sorted[idx]=a[r];
				idx++;
				r++;
			}
		}
		if(l>mid) {
			while(r<=right) {
				sorted[idx]=a[r];
				idx++;
				r++;
			}
		}
		else {
			while(l<=mid) {
				sorted[idx]=a[l];
				idx++;
				l++;
			}
		}
		for(int i=left;i<=right;i++) {
			a[i]=sorted[i];
		}
	}
}