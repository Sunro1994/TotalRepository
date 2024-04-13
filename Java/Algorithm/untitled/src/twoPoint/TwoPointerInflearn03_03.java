package twoPoint;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class TwoPointerInflearn03_03 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] sales = new int[N];
        int sum = 0;
        int max =0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            sales[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < K; i++) {
            sum += sales[i];
        }
        max = sum;

        for (int i = K; i <N ; i++) {
            sum += sales[i];
            sum -= sales[i -K];
            max = Math.max(max ,sum);

        }

        System.out.println(max);
    }
}
