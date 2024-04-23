package Hash;

import java.util.*;
import java.io.*;
import java.lang.*;

public class Inflearn4_2 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str1 = br.readLine();
        String str2 = br.readLine();

        boolean flag = true;

        for (int i = 0; i < str1.length(); i++) {
            String standard = str1.charAt(i)+"";
            if (str2.contains(standard)) {
                str2 = str2.replaceFirst(standard, "");
            } else {
                flag = false;
                break;
            }

        }
            System.out.println(flag==true? "YES" : "NO");

    }
}
