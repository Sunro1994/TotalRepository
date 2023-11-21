package ch14_Stream;

import java.util.Comparator;
import java.util.stream.Stream;

class Student implements Comparable<Student> {
	String name;				//학생 이름
	int ban;					//반
	int totalScore;				//총점
	
	Student(String name, int ban, int totalScore) {	//생성자
		this.name = name;
		this.ban = ban;
		this.totalScore = totalScore;
	}
	public String toString() {						//이름 반 총점순으로 출력
		return String.format("[%s, %d, %d]", name, ban, totalScore);
	}
	
	//getter
	String getName() { return name;}
	int getBan()		{return ban;}
	
	int getTotalScore() {return totalScore;}
	//총점 내림차순을 기본 정렬로 하는 comapreTo 추상 메서드 구현
	public int compareTo(Student s) {
		return s.totalScore-this.totalScore;
	}
}


public class StreamEx1 {
public static void main(String[] args) {
	Stream<Student> studentStream = Stream.of(
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
			);
	
//	studentStream.sorted(Comparator.comparing(Student::getBan)				// 반별 정렬
//			.thenComparing(Comparator.naturalOrder()))						// 기본 정렬
//			.forEach(System.out::println);
	
	studentStream.sorted(Comparator.comparing(Student::getName)
			.thenComparing(Student::getBan)
			.thenComparing((s1,s2) -> -1*s1.compareTo(s2))).forEach(System.out::println);
	
}
}
