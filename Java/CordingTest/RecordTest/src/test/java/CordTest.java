import org.example.Main;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;


public class CordTest {

    @Test
    //중복문자제거
    public void deleteString() {
        String target = "ksekkset";
        String answer = "";

        List<Character> arr = new ArrayList<>();
        for (int i = 0; i < target.length(); i++) {
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
    public void deleteString2() {
        String target = "ksekkset";
        String answer = "";
        for (int i = 0; i < target.length(); i++) {
            if (target.indexOf(target.charAt(i)) == i) {
                answer += target.charAt(i);
            }

        }

    }


    @Test
    //회문문자열 판단
    //IgnoreCase 대소문자를 무시하고 비교한다.
    public void reverseString() {
        String target = "gooG";
        target = target;
        StringBuffer sb = new StringBuffer(target);
        String string = sb.reverse().toString();
        System.out.println(target.equalsIgnoreCase(string) ? "YES" : "NO");

        boolean a = Character.isAlphabetic(7);
        System.out.println(a);

    }

    @Test
    public void replaceAll() {
        String target = "found7, time: study; Yduts; emit, 7Dnuof\n";
        //repalce에서는 정규식을 사용할 수 없다.
        // ^A-Z : A~Z가 아닌것들
        String s = target.toUpperCase().replaceAll("[^A-Z]", "");
        StringBuilder sb = new StringBuilder(s);
        String string = sb.reverse().toString();

        System.out.println(s.equals(string) ? "YES" : "NO");
    }

    @Test
    public void ExtractOnlyNumber() {
        String target = "g0en2T0s8eSoft";
        System.out.println((int) '0'); //48
        System.out.println((int) '9'); //57

        int answer = Integer.parseInt(target.replaceAll("[^0-9]", ""));

        String answer2 = "";
        for (char x : target.toCharArray()) {
            if (Character.isDigit(x)) answer2 += x;
        }
        System.out.println(answer);
        System.out.println(Integer.parseInt(answer2));


    }

    /**
     * 한 개의 문자열 s와 문자 t가 주어지면 문자열 s의 각 문자가 문자 t와 떨어진 최소거리를 출력하는 프로그램을 작성하세요.
     */

    @Test
    public void shortestStringLnegth() {
        Scanner sc = new Scanner(System.in);


        String a = sc.nextLine();
        String b = sc.nextLine();

        int[] arr = new int[a.length()];

        int p = 1000;
        for (int i = 0; i < a.length(); i++) {
            if (b.equals(a.charAt(i) + "")) {
                p = 0;
                arr[i] = p;
            } else {
                p++;
                arr[i] = p;
            }
        }

        p = 1000;
        for (int i = a.length() - 1; i >= 0; i--) {
            if (b.equals(a.charAt(i) + "")) {
                p = 0;
                arr[i] = p;
            } else {
                p++;
                arr[i] = Math.min(arr[i], p);
            }
        }

        for (int i : arr) {
            System.out.print(i);
        }

        sc.close();


    }


    /**
     * 알파벳 대문자로 이루어진 문자열을 입력받아 같은 문자가 연속으로 반복되는 경우 반복되는
     * <p>
     * 문자 바로 오른쪽에 반복 횟수를 표기하는 방법으로 문자열을 압축하는 프로그램을 작성하시오.
     */

    @Test
    public void compactString() {
        String x = "KKTFFFFFFEEE";

        char target = x.charAt(0);
        List<String> arr = new ArrayList<>();

        int count = 1;
        for (int i = 0; i < x.length(); i++) {
            if (i == 0) arr.add(target + "");

            else if (x.charAt(i) == target) {
                count++;
                if (i == x.length() - 1) {
                    arr.add(count + "");
                }
            } else {
                if (count != 1) {
                    arr.add(count + "");

                }
                target = x.charAt(i);
                arr.add(target + "");
                count = 1;
            }

        }
        String answer = "";
        for (String i : arr) {
            answer += i;
        }
        System.out.println(answer);
    }

    /**
     * 1. “#*****#”를 일곱자리의 이진수로 바꿉니다. #은 이진수의 1로, *이진수의 0으로 변환합니다.
     * 결과는 “1000001”로 변환됩니다.
     * <p>
     * 2. 바뀐 2진수를 10진수화 합니다. “1000001”을 10진수화 하면 65가 됩니다.
     * <p>
     * 3. 아스키 번호가 65문자로 변환합니다. 즉 아스크번호 65는 대문자 'A'입니다.
     */
    @Test
    public void password() {
        int cnt = 4;
        String pw = "#****###**#####**#####**##**".replaceAll("#", "1").replace("*", "0");
        String answer = "";

        for (int i = 0; i < cnt * 7; i += 7) {
            char target = (char) Integer.parseInt(pw.substring(i, i + 7), 2);
            answer += target;
        }
        System.out.println("answer = " + answer);
    }

    /**
     * N개의 정수를 입력받아, 자신의 바로 앞 수보다 큰 수만 출력하는 프로그램을 작성하세요.
     * <p>
     * (첫 번째 수는 무조건 출력한다)
     * <p>
     * <p>
     * 입력
     * 첫 줄에 자연수 N(1<=N<=100)이 주어지고, 그 다음 줄에 N개의 정수가 입력된다.
     */
    @Test
    @DisplayName("Scanner는 작동되지 않으니 임의의 수를 넣어줘야 한다.")
    public void pringBigNumber() {
        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < len; i++) {
            list.add(sc.nextInt());
        }

        for (int i = 0; i < list.size(); i++) {
            if (i == 0) System.out.print(list.get(i) + " ");
            else if (list.get(i) > list.get(i - 1)) {
                System.out.print(list.get(i) + " ");
            }
        }
    }

    /**
     * 선생님이 N명의 학생을 일렬로 세웠습니다. 일렬로 서 있는 학생의 키가 앞에서부터 순서대로 주어질 때, 맨 앞에 서 있는
     * <p>
     * 선생님이 볼 수 있는 학생의 수를 구하는 프로그램을 작성하세요. (앞에 서 있는 사람들보다 크면 보이고, 작거나 같으면 보이지 않습니다.)
     * <p>
     * 첫 줄에 정수 N(5<=N<=100,000)이 입력된다. 그 다음줄에 N명의 학생의 키가 앞에서부터 순서대로 주어진다.
     */
    @Test
    public void canSeeStudent() {
        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < len; i++) {
            list.add(sc.nextInt());
        }

        int cnt = 0;
        int maxHeight = 0;
        for (int i = 0; i < list.size(); i++) {
            if (i == 0) {
                cnt++;
                maxHeight = list.get(i);
                continue;
            }
            if (list.get(i) > maxHeight) {
                cnt++;
                maxHeight = list.get(i);
            }


        }
        System.out.println(cnt);

    }

