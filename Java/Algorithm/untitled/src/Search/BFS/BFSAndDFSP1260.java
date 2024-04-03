package Search.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BFSAndDFSP1260 {
    static int N;
    static int V;
    static int start;
    static ArrayList<Integer> arr = new ArrayList<>();
    static ArrayList<Integer> arr2 = new ArrayList<>();


    static boolean[] visited;

    static ArrayList<Integer>[] list;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        V= Integer.parseInt(st.nextToken());
        start = Integer.parseInt(st.nextToken());

        visited = new boolean[N + 1];

        list= new ArrayList[N+1];
        for (int i = 0; i < N+1; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < V; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            list[x].add(y);
            list[y].add(x);

        }

        for (int i = 0; i < N; i++) {
            Collections.sort(list[i]);
        }


        getVisitedListByDFS(start);

        arr.forEach((x)-> System.out.print(x+" "));

        visited = new boolean[N + 1];

        getVisitedListByBFS(start);
        System.out.println();
        arr2.forEach((x)-> System.out.print(x+" "));
    }

    private static void getVisitedListByBFS(int start) {
        Queue<Integer> que = new LinkedList<>();
        visited[start] = true;
        que.offer(start);

        while (!que.isEmpty()) {
            int x = que.poll();
            arr2.add(x);
            for (int y : list[x]) {
                if (!visited[y]) {
                    visited[y]=true;
                    que.offer(y);
                }
            }
        }
    }

    private static void getVisitedListByDFS(int start) {
        visited[start] = true;
        arr.add(start);
        for (int x : list[start]) {
            if (!visited[x]) {
                getVisitedListByDFS(x);
            }
        }

    }
}
