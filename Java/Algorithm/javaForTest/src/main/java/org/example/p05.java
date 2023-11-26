package org.example;

import java.util.Scanner;

public class p05 {

    public static void swap(char[] arr, int c1, int c2) {
        char tmp = arr[c1];
        arr[c1] = arr[c2];
        arr[c2] = tmp;


    }
    public static void revertOnlyAlp(String target){

        char[] charArray = target.toCharArray();
        int invertIndex = charArray.length-1;
        for(int i=0; i<=invertIndex/2;i++){
            char c_target = charArray[i];
            if ((c_target >= 65 && c_target <= 90) || (c_target >= 97 && c_target <= 122)) {
                swap(charArray,i,invertIndex-i);

            }
        }

        String answer ="";
        for (char x : charArray) {
            answer +=x;
        }
        System.out.println(answer);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String target = sc.nextLine();

        revertOnlyAlp(target);



    }
}