    /**
     * 가위 바위 보
     */

    @Test
    public void RockSeizerPepper() {
        Scanner sc = new Scanner(System.in);
        int cnt = sc.nextInt();
        int[] userA = new int[cnt];
        int[] userB = new int[cnt];

        for (int i = 0; i < cnt; i++) {
            userA[i] = sc.nextInt();
        }

        for (int i = 0; i < cnt; i++) {
            userB[i] = sc.nextInt();
        }
        for (int i = 0; i < cnt; i++) {
            if (userA[i] == userB[i]) System.out.println("D");
            else if (userA[i] == 1 && userB[i] == 3) System.out.println("A");
            else if (userA[i] == 2 && userB[i] == 1) System.out.println("A");
            else if (userA[i] == 3 && userB[i] == 2) System.out.println("A");
            else System.out.println("B");
        }


    }

    /**
     * 피보나치 수열 계산법
     */
    @Test
    public void fibonacciSequence() {
        Scanner sc = new Scanner(System.in);
        int cnt = sc.nextInt();
        int[] arr = new int[cnt + 1];
        for (int i = 1; i <= cnt; i++) {
            if (i == 1 || i == 2) arr[i] = 1;
            else {
                arr[i] = arr[i - 1] + arr[i - 2];
            }
        }
        for (int i : arr) {
            if (i == 0) continue;
            System.out.print(i + " ");
        }
    }


    /**
     * 에라토스테네스 체 - 소수 구하기
     */

    public void Decimal() {
        Scanner sc = new Scanner(System.in);
        int cnt = sc.nextInt();
        int result = 0;
        int[] arr = new int[cnt + 1];
        for (int i = 2; i <= cnt; i++) {
            if (arr[i] == 0) {
                result++;
                for (int j = i; j <= cnt; j = j + i) {
                    arr[j] = 1;
                }
            }
        }
        System.out.println(result);

    }


