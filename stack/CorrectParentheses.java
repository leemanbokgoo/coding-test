package stack;

import java.util.Collections;
import java.util.Scanner;
import java.util.Stack;
import java.util.TreeSet;

import hashMapTreeSet.LargestNumber;

/**
 * 괄호가 입력되면 올바른 괄호라면 "YES", 올바르지않으면 "NO"를 출력한다.
 * (())() 이것은 괄호의 쌍이 올바르게 위치하는 거지만 (()()))은 올바른 괄호가 아니다.
 *
 * 입력예제 (()(()))(()
 * 출력예제 NO
 */
public class CorrectParentheses {
	public String solution( String str){
		String answer = "YES";
		Stack<Character> stack = new Stack<>();
		for(char x : str.toCharArray()){
			if(x=='(') stack.push(x);
			else{
				if(stack.isEmpty()) return "NO";
				stack.pop();
			}
		}
		if(!stack.isEmpty()) return "NO";
		return answer;
	}

	public static void main(String[] args){
		CorrectParentheses T = new CorrectParentheses();
		Scanner kb = new Scanner(System.in);
		String str = kb.next();
		System.out.println(T.solution(str));
	}
}
