package bufferedIOStream;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class BuffredOutputStreamEx {
	public static void main(String[] args) {
		try {
			FileOutputStream fos = new FileOutputStream("123.txt");
			// BuffuredOutputStream의 버퍼크기를 5로 한다.
			BufferedOutputStream bos = new BufferedOutputStream(fos, 5);
			// 파일123.txt에 1 부터 9 까지 출력한다.
			for(int i='1'; i<= '9'; i++) {
				bos.write(i);
			}
			
			bos.close();// close를 해주면 알아서flush한 후 close한다.
//			따라서 기반스트림은 close할 필요없이 보조 스트림을close해주면된다.
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
}
