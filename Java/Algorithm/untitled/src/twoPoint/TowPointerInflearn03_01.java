package twoPoint;

import java.util.*;

public class TowPointerInflearn03_01 {
    // 첫째 줄 : 첫번째 배열 크기(최대 100)
    // 두번재 줄 오름차순 배열 원소
    // 세번째 줄 : 두번째 배열 크기(최대100)
    // 네번째 줄  오름차순 배열 원소
    public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int firstLineSize = sc.nextInt();
    int[] firstLine = new int[firstLineSize+1];
    List<Integer> result = new ArrayList<>();

        for (int i = 0; i < firstLineSize; i++) {
            int x  = sc.nextInt();
            result.add(x);

        }

    int secondLineSize = sc.nextInt();
    int[] secondLine = new int[secondLineSize+1];
    for (int i = 0; i < secondLineSize; i++) {
        int x = sc.nextInt();
        result.add(x);
    }

    result.sort(Comparator.naturalOrder());

    result.forEach(i-> System.out.print(i+" "));






    }
}
