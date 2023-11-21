package day05;

// java beans 의 조건
// 1) private 멤버 필드
// 2) public getter/setter
// 3) 기본 생성자

public class Member {

	private String name;
	private int age;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
}
