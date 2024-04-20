package Simulation;

import java.util.ArrayList;
import java.util.Scanner;

public class Simulation12933 {
    static String[] pattern = {"q", "u", "a", "c", "k"};
    static String quack;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        quack = sc.nextLine();

        ArrayList<String> quackList = new ArrayList<>();

        for (int i = 0; i < quack.length(); i++) {
            quackList.add(quack.charAt(i) + "");
        }

        int answer = maxDucks(quackList);

        System.out.println(answer);

    }

    private static int maxDucks(ArrayList<String> quackList) {

        int[] cntArr = new int[5];
        if (!quackList.get(0).equals("q")) {
            return -1;
        } else {
            quackList.remove(0);
        }
        //1. quack 순서대로 검색
        int idx =0;

        //2. 문자열에서 하나씩 검색 후 제거
        int len = quackList.size();
        for (int i =1 ; i < len; i++) {
            if (quackList.contains(pattern[i%5])) {
                quackList.remove(quackList.indexOf(pattern[i%5]));
                cntArr[i%5]++;
            }else {
                return -1;
            }
            while (quackList.contains("quack")) {
                quackList.remove("quack");
                cntArr[i%5]++;
            }

        }

        //3. 남아있는 문자열 순서 체크
        if (quackList.size() != 0) {
            int rest_len = quackList.size();

            System.out.println(quackList);
        }















        return 0;

    }
}
