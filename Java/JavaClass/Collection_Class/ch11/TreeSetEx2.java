package ch11;

import java.util.TreeSet;

public class TreeSetEx2 {
	public static void main(String[] args) {
		TreeSet<Integer> set = new TreeSet();
		int[] score = {80, 50, 35, 45, 65, 10, 100};
		for(int i=0; i<score.length;i++) {
			set.add(new Integer(score[i]));
		}
		
		System.out.println("50���� ���� �� : " + set.headSet(new Integer(50)));
		System.out.println("50���� ���� �� : " + set.tailSet(new Integer(50)));
	}
}
