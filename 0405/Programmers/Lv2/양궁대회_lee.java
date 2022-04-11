// tc 2개 시간 초과 에러
class Solution {
	static int maxDiff = -1;
	static int[] answer = { -1 };
	static int[] ryanInfo;
	static int[] apeachInfo;
    static int N;
	public int[] solution(int n, int[] info) {
        // 초기화
		ryanInfo = new int[11];
        // static 으로 변경 (파라미터로 이용하지 않기 위해)
		apeachInfo = info.clone();
        N = n;
        // 재귀함수 호출
		findRyanInfo(0);
		return answer;
	}

	public static void findRyanInfo(int idx) {
        // 과녁 다 맞힌 경우,
		if (idx == N) {
			int apeachScore = 0;
			int ryanScore = 0;
			for (int i = 0; i < 11; i++) {
                // 둘다 0개 맞힌 경우, 점수 획득 X
                if(ryanInfo[i] != 0 || apeachInfo[i] !=0) {
                    // ryan 값이 커야만 ryan이 점수를 얻을 수 있다.
                    if (ryanInfo[i] > apeachInfo[i]) {
                        ryanScore += 10 - i;
                    } else {
                        apeachScore += 10 - i;
                    }
                }
			}
			// ryanScore가 높아야만 이길 수 있다. && 가장 큰 점수차로 이겨야 한다.
			if (ryanScore > apeachScore && ryanScore - apeachScore >= maxDiff) {
				answer = ryanInfo.clone();
				maxDiff = ryanScore - apeachScore;
			}
			return;
		}
        
        // 10점 ~ 0점 중 어피치가 가지고 있는 과녁 개수의 값보다 작거나 같은 경우에만 
		for (int i = 0; i < 11 && ryanInfo[i] <= apeachInfo[i]; i++) {
			ryanInfo[i]++;
            // 하나 더 맞혀서 점수를 얻는 경우 계산 -> 이길 수 없음을 알게 되면, return
			findRyanInfo(idx + 1);
            // return해서 돌아오면, 다시 과녁 개수 원상복구
			ryanInfo[i]--;
		}
         // 다음 점수의 과녁 확인
	}
}
