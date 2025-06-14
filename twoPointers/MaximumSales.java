package twoPointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * N동안의 매출 기록을 주고 연속된 K동안의 최대 매출액이 얼마인지 구하라.
 * 10일동안 매출기록이 주어지면 이때 K가 3이면 연속된 3일의 매출을 구하는것. 연속적인 3일 중 최대 매출액을 구하면된다.
 * sliding window 문제
 * 입력 예제 10 3
 * 12 15 11 20 25 10 20 19 13 15
 * 출력 예제 56
 */
public class MaximumSales {
	public int solution(int n, int k, int[] arr){
		int answer = 0, sum = 0;
		// 첫번째 윈도우 (첫번째 연속된 k의 값을) 구한다.
		for(int i = 0; i<k; i++) sum +=arr[i];
		answer = sum;
		// 이제 두번째 윈도우 부터 연속된 k의 최대 매출액을 구하기위한 for문
		for(int i=k; i<n; i++){
			// arr[i]값은 더하고 arr[k]값은 빼준다.
			sum+=(arr[i]-arr[k]);
			answer=Math.max(answer, sum);
		}

		return answer;
	}

	public static void main(String[] args){
		MaximumSales T = new MaximumSales();
		Scanner kb = new Scanner(System.in);
		int n = kb.nextInt();
		int k = kb.nextInt();
		int[] arr = new int[n];
		for(int i = 0; i<n; i++) {
			arr[i] = kb.nextInt();
		}
		System.out.println(T.solution(n,k,arr));
	}
}
