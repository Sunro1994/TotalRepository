package ch15;

public class FileInputOutputStream {
//실제 프로그래밍에서 가장 많이 쓰이는 스트림 중 하나
	
	/*
	 FileInputStream(String anme) : 지정된 파일이름을 가진 실제 파일과 연결된 FileInputStream을 생성한다.
	 FileInputStream(File file) : 파일의 이름이 String이 아닌 File인스턴스로 지정해주어야 하는 점을 제외하고 위와 같다.
	 FileInputStream(FileDescriptor fdObj) : 파일 디스크립터를 생성한다.
	 FileOutputStream(String name) : 지정된 파일의 이름을 가진 실제 파일과의 연결된 파일 OutputStream을 생성한다.
	 FileOutputStream(String name, boolean append) : 지정된 파일이름을 가진 실제 파일과 연결된 FileOutputStream을 생성한다. 두 번째 인자인 append를 true
	 로 하면 출력시 기존의 파일내용의 마지막에 덧 붙인다. false면 기존의 파일내용을 덮으쓴다.
	 FilOutputStream(File file) : File인스턴스로 지정한  file의 FileOutputStream을 생성
	 FileOutputStream(File file, boolean append) : file객체 스트림 생성 , append가 true이면 뒤에 추가, false이면 덮어쓰기
	 FileOutputStream(FileDiscriptor fdObj) : 파일 디스크립터로 스트림 생성
	 */
}
