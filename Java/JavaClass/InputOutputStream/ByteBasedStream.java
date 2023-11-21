package ch15;

public class ByteBasedStream {
	public static void main(String[] args) {
		// 바이트 기반 스트림 - Inputstream, OutputStream
		
		/*
		 스트림은 바이트단위로 데이터를 전송하여 입출력 대상에 따라 다음과 같은 입출력스트림이 있다.
		 이들은 모두 InputStream,OutputStream의 자손들이다.
		 
		 1. 파일
		 FileInputStream, FileOutputStream
		 2.메모리
		 ByteInputStream, ByteOutputStream
		 3.프로세스
		 PipedInputStream, PipedOutputStream
		 4.오디오장치
		 AudioInputStream, AudioOutputStream
		 
		 
		 자바에서는 java.io패키지를 통해서 다양한 입출력놜녀 클래스들을 제공하며, 표준화된 방법을 제공함으로써 입출력의 대상이 달라져도 동일한 방법으로 입출력이 가능하다.
		 
		 InputStream의 read()와 OutputStream의 write(int b)는 입출력의 대상에 따라 쓰는 방법이 다르기 때문에 각 상황에 알맞게 구현하라는 의미에서 추상메서드로 정의되어 있다.
		 이를 제외한 나머지 메서드들은 추상메서드가 아니지만 read()와write(Int b)를 이용해 구현한 것들이기 때문에 이 두가지를 구현하지 않으면 이들은 아무런 의미가 없다.
		 */
		
		// 보조스트림
		
		/*
		 스트림의 기능을 보완하기 위한 보조스트림이 제공된다.
		 보조스트림은 직접 입출력은 불가능하지만, 스트림의 기능을 향상시키거나 새로운 기능을 추가할 수 있다.
		 그래서 스트림을 생성한 후 이를 이용해 보조스트림을 생성해야 한다.
		
		먼저 기반스트림을 생성
		FileInputStream fis = new FileInputStream("test.txt);
		
		기반스트림을 이용해서 보조스트림을 생성
		BufferedInputStream bis = new BufferedInputStream(fis);
		
		bis.read();	//보조 스트림인 BufferedInputStream으로부터 데이터를 읽는다.
		
		버퍼를 이용한 입출력과 일반 입출력간의 성능차이는 상당하기 때문에 대부분의 경우에 버퍼를 이용한 보조스트림을 사용한다.
		
		FilterInputStream/FilterOutputStream : 필터를 이용한 입출력 처리
		BuffredInputStream/BufferedOutputStream : 버퍼를 이용한 입출력 성능 향상
		DataInputStream/DataOutputStream		: int,float와 같은 기본형 단위로 데이터를 처리하는 기능
		SSequenceInputStream/없음					: 두 개의 스트림을 하나로 연결
		LineNumberInputStream/없음				: 읽어 온 데이터의 라인 번호를 카운트(JDK1.1부터 LineNumberReader로 대체)
		ObjectInputStream/ObjectOutputStream	: 데이터를 객체단위로 읽고 쓰는데 사용, 주로 파일을 이용하여 객체 직렬화와 관련있다.
		없음/PrintStream							: 버퍼를 이용하며, 추가적인 print관련 기능
		PushbackInputStream/없음					: 버퍼를 이용해서 읽어 온 데이터를 다시 되돌리는 기능(unread,push back to buffer)
		 */
	}
}
