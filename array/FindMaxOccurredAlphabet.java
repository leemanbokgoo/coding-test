package array;

import java.util.Scanner;

public class FindMaxOccurredAlphabet {
	public char solution(String str) {
		int[] alphabetOccurrenceArray = new int[26]; // 알파벳 소문자 개수 배열

		for (char x : str.toCharArray()) {
			if (!Character.isLetter(x)) continue; // 알파벳이 아닌 경우 무시

			x = Character.toLowerCase(x); // 대소문자 구분 없이 처리
			// char을 int로 바꾸기위해(아스키코드로 바꾸기 위해) -a를 해야함
			int index = x - 'a';
			alphabetOccurrenceArray[index]++;
		}

		int maxOccurrence = 0;
		int maxAlphabetIndex = 0;

		for (int i = 0; i < alphabetOccurrenceArray.length; i++) {
			if (alphabetOccurrenceArray[i] > maxOccurrence) {
				maxOccurrence = alphabetOccurrenceArray[i];
				maxAlphabetIndex = i;
			}
		}
		// 'a'는 유니코드에서도 아스키 코드 97과 같기 때문에
		// index + 'a'는 알파벳 문자로 변환되는 유니코드 코드포인트가 된다.
		// 예: 0 + 97 = 97 ('a'), 1 + 97 = 98 ('b')
		return (char) (maxAlphabetIndex + 'a'); // 인덱스를 문자로 변환
	}

	public static void main(String[] args) {
		FindMaxOccurredAlphabet T = new FindMaxOccurredAlphabet();
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();

		System.out.println( T.solution(input));
	}
}