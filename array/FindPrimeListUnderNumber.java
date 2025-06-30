package array;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Q. 정수를 입력 했을 때, 그 정수 이하의 소수를 모두 반환하시오.
 * 소수는 자신보다 작은 두 개의 자연수를 곱하여 만들 수 없는 1보다 큰 자연수이다.
 * 소수는 자기자신과 1 외에는 나눌 수 없다.
 */
public class FindPrimeListUnderNumber {
	public List<Integer> solution(int number) {
		List<Integer> primeList = new ArrayList<>();

		for (int n = 2; n <= number; n++) {
			boolean isPrime = true;

			// 어떤 수가 소수인지 확인하려면, 자기 자신과 1 외에 나누어떨어지는 수가 없어야 한다.
			// 그런데 소수가 아닌 수는 이미 다른 수(특히 소수)의 곱으로 만들어진 숫자이다.
			// 따라서 소수 판별 시에는, 굳이 모든 수로 나눠볼 필요 없이,
			// 이전에 소수라고 판별된 숫자들로만 나눠봐도 충분하다.
			// 소수가 아닌 수는 이미 소수들의 곱으로 만들어진 수이므로, 소수 판별 시에는 이전에 판별된 소수들로만 나눠봐도 충분하다.
			for (int prime : primeList) {
				// primeList(소수 리스트)에 있는 모든 소수로 나눠지는 지 확인할 필요 없이 2부터 제곱근까지만 검사하면 충분하다.

				// 여기서 제곱근은 어떤 수를 두 번 곱해서 원래 수가 되는 숫자로 예를 들어, 25의 제곱근은 5이고, 16의 제곱근은 4이다.
				// 어떤 수 n을 a와 b라는 두 자연수의 곱으로 나타낼 때,  만약 a가 n의 제곱근보다 크면, b는 반드시 제곱근보다 작거나 같다.
				// 둘 다 제곱근보다 크면 곱한 값이 n보다 커지기 때문이다.
				// 예를 들어, √25의 값은 5이다.
				// 6 * 4 = 24 → 4는 5보다 작고 6은 5보다 크다.
				// 7 * 3 = 21 → 3은 5보다 작고 7은 5보다 크다.
				// 6 * 6 = 36 → 둘 다 5보다 크면 25보다 크다.
				// 즉, prime * prime이 n보다 크다는 것은 prime이 n의 제곱근보다 크다는 뜻다.
				// n의 제곱근 보다 prime의 큰 경우 짝꿍 숫자(나누어 떨어질 때 함께 곱해져서 n이 되는 수)이 반드시 제곱근 이하이고,
				// 그 짝꿍은 이미 검사했기 때문에 중복 검사라서 굳이 또 검사할 필요가 없다.
				// 따라서 prime * prime이 n보다 크면, 이후 소수들로 나누어볼 필요가 없다.
				if (prime * prime > n) break;

				if (n % prime == 0) {
					isPrime = false; // 나누어떨어지면 소수가 아니다.
					break;
				}
			}

			if (isPrime) {
				primeList.add(n);
			}
		}

		return primeList;
	}

	public static void main(String[] args) {
		FindPrimeListUnderNumber T = new FindPrimeListUnderNumber();
		Scanner sc = new Scanner(System.in);
		int input = sc.nextInt();
		for( Integer x : T.solution(input)){
			System.out.println(x + " " );
		}
	}
}
