package quickSort;

public class InStack {
	
	private int max;			// 스택 용량	
	private int ptr;			// 스택 포인터
	private int[] stk;			// 스택 본체
	
	public class EmptyInStackException extends RuntimeException {
		public EmptyInStackException() {}
	}
	
	public class OverflowStackException extends RuntimeException {
		public OverflowStackException() {}
	}
	
	//생성자
	
	public InStack(int capacity) {
		ptr =0;
		max = capacity;
		try {
			stk = new int[max];		//스택 본체 배열을 생성
		
		}catch (OutOfMemoryError e) {	//생성할 수 없음
			max =0;
		}
	}
	//값을 스택의 다음 포인터에 저장
	public int push(int x) throws OverflowStackException {
		if(ptr>=max) throw new OverflowStackException();
		return stk[ptr++] =x;
		
	}
	// 스택의 최상위에 있는 데이터를 제거하고 그 값을 반환
	public int pop() throws EmptyInStackException {
		if(ptr<=0) throw new EmptyInStackException();
		return stk[--ptr];
	}
	
	//스택의 최상위에 있는 데이터를 '몰래'보는 메서드, 팝처럼 제거하지 않음
	public int peek() throws EmptyInStackException {
		if(ptr<=0) throw new EmptyInStackException();
		return stk[ptr-1];
	}
	
	//검색 메서드 indexOf
	// 해당 검색 값과 같은 데이터가 포함되어 있는지, 있다면 배열의 어디에 들어 있는지 조사하는 메서드
	// 꼭대기에서 바닥으로 선형 검색을 수행 , 실패하면 -1 반환
	public int indexOf(int x) {
		for(int i= ptr -1; i>=0 ; i--) {
			if (stk[i] ==x) return i;
		}
		return -1;
	}
	// 모든 요소 삭제 메서드 clear
	public void clear() {
		ptr=0;
	}
	
	//용량 확인 capacity
	public int capacity() {
		return max;
	}
	
	//스택의 데이터 수를 확인하는 메서드 size
	public int size() {
		return ptr;
	}
	
	//스택이 비어 있는가?
	public boolean isEmpty() {
		return ptr <=0;
	}
	
	//스택이 가득 찼는가?
	public boolean isFull() {
		return ptr>=max;
	}
	
	//스택안의 모든 데이터를 표시하는 메서드dump
	public void dump() {
		if(ptr <=0) System.out.println("스택이 비어있습니다.");
		else {
			for (int i=0; i<ptr; i++) {
				System.out.print(stk[i]+ " ");
				System.out.println();
			}
		}
	}
}
