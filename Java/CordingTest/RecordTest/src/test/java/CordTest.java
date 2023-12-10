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

}
