package DP.gold;

import java.util.*;
import java.io.*;

public class P9251 {
    static String x;
    static String y;
    public static void main(String[] args) throws IOException{
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));

        x = br.readLine();
        y = br.readLine();

        System.out.println(solve(x, y));

    }

    private static int solve(String x, String y) {
        int max = 0;
        for (int i = 0; i < x.length(); i++) {
            for (int j = 0; j < y.length(); j++) {
                int lt = i;
                int rt = j;
                int temp = 0;
                if(max> x.length()-lt || max > y.length()-1) break;

                    while (lt < x.length() && rt < y.length()) {
                        if (x.charAt(lt) == y.charAt(rt)) {
                            lt++;
                            rt++;
                            temp++;
                        } else if (rt < y.length() - 1) {
                            rt++;
                        } else if (lt < x.length() - 1) {
                            lt++;
                        }
                        max = Math.max(max, temp);
                    }
                temp = 0;
            }
        }
        return max;
    }
    }

