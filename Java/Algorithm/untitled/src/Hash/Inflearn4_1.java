package Hash;

import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Inflearn4_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(new InputStreamReader(System.in));
        int N = sc.nextInt();
        String x = sc.next();
        HashMap<Character, Integer> map = new HashMap<>();


        for (int i = 0; i < x.length(); i++) {
            char target = x.charAt(i);
            map.put(target, map.getOrDefault(target, 0) + 1);

        }

        int max = Integer.MIN_VALUE;
        char result = ' ';

        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (max < entry.getValue()) {
                max= entry.getValue();
                result = entry.getKey();
            }
        }
        System.out.println(result);

    }
}
