package randomAccessFile;

import java.io.EOFException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class RandomAccessFileEx2 {
public static void main(String[] args) {
	//						번호, 국어, 영어, 수학
	int[] score = 		   {1,   100, 90, 45,
							2,  70, 90, 50,
							3,  80, 70, 30,
							4, 70, 80, 100,
							5, 90 , 80 , 70};
	
	try {
		RandomAccessFile raf = new RandomAccessFile("score2.dat", "rw");
		for(int i=0; i<score.length; i++) {
			raf.write(score[i]);
		}
		//이대로 수행하면 포인터가 가장 마지막에 가있기 때문에 다시 처음으로 되돌려줘야 한다.
		raf.seek(0);
		//이후 출력이 정상적으로 작동됨
		while(true) {
			System.out.println(raf.readInt());
		}
	} catch (EOFException eof) {
//		readInt()를 호출했을 때 더이상 읽을 내용이 없으면 에외 발생
	}catch (IOException e) {
		e.printStackTrace();
	}
}
}
