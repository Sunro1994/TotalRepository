package String;

import java.util.Scanner;

public class 업앤다운 {

    static int answer =49;
    static int n;
    public static void main(String[] args) {
         int cnt=0;

        Scanner sc = new Scanner(System.in);
        n = 0;
        while (answer != n && cnt <10) {
            int n = sc.nextInt();
            cnt++;
            System.out.println("cnt = " + cnt);
            if (cnt == 2) {
                cnt++;
                continue;
            }
            if (n > answer) {
                System.out.println("다운");

            } else if (n < answer) {
                System.out.println("업");

            }else{
                System.out.println("정답");
            }


        }
    }
}
