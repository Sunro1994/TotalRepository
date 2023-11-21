package ch14_Stream;

import java.util.Arrays;
import java.util.stream.Stream;

public class StreamEx4 {
public static void main(String[] args) {
	Stream<String[]> strArrstrm = Stream.of(
				new String[] {"abc","def","jkl"},
				new String[] {"ABC", "GHI", "JKL"}
			
			);
	
//	Stream<Stream<String> strStrmstrm = strArrStrm.map(Arrays::stream);
	Stream<String> strStrm = strArrstrm.flatMap(Arrays::stream);				//배열을 문자열로
	
	strStrm.map(String::toLowerCase).distinct().sorted().forEach(System.out::println);
	System.out.println();
	
	String[] lineArr = {
			"Believe or not It is true", "Do ro do not There is no try"
	};
	
	Stream<String> lineArrStream = Stream.of(lineArr);
	lineArrStream.flatMap(line-> Stream.of(line.split(" +")))
	.map(String::toLowerCase)
	.distinct()
	.sorted()
	.forEach(System.out::println);
	System.out.println();
	
	Stream<String> strStrm1 = Stream.of("AA","BB","CC","dD"	);
	Stream<String> strStrm2 = Stream.of("aa","bb","ccc","dddd");
		
	Stream<Stream<String>> strStrmstrm = Stream.of(strStrm1, strStrm2);
	Stream<String> strStream = strStrmstrm.map(s -> s.toArray(String[]::new)).flatMap(Arrays::stream);
	
	strStream.map(String::toLowerCase).distinct().forEach(System.out::println);




}
}
