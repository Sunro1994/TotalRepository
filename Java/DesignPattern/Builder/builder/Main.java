package builder;

import java.util.Scanner;

public class Main {
public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);

	String answer = sc.nextLine();
	if(answer.equals("text")) {
		TextBuilder textbuilder = new TextBuilder();
		Director director = new Director(textbuilder);
		director.construct();
		String result = textbuilder.getTextResult();
		System.out.println(result);
	}else if(answer.equals("html")) {
		HTMLBuilder htmlBuilder = new HTMLBuilder();
		Director director = new Director(htmlBuilder);
		director.construct();
		String fileName = htmlBuilder.getHTMLResult();
		System.out.println("HTML파일 "+fileName+"이 작성되었습니다.");
	}else {
		usage();
		sc.close();
	}
	
}
	public static void usage() {
		System.out.println("Usage : java Main text        텍스트로 문서 작성");
		System.out.println("Usage : java Main html        html파일로 문서 작성");
	}
}
