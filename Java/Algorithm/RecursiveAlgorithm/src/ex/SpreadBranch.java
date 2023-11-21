package ex;

//	가지를 뻗으며 모든 조합을 나열하는 프로그램을 만들어 본다.
//	배열pos는 퀸의 배치를 나타낸다.
//	0열의 퀸이 0에 배치된 상태 > pos[0] =0      pos[행의 위치] = 열의위치
//	이와 같은 메서드를 통해 pos[i]에 0~7까지 대입하여 i열에 퀸을 1개만 배치하는 8가지 조합을 만드는게 재귀 메서드이다.

//	과정
//	1. set(0) 호출된 set메서드는 i에 0을 전달받는다. 0열에 1개의 퀸을 배치하는 8가지 조합을 for문에 의해 나열한다.
//	2. j값을 0~7까지 1씩 증가하며 다음과 같이 재귀 호출을 한다.
//	3. set(i+1)에 의해 앞에서 했던 작업을 다음 열인 1열에서 수행한다.
//	4. i가 7이 되면 8개의 퀸이 모두 배치된다. 
//	5. print메서드를 호출하여 퀸이 배치된 위치를 출력한다. 출력하는 값은 pos배열 요솟값
public class SpreadBranch {
	
		static int[] pos = new int[8]; //각 열의 퀸의 위치
		
		//각 열의 퀸의 위치를 출력한다.
		
		static void print() {
			for(int i=0; i<8 ; i++) {
				System.out.printf("%2d",pos[i]);
				System.out.println();
				}
			
			}//print
		
		static void set(int i) {
			for(int j=0 ; j<8 ; j++) {
				pos[i] = j;
				if(i ==7) 
					print();
				else
					set(i+1);
			}
		}//set
public static void main(String[] args) {
	set(0);
}

}
