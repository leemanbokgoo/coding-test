package array;

import java.util.Scanner;

public class FindNonRepeatingCharFinder {
	public char solution(String str) {
		int[] alphabetCount = new int[26];

		// 첫 번째 루프: 각 알파벳 등장 횟수 세기
		for (char ch : str.toCharArray()) {
			if (!Character.isLetter(ch)) continue;
			ch = Character.toLowerCase(ch); // 대소문자 통일
			int index = ch - 'a';
			alphabetCount[index]++;
		}

		// 두 번째 루프: 문자열 순서대로 첫 중복되지 않는 문자를 찾기
		for (char ch : str.toCharArray()) {
			if (!Character.isLetter(ch)) continue;

			ch = Character.toLowerCase(ch);
			int index = ch - 'a';
			if (alphabetCount[index] == 1) {
				return ch;
			}
		}

		return '_'; // 중복되지 않은 문자가 없는 경우
	}


	public static void main(String[] args) {
		FindMaxPlusOrMultiply T = new FindMaxPlusOrMultiply();
		Scanner kb = new Scanner(System.in);
		String str = kb.next();
		System.out.println(T.solution(str));
	}
}
