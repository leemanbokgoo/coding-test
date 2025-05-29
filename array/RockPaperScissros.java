package array;

import java.util.Scanner;

/**
 * A,B 두사람이 가위바위보 게임을 하는데 총 N번의 게임을 하여 A가 이기면 A를 출력하고 B가 이기면 B를 출력한다. 비길 경우에는 D를 출력한다.
 * 두사람의 각 회의 가위,바위,보 정보가 주어지면 각 회를 누가 이겼는데 출력하는 프로그램을 작성하라
 *
 * 첫번째 줄 : 게임 횟수(1<=N<=100) 두번째 줄 : A가 낸 가위,바위,보 정보 N개 세번째 줄: B가 낸 가위,바위,보 정보 N개
 * 각 줄에 각 회의 승자를 출력한다. 비겼을 경우에는 D를 출력한다.
 *
 * 입력 예제 5 | 2 3 3 1 3 | 1 1 2 2 3
 * 출력 예제 A B A A B D
 */
public class RockPaperScissros {
	public String solution(int n , int[] a, int[] b){
		String answer = "";
		for(int i =0; i<n; i++){
			// 비긴 경우
			if(a[i] == b[i]) answer+="D";
			// 가위 = 1 으로 이길 수 있는 경우 보 = 3
			else if(a[i]== 1 && b[i]==3 ) answer+="A";
			// 바위 = 2 으로 이길 수 있는 경우 가위 = 1
			else if(a[i]== 2 && b[i]==1 ) answer+="A";
			// 보 = 3 으로 이길 수 있는 경우 바위 = 2
			else if(a[i]== 3 && b[i]==2 ) answer+="A";
			else answer+="B";
		}

		return answer;
	}

	public static void main(String[] args){
		RockPaperScissros T = new RockPaperScissros();
		Scanner kb = new Scanner(System.in);
		int n = kb.nextInt();
		int[] a = new int[n];
		int[] b = new int[n];
		for(int i=0; i<n; i++){
			a[i] = kb.nextInt();
		}
		for(int i=0; i<n; i++){
			b[i] = kb.nextInt();
		}
		for( char x : T.solution(n, a, b).toCharArray()){
			System.out.println(x);
		}
	}
}
