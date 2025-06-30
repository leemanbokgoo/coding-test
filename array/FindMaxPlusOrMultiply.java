package array;

import java.util.Scanner;

public class FindMaxPlusOrMultiply {
	public int solution(String str) {
		// 다 곱하면 가장 큰 수가 나올 것 같지만 배열에 0이 존재하면 무엇을 곱하든 결과는 0임으로 0이 있으면 더하는 것이 좋다.
		// 1인 경우에도 곱해봤자 값이 커지지않기때문에 더하는 것이 낫다.
		int result = 0;

		for (int number : str.toCharArray()) {
			// 숫자가 1보다 작거나 같다면, 그리고 현재까지 계산한 값이 1보다 작거나 같다면 (즉,0이라면)
			if (number <= 1 || result <= 1) {
				// 0이라면 더하는 것이 더 큰 수다.
				result += number;
			} else {
				// 0이 아닌 경우에는 곱하는 것이 더 큰 수다.
				result *= number;
			}
		}

		return result;
	}

	public static void main(String[] args) {
		FindMaxPlusOrMultiply T = new FindMaxPlusOrMultiply();
		Scanner kb = new Scanner(System.in);
		String str = kb.next();
		System.out.println(T.solution(str));
	}
}
