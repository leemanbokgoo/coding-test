package string;

import java.util.Scanner;

public class ConvertString {
	public String solution(String str, char t){
		String answer = "";

		// 방법 1.
		for( char x : str.toCharArray()){
			// x가 소문자인지 확인 -> x를 대문자로 변경
			if(Character.isLowerCase(x)) answer += Character.toUpperCase(x);
			else answer += Character.toLowerCase(x);
		}

		// 방법 2. 아스키 번호로 변환하는 방식
		for( char x : str.toCharArray()){
			if( x >= 97 && x <= 122) answer += (char)(x - 32); // 소문자를 대문자로 변경
			else answer += (char)(x+32);
		}
		return answer;
	}

	public static void main(String[] args){
		FindString T = new FindString();
		Scanner kb = new Scanner(System.in);
		// 스캐너로 입력한 str 읽기
		String str = kb.next();
		// 문자열을 읽음.
		char c = kb.next().charAt(0);

		System.out.println(T.solution(str, c));
	}
}
