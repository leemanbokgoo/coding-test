package string;

import java.util.Scanner;

/**
 * 예시 ksekkset 정답 : kset
 */
public class RemoveDuplicateCharacters {

	public String solution(String str){
		String answer = "";
		for( int i= 0; i <str.length(); i++){
			// i는 현재 그 문자의 위치 , str.indexOf(는) 해당 문자가 첫번째로 등장한 인덱스의 위치
			// 두 위치가 같으면 처음 나타난 문자, 두 위치가 틀리면 중복 문자
			if(str.indexOf(str.charAt(i)) == i){
				answer += str.charAt(i);
			}
		}
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
