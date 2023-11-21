package ch15;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.Arrays;

public class IOEx01 {
public static void main(String[] args) {
//	ByteArrayInput/OutputStream을 이용해서 바이트개열 inSrc의 데이터를 outSrc로 복사하는 예제
//	한번에 1byte만 읽고 쓰므로 작업효율이 많이 떨어진다.
	byte[] inSrc = {0,1,2,3,4,5,6,7,8,9};
	byte[] outSrc = null;
	
	ByteArrayInputStream input = null;
	input = new ByteArrayInputStream(inSrc);

	ByteArrayOutputStream output = null;
	output = new ByteArrayOutputStream();
	
	int data =0;
		
	while((data = input.read()) != -1) {
		output.write(data);				//void write(int b);
	}
	
	outSrc = output.toByteArray();
	
	System.out.println("Input Source : "+ Arrays.toString(inSrc));
	System.out.println("output Source : "+ Arrays.toString(outSrc));
}
}
