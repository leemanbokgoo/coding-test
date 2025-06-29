package array;

import java.util.Scanner;

public class NumberSort {
	public int[] solution(int[] arr){
		int n = arr.length;
		// 버블 정렬을 사용해 비교
		// 버블 정렬 : 인접한 두 수를 계속 비교해서 큰 수를 오른쪽으로 보내는 방식.
		for(int i = 0; i < n - 1; i++){
			// j < n - i - 1하는 이유는 버블 정렬은 큰 값을 오른쪽 끝으로 보내는 과정을 여러 번 반복하기 때문에 한 바퀴 돌고 나면, 가장 큰 값이 맨 끝에 간다.
			//  즉, 한 바퀴가 끝날 때마다 마지막에 있는 값 하나는 정렬 완료된 상태이다. 그래서 i번째 반복이 끝나면, 마지막 i개의 값은 이미 정렬되었기 때문에, 다음 반복에서는 비교할 필요가 없다.
			//  그걸 코드로 표현한 게 n - i - 1이다.
			for(int j = 0; j < n - i - 1; j++){
				if(arr[j] > arr[j + 1]){
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}
		}
		return arr;
	}

	public static void main(String[] args){
		NumberSort T = new NumberSort();
		Scanner kb = new Scanner(System.in);
		int n = kb.nextInt();
		int[] arr = new int[n];
		for(int i = 0; i < n; i++){
			arr[i] = kb.nextInt();
		}
		for(int x : T.solution(arr)){
			System.out.print(x + " ");
		}
	}
}
