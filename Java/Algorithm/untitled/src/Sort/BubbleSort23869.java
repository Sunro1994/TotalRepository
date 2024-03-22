package Sort;

import java.util.Scanner;

public class BubbleSort23869 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int K = sc.nextInt();
        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        int count = bubbleSort(arr, N, K);

        if (K > count) {
            System.out.println(-1);
        } else {
            for (int i = 0; i < N; i++) {
                System.out.print(arr[i] + " ");
            }
        }
    }

    private static int bubbleSort(int[] arr, int N, int K) {
        int count = 0;

        for (int i = 0; i < N - 1; i++) {
            for (int y = 0; y < N - i - 1; y++) {
                if (arr[y] > arr[y + 1]) {
                    swap(y, y + 1, arr);
                    count++;
                }
                if (count == K) {
                    return count;
                }
            }
        }

        return count;
    }

    private static void swap(int y, int i, int[] arr) {
        int tmp = arr[y];
        arr[y] = arr[i];
        arr[i] = tmp;
    }
}
