package hashMapTreeSet;

import java.util.Collections;
import java.util.Scanner;
import java.util.TreeSet;

/**
 * 1부터 100사이의 자연수가 적힌 N장의 카드를 가지고 있다. 같은 숫자의 카드가 여러장 있을 수 있다.
 * 이 중 3장을 뽑아 각 카드에 적힌 수를 합한 값을 기록하려고한다. 3장을 뽑을 수 있는 모든 경우를 기록한다.
 * 기록한 값 중 K번째로 큰 수를 출력하는 프로그램을 작성하라
 * 만약 큰수부터 만들어진 수가 25 25 23 23 22 20 19 ..... 이고 K값이 3이라면 K번째 큰 값은 22이다.
 *
 * 입력예제 10 3
 * 13 15 34 23 45 65 33 11 26 42
 * 출력예제 143
 */
public class LargestNumber {
	public int solution( int[] arr, int n , int k){
		int answer = 0;
		// Collections.reverseOrder()를 설정해 내림 차순으로 변경
		TreeSet<Integer> Tset = new TreeSet<>(Collections.reverseOrder());
		for(int i=0; i<n; i++){
			// i가 뽑혔는데 j가 i를 뽑으면 안되기때문에 int j = i+1;이다
			for(int j=i+1; j<n; j++){
				for(int l= j+1; l<n; l++){
					Tset.add(arr[i] + arr[j] + arr[l]);
				}
			}
		}
		int cnt=0;
		for( int x : Tset){
			cnt++;
			if(cnt==k) return x;
		}
		return answer;
	}

	public static void main(String[] args){
		LargestNumber T = new LargestNumber();
		Scanner kb = new Scanner(System.in);
		int n = kb.nextInt();
		int k = kb.nextInt();
		int[] arr = new int[n];
		for(int i=0; i<n; i++){
			arr[i] = kb.nextInt();
		}
		System.out.println(T.solution(arr, n , k));
	}
}
