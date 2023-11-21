package randomAccessFile;

import java.io.IOException;
import java.io.RandomAccessFile;

public class RandomAccessFileEx1 {
	public static void main(String[] args) {
		try {
			RandomAccessFile raf = new RandomAccessFile("test.dat", "rw");
			System.out.println("파일 포인터 위치 : "+ raf.getFilePointer());
			raf.writeInt(100);				//int가 4byte이기 때문에 4만큼 이동
			System.out.println("파일 포인터 위치 : "+ raf.getFilePointer());
			raf.writeLong(100L);			//long이 8byte이기 때문에 8만큼 이동
			System.out.println("파일 포인터 위치 : "+ raf.getFilePointer());
		} catch (IOException e) {
			e.printStackTrace();
			}
	}
}
