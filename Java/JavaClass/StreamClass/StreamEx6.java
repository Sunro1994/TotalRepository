package ch14_Stream;

import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamEx6 {
public static void main(String[] args) {
	

	Student[] stuArr =  {
			new Student("이자바",3,300),
			new Student("김자바1",3,300),
			new Student("김자바2",2,700),
			new Student("김자바3",2,450),
			new Student("김자바4",2,150),
			new Student("리자바",3,400),
			new Student("비자바",1,700),
			new Student("김자바",1,200),
			new Student("나자바",2,100),
			new Student("박자바",2,150),
			new Student("키자바",3,290)
	};
	
	//학생 이름만 뽑아서 List<String>에 저장
	List<String> names = Stream.of(stuArr).map(Student::getName).collect(Collectors.toList());
	System.out.println(names);
	
	//스트림을 배열로 변환
	Student[] stuArr2 = Stream.of(stuArr).toArray(Student[]::new);
	for(Student i : stuArr2) System.out.println(i);
	
	//스트림을 Map<String,Student>로 변환. 학생 이름이 key
	Map<String, Student> stuMap = Stream.of(stuArr).collect(Collectors.toMap(s->s.getName(), p->p));
	
	for(String name: stuMap.keySet()) System.out.println(name + "-" +stuMap.get(name));
	
	long count = Stream.of(stuArr).collect(Collectors.counting());
	long totalScore = Stream.of(stuArr).collect(Collectors.summingInt(Student::getTotalScore));
//	
	System.out.println("count="+count);
	System.out.println("totalScore=" + totalScore);
//	
	totalScore= Stream.of(stuArr).collect(Collectors.reducing(0,Student::getTotalScore, Integer::sum));
	
	Optional<Student> topStudent = Stream.of(stuArr).collect(Collectors.maxBy(Comparator.comparingInt(Student::getTotalScore)));
	Student topstudent = topStudent.get();
	System.out.println("topStudent: " + topStudent);
	System.out.println(topstudent.getName());
	
	IntSummaryStatistics stat = Stream.of(stuArr).collect(Collectors.summarizingInt(Student::getTotalScore));
	System.out.println(stat);
	
	String stuName = Stream.of(stuArr).map(Student::getName).collect(Collectors.joining(",","{","}"));
	System.out.println(stuName);


}
}
