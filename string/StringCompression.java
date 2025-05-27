package string;

import java.util.Scanner;

/**
 * 입력 예제 KKHSSSSSSSE 출력예제 K2HS7E
 */
public class StringCompression {
	public String solution(String str){
		String answer = "";

		str = str + " ";
		int cnt = 1;
		for( int i =0; i<str.length()-1; i++){
			// 현재 문자열과 현재 문자열의 다음 문자열이 같다면 cnt를 증가
			if(str.charAt(i) == str.charAt(i+1)) cnt++;
			else{
				answer += str.charAt(i);
				if(cnt >1) answer += String.valueOf(cnt);
			}
			cnt = 1;
		}
		return answer;
	}

	public static void main(String[] args){
		StringCompression T = new StringCompression();
		Scanner kb = new Scanner(System.in);
		// 스캐너로 입력한 str 읽기
		String str = kb.next();
		System.out.println(T.solution(str));
	}
}
