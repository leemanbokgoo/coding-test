package array;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * OX문제로 만들어진 시험에서 연속적으로 답을 맞히는 경우에는 가산점이 부여된다.
 * k번째 연속으로 맞히면 K점으로 계산한다. 틀린 문제는 0점이다.
 *
 * 입력예제 10 | 1 0 1 1 1 0 0 1 1 0
 * 출력예제 10
 */
public class ScoreCalculation {
	public int solution(int n, int[] arr){
		int answer = 0, cnt=0;
		for(int i=0; i<n; i++){
			if(arr[i] ==1 ){
				cnt++;
				answer+=cnt;
			} else {
				cnt=0;
			}
		}
		return answer;
	}

	public static void main(String[] args){
		ScoreCalculation T = new ScoreCalculation();
		Scanner kb = new Scanner(System.in);
		int n = kb.nextInt();
		int[] arr = new int[n];
		for(int i=0; i<n; i++){
			arr[i] = kb.nextInt();
		}
		System.out.println(T.solution(n,arr));
	}
}
