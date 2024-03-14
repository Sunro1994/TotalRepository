package Array;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ArrayP1337 {

    static int N;
    public static void main(String[] args) {
        /*

        N=2 [1,50] = 4
        N=3 [1, 10 , 50]

        1. 정렬
        2. 연속된 5개의 숫자이므로 1이면 5까지 x ... x+4까지의 범위가 있어야한다.
        3. a에서 4칸 뒤 인덱스의 숫자를 뺐을때 0인경우:
             0출력
        3-1. 다른 방법, [1,2,3,4,5]의 배열이라면 [1,1,1,1,0]
        [1,4,8,11,50,79,80]의 배열이라면 [3,4,3,29,1,0]
        [1,2,4,8,11,60,79,80,81]
        [1,90,111]
        [1,2,5,6,8,9,90,91,92,93,99,100,101,102,103,104]


        변수N생성
        정답변수생성
        카운트변수 생성

        int[] arr생성
        N값 초기화, arr값 초기화

        정렬


        while(정답변수가 5보다 작아야함)
        target이 N과 같으면 break
        if(타겟-시작점이 4보다 작으면){
            카운트++
            타겟++
        }
        else{
            start는 옆칸으로 이동
            target은 start옆칸으로 이동
            카운트 초기화

        }

        현재 나온 카운트중 가장 큰 것을 정답변수에 넣는다.


        추가해야할 수를 답으로 내야하기때문에
        4-현재 존재하는 카운트 출력
        start를 포함하여 카운트한다면 5-현재 존재하는 카운트 출력





         */
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        List<Integer> arr = new ArrayList<>();
        //정답 변수
        int max_cnt =0;
        //시작 인덱스
        int start = arr.get(0);
        //target인덱스
        int target =1;
        //다음 인덱스 미리 지정
        int next_idx=2;
        //if가 true일때 카운트 변수
        int cnt=0;


        for (int i = 0; i < N; i++) {
            int x = sc.nextInt();
            arr.add(i,x);
        }

        arr.sort((o1, o2) -> o1-o2);


        while(max_cnt<5){
            if(target==N) break;
            //조건성립시 해당 내용 반복
            if (arr.get(target) - start<=4) {
                cnt++;
                target++;
            }
            //조건불충족시 다음 인덱스로 변경
            else {
                //다음칸으로 이동
                start = arr.get(next_idx-1);
                //start옆칸으로 이동
                target= next_idx;
                //다음 시작할 위치 준비
                next_idx++;
                //cnt초기화
                cnt=0;
            }
                max_cnt = Math.max(max_cnt, cnt);
        }


        System.out.println((4-max_cnt));

    }
}
