package Search.DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class DFSP2667 {

    //배열
    static int[][] arr;
    //방문배열
    static boolean[][] visited;
    //배열 사이즈
    static int N;

    //이동좌표
    static int[] dx = {0,1,-1,0};
    static int[] dy = {1,0,0,-1};

    //정답 리스트
    static ArrayList<Integer> list = new ArrayList<>();
    //판단
    static int count =1;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());


        //필드초기화
        N = Integer.parseInt(st.nextToken());
        visited = new boolean[N][N];
        arr = new int[N][N];

        //배열초기화
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(line.substring(j, j + 1));
            }
        }

        //BFS 순환
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (arr[i][j] == 1 && !visited[i][j]) {
                    BFS(i,j);
                    list.add(count);
                    count =1;
                }
            }
        }

        Collections.sort(list);

        System.out.println(list.size());
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }

    private static void BFS(int x, int y) {
      visited[x][y]=true;

        for (int i = 0; i < 4; i++) {
            int nx = dx[i]+x;
            int ny = dy[i]+y;

            //방문하면서 1이면 count 증가시키기
            if (nx >= 0 && ny >= 0&&nx<N && ny<N) {
                if (!visited[nx][ny] && arr[nx][ny] == 1) {
                    count++;
                    //다음 좌표 이동
                    BFS(nx, ny);
                }
            }
        }
    }
}
