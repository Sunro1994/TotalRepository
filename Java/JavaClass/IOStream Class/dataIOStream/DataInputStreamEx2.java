package dataIOStream;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class DataInputStreamEx2 {
public static void main(String[] args) throws IOException {
	int sum =0;
	int score =0;
	
	FileOutputStream fos = new FileOutputStream("score.dat");
	DataOutputStream dos = new DataOutputStream(fos);
	
	int[] grade  = {100,90,80,50,60};
	for (int i : grade) dos.writeInt(i);
	
	
	FileInputStream fis = null;
	DataInputStream dis = null;
	
	try {
		fis = new FileInputStream("score.dat");
		dis = new DataInputStream(fis);
		//DataInputStream의 readInt()와 같이 데이터를 읽는 메서드는 더이상 읽을 데이터가 없으면 EOFException을 발생시킨다.
//		그래서 다른 입력 스트림과는 달리 무한반복문과 EOFExcection을 처리하는 catch문을 이용해서 데이터를 읽는다.
//		원래 while문으로 작업을 마친 후 스트림을 닫아 줘야하지만, while문이 무한 반복문이기 때문에 finally블럭에서 스트림을 닫도록 처리했다.
//		참조변수 dis가 null일때 close()를 호출하면 NullPointerException이발생하므로 if문을 사용해서 ids가 null인지 체크한 후에 close
//		를 호출해야 한다.
//		그리고 close()는 IOException을 발생시킬 수 있으므로 try-catch블럭으로 감사주어야 한다.
//		finally로 블럭을 닫아주는 것이 가장 확실한 방법이다.
		while(true) {
			score = dis.readInt();
			System.out.println(score);
			sum += score;
		}
	}catch (EOFException e) {
		e.printStackTrace();
	}catch (IOException ie) {
		ie.printStackTrace();
	}finally {
		try{if(dis!=null)
			dis.close();
		}catch (IOException ie) {
		ie.printStackTrace();
		}
	}
}
}
