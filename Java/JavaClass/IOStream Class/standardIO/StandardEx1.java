package standardIO;

public class StandardEx1 {
public static void main(String[] args) {
	try {
		int input = 0;
		
		while((input= System.in.read())!= -1) 
			System.out.println("input : " + input + ", (char) input : "+ (char)input);
	} catch (Exception e) {
	}
}
}

/*
hello 
hello
input : 104, (char) input : h
input : 101, (char) input : e
input : 108, (char) input : l
input : 108, (char) input : l
input : 111, (char) input : o
input : 13, (char) input : 				<<특수문자라서 화면에 보이지 않는다. ( Enter를 누르면 /r + /n이 입력됨)
input : 10, (char) input : 
										<<개행문자가 출력되어 줄바꿈되었다.
^Z										<< Ctrl+Z를 눌러 입력의 끝을 알린다.(유닉스와 메킨토시는 Ctrl + d)

입력을 할때마다 
 */
