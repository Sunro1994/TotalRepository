package Sort;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class SelectionSort23900 {
    /*
    *   오름차순 정렬
    * 배열 A가 배열 B와 같으면 1 아니면 0
    *
    * */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        List<Integer> origin = new ArrayList<>();
        List<Integer> target = new ArrayList<>();



            st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            origin.add(Integer.parseInt(st.nextToken()));

        }
            st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            target.add(Integer.parseInt(st.nextToken()));
        }

        boolean flag = false;
        for (int i = 0; i < N; i++) {
            int min = i;
            for (int j =i+1; j < N; j++) {
                if (origin.get(min) > origin.get(j)) {
                    min =j;
                    swap(min, i, origin);
                }

                }
            if (origin.equals(target)) {
                flag = true;
                break;
            }
        }
        System.out.println(flag?"1":"0");

    }

    private static void swap(int max, int j, List<Integer> origin) {
        int tmp = origin.get(max);
        origin.set(max,origin.get(j));
        origin.set(j,tmp);
    }
}
