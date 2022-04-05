
	public static int solution(String dartResult) {
		int answer = 0; // 총 점수
		char[] dart = dartResult.toCharArray();
		int size = dart.length;
		int preScore = 0; // 전 스코어 0으로 초기화
		int nowScore = 0; // 이번 스코어
		for (int i = 0; i < size; i++) {
			if (dart[i] == '1' && dart[i + 1] == '0') { // 10인 경우
				i++;
				nowScore = 10;
			} else // 나머지 숫자인 경우
				nowScore = dart[i] - '0';
			i++;

			if (dart[i] == 'T') // S면 그대로고 T와 D인 경우 구함
				nowScore *= nowScore * nowScore;
			else if (dart[i] == 'D')
				nowScore *= nowScore;

			if (i + 1 < size && dart[i + 1] < '0') { // *이나 #가 있다면
				i++;
				if (dart[i] == '*') {
					nowScore += nowScore; // 이번 점수 두 배
					answer += preScore; // 이전 점수 두 배
				} else // #인 경우 -
					nowScore = -nowScore;

			}

			answer += nowScore; // 이번 점수 더하기
			preScore = nowScore; // 이번 점수를 이전 점수에 대입
		}

		return answer;
	}

