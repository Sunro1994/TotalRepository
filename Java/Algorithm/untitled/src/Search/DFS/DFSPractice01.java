package Search.DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

import static Search.DFS.DFSProblem1.visited;

public class DFSPractice01 {
    public static List<Integer>[] list;
    public static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int count =0;
         visited = new boolean[n+1];
        list = new ArrayList[n+1];

        for (int i = 0; i < n+1; i++) {
            list[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < m; i++) {
        st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            list[x].add(y);
            list[y].add(x);
        }

        System.out.println("======");
        for (int i = 1; i < m; i++) {
            System.out.println(visited[i]);
        }

        System.out.println("======");

        System.out.println(Arrays.stream(list).toList());

        for (int i = 1; i < n+1; i++) {
            if (!visited[i]) {
                count++;
                DFSForPractice(i);
            }
        }

        System.out.println(count);

    }

    private static void DFSForPractice(int i) {
        if(visited[i]) return;

        visited[i] = true;
        for( int x : list[i]){
            DFSForPractice(x);
        }



    }
}
