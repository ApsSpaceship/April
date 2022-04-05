package study_0405;

import java.util.Scanner;
import java.util.Stack;

public class baekjoon_P9012_괄호 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		for(int tn = 1; tn <= tc; tn++ ) {
			Stack<Character> stack = new Stack<>();
			String check = sc.next();
			String ans = "YES";
			for(int i = 0; i < check.length(); i++) {
				if(check.charAt(i) == '(') {
					stack.add(check.charAt(i));
				}else { // 닫는 괄호일 때
					if(stack.empty()) {
						ans = "NO";
					}else {
						stack.pop();
					}
				}
			}
			if(!stack.empty()) {
				ans = "NO";
			}
			System.out.println(ans);
		}
	}

}
