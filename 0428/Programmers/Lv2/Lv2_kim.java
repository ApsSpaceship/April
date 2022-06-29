package study0428;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Programmers_Lv2_수식최대화2 {
	static String[] sel;
	static boolean[] visited;
	static String[] cal;
	static String check;
	static long max = 0;
	static List<String> listorigin;
	public static void main(String[] args) {
		String expression = "100-200*300-500+20";
		check = expression;
		cal = new String[] { "+", "-", "*" };
		visited = new boolean[3];
		sel = new String[3];
		listorigin = new ArrayList<>();			
		int num = 0;
		for (int i = 0; i < check.length(); i++) {
			if (check.charAt(i) - '0' >= 0 && check.charAt(i) - '0' <= 9) {
				num = num * 10 + (check.charAt(i) - '0');
			} else {
				listorigin.add(Integer.toString(num)); // 숫자 넣어주고
				num = 0; // 초기화
				listorigin.add(Character.toString(check.charAt(i))); // 수식도 넣어주고
			}
		}
		listorigin.add(Integer.toString(num)); // 마지막 남은 숫자 넣어주기
		perm(0);
		System.out.println(max);
	}

	private static void perm(int idx) {
		if (idx == 3) {
			List<String> list = new ArrayList<>();
			for(int i = 0; i < listorigin.size(); i++) {
				list.add(i, listorigin.get(i));
			}// 원본 리스트 복사	         
			for (int j = 0; j < 3; j++) { // 연산
				for (int i = 0; i < list.size(); i++) {
					if(list.get(i).equals(sel[j])) {
						long result = cals(Long.parseLong(list.get(i-1)),Long.parseLong(list.get(i+1)),sel[j]);
						//System.out.println(result);
						list.set(i, Long.toString(result)); // 연산이 있던 위치에 계산된 숫자 저장
						list.remove(i+1); // 뒤에 숫자 지우기
						list.remove(i-1); // 앞에 숫자 지우기
						i--; // 앞 뒤 숫자를 지움으로 인해 변경된 인덱스 맞춰주기 위해서 사용
					}
				}
			}
			max = Math.max(max, Math.abs(Long.parseLong(list.get(0))));

			return;
		}
		for (int i = 0; i < 3; i++) {
			if (!visited[i]) {
				visited[i] = true;
				sel[idx] = cal[i];
				perm(idx + 1);
				visited[i] = false;
			}
		}

	}

	public static long cals(long x, long y, String c) {
		long result = 0;

		switch(c){
		case "+":
			result = x+y;
			break;
		case "*":
			result = x*y;
			break;
		default:
			result = x-y;
		}
		return result;
	}
}
