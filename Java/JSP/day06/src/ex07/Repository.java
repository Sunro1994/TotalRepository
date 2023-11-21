package ex07;

import java.util.ArrayList;

public class Repository {

	private ArrayList<Member> list = new ArrayList<>();
	
	public Repository() {
		list.add(new Member("이지은", 31));
		list.add(new Member("홍진호", 42));
		list.add(new Member("김지수", 28));
		list.add(new Member("나단비", 5));
		list.add(new Member("박정석", 41));
	}

	public ArrayList<Member> getList() {
		return list;
	}

}
