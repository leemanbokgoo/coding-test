package array;

import java.util.Scanner;

/**
 * 자연수 N이 입력되면 1부터 N까지의 소수의 개수를 출력하는 프로그램을 작성한다.
 * 만약 20이 입력되면 1부터 20까지의 소수는 2,3,5,7,11,13,17,18 로 총 8개이다.
 * 제한시간은 1초이다.
 *
 * 입력예제 20
 * 출력예제 8
 */
public class PrimeNumbers {
	public int solution(int n){
		int answer = 0;
		// 에라토스테네스의 체 방법으로 구하기
		int[] ch = new int[n+1];
		for(int i=2; i<n; i++){
			// 소수라면
			if(ch[i] ==0){
				answer++;
				// i의 배수로 돌아아하기때문에 i만큼 증가
				for(int j =i; j<n; j=j+i){
					ch[j] = 1;
				}
			}
		}
		return answer;
	}

	public static void main(String[] args){
		PrimeNumbers T = new PrimeNumbers();
		Scanner kb = new Scanner(System.in);
		int n = kb.nextInt();
		System.out.println(T.solution(n));

	}
}
