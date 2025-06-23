package hashMapTreeSet;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * N일 동안의 매출기록을 주고 연속된 K일 동안의 매출액의 종류를 각 구간별로 구해라.
 * 만약 K=7이고 7일간이ㅡ 매출기록이 라애와 같고 이때 k=4이면
 * 20 12 20 10 23 17 10
 * 각 연속된 4일간의 매출구간의 종류는
 * 첫번쨰 구간은 [20, 12, 20, 10]는 매출액의 종류가 20, 12, 10으로 3이다.
 * 두번째 구간은 [12, 20, 10, 23]는 매출액의 종류가 4이다.
 * 세번째 구간은 [20, 10, 23, 17]는 매출액의 종류가 4이다.
 * 네번째 구간은 [10, 23, 17, 10]는 매출액의 종류가 3이다.
 * N일간의 매출기록과 연속구간의 길이가 K주어지면 첫번째 구간부터 각 구간별 매출액의 종류를 출력해라.
 *
 * 입력예제 7 4
 * 20 12 20 10 23 17 10
 * 출력예제 3 4 4 3
 */
public class TypeOfSales {
	public ArrayList<Integer> solution(int n , int k, int[] arr){
		ArrayList<Integer> answer = new ArrayList<>();
		HashMap<Integer, Integer> HM = new HashMap<>();
		// 미리 첫번째 구간을 HM에 셋팅
		for(int i=0; i<k-1; i++){
			HM.put(arr[i], HM.getOrDefault(arr[i], 0)+1);
		}
		// 투포인트 알고리즘 사용
		int lt=0;
		// k-1인 이유는 0번부터 시작하기떄문에 (0,1,2,3)
		for(int rt=k-1; rt<n; rt++ ){
			HM.put(arr[rt], HM.getOrDefault(arr[rt], 0)+1);
			// 매출액 종류 카운팅
			answer.add(HM.size());
			// rt가 쫒아간다 = 윈도우를 한칸 민다.
			HM.put(arr[lt], HM.get(arr[lt]) - 1);
			// 밀고가는 윈도우 안에 이 값이 없다면(연속된 구간안에 없다)
			// 즉 윈도우를 밀고가면 한칸 옮긴 만큼 한칸 빼야한다.
			if( HM.get(arr[lt]) == 0 ){
				HM.remove(arr[lt]);
			}
			lt++;
		}
		return answer;
	}

	public static void main(String[] args){
		TypeOfSales T = new TypeOfSales();
		Scanner kb = new Scanner(System.in);
		int n = kb.nextInt();
		int k = kb.nextInt();
		int[] arr = new int[n];
		for(int i=0; i<n; i++){
			arr[i] = kb.nextInt();
		}
		for(int x : T.solution(n, k, arr))
			System.out.println(x + " ");
	}
}
