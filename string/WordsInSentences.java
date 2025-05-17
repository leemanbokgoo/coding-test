package string;

import java.util.Scanner;

public class WordsInSentences {

	// 주어진 값 : it is time study |  answer : study
	public String solution(String str){
		String answer = "";
		int m = Integer.MIN_VALUE;

		/**
		 * split 방식
		 */
		String[] s = str.split(" ");
		for(String x : s){
			int len = x.length();
			if(len > m){
				m = len;
				answer = x;
			}
		}

		/**
		 * index of 방식
		 */
		int m2 = Integer.MIN_VALUE, pos;
		// 띄어쓰기를 발견 못하면 -1 리턴, 띄어쓰기를 발견하면 index 번호를 리턴 , 즉 띄어쓰기의 index를 반환
		while((pos = str.indexOf(' ')) != -1){
			String tmp = str.substring(0, pos);
			int len = tmp.length();
			if(len > m){
				m = len;
				answer = tmp;
			}
			// 이미 저장된 단어는 문자열에서 잘라내버린다.
			str = str.substring(pos+1);
		}
		// 마지막 단어는 띄어쓰기가 발견되지않아서 -1로 return 되어 while문이 끝나버려 계산이 안된다. 그래서 처리가 별도로 필요함.
		if(str.length()> m) answer = str;
		return answer;
	}

	public static void main(String[] args){
		WordsInSentences T = new WordsInSentences();
		Scanner kb = new Scanner(System.in);
		String str = kb.nextLine();
		System.out.println(T.solution(str));
	}
}
