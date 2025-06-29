package array;

import java.util.Scanner;

public class FindMaxNum {
	public int solution(int[] arr){
		int max = arr[0]; // 첫 번째 값을 초기 최대값으로 설정
		for(int i = 1; i < arr.length; i++){
			if(arr[i] > max){
				max = arr[i]; // 더 큰 값이 나오면 갱신
			}
		}
		return max;
	}

	public static void main(String[] args){
		FindMaxNum T = new FindMaxNum();
		Scanner kb = new Scanner(System.in);
		int n = kb.nextInt();
		int[] arr = new int[n];
		for( int i = 0; i<n; i++){
			arr[i] = kb.nextInt();
		}
		System.out.println(T.solution(arr));
	}
}