package array;

import java.util.Scanner;

/**
 * 봉우리 문제
 * 지도 정보가 N*N 격자판에 주어진다. 각 격자에는 그 지역의 높이가 쓰여있다. 각 격자판의 숫자 중 자신의 상하좌우 숫자보다 큰 숫자는 봉우리 지역이다.
 * 봉우리 지역이 몇개 있는지 알아내시오. 격자의 가장 자리는 0으로 초기화 되었다고 가정한다.
 * 즉, 해당 위치를 둘러싼 격자의 상하좌우의 수가 해당 위치보다 작으면 봉우리가 된다.
 *
 * 입력예제 5
 * 5 3 7 2 3
 * 3 7 1 6 1
 * 7 2 5 3 4
 * 4 3 6 4 1
 * 8 7 3 5 2
 * 출력예제 10
 */
public class GridProblem {

	// 상하좌우를 돌기위해 필요한 값
	int[] dx = {-1, 0, 1, 0};
	int[] dy = {0, 1, 0, -1};

	public int solution(int n, int[][] arr){
		int answer = 0;

		// 2차원 배열 탐색
		for(int i=0; i<n; i++){
			for(int j=0; j<n; j++){
				// ij가 결정되었음으로(=위치가 결정되었음으로) 이제 해당 ij의 상하좌우의 크기가 ij보다 작은지 확인. 작으면 봉우리다.
				boolean flag = true;
				// 상하좌우 4방향이니까 4번 돈다.
				for(int k=0; k<4; k++){
					// 네방향을 보기위한 행 좌표
					int nx = i+dx[k];
					// 네방향을 보기위한 열 좌표
					int ny = j+dy[k];

					// nx >= 0 && nx<n && ny>=0 && ny <n 은 가장자리에 있는 ij의 경우 상하좌우의 값이 없을 수 있기때문에 미리 필터링해야함.
					// 상하좌우 방향에 있는 위치의 값이 arr[i][j](현재위치)보다 크거나 같으면 arr[i][j](현재위치)는 봉우리가 아님.
					if( nx >= 0 && nx<n && ny>=0 && ny <n && arr[nx][ny] >= arr[i][j] ){
						flag = false;
						break;
					}
				}
				if( flag ) answer++;
			}
		}
		return answer;
	}

	public static void main(String[] args){
		GridProblem T = new GridProblem();
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
