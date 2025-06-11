package array;

import java.util.Scanner;

/**
 * 멘토링 프로그램을 만든다. 조건은 다음과 같다. M번의 수학 테스트 등수를 가지고 멘토와 멘티를 정한다.
 * 만약 A학생이 멘토이고 B학생이 멘티가 되는 짝이 되었다면 A학생은 M번의 수학 테스트에서 모두 B학생보다 등수가 앞서야한다.
 * M번의 수학성적이 주어지면 멘토와 멘티가 되는 짝을 만들 수 있는 경우가 총 몇가지인지를 출력해라.
 *
 * 입력예제 4 3 (학생 수 : 4 , 테스트의 갯수 3)
 * 3 4 1 2  (3번 학생이 1등인 것)
 * 4 3 2 1
 * 3 1 4 2
 * 출력예제 3 (3,1)(3,2)(4,2) 와 같이 3같이 경우의 (멘토,멘티)짝을 만들수있다.
 */
public class Mentoring {
	public int solution(int n, int m, int[][] arr){
		//2차원배열으로 4중 for문을 돌려야하는 문제.

		int answer = 0;
		// 학생이 4명일때 총 멘토와 멘티가 될 수 있는 총 경우의 수(조건을 따지지않을때)는 16개다. 4*4
		// 멘토가 되기위해서는 1번 학생이 2번학생보다 3번의 테스트에서 성적이 모두 앞서는 지 확인해야한다.
		// i번의 학생을 찾아서 돌리는 for문
		for(int i = 1; i<n; i++) {
			// i번 학생과 나머지 학생들을 비교하기위해 돌리는 for문 즉, i번 학생과 j번 학생의 등
			for (int j = 1; j < n; j++) {
				int cnt = 0;
				// 테스트에 해당하는 for문
				for (int k = 0; k < m; k++) {
					int pi=0, pj=0;
					// 등수 해당하는 for문
					for (int s = 0; s < m; s++) {
						// arr[k][s]의 결과 값은 k번의 테스트의 s등의 학생번호이다.
						// 위의 학생번호가 i학생 번호와 같다면 i번 학생은 s등인 것.
						if(arr[k][s] == i) pi=s;
						// j번의 학생의 등수를 찾아서 넣어줌
						if(arr[k][s] == j) pj=s;
					}
					// i번의 학생의 등수가 j번의 학생의 등수보다 크면 cnt ++
					if(pi<pj) cnt++;
				}
				// cnt==m : i번 학생의 등수가 j번 학생의 등수보다 큰 횟수가 시험 테스트 횟수와 같다면, 멘티가 가능하다.
				if(cnt==m){
					answer++;
				}
			}
		}
		return answer;
	}

	public static void main(String[] args){
		Mentoring T = new Mentoring();
		Scanner kb = new Scanner(System.in);
		int n = kb.nextInt();
		int m = kb.nextInt();
		int[][] arr = new int[m][n];
		for(int i = 0; i<m; i++) {
			for(int j = 0; j<n; j++) {
				arr[i][j] = kb.nextInt();
			}
		}
		System.out.println(T.solution(n,m,arr));
	}
}
