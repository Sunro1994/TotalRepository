package Stack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class StackP2164 {
    static int N;
    public static void main(String[] args) {
        /*
        * 123456
        * 1버리고 2를 뒤로
        * 34562
        * 3버리고 4를 뒤로
        * 5624
        * 5버리고 6을 뒤로
        * 246
        *
        * 2버리고 4를 뒤로
        * 64
        *
        * 6버리고 4를뒤로
        * 4
        *
        *
        * */

        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        //ArrayDeque를 사용하면 더 빠르다
        Deque<Integer> que = new LinkedList();
        Deque<Integer> que2 = new ArrayDeque<>();


        for (int i = 1; i <=N; i++) {
            que.add(i);
        }

        while(que.size()!=1){
            int toBack;
            que.pollFirst();
            toBack =  que.pollFirst();
            que.addLast(toBack);
        }

        System.out.println(que.pop());
    }
}
