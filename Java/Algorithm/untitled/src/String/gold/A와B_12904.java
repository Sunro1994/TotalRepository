package String.gold;

import java.util.*;
import java.io.*;

public class A와B_12904 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String x = br.readLine();
        String target = br.readLine();
        int len = target.length();
        int result=1;


        while (target.length() > x.length()) {
            int idx = target.length()-1;
            if (target.charAt(idx) == 'A') {
                target = target.substring(0,target.lastIndexOf("A"));
            } else if (target.charAt(idx) == 'B') {
                target = target.substring(0,target.lastIndexOf("B"));
                target = new StringBuilder(target).reverse().toString();
            }
        }
        System.out.println(target);
        System.out.println(target.equals(x)?"1":"0");









    }
}
