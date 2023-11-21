package printIOStream;

public class PrintStream {
public static void main(String[] args) {
	//PrintStream
//	데이터를 기반스트림에 다양한 형태로 출력할 수 있는 print,println,printf와 같은 메서드를 오버로딩하여 제공한다.
//	데이터를 문자 기바능로 출력하기 때문에 문자기반 스트림의 역할이다.
//	PrintStream과 printWriter는 거의 같은 기능을 갖고 있지만 PrintWriter가 PrintStream에 비해 다양한 언어의 문자를 처리하는데
//	적합하기 때문에 가능하면 PrintWriter를 사용하자.
//  println()이나 print()는 예외를 던지지 않고 내부에서 처리하도록 정의하였는데, 그 이유는 println()과 같은 메서드가 자주 사용되기 때문에
//	사용할때마다 try-catch문을 써야하기 때문이다.
	
//	PrintStream의 생성자와 메서드
	
//	지정된 출력스트림을 기반으로 하는 인스턴스 생성, autoFlush의 값을 true로 하면 호출되거나 개행문자가 출력될 때 자동으로 flush된다.
//	기본값은 false이다.
//	PrintStream(File file)
//	PrintStream(File file, String csn)
//	PrintStream(OutputStream out)
//	PrintStream(OutputStrema out, boolean autoFlush)
//	PrintStream(OutputStream out, boolean autoFlush, String encoding)
//	PrintStream(String fileName)
//	printStrema(String fileName, String csn)

//	메서드
//	boolean checkError()		스트림을  flush하고 에러가 발생했는지 알려준다.
	
//	void print(boolean~ char~int ~...) 인자로 주어진 값을 출력소스에 문자로 출력한다.
//	void println(boolean~ char~ int ~...) 줄바꿈문자를 출력함으로써 줄을 바꾼다.
//	PrintStream printf(String foramt, Object ... args)	정형화된 출력을 가능하게 한다.(formatted)
//	protected void setError()			작업중에 오류가 발생했음을 알린다. setError()를 호출한 후, checkError를 호출하면 true반환
	

//	printf()에서 자주 사용되는 옵션
	/*
	 %d	10진수
	 %o	8진수
	 %x	16진수
	 %c	문자
	 %s	문자열
	 %5s	5자리 문자열, 빈자리는 공백
	 %-5s	5자리 문자열, 왼쪽 정렬, 빈자리 공백
	 %5d	5자리 숫자, 빈자리는 공백
	 %-5d	5자리 숫자, 빈자리는 공백으로(왼쪽 정렬)
	 %05d	5자리 숫자, 빈자리는 0으로 채운다.
	 %e		지수형태표현
	 %f		10진수
	 %3.1f	출력된 자리수를 최소 3자리(소수점 포함), 소수점 이하 1자리 확보, 두번째 자리에서 반올림
	 %8.1f	소수점이상 최소 6자리, 소수점 이하 1자리, 출력될 자리수를 최소 8자리(소수점 포함)확보, 빈자리는 공백(오른쪽 정렬)
	 %08.1f	위와 동일, 빈자리는0 으로 채움
	 %tR 또는 %tH:%tM 				시분(24시간)
	 %tH:%tM:%tS 또는 %tT				시분초(24시간)
	 %tD			월일년
	 %tm/%td/%ty	월일년
	 %tF
	 %tY-%tm-%td	년월일
	 
	 
	 */
}
}
