package Simulation.silver;

import java.util.*;
import java.io.*;


/*
1. 첫 번째에는 테스트 케이스의 수
--그다음
2. 첫 줄 문서의 개수 1<= N <= 100
3. 두 번째 줄은 해당 문서의 번호 (0<=N<=M)

-- 그다음
4. 나열된 N개의 문서들은 각각 중요도를 보여준다.

 */
public class P1966 {
    static int N;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException{

    N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
StringTokenizer st = new StringTokenizer(br.readLine());
            int len = Integer.parseInt(st.nextToken());
            int target = Integer.parseInt(st.nextToken());

            solve(len,target);
        }

    }

    private static void solve(int len, int target) throws IOException {
        HashMap<Integer,Integer> map = new HashMap<>();
        StringTokenizer st =new StringTokenizer(br.readLine());
        for (int i = 1; i <= len; i++) {
            int value = Integer.parseInt(st.nextToken());
            map.put(i,value);
        }
        findTargetOrder(map, target);

    }

    private static void findTargetOrder(HashMap<Integer, Integer> map, int target) {




    }
}
