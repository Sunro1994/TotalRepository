package ex06;

import java.util.ArrayList;

public class Test {

	private ArrayList<String> list = new ArrayList<>();

	public ArrayList<String> getList() {
		return list;
	}
	public boolean add(String data) {
		return list.add(data);
	}
	public boolean remove(String data) {
		return list.remove(data);
	}
	
	
}
