package ex;

import stack.InStack;

public class RemoveTailRecur {
static void recur(int n) {
	InStack s = new InStack(n);
	
	while(true) {
		if(n>0) {
			s.push(n);			//stack에 4,3,2,1 순으로 저장
			n = n-1;
			continue;
		}
		
		if(s.isEmpty() != true) {
			n = s.pop();		//1, 2, 3, 1, 4, 2, 1 
			System.out.println(n);
			n = n -2;			//1 , 2 , 3 , 1 , 4, 2 , 1 
			continue;
		}
		break;
	}
}
}
