package simpledateformat;

import java.text.ChoiceFormat;

public class ChoiceFormatEx2 {
public static void main(String[] args) {
	//패턴은 구분자로 #와 <를 제공하는데 limit#value의 형태로 사용한ㄷ.ㅏ
	//#은 경계값을 범위에 포함시키지만, <은 포함시키지 않는다.
	String pattern = "60#D|70#C|80<B|90#A";
	int[] scores = {91,90,80,88,70,52,60};
	
	ChoiceFormat form = new ChoiceFormat(pattern);
	
	for(int i=0; i<scores.length;i++) {
		System.out.println(scores[i]+":"+ form.format(scores[i]));
	}
}
}
