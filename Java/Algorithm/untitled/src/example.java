import java.util.Scanner;

public class example {
    public static void main(String[] args) {

        // 1,2,3,4,5를 순서대로 입력받아서 다른 배열에 담고 싶을때

        //1. Scanner생성,
        Scanner sc = new Scanner(System.in);
        //1-1. 수들을 담을 새로운 배열 변수 생성
        int len = 5;
        int[] arr =new int[len];

        //3. 길이만큼 반복문을 수행
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }

        //4. 잘 들어갔는지 확인
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
        }
        System.out.println();
        
        //5. 값들의 총합 구하기
            int sum =0;
            for (int j = 0; j <arr.length ; j++) {
                sum += arr[j];
            }
            
        //6. 값들의 평균 구하기
            int avg= sum/arr.length;

            System.out.println("avg = " + avg);

    }
}
