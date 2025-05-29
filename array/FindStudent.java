package array;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 선생님이 N명의 학생을 일렬로 세울 때 일렬로 서 있는 학생의 키가 앞에서부터 순서대로 주어질때 맨 앞에 서 있는 선생님이 볼수 있는 학생 수를 구하시오
 * 어떤 학생이 자기 앞에 서 있는 학생들보다 크면 그 학생은 보이고 작거나 같으면 보이지않는다.
 *
 * 첫줄에 정수 N(5<N<100,000)이 입력된다. 그 다음 줄에 N명의 학생의 키가 앞에서부터 순서대로 주어진다.
 *
 * 입력 예제 8 : 130 135 148 140 150 150 153 출력예제 5
 */
public class FindStudent {
	public int solution(int n , int[] arr){
		int answer = 1, max = arr[0];
		for(int i = 1; i<n; i++){
			if(arr[i] >max) {
				answer++;
				max = arr[i];
			}
		}
		return answer;
	}

	public static void main(String[] args){
		FindStudent T = new FindStudent();
		Scanner kb = new Scanner(System.in);
		int n = kb.nextInt();
		int[] arr = new int[n];
		for( int i = 0; i<n; i++){
			arr[i] = kb.nextInt();
		}
		System.out.println(T.solution(n, arr));
	}
}
