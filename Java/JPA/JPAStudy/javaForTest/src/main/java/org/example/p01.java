package org.example;

import java.util.Scanner;

public class p01 {

    public static int findContainer(String arr, String target){
        int cnt = 0;
        arr = arr.toLowerCase();
        target = target.toLowerCase();
        char[] c_arr = arr.toCharArray();
        for(char x : c_arr){
            if(target.equals(x+"")){
                cnt++;
            }
        }
        return cnt;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String arr = sc.nextLine();
        String target = sc.next();

        System.out.println(findContainer(arr, target));
    }
}