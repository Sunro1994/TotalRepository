package calculator;

public class Calculator {
	public int pow(int n1, int n2) {
		int answer = 1;
		for(int i = 0; i < n2 ; i++) {
			answer *= n1;
		}
		return answer;
	}
}
