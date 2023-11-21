package seqSearch;

import java.util.Scanner;

//순차적 검색

//종료 조건 1 : 검색할 값을 발견하지 못하고 배열이 끝난다.
//종료 조건2 : 검색할 값을 발견하고 종료
//마지막까지 검색후 발견하지 못하면 배열이 끝나고 종료한다는 검사비용이 발생
//위 조건의 비용을 반으로 줄이는 보초법이 존재

//보초법 : 마지막에 찾는 값을 넣어둔다. 만약 존재하지 않으면 보초값을 찾고 바로 종료
//								존재하면  그자리에서 바로 종료 1회판단으로 끝낼 수 있음
public class SeqSearch {
	static int seqSearchSen(int[] a, int n, int key) {
		int i=0;
		
		a[n] = key;// 보초를 추가
		
		while(true) {
			if(a[i] == key) break;
			i++;
		}
		//보초인지 아닌지 판단
		return i ==n? -1 : i;
	}
public static void main(String[] args) {
Scanner sc = new Scanner(System.in);
System.out.println("요솟수 : " );
int num = sc.nextInt();

int[] x = new int[num+1];
for(int i=0; i<num;i++) {
	System.out.print("x["+i+"] :" );
	x[i] = sc.nextInt();
}
System.out.println();
System.out.println("검색할 값 : ");
int ky = sc.nextInt();

int idx = seqSearchSen(x, num, ky);

if(idx == -1) System.out.println("값을 찾을 수 없습니다.");
else System.out.println(ky+ "의 위치는 x["+idx+"]에 있습니다.");

}
}

//while문에 의한 반복이 와나료되면 찾은 값이 원래의 데이터인지 보초인지 판단해야 한다.