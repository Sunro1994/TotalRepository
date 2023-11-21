package ex;

//필요하지 않은 분기를 없애 불필요한 조합을 줄이는 방법 = 한정 조작(bounding)
// 가지 뻗기와 한정 조작을 조합하여 문제를 풀어가는 방법을 분기 한정법(branching and bounding method)라고 한다.

public class BoundingBranch {
static boolean[] flag = new boolean[8];
static int[] pos = new int[8];

static void print() {
	for(int i=0; i<8 ; i++) {
		System.out.printf("%2d", pos[i]);
		System.out.println();
	}
}
	
	static void set(int i) {
		for(int j=0;j<8;j++) {
			if(flag[j]==false) {	//j행에는 퀸을 아직 배치하지 않았다면
				pos[i] = j;
				if(i==7) print();
				else {
					flag[j]=true;
					set(i+1);
					flag[j] =false;
				}
			}
		}
	}
	public static void main(String[] args) {
		set(0);
	}
}


