package String.silver;

import java.util.*;

public class 접미사배열_11656 {
    public static void main(String[] args){

    Scanner sc = new Scanner(System.in);

    String target = sc.nextLine();

    ArrayList<String> list = new ArrayList();

            for (int j = 0; j <target.length() ; j++) {
                String str = target.substring(j);
                list.add(str);
            }

    Collections.sort(list);

        for (String s : list) {
            System.out.println(s);
        }

    }

}
