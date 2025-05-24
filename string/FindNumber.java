package string;

import java.util.Scanner;

/**
 * 주어진 문자열에서 숫자 추출하여 자연수로 만들기
 * 예시 g0en2T0s8esodft 정답 : 208
 */
public class FindNumber {
	public Integer  solution(String str){

		// 방법 1. 정수로 만들기
		int answer = 0;
		for( char x : str.toCharArray()){
			// 아스키 코드가 48~57이면 문자 '0'~'9'이므로 숫자임
			// 문자 '0'의 아스키 값이 48이므로, 문자에서 48을 빼면 실제 숫자값이 됨
			// 예: '3' - 48 == 3
			// anser에 10을 곱해서 정수로 만든다. 예를 들어 123이 답이라고 할때 백이십삼을 출력해야하니까 10씩 곱해서 1+0 = 1, 10+2 = 12, 120+3 = 123으로 만드는 것.
			if(x >= 48 && x<= 57 ) answer =  answer * 10 + (x-48);
		}

		// 방법 2. String으로 더하기
		String answer2 = "";
		for(char x : str.toCharArray()){
			// true 일시 숫자
			if(Character.isDigit(x)) answer2 += x;
		}
		answer = Integer.parseInt(answer2);

		return answer;
	}

	public static void main(String[] args){
		FindNumber T = new FindNumber();
		Scanner kb = new Scanner(System.in);
		// 스캐너로 입력한 str 읽기
		String str = kb.next();
		System.out.println(T.solution(str));
	}
}
