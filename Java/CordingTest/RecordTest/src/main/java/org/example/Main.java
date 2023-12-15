package org.example;

import java.util.*;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();
        List<Integer> list = new ArrayList<>();

        for(int i=0; i<len;i++){
            list.add(sc.nextInt());
        }

        for(int i=0; i<list.size();i++){
           if(i==0) System.out.print(list.get(i)+" ");
           else if(list.get(i)>list.get(i-1)){
                System.out.print(list.get(i)+" ");
            }
        }




    }

    }
