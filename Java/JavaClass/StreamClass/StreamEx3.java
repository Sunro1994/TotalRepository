package ch14_Stream;

import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.stream.IntStream;
import java.util.stream.Stream;


public class StreamEx3 {
public static void main(String[] args) {
	
	Student[] stuArr =  {
			new Student("이자바",3,300),
			new Student("김자바1",3,300),
			new Student("김자바1",2,700),
			new Student("김자바1",2,450),
			new Student("김자바1",2,150),
			new Student("리자바",3,400),
			new Student("비자바",1,700),
			new Student("김자바",1,200),
			new Student("나자바",2,100),
			new Student("박자바",2,150),
			new Student("키자바",3,290)
	};
	
	Stream<Student> stuStream = Stream.of(stuArr);
	
	stuStream.sorted(Comparator.comparing(Student::getBan)				// 반별 정렬
			.thenComparing(Comparator.naturalOrder()))						// 기본 정렬
			.forEach(System.out::println);
	
	stuStream = Stream.of(stuArr);
	IntStream stuScoreStream = stuStream.mapToInt(Student::getTotalScore);
	
	IntSummaryStatistics stat = stuScoreStream.summaryStatistics();
	System.out.println("count="+stat.getCount());
	System.out.println("sum="+stat.getSum());
	System.out.printf("average=%.2f%n",stat.getAverage());			//%n : 줄바꿈
	System.out.println("min="+stat.getMin());
	System.out.println("max="+stat.getMax());
	
	
	
}
}
