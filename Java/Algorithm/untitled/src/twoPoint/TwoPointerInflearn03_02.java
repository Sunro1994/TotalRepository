package twoPoint;

import java.util.*;

//투포인터는 오름차순 정렬이 필요하다.

public class TwoPointerInflearn03_02 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        List<Integer> list = new ArrayList<>();
        int n = sc.nextInt();
        int[] arr1 = new int[n];
        for (int i = 0; i < n; i++) {
            arr1[i] = sc.nextInt();
        }

        int m = sc.nextInt();
        int[] arr2 = new int[m];
        for (int i = 0; i < n; i++) {
            arr2[i] = sc.nextInt();
        }

        Arrays.sort(arr1);
        Arrays.sort(arr2);

        int lt=0;
        int rt=0;

        while (lt<n && rt < m) {
            if (arr1[lt] == arr2[rt]) {
                list.add(arr1[lt]);
                lt++;
                rt++;
            } else if (arr1[lt] < arr2[rt]) {
                lt++;
            }else{
                rt++;
            }

        }
        for (Integer i : list) {
            System.out.print(i+" ");
        }



    }
}
