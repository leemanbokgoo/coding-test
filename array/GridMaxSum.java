package array;

import java.util.Scanner;

/**
 * N*N 격자판이 주어지만 각 행의 합, 각 열의 합, 두 대각선의 합 중 가장 큰 합을 출력한다.
 *
 * 입력예제 5
 * 10 13 10 12 15
 * 12 39 30 23 11
 * 11 25 50 53 15
 * 19 27 29 37 27
 * 19 13 30 13 19
 * 출력예제 155
 */
public class GridMaxSum {
	public int solution(int n, int[][] arr){
		int answer = Integer.MIN_VALUE;
		// sum1은 행의 합 sum2은 열의 합
		int sum1, sum2;

		// 각각의 행과 열을 구하기위해 이중 for문 조회
		for(int i=0; i<n; i++){
			sum1 = sum2 = 0;
			for(int j=0; j<n; j++){
				// i가 n일때 sum1에는 n의 행의 값 sum2에는 n의 열의 값을 더한다
				// a[][]일때 첫번째[]은 행이고 두번째[]은 열번호다.
				//밑의 코드는 행은 고정되고 열이 도는 것
				sum1+=arr[i][j];
				// 밑의 코드는 열은 고정되고 행이 되는 것
				sum2+=arr[j][i];
			}
			// sum1이랑 sum2중에 큰 값이 answer에 들어간다(기존값보다 큰 경우에)
			answer = Math.max(answer, sum1);
			answer = Math.max(answer, sum2);
		}
		sum1 = sum2 = 0;

		// 대각선의 합 구하기
		for(int i=0; i<n; i++){
			sum1+=arr[i][i];
			sum2+=arr[i][n-i-1];
		}
		answer = Math.max(answer, sum1);
		answer = Math.max(answer, sum2);

		return answer;
	}

	public static void main(String[] args){
		GridMaxSum T = new GridMaxSum();
		Scanner kb = new Scanner(System.in);
		int n = kb.nextInt();
		int[][] arr = new int[n][n];
		for(int i=0; i<n; i++){
			for(int j=0; j<n; j++){
				arr[i][j] = kb.nextInt();
			}
		}
		System.out.println(T.solution(n,arr));
	}
}
