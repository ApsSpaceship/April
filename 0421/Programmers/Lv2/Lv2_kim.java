package study0421;

import java.util.Stack;

public class Programmers_괄호변환 {
	public static void main(String[] args) {
		String p = "()))((()";
		String ans = check(p);
		System.out.println(ans);
	}

	public static String check(String p) {
		if (p.length() == 0) {
			return "";
		}
		int point = 0;
		int open = 0;
		int close = 0;
		for (int i = 0; i < p.length(); i++) {
			if (p.charAt(i) == '(') {
				open++;
			} else {
				close++;
			}
			if (close == open) {
				point = i + 1;
				break;
			}
		}
		String u = p.substring(0, point);
		String v = p.substring(point, p.length());

		if (right(u)) { // u가 올바른 문자열일 때
			String s = check(v);
			return u + s;
		} else {
			String s = "";
			s += "(";
			s += check(v);
			s += ")";
			for (int i = 1; i < u.length() - 1; i++) {
				if (u.charAt(i) == '(')
					s += ')';
				else
					s += '(';
			}
			return s;
		}
	}

	// 올바른 배열인지 확인!
	public static boolean right(String s) {
		Stack<Character> stack = new Stack<>();
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '(') {
				stack.add(s.charAt(i));
			} else {
				if (stack.isEmpty()) {
					return false;
				} else {
					stack.pop();
				}
			}
		}
		return true;
	}

}
