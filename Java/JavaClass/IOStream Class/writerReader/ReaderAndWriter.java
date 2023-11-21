package writerReader;

public class ReaderAndWriter {
public static void main(String[] args) {
//	바이트기반 스트림의 조상이 InputStream/OutputStream인 것 같이 문자기반의 스트림에서는 Reader/Writer가 같은 역할을 한다.
//	byte배열 대신 char배열을 사용한다는 것 외에는 InputStream/OutputStream의 메서드와 다르지 않다.
	
//	특징
//	문자기반스트림 이라는 것이 단순히 2byte로 스트림을 처리하는 것만을 의미하지는 않는다.
//	문자 데이터를 다루는데 필요한 또 하나의 정보는 인코딩이다.
//	여러 종류의 인코딩과 자바에서 사용하는 유니코드 간의 변환을 자동적으로 처리해준다.
//	Reader는 특정 인코딩을 읽어서 유니코드로 변환하고 Writer는 유니코드를 특정 인코딩으로 변환하여 저장한다.
	
	
	
//	Reader메서드
/*	abstract void close()		입력 스트림을 닫음으로써 사용하고 있던 자원을 반환
	void mark (int readlimit)	현재위치를 표시해놓는다. 후에 reset()에 의해서 표시한 곳으로 다시 돌아갈 수 있다.
	boolean markSupported()		mark()와 reset()을 지원하는지 알려준다.
	int read()					입력소스로부터 하나의 문자를 읽어온다. char의 범위인 0~ 65535범위의 정수를 반환하여,
								마지막 데이터에 도달하면 -1을 반환한다.
	int read(char[] c, int off, int len)	입력소스로부터 배열c의 크기만큼 읽어서 c에 저장한다. 읽어 온 데이터의 개수 또는 -1반환
	int read(charBuffer target)	입력소스로부터 읽어서 문자버퍼에 저장한다.
	boolean ready()					입력소스로부터 데이터를 읽을 준비가 되어있는지 알려준다.
	void reset()				mark가 호출되었던 위치로 되돌린다.
	long skip(long n)			현재 위치에서 n만큼 건너 뛴다.
	
	Writer메서드
	
	Writer append(char c)		지정된 문자를 출력소스에 출력한다.
	Writer append(CharSequence c)	지정된 문자열을 출력소스에 출력한다.
	Writer append(CharSequence c, int start, int end)	지정된 문자열의 일부를 출력소스에 출력
														CharBuffer, String, StringBuffer가 CharSequence를 구현
	abstract void close()		출력스트림을 닫고 자원반환
	abstract void flush()		스트림의 버퍼에 있는 모든 내용을 출력소스에 쓴다.(버퍼가 있는 스트림에만 해당)
	void write(int b)			주어진 값을 출력소스에 쓴다.
	void write(char[] c)		배열c에 저장된 모든 내용을 출력소스에 쓴다.
	abstract void write(char[]c, int off, int len) 주어진 배열 c에 저장된 내용 중 off번째부터 len만큼 출력소스에 쓴다.
	void write(String str)		주어진 문자열을 출력소스에 쓴다.
	void write(String str, int off, int len) 주어진 문자열str의 일부를 출력소스에 쓴다.
	
*/
}
}
