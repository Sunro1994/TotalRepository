import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;


public class CordTest {

    @Test
    //중복문자제거
    public void deleteString(){
        String target = "ksekkset";
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

    @Test
    //중복문자제거2
    public void deleteString2(){
        String target = "ksekkset";
        String answer = "";
        for (int i=0; i<target.length();i++){
            if (target.indexOf(target.charAt(i))==i) {
                answer += target.charAt(i);
            }

        }

    }


    @Test
    //회문문자열 판단
    //IgnoreCase 대소문자를 무시하고 비교한다.
    public void reverseString(){
        String target = "gooG";
        target = target;
        StringBuffer sb = new StringBuffer(target);
        String string = sb.reverse().toString();
        System.out.println(target.equalsIgnoreCase(string) ? "YES" : "NO");

        boolean a = Character.isAlphabetic(7);
        System.out.println(a);

    }

    @Test
    public void replaceAll(){
        String target = "found7, time: study; Yduts; emit, 7Dnuof\n";
        //repalce에서는 정규식을 사용할 수 없다.
        // ^A-Z : A~Z가 아닌것들
        String s = target.toUpperCase().replaceAll("[^A-Z]", "");
        StringBuilder sb = new StringBuilder(s);
        String string = sb.reverse().toString();

        System.out.println(s.equals(string) ? "YES" : "NO");
    }

    @Test
    public void ExtractOnlyNumber(){
        String target = "g0en2T0s8eSoft";
        System.out.println((int) '0'); //48
        System.out.println((int) '9'); //57

        int answer = Integer.parseInt(target.replaceAll("[^0-9]", ""));

        String answer2 = "";
        for (char x :target.toCharArray()) {
            if(Character.isDigit(x)) answer2 += x;
        }
        System.out.println(answer);
        System.out.println(Integer.parseInt(answer2));


    }


}
