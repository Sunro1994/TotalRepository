package DP;

import java.util.Scanner;

public class P9655 {
    public static void main(String[] args) {

        boolean flag = true;
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        if (N < 3) {
            N--;
        }else{
            N -= 3;
        }


        while (N >0) {
            if (flag) {
            if (N < 3) {
                N--;
            }else{
                N -= 3;
            }
            flag = !flag;

            }else{
                if (N < 3) {
                    N--;
                }else{
                    N -= 3;
                }
                flag = !flag;
            }
        }
        System.out.println(flag?"SK":"CY");
    }
}
