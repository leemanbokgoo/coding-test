package string;

import java.util.Scanner;

/**
 * 문자열 s와 한개의 문자열 t가 주어지면 문자열 s와 각 문자가 문자 t와 떨어진 최소거리를 출력하는 프로그램을 작성한다. 문자열 길이는 100을 넘지않는다.
 * 입력예제 teachermode e 출력 예제 1 0 1 2 1 0 1 2 2 1 0
 */
public class ShortestTextDistance {
	public int[] solution(String str, char t){
		int[] answer = new int[str.length()];
		// 임의의 숫자 생성
		int p = 1000;
		// 먼저 왼쪽을 기준으로 타겟문자와 해당문자(i)와의 거리를 계산해서 정답 배열에 넣는다.
		for(int i =0; i< str.length(); i++){
			// 타겟 문자인 경우 p
			if(str.charAt(i) ==  t){
				p = 0 ;
			// 타겟 문자가 아닌 경우 p의 값을 하나씩 증가 -> 타겟문자와 해당 문자(i)와의 거리를 측정
			} else {
				p++;
			}
			// 타겟문자와 해당문자(i)의 거리인 p를 정답의 index에 넣는다.
			answer[i] = p;
		}

		// 반대로 오른쪽을 기준으로 타겟문자와 해당문자(i)와의 거리를 계산해서 아까 넣은 최소 숫자와 비교하여 더 작은 숫자를 정답 배열에 넣는다.
		p = 1000;
		for(int i = str.length()-1; i>= 0; i--){
			if(str.charAt(i) ==  t){
				p = 0 ;
			} else {
				p++;
				// 왼쪽을 기준으로 구한 최소거리와 오른쪽을 기준으로 구한 최소 거리 중 더 작은 최소거리를 정답 배열에 넣는다.
				answer[i] = Math.min(answer[i] , p);
			}
		}

		return answer;
	}

	public static void main(String[] args){
		ShortestTextDistance T = new ShortestTextDistance();
		Scanner kb = new Scanner(System.in);
		// 스캐너로 입력한 문자열 읽기
		String str = kb.next();
		// 문자1개를 읽음.
		char c = kb.next().charAt(0);
		for(int x : T.solution(str, c)){
			System.out.println(x+ " ");
		}
	}
}
