package array;

public class FindMaxPlusOrMultiply {
	public int solution(int[] array) {
		// 다 곱하면 가장 큰 수가 나올 것 같지만 배열에 0이 존재하면 무엇을 곱하든 결과는 0임으로 0이 있으면 더하는 것이 좋다.
		int result = 0;

		for (int number : array) {
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
		int[] arr = {1, 2, 3, 0, 4}; // 예시 입력
		System.out.println(T.solution(arr)); // 결과 출력
	}
}
