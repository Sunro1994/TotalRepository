package shellsort;

public class AboutShellSort {
public static void main(String[] args) {
//	단순 삽입의 장점은 살리고 단점은 보완한 정렬 알고리즘으로 도널드 셸이 고안했다.
// 	먼저 정렬할 배열의 요소를 그룹으로 나눠 각 그룹별로 단순 삽입 정렬을 수행하고, 그 그룹을 합치면서 정렬을 반복하여 요소의 이동 횟수를 줄이는 방법
	
//	예시) int[] test = {8,1,4,2,7,6,3,5}
//	1. 4칸만큼 떨어진 요소들을 각 그룹별로 정리
//		{8,7}, {1,6}, {4, 3}, {2,5} << 각 배열 정렬 : {7,8},{1,6},{3,4},{2,5}
//	결과 : test = {7,1,3,2,8,6,4,5}		(정렬 4회 실행)
//	정렬을 마친 상태에 가까워졌습니다.
//	2. 2칸만큼 떨어진 요소들을 각 그룹별로 정리
//		{7,3,8,4} , { 1,2,6,5} << 각 배열 정렬 : {3,4,7,8} {1,2,5,6}
//	결과 : test = {3,1,4,2,7,5,8,6}		(정렬 2회 실행)
//	3. 모든 요소를 한번에 정렬
//	test = {12345678}					(정렬1회 실행)
	
//	이렇게 수행하는 이유 : 정렬해야 하는 횟수는 증가하지만 전체적으로는 요소 이동의 횟수가 줄어들어 효율적인 정렬이 가능하다.
}
}
