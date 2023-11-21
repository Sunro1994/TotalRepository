package ch15;

public class FilterIOStream {
//FilterI/OStream은 I/OStream의 자손이면서 모든 보조스트림의 조상이다.
//	보조 스트림은 자체적으로 입출력을 할 수 없기 때문에 기반 스트림을 필요로 한다.
	
//	protected FilterInputStream(InputStream in)
//	public FilterOutputStream(OutputStream out)
	
//	모든 메서드는 기반 스트림의 메서드를 그ㅐㄷ로 호출할 뿐이다. 자체로는 아무런 일도 하지 않는다.
//	상속을 통해 원하는 작업을 수행하도록 읽고 쓰는 메서드를 오버라이딩 해야한다.
//	생성자 FilterInputStream(InputStream in)는 접근 제어자가 protected이기 때문에 FilterInputStream의 인스턴스를 생성해서 
//	사용할수 없고 상속을 통해 오버라이딩 되어야 한다.
//	상속받은 보조스트림 클래스는 아래와 같다.
	
//	FilterInputStream의 자손 : BuffuredInputStream, DataInputStream, PushbackInputStream등
//	FilterOutputStream의 자손 : BuffuredOutputStream, DataOutputStrema, PrintStream등
}
