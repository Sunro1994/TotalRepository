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

        int cnt =0;
        int maxHeight=0;
        for(int i=0; i<list.size();i++){
          if(i==0) {
              cnt++;
              maxHeight = list.get(i);
              continue;
          }
          if(list.get(i)>maxHeight){
              cnt++;
              maxHeight = list.get(i);
          }


        }
            System.out.println(cnt);




    }

    }
