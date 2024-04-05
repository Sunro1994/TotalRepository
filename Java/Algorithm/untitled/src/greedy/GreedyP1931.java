package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.StringTokenizer;

public class GreedyP1931 {
    static int N;
    static ArrayList<int[]> list = new ArrayList<>();
    public static void main(String[] args) throws IOException {

        /*
            한 개의 회의실
            N개의 회의
            회의I 시작/끝시간 주어짐, 겹치지 않아야 함
            최대 개수 산출
            끝나는 것과 동시에 시작 가능
            시작시간과 끝나는 시간이 같을 수도 있다.
            시작하자마자 끝나는 것

            1. 빨리 끝나는 걸로 정렬
            2. 끝나는 시간이 같을 때 시작 시간으로 판단해서 정렬
            3. 첫 끝나는 시간을 기준으로 다음 시작 시간을 결정

         */

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            list.add(new int[]{start,end});
        }

        list.sort(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {

                if(o1[1] == o2[1]) return Integer.compare(o1[0],o2[0]);

               return Integer.compare(o1[1],o2[1]);
            }
        });


        int standard=list.get(0)[1];
        int cnt =1;

        for (int i = 1; i < list.size(); i++) {
            if(list.get(i)[0]>=standard) {
                standard = list.get(i)[1];
                cnt++;
            }
        }

        System.out.println(cnt);











    }
}
