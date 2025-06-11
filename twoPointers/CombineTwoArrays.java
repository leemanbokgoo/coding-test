package twoPointers;

import java.util.ArrayList;
import java.util.Scanner;

import array.Mentoring;

/**
 * 오름차순으로 정렬이된 두 배열이 주어지면 두 배열을 오름차순으로 합쳐 출력하시오.
 *
 * 입력예제 3
 * 1 3 5
 * 5
 * 2 3 6 7 9
 * 출력예제 1 2 3 3 5 6 7 9
 */
public class CombineTwoArrays {

	public ArrayList<Integer> solution(int n, int m, int[] a, int[] b){
		//two Pointer 알고리즘을 사용해야한다.
		ArrayList<Integer> answer = new ArrayList<>();
		int p1=0, p2=0; // 포인터로 배열의 index를 나타낸다.
		// 두 배열 중에 하나라도 전부 돌고난 후에는 멈춘다.
		while( p1<n && p2<m){
			// answer.add(a[p1++] 이렇게 하면 p1이 가르키는 값을 add한 후에 p1값을 1증가시킨다.
			if(a[p1] < b[p2]) answer.add(a[p1++]);
			else answer.add(b[p2++]);
		}
		// 두 배열의 크기가 다르기때문에 어느 한쪽이 먼저 중단된 경우 남은 배열의 값을 answer에 더해줘야한다.
		// 어떤 배열이 남았을 지 알 수 없기때문에 두가지 경우 둘다 코딩해줘야함.
		while (p1<n) answer.add(a[p1++]);// a 배열이 남은 경우
		while (p2<m) answer.add(b[p2++]);// b 배열이 남은 경우

		return answer;
	}

	public static void main(String[] args){
		CombineTwoArrays T = new CombineTwoArrays();
		Scanner kb = new Scanner(System.in);
		int n = kb.nextInt();
		int[] a = new int[n];
		for(int i = 0; i<n; i++) {
			a[i] = kb.nextInt();
		}
		int m =kb.nextInt();
		int[] b = new int[m];
		for(int i=0; i<m; i++){
			b[i] = kb.nextInt();
		}
		for(int x : T.solution(n, m , a , b))
			System.out.println(x + " ");
	}
}
