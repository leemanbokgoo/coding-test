package array;

import java.util.ArrayList;
import java.util.Scanner;

import string.StringCompression;

/**
 * N(1<=N<=100)개의 정수를 입력받아 자신의 바로 앞수보다 큰 수만 출력하는 프로그램을 작성한다.(첫번째수는 무조건 출력한다.0
 * 첫줄에 자연수 N이 주어지고 그 다음 줄에 N개의 정수가 입려괻ㄴ다.
 * 자신의 바로 앞 수 보다 큰 수만 한줄로 출력한다.
 *
 * 입력 예제 6 7 3 9 5 6 12 출력예제 7 9 6 12
 */
public class PrintingLargeNumbers {
	public ArrayList<Integer> solution(int n , int[] arr){
		ArrayList<Integer> answer = new ArrayList<>();
		answer.add(arr[0]);
		for(int i=1; i<n; i++){
			if(arr[i] > arr[i-1]){
				answer.add(i);
			}
		}
		return answer;
	}

	public static void main(String[] args){
		PrintingLargeNumbers T = new PrintingLargeNumbers();
		Scanner kb = new Scanner(System.in);
		int n = kb.nextInt();
		int[] arr = new int[n];
		for(int i = 0; i<n; i++) {
			arr[i] = kb.nextInt();
		}
		for(int x: T.solution(n, arr)) {

		}
	}
}
