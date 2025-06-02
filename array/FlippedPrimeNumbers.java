package array;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * N개의 자연수가 입력되면 각 자연수를 뒤집은 후 그 뒤집은 수가 소수이면 소수를 출력한다.
 * 첫자리가 0이면 0은 무시한다.
 *
 * 첫줄에 자연수의 개수 N(3<=N<=100)이 주어지고 그 다음 줄에 N개의 자연수가 주어진다.
 * 각 자연수의 크기는 100000를 넘지안흔다.
 *
 * 입력예제 9 | 32 55 62 20 250 370 200 30 100
 * 출력예제 23 2 73 2 3
 */
public class FlippedPrimeNumbers {

	public boolean isPrime(int num){
		if(num==1) return false;
		for(int i=2; i<num; i++){
			if(num%i==0) return false;
		}
		return true;
	}
	public ArrayList<Integer> solution(int n, int[] arr){
		ArrayList<Integer> answer = new ArrayList<>();
		for(int i=0; i<n; i++){
			int tmp = arr[i];
			int res = 0;
			while (tmp>0){
				int t = tmp%10;
				res = res*10+t;
				tmp = tmp/10;
			}
			if(isPrime(res)) answer.add(res);
		}
		return answer;
	}

	public static void main(String[] args){
		FlippedPrimeNumbers T = new FlippedPrimeNumbers();
		Scanner kb = new Scanner(System.in);
		int n = kb.nextInt();
		int[] arr = new int[n];
		for(int i=0; i<n; i++){
			arr[i] = kb.nextInt();
		}
		for(int x : T.solution(n, arr)){
			System.out.println(x+" ");
		}
	}
}
