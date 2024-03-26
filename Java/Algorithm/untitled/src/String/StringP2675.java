package String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class StringP2675 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            //N만큼 입력 반복
            st = new StringTokenizer(br.readLine());
            int rep = Integer.parseInt(st.nextToken());
            String target = st.nextToken();
            String res ="";

            //rep만큼 각 글자를 반복해야 함
            for (int j = 1; j <= rep*target.length(); j++) {
                sb.append(target.charAt(j));
            }
            
            
        }

    }
}
