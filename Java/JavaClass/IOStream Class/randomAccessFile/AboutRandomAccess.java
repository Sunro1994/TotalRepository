package randomAccessFile;

public class AboutRandomAccess {
public static void main(String[] args) {
	//자바에서는 입력과 출력이 각각 분리되어 별도로 작업을 하도록 설계되어 있는데, RandomAccessFile만은 하나의 클래스로 
	// 입력과 출력을 모두 할 수 있다.
	// InputStream이나 OutputStream으로 상속받지 않고, DataInput,Output 인터페이스를 모두 구현했기 때문에 읽기와 쓰기 모두 가능하다.
	// 또한 다른 입출력 클래스들은 입출력 소스에 순차적으로 읽기 / 쓰기를 하는데 반해서 RandomAccessFile클래스는 파일에 읽고 쓰는 위치에 제한이 없다.
	// 이를 간능하게 하기 위해 내부적으로 파일 포인터를 사용하는데, 입출력 시에 작업이 수행되는 곳이 바로 파일 포인터가 위치한 곳이 된다.
	// 파일 포인터는 파일의 첫 부분이 0부터 시작이며, 읽기 또는 쓰기를 수행할 때마다 작업이 수행된 다음 위치로 이동하게 된다.
	// 파일 포인터를 이동시키기 위한 작업이 순차적이라면 필요하지 않지만, 
	//임의의 위치에 있는 내용을 작업하고자 한다면, 먼저 파일 포인터를 원하는 위치로 옮겨야 한다.
	
	//현재 파일의 포인터 위치를 알고 싶을 때 : getFilePointer()를 사용
	// 파일 포인터 위치를 옮기고 싶을 때 : seek(long pos)또는 skipBytes(int n)을 사용
	
//	사실 모든 입출력에 사용되는 클래스는 입출력시 다음 작업이 이루어질 위치를 저장하고 있는 포인터를 내부적으로 갖고 있다.
//	다만 내부적으로 사용되기 때문에 사용자가 맘대로 변경할 수 없다.
	
	//생성자
/*	주어진 file에 읽기 mode값을 지정한 인스턴스를 생성한다. r- : 읽기만 수행 , rw : 읽기,쓰기 rws(파일의 메타정보),rwd(내용만) 파일에 지연없이 바로 쓰기
	rw모드로 하고 지정된 파일이 없으면 새로운 파일을 생성한다.
	RandomAccessFile(File file, String mode)   
	RandomAccessFile(File fileName, String mode) 
	
	
	//메서드
	FileChannel getChannel() : 파일의 채널을 반환
	FileDescriptor getFd() : 파일 디스크립터를 반환
	long getFilePointer()	: 파일 포인터 위치를 반환
	long length()			: 파일의 크기를 얻을 수 있다.(byte단위)
	void seek(long pos)		: 파일 포인터의 위치를 변경, 위치는 파일의 첫 부분부터 pos만큼 떨어진 곳(byte 단위)
	void setLength(long newLength) : 파일의 크기를 지정된 길이로 변경(byte 단위)
	skip Bytes(int n)		: 지정된 수만큼  byte를 건너뛴다.
*/
}
}
