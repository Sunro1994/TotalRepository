package bufferedIOStream;


public class BuffredIOStream {
	public static void main(String[] args) {
	
//	BuffredI/OStream은 입출력 효율을 높이기 위해 버퍼를 사용하는 보조 스트림이다.
//	한 바이트씩 입력받기 보다는 버퍼를 이용해서 한 번에 여러 바이트를 입출력하는 것이 빠르기 떄문에 대부분의 입출력 작업에 사용된다.
		
//	BufferedInputStream 생성자
//	BufferedInputStream bi = new BufferedInputStream(in);	InputStream입력소스 in을 갖는 인스턴스 생성
//	BufferedInputStream bi = new BufferedInputStream(in, 6); 위와 동일하고 ,6의 크기의 버퍼를 갖는 인스턴스 생성
		
//	프로그램에서 입력소스로부터 데이터를 읽기 위해 처음으로 read메서드를 호출하면, BuffredInputStream은 입력소스로부터 버퍼 크기만큼의 데이터를 읽는다.
//	그리고 내부 버퍼에 저장한다. 외부입력소스로부터 읽는 것보다 훨씬 빠르다.
//	버퍼에 저장된 모든 데이터를 다 읽고 그 다음 데이터를 읽기위해 read메서드가 호출되면, BufferedInputStream은 입력소스로부터 다시 버퍼크기 만큼
//	의 데이터를 읽어다 저장해 놓는다.
		
//	BuffredOutputStream 생성자
//	BufferedOutputStream bo = new BufferedOutputStream(out);
//	BufferedOutputStream bo = new BufferedOutputStream(out, size);
//	bo.flush();				//버프의 모든 내용 출력
//	bo.close();				//자원반환

		
//	버퍼가 가득 찼을때만 출력소스에 출력하기 때문에, 마지막 출력부분이 출력소스에 쓰이지 못하고 BufferedOutputStream의 버퍼에 남아있는 채로
//		종료될 수 있다. 꼭 flush와 close를 사용하자.

	}
}
