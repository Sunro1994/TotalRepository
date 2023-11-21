package standardIO;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class StandardIOEx3 {
	public static void main(String[] args) {
		PrintStream ps = null;
		FileOutputStream fos =null;
		
		try {
			fos = new FileOutputStream("text.txt");
			ps = new PrintStream(fos);
			System.out.println(ps);   			//System.out의 출력대상을 test.txt파일로 변경
		} catch (FileNotFoundException e) {
			System.out.println("File not found.");
		}
		System.out.println("Hello by System.out"); // >> text.file에 입력됨
		System.out.println("Hello by System.err"); // >> 그대로 출력
	}
}
