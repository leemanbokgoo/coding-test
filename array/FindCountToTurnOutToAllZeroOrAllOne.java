package array;

import java.util.Scanner;

/**
 * 0과 1로만 이루어진 문자열이 주어졌을 때, 이 문자열에 있는 모든 숫자를 전부 같게 만들려고 한다. 할 수 있는 행동은 문자열에서 연속된 하나 이상의 숫자를 잡고 모두 뒤집는 것이다.
 * 뒤집는 것은 1을 0으로, 0을 1로 바꾸는 것을 의미한다.
 * 예를 들어 S=0001100 일 때, 1로 다 만든다면 000을 1번 뒤집고 00을 한번 뒤집어서 1111111을 만든다. 0001100 -> 1111100 -> 1111111 => 총 2번
 * 하지만, 처음부터 4번째 문자부터 5번째 문자까지 문자를 뒤집으면 한 번에 0000000이 되어서 1번 만에 모두 같은 숫자로 만들 수 있다. 0001100 -> 0000000 => 총 1번
 * 주어진 문자열을 모두 0 혹은 모두 1로 같게 만드는 최소 횟수를 반환하시오.
 */
public class FindCountToTurnOutToAllZeroOrAllOne {
	public int solution(String str) {
		int countToAllZero = 0; // 모든 것을 0으로 만듬
		int countToAllOne = 0; // 모든 것을 1로 만듬.

		// 첫 문자에 따라 카운트 초기화
		if (str.charAt(0) == '0') {
			countToAllOne++;
		} else {
			countToAllZero++;
		}

		// 인접한 문자 비교하면서 블록 전환 시 카운트 증가
		for (int i = 0; i < str.length() - 1; i++) {
			// 현재 값과 현재 값보다 하나 뒤에 있는 값(=다음값)이 다르다면 즉 현재값이 1, 다음값이 0이거나 현재값이 0, 다음값이 1이다.
			// 즉 현재값과 다음값이 일치하지않으면 문자를 뒤집어줘야한다.
			if (str.charAt(i) != str.charAt(i + 1)) {
				// 다음값에 따라 모든 것을 0으로 만드는 경우와 모든 것을 1을 만드는 경우 둘중에 하나를 카운팅한다.
				if (str.charAt(i + 1) == '0') {
					countToAllOne++;
				} else {
					countToAllZero++;
				}
			}
		}

		// 모든 것을 0으로 바꾸는 경우, 모든 것을 1로 바꾸는 경우 둘 중 가장 카운팅이 적은 것을 반환한다.
		return Math.min(countToAllZero, countToAllOne);
	}

	public static void main(String[] args) {
		FindCountToTurnOutToAllZeroOrAllOne T = new FindCountToTurnOutToAllZeroOrAllOne();
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();

		System.out.println( T.solution(input));
	}
}

