package ch14_Stream;

import java.io.File;
import java.util.stream.Stream;

//	연산이 올바르게 처리되고 있는지 확인하고 싶다면, peek()을 사용하자.
//	forEach()와 달리 스트림의 요소를 소모하지 않으므로 연산 사이에 여러 번 끼워넣어도 문제가 되지 않는다.
//	fliter()나  map()의 결과를 확인할 때 유용하게 사용할 수 있다.


public class StreamPeek {
	public static void main(String[] args) {

	File[] fileArr = { new File("Ex1.java"), new File("Ex1.bak"), new File("Ex2.java"), new File("Ex1"), new File("Ex1.txt")};
	
	Stream<File> fileStream = Stream.of(fileArr);
	
	//map()으로 Stream<file>을 Stream<String>으로 변환
	Stream<String> filenameStream = fileStream.map(File::getName);
	filenameStream.forEach(System.out::println);
	System.out.println("===== 일반 출력");
	System.out.println();
	
	
	fileStream = Stream.of(fileArr);

	fileStream.map(File::getName)
		.filter(s -> s.indexOf('.') != -1)
		.map(s -> s.substring(s.indexOf('.')+1))
		.map(String::toUpperCase)
		.distinct()
		.forEach(System.out::println);
	
	
	
	
	
	
	
	}
}
