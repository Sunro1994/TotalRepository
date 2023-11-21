package ch14_Stream;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PartitionEx01 {

	public static class Student1{
		String name;
		boolean isMale;
		int hak;
		int ban;
		int score;
		
		public Student1(String name, boolean isMale, int hak, int ban, int score) {
			this.name = name;
			this.isMale = isMale;
			this.hak = hak;
			this.ban = ban;
			this.score = score;
		}
		
		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public boolean isMale() {
			return isMale;
		}

		public void setMale(boolean isMale) {
			this.isMale = isMale;
		}

		public int getHak() {
			return hak;
		}

		public void setHak(int hak) {
			this.hak = hak;
		}

		public int getBan() {
			return ban;
		}

		public void setBan(int ban) {
			this.ban = ban;
		}

		public int getScore() {
			return score;
		}

		public void setScore(int score) {
			this.score = score;
		}

		@Override
		public String toString() {
			return String.format("{%s, %s, %d학년, %d반, %3d점]", name, isMale? "남": "여", hak, ban, score	);
		}
		
//		enum Level {HIGH, MID, LOW};
	}
	public static void main(String[] args) {
		Stream<Student1> stuStream = Stream.of( 
				new Student1("나자바", false, 1, 1, 300),
				new Student1("김자바", true, 1, 1, 200),
				new Student1("이자바", false, 1, 2, 250),
				new Student1("남자바", true, 1, 3, 100),
				new Student1("가자바", true, 1, 2, 150),
				new Student1("파자바", false, 1, 3, 370),
				new Student1("강자바", true, 1, 1, 360),
				
				new Student1("나자바1", false, 2, 1, 300),
				new Student1("김자바1", true, 2, 1, 200),
				new Student1("이자바1", false, 2, 2, 250),
				new Student1("남자바1", true, 2, 3, 100),
				new Student1("가자바1", true, 2, 2, 150),
				new Student1("파자바1", false, 2, 3, 370),
				new Student1("강자바1", true, 2, 1, 360)
				
				);
		
		//PartitionBy에 의한 분류
		//1. 기본 분할
//		Map<Boolean, List<Student1>> stuBySex = stuStream.collect(Collectors.partitioningBy(Student1::isMale));
//		
//		List<Student1> maleStudent = stuBySex.get(true);
//		List<Student1> femaleStudent = stuBySex.get(false);
//		
//		System.out.println(maleStudent);
//		System.out.println(femaleStudent);
		
		//2. 기본 분할 + 통계 정보
		
//		Map<Boolean, Long> stuNumBySex = stuStream.collect(Collectors.partitioningBy(Student1::isMale, Collectors.counting()));
//		System.out.println("남학생 수 : "+ stuNumBySex.get(true));
//		System.out.println("여학생 수 : "+ stuNumBySex.get(false));
	
		//3. 남학생 1등과 여학생 1등 구하기
		
//		Map<Boolean, Optional<Student1>> topScoreBySex = stuStream.collect(Collectors.partitioningBy(Student1::isMale,
//				Collectors.maxBy(Comparator.comparing( Student1::getScore))));
//		
//		System.out.println("남학생 1등 : "+ topScoreBySex.get(true));
//		System.out.println("여학생 1등 : "+ topScoreBySex.get(false));
		
		//3-1. Optional<Student1>이 아닌 Student1타입으로 받고 싶을 때
//		Map<Boolean, Student1> topScoreBySex = stuStream.collect(Collectors.partitioningBy(Student1::isMale,
//				Collectors.collectingAndThen(
//						Collectors.maxBy(Comparator.comparingInt(Student1::getScore)),Optional::get
//						)
//				)
//		);
		
		
		//4. 성적이 150점 아래인 학생들은 불합격처리하고 싶을 때, 이중 분할을 사용한다.
		
		Map<Boolean, Map<Boolean,List<Student1>>> failedStuBySex = stuStream
				.collect(
						Collectors.partitioningBy(Student1::isMale,
								Collectors.partitioningBy(s -> s.getScore()<150)
				)
		);
		
		List<Student1> failedMaleStu = failedStuBySex.get(true).get(true);
		List<Student1> failedfeMaleStu = failedStuBySex.get(false).get(true);
		
		System.out.println(failedMaleStu);
		System.out.println(failedfeMaleStu);
	}
	
}
