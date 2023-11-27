package org.example;

import java.util.Scanner;

public class p03 {
    public static String findLongestString(String arr){
        String answer ="";

        String[] split_arr = arr.split(" ");
        for (String x : split_arr) {
            if (answer.length() < x.length()) {
                answer = x;
            } else if (answer.length() == x.length()) {
                continue;
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String arr = sc.nextLine();

        System.out.println(findLongestString(arr));
    }
}
