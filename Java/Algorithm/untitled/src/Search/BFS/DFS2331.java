package Search.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class DFS2331 {
    static String start;
    static int zegob;
    static ArrayList list;
    static int cnt;
    static boolean flag = false;
    public static void main(String[] args)  throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        start = st.nextToken();
        zegob = Integer.parseInt(st.nextToken());
        list = new ArrayList();


            cnt = loop(start,zegob);



        System.out.println(cnt);


    }


    private static int loop(String start,int zegob) {
        int sum = 0;
        for (int i = 0; i < start.length(); i++) {
            int n1 = Integer.parseInt(start.substring(i, i + 1));
            sum += (int) Math.pow(n1, zegob);
        }
        if (list.contains(sum)) {
            flag = true;
            list.remove(sum);
        }
        cnt++;
        list.add(sum);

        return loop(String.valueOf(sum),zegob);

    }
}
