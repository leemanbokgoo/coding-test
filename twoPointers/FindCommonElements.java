package twoPointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * A,B 두개의 집합이 주어지면 두 집합의 공통 원소를 추출하여 오름차순으로 출력하는 프로그램을 출력한다.
 *
 * 입력예제 5
 * 1 3 9 5 2
 * 3 2 5 7 8
 * 출력예제 2 3 5
 */
public class FindCommonElements {

	public ArrayList<Integer> solution(int n, int m, int[] a, int[] b){
		ArrayList<Integer> answer = new ArrayList<>();
		Arrays.sort(a);
		Arrays.sort(b);
		int p1=0 , p2=0;

		while (p1<n && p2<m){
			if(a[p1] == b[p2]) {
				answer.add(a[p1++]);
				p2++;
			} else if( a[p1] <b[p2]){
				p1++;
			} else {
				p2++;
			}
		}

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
