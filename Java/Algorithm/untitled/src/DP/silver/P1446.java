package DP.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class P1446 {
    static int N,D;
    static ArrayList<int[]> list = new ArrayList<int[]>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            st=new StringTokenizer(br.readLine());
            int start=Integer.parseInt(st.nextToken());
            int end=Integer.parseInt(st.nextToken());
            int shorWayDist=Integer.parseInt(st.nextToken());
            if(end>D) continue;
            if(end-start<=shorWayDist) continue;
            int[] shortCut = {start,end,shorWayDist};
            list.add(shortCut);
        }

        Collections.sort(list, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] == o2[0]) return o1[1]-o2[1];
                return o1[0] - o2[0];
            }
        });
//지름길로 가는 길과, 일반 길로 가는 길 중 어느 것이 더 효율적인지 계산하여 거리를 계산해야 한다.






    }




}
