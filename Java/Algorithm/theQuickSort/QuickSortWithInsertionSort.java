package theQuickSort;

public class QuickSortWithInsertionSort {
    private static final int THRESHOLD = 10; // 임계치 설정

    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            if (high - low < THRESHOLD) {
                // 임계치 이하인 경우 삽입 정렬 호출
            	System.out.println("현재 간격 : " + (high-low) );
            	System.out.println("임계치 이하이므로 호출");
                insertionSort(arr, low, high);
            } else {
                int partitionIndex = partition(arr, low, high);
                quickSort(arr, low, partitionIndex - 1);
                quickSort(arr, partitionIndex + 1, high);
            }
        }
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;
                swap(arr, i, j);
            }
        }

        swap(arr, i + 1, high);
        return i + 1;
    }

    private static void insertionSort(int[] arr, int low, int high) {
        for (int i = low + 1; i <= high; i++) {
            int key = arr[i];
            int j = i - 1;

            while (j >= low && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }

            arr[j + 1] = key;
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    
}
