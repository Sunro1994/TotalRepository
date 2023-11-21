package dataIOStream;

import java.io.DataOutputStream;
import java.io.FileOutputStream;

public class DataOutputStreamEx1 {
	public static void main(String[] args) {
		FileOutputStream fos = null;
		DataOutputStream dos = null;
		
		try {
//			FileOutputStream을 기반으로 하는 DataOutputStream 생성
			fos = new FileOutputStream("sample.dat");
			dos = new DataOutputStream(fos);
			//내용 출력(해당 값들은 16진수로 저장된다.)
			dos.write(10);
			dos.writeFloat(20.0f);
			dos.writeBoolean(true);
		
			dos.close();
		}catch (Exception e) {
			e.printStackTrace();
			}
	}
}
