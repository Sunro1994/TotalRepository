package ch14_Stream;

import java.util.Arrays;
import java.util.stream.Stream;

public class FlatMap {
public static void main(String[] args) {
	//스트림의 요소가 배열이거나, map의 연산 결과가 배열인 경우 (= Stream<T[]>인 경우)를 Stream<T>로 다루고 싶을 때 사용한다.
	
	Stream<String[]> stream = Stream.of(
			new String[]{"ABC","BBC","DDC"},
				new String[]{"abc","bcd","efg"}
			);
	
	Stream<String> strStream = stream.flatMap(Arrays::stream);//그냥map을 사용하면 strStream안에 새로운 stream이 생기고 그 안에 값이 담아진다.
	
	String[] lineArr = {
			"Believe or not It is true",
			"Do or do not There is no try"};
	
	
	//다른 경우의 예시
	//여러 문장을 요소로 하는 스트림이 있을 때, 이 문장들을 split()으로 나눠서 요소가 단어인 스트림을 만들고 싶다면 어떻게 해야 할까
	Stream<String> lineStream = Arrays.stream(lineArr);
	//아래의 예시처럼 map()은 Stream<String>이 아니라 Stream<Stream<String>>을 돌려준다.
//	Stream<Stream<String>> strArrStream = lineStream.map(line -> Stream.of(line.split("+")));
	
	//이떄에도 flatMap을 사용하면 된다.
	Stream<String> strStream2 =  lineStream.flatMap(line->Stream.of(line.split(" +")));
	
	//중복제거, 정렬, 출력
	strStream2.map(String::toLowerCase).distinct().sorted().forEach(System.out::println);






}


}

