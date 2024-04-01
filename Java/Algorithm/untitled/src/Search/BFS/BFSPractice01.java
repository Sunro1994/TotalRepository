package Search.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BFSPractice01 {
     static int N;
     static int M;
     static int[][] arr;
     static boolean[][] visited;

    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        arr = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
            String line = st.nextToken();
                for (int j = 0; j < M; j++) {
                arr[i][j]= Integer.parseInt(line.substring(j,j+1));
            }
        }

        DFSPractice(0,0);
        System.out.println(arr[N-1][M-1]);

    }

    private static void DFSPractice(int x, int y) {
        Queue<int[]> que = new LinkedList<>();
        que.offer(new int[]{x, y});

        while (!que.isEmpty()) {
            int[] target = que.poll();
            visited[x][y] = true;
            for (int i = 0; i < 4; i++) {
                x = target[x]+ dx[i];
                y = target[y] + dy[i];
                if (x >= 0 && y >= 0 && x < N && y < M) {
                    if (arr[x][y] != 0 && !visited[x][y]) {
                        visited[x][y] = true;
                        arr[x][y] = arr[target[0]][target[1]]+1;
                        que.add(new int[]{x,y});
                    }
                }
            }
        }


    }
}
