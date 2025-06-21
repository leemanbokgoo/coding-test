package hashMapTreeSet;

import java.util.HashMap;
import java.util.Scanner;

/**
 * 두 문자열이 알파벳의 나열 순서를 다르지만 그 구성이 일치하는 두 단어를 아나그램이라고 한다.
 * AbaAeCe와 baeeACA는 알파벳의 나열 순서는 다르지만 구성을 살펴보면 알파벳과 그 갯수가 동일하다.
 *
 * 입력예제 AbaAeCe baeeACA
 * 출력예제 YEㄴ
 */
public class Anagram {
	public String solution(String s1, String s2){
		String answer = "YES";
		HashMap<Character, Integer> map = new HashMap<>();
		for(char x : s1.toCharArray()){
			map.put(x, map.getOrDefault(x, 0)+1);
		}
		for(char x : s2.toCharArray()){
			// map에 해당 x가 없거나 x의 value가 0이라면 해당 문자열이 s1에 없거나 해당 문자열의 갯수가 s1과 다르다는 이야기 = 아나그램이 아님
			if(!map.containsKey(x) || map.get(x) == 0) return "NO";
			// 카운팅한 문자열의 갯수는 -1 해서 줄여줌 (아나그램은 문자열의 갯수도 같아야하기떄문)
			map.put(x, map.get(x)-1);
		}
		return answer;
	}

	public static void main(String[] args){
		Anagram T = new Anagram();
		Scanner kb = new Scanner(System.in);
		String a = kb.next();
		String b = kb.next();
		System.out.println(T.solution(a,b));

	}
}
