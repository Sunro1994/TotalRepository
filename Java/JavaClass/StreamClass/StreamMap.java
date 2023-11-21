package ch14_Stream;

import java.io.File;
import java.util.stream.Stream;

public class StreamMap {
public static void main(String[] args) {
	
//	 스트림의 요소에 저장된 값 중에서 원하는 필드만 뽑아내거나, 특정 형태로 변환해야 할 때 사용한다.
//	 Stream<R> map(Function<? super T, ? extends R> mapper)
	
//	예시, File의 스트림에서 파일의 이름만 뽑아서 출력하고 싶을때, 아래와 같이 사용할 수 있다.
	
	Stream<File> fileStream = Stream.of(new File("Ex1.java"), new File("Ex1"), new File("Ex1.bak"), new File("Ex2.java"), new File("Ex1.txt"));
	
	//map()으로 Stream<File>을 Stream<String>으로 변환
//	Stream<String> fileNameString = fileStream.map(File::getName);
//	fileNameString.forEach(System.out::println);                     //스토리의 모든 파일이름을 출력
	
//	map()역시 중간 연산으로, 연산결과는 String을 요소로 하는 스트림이다. map()으로 Stream<File>을 Stream<String>으로 변환했다고 볼 수 있다.
//	그리고, map()도 filter()처럼 하나의 스트림에 여러번 적용할 수 있다.
//	아래의 문장은 File의 스트림에서 파일의 확장자만을 뽑은 다음 중복을 제거해서 출력한다.
	
	fileStream.map(File::getName)
	.filter(s -> s.indexOf('.')!= -1)
	.map(s -> s.substring(s.indexOf('.')+1))
	.map(String::toUpperCase).distinct().forEach(System.out::println);













}

}