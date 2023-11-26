package org.example;


import java.util.ArrayList;
import java.util.Scanner;

public class p04 {



    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cnt = sc.nextInt();
        ArrayList<String> arr = new ArrayList<>();
        for (int i = 0; i < cnt; i++) {
            String target = sc.next();
            arr.add(target);
        }

        arr.forEach(i -> System.out.println(new StringBuffer(i).reverse().toString()));


    }
}
