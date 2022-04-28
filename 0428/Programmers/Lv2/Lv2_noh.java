import java.util.ArrayList;
import java.util.List;

class Solution {
	static final char[][] order = { { '+', '-', '*' }, { '+', '*', '-' }, { '-', '+', '*' }, { '-', '*', '+' }, { '*', '+', '-' }, { '*', '-', '+' } };

	public long solution(String expression) {
		long answer = 0;

		int len = expression.length();
		List<String> list = new ArrayList<String>();
		int temp = 0;
		for (int i = 0; i < len; ++i) {
			char c = expression.charAt(i);
			if (c == '+' || c == '-' || c == '*') {
				list.add(expression.substring(temp, i));
				list.add(expression.substring(i, i + 1));
				temp = i + 1;
			}
		}
		list.add(expression.substring(temp, len));

		for (int i = 0; i < 6; ++i) {
			List<String> tempList = new ArrayList<String>();
			for (int copy = 0; copy < list.size(); ++copy)
				tempList.add(list.get(copy));

			for (int j = 0; j < 3; ++j) {
				for (int k = 0; k < tempList.size(); ++k) {
					if (tempList.get(k).charAt(0) == order[i][j]) {
						long a = Long.parseLong(tempList.get(k - 1));
						char oper = order[i][j];
						long b = Long.parseLong(tempList.get(k + 1));

						switch (oper) {
						case '+':
							tempList.set(k - 1, Long.toString(a + b));
							break;
						case '-':
							tempList.set(k - 1, Long.toString(a - b));
							break;
						case '*':
							tempList.set(k - 1, Long.toString(a * b));
							break;
						}
						tempList.remove(k);
						tempList.remove(k);
						--k;
					}
				}
			}
			answer = Math.max(answer, Math.abs(Long.parseLong(tempList.get(0))));
		}
		return answer;
	}
}
