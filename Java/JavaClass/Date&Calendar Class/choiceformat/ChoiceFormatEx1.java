package choiceformat;

import java.text.ChoiceFormat;

/**
 * ChoiceFormat은 특정 범위에 속하는 값을 문자열로 변환해준다.
 * 연속적 또는 불연속적인 값들을 처리하는데 있어서 if문이나 switch문을 적절하지 못한 경우 사용한다.
 * @author Sunro
 *
 */
public class ChoiceFormatEx1 {
public static void main(String[] args) {
	//경계값 60~69 / 70~79 / 80~ 89/ 90~ 
	double[] limits = {60,70,80,90};			
	// limits, greades간의 순서와 개수를 맞춰야 한다.
	String[] grades = {"D","C","B","A"};
	int[] scores = {100,95,88,70,52,60,70};
	
	//limits는 범위의 경계값을 저장하는데 사용하고, grades는 포함된 값을 치환할 문자열을 저장하는데 사용되었다.
//	경계값은 double형으로 만드시 모두 오름차순으로 정렬되어야 한다.
	ChoiceFormat form = new ChoiceFormat(limits, grades);
	
	for(int i=0; i<scores.length;i++) {
		System.out.println(scores[i] + ": "+form.format(scores[i]));
	}
}
}
