package mergeSort;
//자연정렬이란?
/*
 	컴퓨터의 정렬 방식과 다르게 사람에게 더 익숙한 정렬방식으로 정렬하는 것
 	예시 ) int[] ex = {text1.txt , text10.txt, text100.txt, text21.txt, text200.txt}
 	
 	일반 정렬 = {text1 > text10 > text100 > text21> text200} (순서별 정렬)
 	자연 정렬 = {text1 > text10 text21 > text100 > text200} (크기별 정렬)
 */

import java.time.Year;
import java.util.Arrays;
import java.util.GregorianCalendar;

//자연 정렬(Gregorian Calendar)만들기
public class SortCalander {
public static void main(String[] args) {
	GregorianCalendar[] x = {
			new GregorianCalendar(2017, 11, 1),
			new GregorianCalendar(1963, 10, 18),
			new GregorianCalendar(1985, 3, 5),
	};
	
	Arrays.sort(x);
	
	for(int i=0; i<x.length;i++) {
		System.out.printf("%04d년 %02d월 %02d일\n",x[i].get(1),x[i].get(2)+1,x[i].get(3));
	}
}
}
