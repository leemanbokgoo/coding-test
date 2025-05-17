package string;

import java.util.ArrayList;
import java.util.Scanner;

public class FlipWords {

	public ArrayList<String> solution(int n, String[] str){
		ArrayList<String> answer = new ArrayList<>();
		/**
		 * 문자열 뒤집기 : StringBuilder 사용
		 */
		for( String x : str){
			String tmp = new StringBuilder(x).reverse().toString();
			answer.add(tmp);
		}
		/**
		 * 문자열 뒤집기 : 직접 구현
		 */
		for( String x : str ){
			char[] s = x.toCharArray();
			int lt = 0, rt = x.length(); // lt : 앞에서 부터 rt : 끝에서부터

			while (lt<rt){
				char tmp = s[lt]; // 앞의 index
				s[lt] = s[rt]; // 자리를 교환
				s[rt] = tmp;
				lt++; // 앞의 index를 +1해서 다음으로 넘긴다
				rt--; // 끝의 index를 -1해서 앞당긴다.
			}

			// charArray -> String으로 변환
			String tmp = String.valueOf(s);
			answer.add(tmp);
		}
		return answer;
	}

	public static void main(String[] args){
		FlipWords T = new FlipWords();
		Scanner kb = new Scanner(System.in);
		int n = kb.nextInt();
		String[] str = new String[n];
		for ( int i =0l i <n; i++){
			str[i] = kb.next();
		}
		for(String x : T.solution(n, str)){
			System.out.println(x);
		}
	}
}
