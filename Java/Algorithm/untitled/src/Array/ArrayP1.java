package Array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class ArrayP1 {
    static int N;
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        String Nnum = sc.next();
        char[] charArray = Nnum.toCharArray();
        int sum =0;

        for (int i = 0; i < charArray.length; i++) {
            sum += charArray[i] - '0';
        }
        System.out.println(sum);

    }
}
