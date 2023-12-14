package org.example;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args){

        Scanner in=new Scanner(System.in);
        String target = in.nextLine();
        String answer = "";

        List<Character> arr = new ArrayList<>();
        for(int i=0; i<target.length(); i++){
            arr.add(target.charAt(i));
        }

        List<Character> collect = arr.stream().distinct().collect(Collectors.toList());

        for (Character c : collect) {
            answer += c;
        }

        System.out.println(answer);


    }
}