package twoPointers;

import java.util.Scanner;

/**
 * N 입력으로 양의 정수 N이 입력되어 2개 이상의 연속된 자연수의 합으로 정수 N을 표현하는 방법의 가짓수를 출력하도록 만들어라.
 * 만약 N이 15이면 7+8 , 4+5+6 , 1+2+3+4+5 와 같이 총 3개의 경우가 존재한다.
 *
 * 입력예제 15
 * 출력예제 3
 */
public class TwoPointers {
	public int solution(int n){
		int answer = 0, sum = 0, lt = 0;
		int m = n/2+1; // 연속된 자연수가 몇개 필요한지
		int[] arr = new int[n];
		for(int i = 0; i<m; i++) arr[i] = i+1;
		// lt와 rt를 증가시키면서 밀고 간다.
		for(int rt=0; rt<m; rt++){
			sum+=arr[rt];
			if(sum==n) answer++;
			while (sum>=n){
				sum -= arr[lt++];
				if(sum==n) answer++;
			}
		}
 		return answer;
	}

	public static void main(String[] args){
		TwoPointers T = new TwoPointers();
		Scanner kb = new Scanner(System.in);
		int n = kb.nextInt();
		System.out.println(T.solution(n));
	}
}
