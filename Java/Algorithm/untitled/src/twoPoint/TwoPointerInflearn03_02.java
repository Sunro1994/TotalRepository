package twoPoint;

import java.util.*;

public class TwoPointerInflearn03_02 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int firstLength = sc.nextInt();
        int[] arr = new int[firstLength];


        for (int i = 0; i < firstLength; i++) {
            int n = sc.nextInt();
            arr[i] = n;
        }


        int secondLength = sc.nextInt();
        int[] secondArr = new int[secondLength];
        for (int i = 0; i < secondLength; i++) {
            int n = sc.nextInt();
            secondArr[i] = n;
        }

int left =0;
int right= 0;
        while (right != secondArr.length-1) {
            if (arr[left] == secondArr[right]) {
                left++;
                System.out.print(secondArr[right]);
                right=0;
            }else{
                right++;
            }
        }
    }
}
