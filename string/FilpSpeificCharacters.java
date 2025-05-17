package string;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 예시 : a#b!GE*T@S  정답 : S#T!EG*b@a
 */
public class FilpSpeificCharacters {
	public ArrayList<String> solution(String str){
		ArrayList<String> answer = new ArrayList<>();
		char[] s = str.toCharArray();
		int lt = 0 , rt = str.length() -1; // lt = 첫번째 문자 rt = 마지막 문자

		while (lt<rt){
			// 알파벳이 아닐때
			if( !Character.isAlphabetic(s[lt])) {
				lt++;
			} else if( !Character.isAlphabetic(s[lt])) {
				rt--;
			} else {
				char tmp = s[lt]; // 앞의 index
				// 자리를 교환
				s[lt] = s[rt];
				s[rt] = tmp;
				lt++; // 앞의 index를 +1해서 다음으로 넘긴다
				rt--; // 끝의 index를 -1해서 앞당긴다.
			}
		}

		// charArray -> String으로 변환
		String tmp = String.valueOf(s);
		answer.add(tmp);
		return answer;
	}

	public static void main(String[] args){
		FilpSpeificCharacters T = new FilpSpeificCharacters();
		Scanner kb = new Scanner(System.in);
		String str = kb.next();
		System.out.println(T.solution(str));
	}
}
