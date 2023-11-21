package theMergeSort;

/**
 * 
 * @param N(정렬할 수의 개수)
 * @param A(정렬할 배열 선언하기)
 * @param tmp(정렬할 때 임시로 사용할 배열)
 * for(N의 개수만큼)
 * { A배열에 데이터 저장
 * }
 * 병합 정렬 함수 수행하기
 * 결괏값 출력하기
 * 
 * --병합정렬수행하기
 * @param s : 시작점
 * @param e : 종료점
 * @param e : 중간점
 * 재귀형태로 구현
 * 
 * 병합 정렬(s,m)
 * 병합 정렬(m+1,e)
 * for(s~e)
 * {tmp 배열 저장하기
 * }
 * 
 * 두 그룹을 병합하는 로직
 * index1 -> 앞쪽 그룹 시작점
 * index2 -> 뒤쪽 그룹 시작점
 * while(index1 <= 중간점 && index2 <=종료점)
 * 	양쪽 그룹의 인덱스가 가리키는 값을 비교한 후 더 작은 수를 선택해 배열에 저장하고
 * 	선택된 데이터의 index값을 오른쪽으로 한 칸 이동하기
 * 	반복문의 끝난 후 남아 있는 데이터 정리하기
 * @author Sunro
 *
 */
public class PseudoCode {
	
}
