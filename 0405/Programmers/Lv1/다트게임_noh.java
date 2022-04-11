class Solution {
	public int solution(String dartResult) {
		int answer = 0;
		dartResult += " ";
		int[] score = new int[3];
		int idx = 0;
		int i = -1;
		while (idx != 3) {
			++i;
			if (dartResult.charAt(i) == 'S')
				score[idx++] = Integer.parseInt(dartResult.substring(0, i));
			else if (dartResult.charAt(i) == 'D') {
				int num = Integer.parseInt(dartResult.substring(0, i));
				score[idx++] = num * num;
			} else if (dartResult.charAt(i) == 'T') {
				int num = Integer.parseInt(dartResult.substring(0, i));
				score[idx++] = num * num * num;
			} else
				continue;

			if (dartResult.charAt(i + 1) == '*') {
				score[idx - 1] *= 2;
				if (idx - 2 >= 0)
					score[idx - 2] *= 2;
				dartResult = dartResult.substring(i + 2);
			} else if (dartResult.charAt(i + 1) == '#') {
				score[idx - 1] *= -1;
				dartResult = dartResult.substring(i + 2);
			} else {
				dartResult = dartResult.substring(i + 1);
			}
			i = -1;
		}
		answer = score[0] + score[1] + score[2];
		return answer;
	}
}
