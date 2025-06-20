package hashMapTreeSet;

import java.util.HashMap;
import java.util.Scanner;

import array.PrimeNumbers;

public class UseHashMap {
	public char solution(int n, String str){
		char answer = 0;
		HashMap<Character, Integer> map = new HashMap<>();
		for( char x : str.toCharArray()){
			map.put(x , map.getOrDefault(x, 0)+1);
		}
		int max = Integer.MIN_VALUE;
		for(char key : map.keySet()){
			// 가장 큰 키의 value가 있다면 answer에 key 값을 넣어준다
			if(map.get(key) > max ){
				max = map.get(key);
				answer = key;
			}
		}
		return answer;
	}

	public static void main(String[] args){
		UseHashMap T = new UseHashMap();
		Scanner kb = new Scanner(System.in);
		int n = kb.nextInt();
		String str = kb.next();
		System.out.println(T.solution(n,str));

	}
}
