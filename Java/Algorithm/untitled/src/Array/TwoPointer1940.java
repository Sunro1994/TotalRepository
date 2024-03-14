package Array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class TwoPointer1940  {
    public static void main(String[] args)  throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        int[] A = new int[N];

        //많은 수를 입력받을때 스캐너보다 빠른 입출력기능을 갖고 있다.
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(A);
        int count =0;
        int i =0;  //min
        int j=N-1; //max

        while (i < j) {
            if(A[i]+A[j]<M) i++;
            else if (A[i] + A[j] > M) {
                j--;
            } else {
                count++;
                i++;
                j--;

            }
        }
        System.out.println(count);

    }
}
