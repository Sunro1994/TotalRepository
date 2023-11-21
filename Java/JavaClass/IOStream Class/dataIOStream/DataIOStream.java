package dataIOStream;

import java.io.DataInputStream;

public class DataIOStream {
public static void main(String[] args) {
//	FilterI/OStream의 자손이며 DataInput,DataOutput Interface를 각각 구현하였기 때문에, 데이터를 읽고 쓰는데 
//	byte단위가 아닌 8가지 기본 자료형 단위로 읽고 쓸 수 있다는 장점이 있다.
//	DataOutputStream이 출력하는 방식은 각 기본 자료형 값을 16진수로 표현하여 저장한다.
//	예를 들어 int값을 출력한다면, 4byte의 16진수로 출력된다.
//	각 자료형의 크기가 달라, 출력한 데이터를 다시 읽어 올 때는 출력했을 떄의 순서를 염두해 두어야 한다.
	
//	=======DataInputStream
	//생성자
//	DataInputStream di = new DataInputStream(in)
	
	//메서드
//	readBoolean.. byte.. Int, ... UnsignedByte(), UnsignedShort() // 각 타입에 맞게 읽어온다. 더 읽을 값이 없으면 EOF예외
//	readFully(byte[] b), readFully(byte[] b, int off, int len) 
//	입력 스트림에서 지정된 배열의 크기만큼 또는 지정된 위치에서 len만큼 데이터를 읽어온다. 끝에 도달하면 EOF예외가 발생하고, I/O에러 발생시 IO예외 발생
	
//	readUTF() 		//UTF-8타입의 쓰여진 문자를 읽는다.
//	readUTF(DataInput in) 	//입력스트림(in)에서 UTF-8형식의 유니코드를 읽어온다.
//	skipBytes(itn n) 		// 현재 읽고 있는 위치에서 저장된 숫자만큼을 건너뛴다.
	
	
//	======DataOutputStream
	//생성자와 자료형 메서드는 동일
//	writeUTF(String s) UTF형식으로 문자를 출력한다.
//	writeChars(String s) 주어진 문자열을 출력한다. writeChar(int c)메서드를 여러번 호출한 결과와 같다.
//	size()				지금까지 DataOutputStream에 쓰여진 byte의 수를 알려준다.
	}
}
