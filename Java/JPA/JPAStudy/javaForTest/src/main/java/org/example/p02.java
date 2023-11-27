package org.example;

import java.util.Scanner;

public class p02 {
    public static String changeString(String arr){
        char[] c_arr = arr.toCharArray();
        String answer ="";
        for(int i=0; i<c_arr.length;i++){
            char target = c_arr[i];
            if(target>=65&& target<=90) answer += ((target+"").toLowerCase());
            if(target>=97&& target<=122) answer += ((target+"").toUpperCase());
        }



        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String arr = sc.nextLine();
        System.out.println(changeString(arr));


    }
}
