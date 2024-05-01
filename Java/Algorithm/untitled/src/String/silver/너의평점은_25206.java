package String.silver;

import java.io.*;
import java.util.*;
/*
전공평점 = (학점 * 과목평점)
A+	4.5
A0	4.0
B+	3.5
B0	3.0
C+	2.5
C0	2.0
D+	1.5
D0	1.0
F	0.0
등급이 P인 과목은 계산에서 제외한다.
20줄을 제공 과목명/학점/등급(과목평점)
 */
public class 너의평점은_25206 {
    static float sum=0;
    static HashMap<String, Float> map = new HashMap<>();
    public static void main(String[] args) throws  IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        map.put("A+", 4.5F);
        map.put("A0", 4.0F);
        map.put("B+", 3.5F);
        map.put("B0", 3.0F);
        map.put("C+", 2.5F);
        map.put("C0", 2.0F);
        map.put("D+", 1.5F);
        map.put("D0", 1.0F);
        map.put("F", 0F);



        int gradeSum =0;
        for (int i = 0; i < 20; i++) {
        StringTokenizer st = new StringTokenizer(br.readLine());
            String sub = st.nextToken();
            float score = Float.valueOf(st.nextToken());
            String grade = st.nextToken();

            if(!grade.equals("P")){
            float get = score * map.get(grade);
            sum+=get;
            gradeSum += score;

            }
        }

        System.out.println(sum/gradeSum);

    }
}
