package dataIOStream;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

//	DataOutputStream의 write로 기록한 메서드는 DataInputStream의 read로 읽기만 하면 되지만
// 	여러 가지 종류의 자료형으로 출력한 경우, 읽을 때는 반드시 쓰인 순서대로 읽어야 한다.
public class DataInputStreamEx1 {
public static void main(String[] args) {
	try {
		//내용 입력(내용을 보낸다)- output
		FileOutputStream fos = new FileOutputStream("sample.dat");
		DataOutputStream dos = new DataOutputStream(fos);
		//내용 출력(가져와서 출력한다) - input
		FileInputStream fis = new FileInputStream("sample.dat");
		DataInputStream dis = new DataInputStream(fis);
		
		dos.writeInt(10);
		dos.writeFloat(20.0f);
		dos.writeBoolean(true);
		
		System.out.println(dis.readInt());
		System.out.println(dis.readFloat());
		System.out.println(dis.readBoolean());
		dis.close();
	}catch (Exception e) {
		e.printStackTrace();
	}
}
}
