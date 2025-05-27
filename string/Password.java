package string;

import java.util.Scanner;

/**
 * 비밀편지는 알파벳 한 문자마다 # 또는 *이 일곱개로 구성되어있다. 만약 "#*****#"으로 구성된 문자로 보냈다면 다음과 같은 규칙대로 해석한다.
 * 1. "#*****#"은 일곱자로 이진수로 바꾼다. #은 이진수의 1로 *은 이진수의 0으로 변환한다. 결과는 1000001로 변환된다.
 * 2. 바뀐 이진수를 10진수화 한다. 1000001을 10진수화하면 65가 된다.
 * 3. 아스키 번호를 65문자로 변환한다. 즉 아스크 번호 65는 대문자 A이다.
 * 참고로 대문자들의 아스키 번호는 A는 65번 B는 66번 C는 67번 등 차례대로 1씩 증가하여 Z는 90번이다.
 * 4개의 문자를 다음과 같은 신호로 보냈다면
 * #****## -> C #**#### -> O  #**#### -> O #**##** -> L => COOL로 해석된다.
 *
 * 입력 예제 4 #****###**#####**#####**##**
 * 출력 예제 COOL
 */
public class Password {
	public String solution(int n , String s){
		String answer = "";
		for(int i =0; i<n; i++){
			// 7개씩 끊어서 출력 될 수 있도록
			String tmp = s.substring(0,7).replace("#", "1").replace("*", "0");
			// 2진수화
			int num = Integer.parseInt(tmp, 2);
			// 2진수 -> 문자열
			answer += (char)num;
			// 이미 출력한 7개는 삭제
			s = s.substring(7);
		}
		return answer;
	}

	public static void main(String[] args){
		Password T = new Password();
		Scanner kb = new Scanner(System.in);
		int n = kb.nextInt();
		// 스캐너로 입력한 str 읽기
		String str = kb.next();
		System.out.println(T.solution(n, str));
	}
}