package array;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 순위 구하기
 * 각 학생의 등 수를 입력한 순서대로 출력한다. 같은 점수가 입력될 경우 높은 등수로 동일 처리한다.
 * 1등이 4명이면 다음으로 높은 점수의 학생은 4등이 된다.
 *
 * 입력예제 5 | 87 89 92 100 76
 * 출력예제 4 3 2 1 5
 */
public class GetRanking {
	public int[] solution(int n, int[] arr){
		int[] answer = new int[n];
		for(int i=0; i<n; i++){
			int cnt = 1;
			for(int j=0; j<n; j++){
				if(arr[j]<i) cnt++;
			}
			answer[i] = cnt;
		}
		return answer;
	}

	public static void main(String[] args){
		GetRanking T = new GetRanking();
		Scanner kb = new Scanner(System.in);
		int n = kb.nextInt();
		int[] arr = new int[n];
		for(int i=0; i<n; i++){
			arr[i] = kb.nextInt();
		}
		for(int x : T.solution(n, arr)){
			System.out.println(x+" ");
		}
	}
}
