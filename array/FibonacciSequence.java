package array;

import java.util.Scanner;

/**
 * 피보나치 수열을 출력한다.
 * 피보나치 수열 : 앞의 2개의 수를 합하여 다음 숫자가 되는 수열이다.
 * 입력은 피보나치 수열의 총 항의 수이다. 만약 7이 입력되면 1 1 2 3 5 8 13을 출력하면된다.
 * 첫 줄에 총 항수 N(3<=N<=45)이 입력된다.
 *
 * 입력 예제 : 10
 * 출력 예제 : 1 1 2 3 5 8 13 21 34 55
 */
public class FibonacciSequence {
	public int[] solution(int n){
		int[] answer = new int[n];
		// 방법 1. 배열로 피보나치 수열 만들기
		// 피보나치 수열은 1, 1 이 앞에 반드시 들어간다.
		answer[0] = 1;
		answer[1] = 1;
		for(int i=2; i<n; i++){
			answer[i] = answer[i-2] + answer[i-1];
		}

		// 방법 2. 배열 없이 피보나치 수열 만들기
		int a = 1, b=1, c;
		System.out.println(a + " " + b + " ");
		for(int i=2; i<n; i++){
			c = a=b;
			System.out.println(c + " ");
			a = b;
			b = c;
		}

		return answer;

	}

	public static void main(String[] args){
		FibonacciSequence T = new FibonacciSequence();
		Scanner kb = new Scanner(System.in);
		int n = kb.nextInt();
		int[] arr = new int[n];
		for( int x : T.solution(n)){
			System.out.println( x + " ");
		}
	}
}
