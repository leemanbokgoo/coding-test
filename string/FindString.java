package string;

import java.util.Scanner;

public class FindString {
	public int solution(String str, char t){
		int answer = 0;
		// 전부 대문자로 변경
		str = str.toUpperCase();
		t = Character.toUpperCase(t);
		// str을 array로 만들어서 향상된 for문 사용.
		for( char x : str.toCharArray()){
			if( x == t ) answer++;
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
