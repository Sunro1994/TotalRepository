package dataIOStream;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class DataOutputStreamEx2 {
public static void main(String[] args) {
	
	ByteArrayOutputStream bos = null;
	DataOutputStream dos = null;
	
	byte[] result = null;
	
	try {
		bos = new ByteArrayOutputStream();
		dos = new DataOutputStream(bos);
		dos.writeInt(10);
		dos.writeFloat(20.0f);
		dos.writeBoolean(true);
		
		result = bos.toByteArray();
		
		String[] hex = new String[result.length];
		for(int i=0; i<result.length;i++) {
//			256을 더하는 이유 : byte는 원래 0~255이나 부호로 인식하는 경우 -128~127의 범위를 가진다.
//			결국 같은 데이터지만 자바의 자료형인 byte의 범위가 부호있는 1byte 정수의 범위인 -128~127범위 이기 때문에 -1로 인식한다.
//			따라서 256을 더해주어야 한다.
//			예를 들어 -1의 경우 -1+256 = 255가 된다. 반대의 경우 256을 빼면 된다.
//			이 경우도 InputStream의 read()는 사용할 필요가 없으나, read(byte[] b)와 같이 byte배열을 사용하는 경우 변환이 필요하다.
		if(result[i]<0) hex[i] = String.format("%02x", result[i]+256);
		else hex[i] = String.format("%02x", result[i]); 
		}
	System.out.println("10진수 : "+ Arrays.toString(result));
	System.out.println("16진수 : "+ Arrays.toString(hex));
	dos.close();
	
	}catch (IOException e) {
		e.printStackTrace();
	}
}
}
