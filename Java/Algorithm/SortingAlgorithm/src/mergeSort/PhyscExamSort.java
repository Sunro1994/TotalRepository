package mergeSort;

import java.util.Arrays;
import java.util.Comparator;

class PhyscExamSort {
static class PhyscData{
	String name;
	int height;
	double vision;
	//생성자
	public PhyscData(String name, int height, double vision) {
		this.name = name;
		this.height = height;
		this.vision = vision;
	}
	
	public String toString() {
		return name+" "+ height + " "+ vision;
	}
	//키 내림차순 용 comparator
	static final Comparator<PhyscData> HEIGHT_ORDER = new HeightOrderComparator();
	
	//내림차순
	 private static class HeightOrderComparator implements Comparator<PhyscData> {
		public int compare(PhyscData d1, PhyscData d2) {
			return(d2.height > d1.height) ? 1:
				(d2.height< d1.height) ? -1 : 0;
		}
	}
	
	
}
public static void main(String[] args) {
	PhyscData[] x = {
			new PhyscData("이나령", 162, 0.3),
			new PhyscData("전서형", 173, 0.7),
			new PhyscData("이수민", 175, 2.3),
			new PhyscData("홍준기", 171, 1.3),
			new PhyscData("유지훈", 168, 4.3),
			new PhyscData("김한결", 169, 9.3),
	};
	
	Arrays.sort(x, PhyscData.HEIGHT_ORDER);
	
	System.out.println("신체 검사 리스트");
	System.out.println("이름         키      시력 ");
	for(int i=0; i<x.length;i++) {
		System.out.printf("%-8s%3d%5.1f\n", x[i].name,x[i].height,x[i].vision);
	}
}
}
