package twoPointers;

import java.util.Scanner;

/**
 * 0과 1로 구성된 길이가 N인 수열이 주어진다. 이 수열에서 최대 K번을 0을 1로 변경할 수 있다. 최대 K번의 변경을 통해 이 수열에서 1로만 구성된 최대 길이의
 * 연속 부분 수열을 찾는 프로그램
 * 만약 길이가 14인 다음곽 ㅏㅌ은 수열이 주어지고 K=2라면 1 1 0 0 1 1 0 1 1 0 1 1 0 1
 * 1 이 연속된 연속 부분 수열의 길이는 8이다.
 *
 * 입력예제 14 2
 * 1 1 0 0 1 1 0 1 1 0 1 1 0 1
 * 출력예제 8
 */
public class MaximumLength {
	public int solution(int n, int k, int[] arr){
		//cnt는 0을 1로 바꾼 횟수
		int answer = 0, cnt = 0, lt = 0;
		for(int rt =0; rt<n; rt++){
			// k개 만큼 0을 1로 변경 할 수 있기때문에 변경 횟수를 카운팅
			if(arr[rt] == 0) cnt++;
			// 지금까지 0을 1로 바꾼 횟수가 k를 초과했다면, 이제는 슬라이딩 윈도우의 왼쪽 경계 lt를 오른쪽으로 옮겨서 0의 개수를 줄여야 한다는 뜻이다.
			// 즉 윈도우를 좁히면서 새로운 수열을 구해가는 과정이다.
			// 이 과정이 끝나면 다시 cnt가 k보다 작아지기때문에 연속된 부분의 수열의 길이를 구할 수 있다.
			while(cnt>k){
				// 윈도우의 왼쪽 경계에 있는 값이 0이라면, 이 0은 우리가 1로 바꾼 것 중 하나였을 가능성이 크다.
				// 따라서 이 0을 슬라이딩 윈도우 밖으로 밀어내는 것이므로, 바꾼 횟수인 cnt를 줄인다.
				if(arr[lt] == 0 )cnt--;
				// lt가 증가하면서 0을 찾아가야하기때문에 lt를 계속 더한다.윈도우 왼쪽 경계 이동
				lt++;
			}
			// rt-lt+1 : 연속으로 1을 가지고 있는 수열의 길이
			answer = Math.max(answer, rt-lt+1);
		}
		return answer;
	}

	public static void main(String[] args){
		MaximumLength T = new MaximumLength();
		Scanner kb = new Scanner(System.in);
		int n = kb.nextInt();
		int k = kb.nextInt();
		int[] arr = new int[n];
		for(int i=0; i<n; i++){
			arr[i] = kb.nextInt();
		}
		System.out.println(T.solution(n,k,arr));
	}
}
