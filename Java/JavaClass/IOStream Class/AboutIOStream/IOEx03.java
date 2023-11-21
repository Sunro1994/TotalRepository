package ch15;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class IOEx03 {
public static void main(String[] args) {
	byte[] inSrc = {0,1,2,3,4,5,6,7,8,9};
	byte[] outSrc = null;
	byte[] temp = new byte[4];	//이전 예제의 배열과 크기가 다르다.
	
	ByteArrayInputStream input = new ByteArrayInputStream(inSrc);
	ByteArrayOutputStream output = new ByteArrayOutputStream();
	
	System.out.println("Input Source : "+ Arrays.toString(inSrc));
	
	try {
		while(input.available() >0 ) {
			input.read(temp);
			output.write(temp);
//			System.out.println("temp : "+ Arrays.toString(temp));
			
			outSrc = output.toByteArray();
			printArrays(temp, outSrc);
		}
	}catch(IOException e) {}
}
static void printArrays(byte[] temp, byte[] outSrc) {
	System.out.println(" temp           :" + Arrays.toString(temp));
	System.out.println("Output Source : " +  Arrays.toString(outSrc));
}
//마지막에 8967이 출력된 이유 : 이전 temp가 4567이였고 이 위에 89가 덮여써졌기 때문에 8967로 67이 한 번 더 출력된다.
//이를 해결하는 방법은 IOEx04에서 볼 수 있다.
}
