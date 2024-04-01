package Sort;

import java.util.Scanner;

public class QuickSOrtP24090 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        int[] arr = new int[N];

        for (int i = 0; i <N ; i++) {
            arr[i] = sc.nextInt();
        }

        sort(arr, 0, arr.length - 1);
    }

    private static void sort(int[] arr, int lo, int hi) {
        /*
         *  lo가 hi보다 크거나 같다면 정렬 할 원소가
         *  1개 이하이므로 정렬하지 않고 return한다.
         */
        if(lo >= hi) {
            return;
        }


        int pivot = partition(arr, lo, hi);

        sort(arr, lo, pivot);
        sort(arr, pivot + 1, hi);
    }

    private static int partition(int[] a, int left, int right) {

        // lo와 hi는 각각 배열의 끝에서 1 벗어난 위치부터 시작한다.
        int lo = left - 1;
        int hi = right + 1;
        int pivot = a[(left + right) / 2];		// 부분리스트의 중간 요소를 피벗으로 설정


        while(true) {

            /*
             * 1 증가시키고 난 뒤의 lo 위치의 요소가 pivot보다 큰 요소를
             * 찾을 때까지 반복한다.
             */
            do {
                lo++;
            } while(a[lo] < pivot);


            /*
             * 1 감소시키고 난 뒤의 hi 위치가 lo보다 크거나 같은 위치이면서
             * hi위치의 요소가 pivot보다 작은 요소를 찾을 떄 까지 반복한다.
             */
            do {
                hi--;
            } while(a[hi] > pivot && lo <= hi);


            /*
             * 만약 hi가 lo보다 크지 않다면(엇갈린다면) swap하지 않고 hi를 리턴한다.
             */
            if(lo >= hi) {
                return hi;
            }


            // 교환 될 두 요소를 찾았으면 두 요소를 바꾼다.
            swap(a, lo, hi);
        }

    }
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
