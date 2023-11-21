package ch15;

public class InputOutputStream {
public static void main(String[] args) {
	//Input/OutputStream은 모두 바이트기반의 스트림의 조상이며 다음과 같은 메서드가 선언되어 있다.

	/*
	 IntStream
	 int available() 	: 스트림으로부터 읽어 올 수 있는 데이터의 크기를 반환
	 void close 		: 스트림을 닫음으로써 사용하고 있던 자원을 반환한다.
	 void mark(int readlimit)	: 현재위치를 표시, 후에 reset()에 의해서 돌아갈 수 있다. readlimit은 되돌아갈 수 있는byte수이다.
	 boolean markSupported()	: mark()와 reset()을 지원하는지 알려 준다. mark와reset은 선택적 기능이므로 이 메서드를 통해 미리 확인한다.
	 abstract int read()		: 1byte를 읽어 온다.(0~255사이의 값). 더 이상 읽어 올 데이터가 없다면 -1을 반환
	 							  abstract메서드라서 InputStream의 자손들은 자신의 상황에 맞게 구현해야 한다.
	 int read(byte[] b, int off, int len) : 최대 len개의 byte를 읽어서, 배열 b의 지정된 위치부터 저장한다. 실제로 읽어 올 수 있는 데이터가 len개보다 적을 수 있다.
	 void reset					: 스트림에서의 위치를 마지막으로 mark()이 호출되었던 위치로 되돌린다.
	 long skip(long n)			: 스트림의 주어진 길이(n)만큼 건너뛴다.
	 
	 OutputStream
	 void close()		:입력 소스를 닫음으로써 사용하고 있던 자원을 반환한다.
	 void flush() 		: 스트림의 버퍼에 있는 모든 내용을 출력소스에 쓴다.
	 abstract void wirte(int b) : 주어진 값을 출력소스에 쓴다.
	 void write(byte[] b) : 주어진 배열 b에 저장된 모든 내용을 출력소스에 쓴다.
	 void write(byte[] b, int off, int len) : 주어진 배열 b에 저장된 내용중에서 off번째부터 len개 만큼만을 읽어서 출력소스에 쓴다.
	 
	 프로그램이 종료될 때, 사용하고 닫지 않은 스트림은 꼭 close()를 호출해서 닫아줘야 한다.
	 System in, out과 같은 표준 입출력 스트림, ByteArrayIntputStream과 같이 메모리를 사용하는 스트림은 닫아 주지 않아도 된다.
	 
	 */
	
	/*	ByteArrayIntput/OutputStream
	 바이트배열에 데이터를 입출력하는데 사용되는 스트림이다. 주로 다른 곳에 입출력하기 전에 데이터를 임시로 바이트배열에 담아서 변환 등의 작업을 하는데 사용된다.
	 스트림의 종류가 달라도 읽고 쓰는 방법은 동일하므로, Ex1예제부터 잘 보고 쓰는 방법을 읽혀두자.
	 */




}
}
