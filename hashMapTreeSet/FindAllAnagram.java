package hashMapTreeSet;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * S문자열과 T문자열과 아나그램이 되는 S의 부분 문자열의 갯수를 구하는 프로그램을 작성해야함.
 * 대소문자를 구분하며 부분 문자열은 연속된 문자열이어야한다.
 *
 * 입력예제 bacaAacba
 * abc
 * 출력예제 3
 */
public class FindAllAnagram {
	public int solution( String a, String b){
		int answer = 0;
		HashMap<Character, Integer> am = new HashMap<>();
		HashMap<Character, Integer> bm = new HashMap<>();
		// b를 먼저 셋팅
		for( char x : b.toCharArray() ){
			bm.put(x, bm.getOrDefault(x, 0)+1);
		}
		// B의 길이-1만큼 A string을 만들어야한다.
		int L = b.length()-1;
		for(int i=0; i<L; i++) am.put(a.charAt(i), am.getOrDefault(a.charAt(i), 0)+1);
		// 투 포인트 알고리즘 사용
		int lt=0;
		for(int rt=L; rt<a.length(); rt++){
			am.put(a.charAt(rt), am.getOrDefault(a.charAt(rt), 0)+1);
			// am과 bm이 같다면 아나그램임으로 answer 카운팅
			if(am.equals(bm)) answer++;
			// lt를 한칸 옆으로 이동
			am.put(a.charAt(lt), am.get(a.charAt(lt))-1);
			// lt가 0이면 한칸 옆으로 이동 한 것임으로 해당 값을 삭제 해줘서 윈도우를 밀어야한다.
			if(am.get(a.charAt(lt)) == 0 ) am.remove(a.charAt(lt));
			lt++;
		}

		return answer;
	}

	public static void main(String[] args){
		FindAllAnagram T = new FindAllAnagram();
		Scanner kb = new Scanner(System.in);
		String a = kb.next();
		String b = kb.next();
		System.out.println(T.solution(a,b));
	}
}
