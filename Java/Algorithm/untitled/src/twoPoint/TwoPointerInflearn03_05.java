package twoPoint;

import java.util.*;
import java.lang.*;
public class TwoPointerInflearn03_05 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = i;
        }

        int lt =0;
        int rt= 1;
        int cnt=0;
        int sum = arr[lt];
        while (lt < N && rt<N) {
            if (sum + arr[rt] < N) {
                sum += arr[rt];
                rt++;
            } else if (sum + arr[rt] > N) {
                lt++;
                rt= lt+1;
                sum =arr[lt];
            }else{
                cnt++;
                lt++;
                rt++;
                sum= arr[lt];
            }
        }
        System.out.println(cnt);


    }
}
