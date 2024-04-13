package twoPoint;

import java.io.*;
import java.util.*;


public class TwoPointerInflearn03_04 {
    public static void main(String[] args) throws  IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int lt=0;
        int rt=1;
        int cnt =0;
        int sum =arr[lt];
        while (lt < N && rt<N) {
            if (sum + arr[rt] < M ) {
                sum += arr[rt];
                rt++;
            } else if (sum + arr[rt] > M ) {
                lt++;
                rt = lt+1;
                sum = arr[lt];
            }else{
                cnt++;
                lt++;
                rt = lt+1;
                sum = arr[lt];
            }
        }
        System.out.println(cnt);
    }
}
