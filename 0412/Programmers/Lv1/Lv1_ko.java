import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public int[] solution(int N, int[] stages) {
      int[] answer = new int[N];
		double[][] fail = new double[N + 2][2]; // 1 ~ N+1 인덱스 사용

		// 0번 인덱스에는 스테이지 번호 저장
		// 1번 인덱스에는 해당 스테이지 실패율
		int[] sum = new int[N + 1]; // 1 ~ N 인덱스 사용
		int userSize = stages.length;
		for (int i = 1; i <= userSize; i++) {
			fail[stages[i - 1]][1]++; // 스테이지 별 유저 수
		}

		for (int i = 1; i <= N; i++) {
			fail[i][0] = i; // 스테이지 번호 저장
			sum[i] += sum[i - 1] + fail[i][1]; // 유저 누적합

			// 실패율 = 스테이지 유저 수 / (size-누적합[i-1])
			int userNow = userSize - sum[i - 1];
			if (userNow > 0) // 남은 유저 수 없으면 끝
				fail[i][1] = fail[i][1] / userNow; // 실패율
		}
		
		Arrays.sort(fail, new Comparator<double[]>() { // 정렬
			@Override
			public int compare(double[] f1, double[] f2) {
				if (f1[1] > f2[1])
					return -1;
				if (f1[1] < f2[1])
					return 1;
				return 0;
			}
		});

		int idx = 0; // answer의 인덱스
		for (int i = 0; i < N + 2; i++) 
			if ( fail[i][0] != 0 && fail[i][0] != N + 1) // 스테이지 번호 0과 N+1의 값은 제외
			    answer[idx++] = (int) fail[i][0];

		return answer;
    }
}