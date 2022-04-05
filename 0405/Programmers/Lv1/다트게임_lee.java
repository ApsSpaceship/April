class Solution {
	public int solution(String dartResult) {
		// 결과 정수값
		int answer = 0;
		// 각 회 별 점수 입력을 위한 배열의 인덱스
		int idx = 0;
		// 점수 보너스 옵션으로 이루어진 문자열 3세트를 체크하여 몇회인지 체크
		int cnt = 0;
		// * 개수
		int starCnt = 0;
		int[] result = new int[3];
		for (int i = 0; i < dartResult.length(); i++) {
			int type = checkType(dartResult.charAt(i));
			if (i < dartResult.length() - 1 && checkType(dartResult.charAt(i + 1)) == 0 && type == 1) {
				type = 10;
                i++;
			}
			switch (type) {
			case 0:
			case 1:
			case 2:
			case 3:
			case 4:
			case 5:
			case 6:
			case 7:
			case 8:
			case 9:
			case 10:
				if (cnt == 2) {
					cnt = 0;
					idx++;
				}
				result[idx] = type;
				cnt++;
				break;
			case -1:
			case -2:
			case -3:
				int tmp = result[idx];
				for (int j = 1; j < -type; j++) {
					result[idx] *= tmp;
				}
				cnt++;
				break;
			case 11:
				result[idx] *= 2;
				if (idx > 0) {
					result[idx - 1] *= 2;
				}
				idx++;
				cnt = 0;
				break;
			case -11:
				result[idx++] *= -1;
				cnt = 0;
				break;
			}
		}
		for (int i = 0; i < 3; i++) {
			answer += result[i];
		}
		return answer;
	}

	public int checkType(char c) {
		// 점수
		if (c - '0' >= 0 && c - '0' <= 10) {
			// 점수일 때 1 반환
			return c - '0';
		}
		// 보너스 (점수와 구분하기 위해 -)
		if (c == 'S') {
			return -1;
		} else if (c == 'D') {

			return -2;
		} else if (c == 'T') {
			return -3;
		}
		// 옵션
		if (c == '*') {
			return 11;
		}
		if (c == '#') {
			return -11;
		}
		// 출력 될 일은 없음
		return 100;
	}
}
