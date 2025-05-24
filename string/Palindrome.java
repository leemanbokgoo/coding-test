package string;

import java.util.Scanner;

/**
 * 앞으로 읽을 때나 뒤에서 읽을때나 같은 문자열을 팰린드롬이라고 함.
 * 예시 : found7, time: study;, Yduts; emit, 7Dnuouf 답 : YES
 */
public class Palindrome {
	public String solution(String str){
		String answer = "NO";
		// 대문자가 아닌 특수 기호 제거
		str = str.toUpperCase().replaceAll("[^A-Z]", "");
		String tmp = new StringBuilder(str).reverse().toString();
		if(str.equals(tmp)) answer = "YES";

		return answer;
	}

	public static void main(String[] args){
		RemoveDuplicateCharacters T = new RemoveDuplicateCharacters();
		Scanner kb = new Scanner(System.in);
		// 스캐너로 입력한 str 읽기
		String str = kb.next();
		System.out.println(T.solution(str));
	}
}
