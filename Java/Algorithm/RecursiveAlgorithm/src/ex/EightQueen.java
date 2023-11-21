package ex;

public class EightQueen {
	static boolean[] flag_a = new boolean[8];		// 각 행에 퀸을 배치했는지 체크
	static boolean[] flag_b = new boolean[15];		// '/' 대각선 방향으로 퀸을 배치했는지 체크
	static boolean[] flag_c = new boolean[15];		// '\' 대각선 방향으로 퀸을 배치했는지 체크
	static int[] pos = new int[8];					// 각 열의 퀸의 위치
	
	//각 열의 퀸의 위치를 출력
	static void print() {
		for(int i=0;i<8;i++) {
			System.out.printf("%2d", pos[i]);
			System.out.println();
		}
	}
	
	//i열의 알맞은 위치에 퀸을 배치
	static void set(int i) {
		for(int j=0; j<8; j++) {
			if(flag_a[j] == false &&
				flag_b[i+j] == false &&
					flag_c[i-j+7] ==false) {
				pos[i] = j;
				if(i==7) print();
				else {
					flag_a[j] = flag_b[i+j] = flag_c[i-j+7]= true;
					set(i+1);
					flag_a[j] = flag_b[i+j] = flag_c[i-j+7] = false;
				}
			}
				
		}
	}//set
	
	public static void main(String[] args) {
//	행과열이 0~7인 체그판이 있다.
//	8개의 서로 공격할 수 없는 퀸을 배치하는 8퀸 문제가 있다.
//	퀸은 자신과 같은 열에 있는 퀸을 공격한다. 
//	계산할 수 있는 경우의 수는 모두 몇가지 인가?
	
/*
 	처음에는 모든 열이  ? 이고 8열을 모두 ? 를 채우면 퀸 배치가 완료된다.
 	BoundingBranch의 방법으로 풀면 8퀸을 풀었다가 아닌 8룩을 풀었다 라고 말할 수 있다.
 	대각선방향을 고려하지 않았기 때문이다. 어떤 대각선에서 보더라도 퀸을 1개만 배치하는 한정 조작을 추가해야 한다.
 
 */
		set(0);
	}
}
