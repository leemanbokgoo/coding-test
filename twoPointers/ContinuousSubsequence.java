package twoPointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * N개의 수로 이루어진 수열이 주어질 때 이 수열에서 연속 부분 수열의 합이 특정숫자 M이 되는 경우가 몇번 있는지 구해라.
 * 만약 N이 8 M이 6이고 수열이 다음과 같다면 1 2 1 3 1 1 1 2
 * 합이 6이 되는 연속부분수열은 {2,1,3} {1,3,1,1} {3,1,1,1}로 총 3가지이다.
 *
 * 입력예제 8 6
 * 1 2 1 3 1 1 2
 * 출력예제 3
 */
public class ContinuousSubsequence {
	public int solution(int n, int m, int[] arr){
		int answer = 0, sum = 0, lt = 0;
		for(int rt=0; rt<n; rt++){
			sum+=arr[rt];
			if(sum==m) answer++;
			while (sum >=m){
				// arr[lt]값을 뺴고나서 lt값을 증가
				sum-=arr[lt++];
				if(sum==m) answer++;
			}
		}
		return answer;
	}

	public static void main(String[] args){
		ContinuousSubsequence T = new ContinuousSubsequence();
		Scanner kb = new Scanner(System.in);
		int n = kb.nextInt();
		int m =kb.nextInt();
		int[] arr = new int[n];
		for(int i=0; i<n; i++){
			arr[i] = kb.nextInt();
		}
		System.out.println(T.solution(n,m,arr));
	}
}
