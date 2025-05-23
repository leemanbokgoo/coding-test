package string;

import java.util.Scanner;

/**
 * 회문 문자열(앞뒤가 같은 문자열)인 경우 YES, 아닐 시 NO (대소문자 구분은 안함.)
 * 예시 : gooG 정답 : YES
 */
public class PalindromeString {
	public String solution(String str){
		String answer = "YES";

		// 방법 1. 대문자로 변경 후 비교
		int len = str.length();
		str = str.toUpperCase();
		// 문자열의 반절만큼만 for문을 돌린다.
		for( int i =0; i <len/2; i++){
			if(str.charAt(i) != str.charAt(len-i-1)){
				answer = "NO";
				break;
			}

		}

		// 방법 2. StringBuilder 사용하기
		String answer2 = "NO";
		String tmp = new StringBuilder(str).reverse().toString();
		// 참고 : equalse가 아니라 equalsIgnoreCase하면 대소문자를 무시한다. 현재는 대소문자까지 똑같아야 정답처리됨.
		if( str.equals(tmp)) answer2 = "YES";

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