    @Test
    public void reverseNumIsDecimal() {
        /**
         *  1. 반복수 입력
         *  2. 반복 수 만큼 배열에 삽입
         *  3. 숫자 뒤집기
         *  4. 소수인지 판별
         */
        Scanner sc = new Scanner(System.in);
        //        1. 반복수 입력
        int cnt = sc.nextInt();
        List<Integer> arr = new ArrayList<>();
//        2. 반복 수 만큼 배열에 삽입
        for (int i = 0; i < cnt; i++) {
//        3. 숫자 뒤집기
            String s = sc.next();
            StringBuilder sb = new StringBuilder(s);
            int target = Integer.parseInt(sb.reverse().toString());
            System.out.println("target = " + target);
            if (isDecimal(target) && target > 1) arr.add(target);
        }

        arr.forEach(i -> System.out.print(i + " "));
    }

    private static Boolean isDecimal(int target) {
        int cnt = 1;
        for (int i = 2; i <= target / 2; i++) {
            System.out.println("target%" + i + "= " + target % i);
            if (target % i == 0) {
                cnt++;
            }
            if (cnt > 1) {
                return false;
            }
        }
        return true;

    }

    @Test
    public void getScore(){
        /**
         * 1. 1이면 점수 증가
         * 2. 연속으로 1이 나오면 득점 수 +1
         * 3. 틀리면 0으로 초기화
         */
        Scanner sc = new Scanner(System.in);
        int cnt = sc.nextInt();
        Boolean flag = true;
        int score = 0;
        int result =0;
        for (int i = 0; i < cnt; i++) {
            int target = sc.nextInt();
            if(target==1) {
                flag = true;
                result += ++score;
            }else {
                flag = false;
                score =0;
            }
        }
        System.out.println(result);
    }

    @Test
    public void getRank(){
        /**
         * 1. 반복수 입력
         * 2. 각 값 입력
         * 3. 이중 반복문으로 각 숫자의 순위를 매김
         */
        Scanner sc = new Scanner(System.in);
        int cnt = sc.nextInt();
        int[] arr = new int[cnt];
        for (int i = 0; i < cnt; i++) {
            arr[i] = sc.nextInt();
        }

        for (int target : arr) {
            int rank =1;
            for (int i = 0; i < cnt; i++) {
                if(target < arr[i]) rank++;
            }
            System.out.print(rank+" ");
        }


    }


    @Test
    public void findMaxNumInBoard(){
        Scanner sc = new Scanner(System.in);

        int cnt = sc.nextInt();
        int[][] arr = new int[cnt][cnt];

        for (int i = 0; i < cnt; i++) {
            for (int j = 0; j < cnt; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        int max_sum = 0;
        int comp_sum =0;
        int comp_sum2 =0;
        //가로,세로
        for (int i = 0; i < cnt; i++) {
            comp_sum=0;
            comp_sum2=0;
            for (int j = 0; j < cnt; j++) {
                comp_sum += arr[i][j];
                comp_sum2 += arr[j][i];
            }
            max_sum = Math.max(max_sum, comp_sum);
            max_sum = Math.max(max_sum, comp_sum2);
        }

        comp_sum=0;
        comp_sum2=0;
        //대각선
        for (int i = 0; i < cnt; i++) {
            comp_sum += arr[i][i];
            comp_sum2 += arr[i][cnt-i-1];
            max_sum = Math.max(max_sum, comp_sum);
            max_sum = Math.max(max_sum, comp_sum2);

        }

        System.out.println(max_sum);

    }

    @Test
    public void 봉우리(){
        int[] dx = {-1, 0 , 1 , 0};
        int[] dy = {0 , 1, 0 , -1};
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[n][n];
        for(int i=0; i<n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

            int answer =0;
            for(int i=0; i<n;i++){
                for(int j=0 ; j<n; j++){
                    boolean flag = true;
                    for(int k =0; k<4; k++){
                        int nx = i + dx[k];
                        int ny = j + dy[k];
                        if( nx>=0 && nx<n && ny >=0 && ny<n &&arr[nx][ny] >= arr[i][j]) {
                            flag = false;
                            break;
                        }
                    }
                    if(flag) answer++;
                }
            }


    }
}


