package writerReader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class BuffredReaderEx1 {
public static void main(String[] args) {
	try {
		//기반스트림
		FileReader fr = new FileReader("C:\\Users\\이선로\\Desktop\\IT\\JAVA\\자바의 정석\\Chapter15\\src\\writerReader\\buffredReaderEx1.java");
		//보조 스트림
		BufferedReader br = new BufferedReader(fr);
		
		//출력할 line
		String line = "";
		//반복문을 통해 line에 한줄씩 내용을 담아 출력 (line =br.readline)<< 내용 담기
		for(int i=1;(line=br.readLine())!= null;i++) {
			//이와 같이 indexOf("찾을 문자열")을 통해 특정 문자열이 포함된 내용을 찾을 수 있다.
			if(line.indexOf(";")!=-1) System.out.println(i+":"+line);
		}
		br.close();
	} catch (IOException e) {	}
}
}
