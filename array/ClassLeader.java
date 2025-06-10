package array;

import java.util.Scanner;

/**
 * 임시반장 정하기
 * 1-5학년까지 지내오면서 같은 반이었던 사람이 가장 많은 학생을 임시반장으로 정한다.
 *
 * 입력예제 5
 * 2 3 1 7 3
 * 4 1 9 6 8
 * 5 5 2 4 4
 * 6 5 2 6 7
 * 8 4 2 2 2
 * 출력예제 4
 */
public class ClassLeader {
	public int solution(int n, int[][] arr){
		int answer = 0, max = Integer.MIN_VALUE;
		// 카운팅시 자기 자신을 비교하게 되는 경우에는 그냥 카운팅한다. 어짜피 자기 자신을 모두 동등하게 카운팅함으로 가장 같은 반을 많이 한 학생을 골라내는 데는 상관없다.
		// 다만 같은 반을 한 횟수를 구할때는 카운팅에서 자기자신은 제외되어야함.
		// i는 학생번호 j는 반
		for(int i = 1; i<n; i++){
			int cnt = 0;
			for(int j = 1; j<5; j++){
				// 5학년때까지 k for문을 돌린다.
				for(int k = 1; k<=5; k++){
					if(arr[i][k] == arr[j][k]){
						cnt++;
						// 카운팅할때 a학생과 b학생이 1학년때 같은 반이고 2학년때 또 같은 반이였다면 한번만 카운팅해야한다. 같은 학생을 여러번 카운팅해서는 안된다.
						// 고로 cnt을 카운팅하고나서는 break로 해당 for문을 빠져나와야함.
						break;
					}
				}
			}
			if(cnt>max){
				max = cnt;
				// 학생 번호를 answer에 넣어준다.
				answer = i;
			}
		}
		return answer;
	}


	public static void main(String[] args){
		ClassLeader T = new ClassLeader();
		Scanner kb = new Scanner(System.in);
		int n = kb.nextInt();
		// 학생번호가 1번부터임으로 2차원 배열을 만들때 행과 열에 0번은 사용하지않는다.
		int[][] arr = new int[n+1][6];
		for(int i=1; i<n; i++){
			// 5학년까지 있기때문에 j<5
			for(int j=1; j<5; j++){
				arr[i][j] = kb.nextInt();
			}
		}
		System.out.println(T.solution(n,arr));
	}


}
