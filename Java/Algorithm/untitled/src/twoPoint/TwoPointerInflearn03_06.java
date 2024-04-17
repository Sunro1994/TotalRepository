package twoPoint;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class TwoPointerInflearn03_06 {
    public static void main(String[] args) throws IOException {
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
        int cnt=0;
        int max=0;
        int chance =M;
        while (lt < N && rt < N) {
            if (chance!=0 && arr[rt] == 0) {
                chance--;
                cnt++;
                rt++;
            } else if (chance == 0 && arr[rt] == 0) {
                lt++;
                rt= lt+1;
                max = Math.max(cnt,max);
                cnt=0;
                chance=M;
            } else if (arr[rt] == 1) {
                cnt++;
                rt++;
            }
        }
        System.out.println(max);

    }
}