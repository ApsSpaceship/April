
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class programmers_실패율 {
	public static void main(String[] args) {
		int N = 5;
		int[] stages = new int[] {2, 1, 2, 6, 2, 4, 3, 3};
		int l = stages.length;
		int[] stop = new int[N + 1]; // 각 스테이지별 도전중인 사용자 수 담을 배열
		int[] total = new int[N + 1]; // 각 스테이지별 도전 한 사용자 수 담을 배열
		int check = 1;
		for (int i = 0; i < l; i++) {
			for (int j = 1; j < N + 1; j++) {
				if (stages[i] >= j) {
					total[j]++;
				}
				if (stages[i] == j) {
					stop[j]++;
				}
			}
		}
		double[][] fail = new double[N][2]; // [0]: 실패율 , [1]: 스테이지 번호
		for (int i = 0; i < N; i++) {
			// 0으로 나누면 에러나서 값을 아예 넣어줌
			if (stop[i + 1] == 0 || total[i + 1] == 0) {
				fail[i][0] = 0;
			} else {
				fail[i][0] = (double) stop[i + 1] / total[i + 1];
			}
			fail[i][1] = i + 1;
		}

		//실패율에 따라 내림차순으로 정렬해준다.
		Arrays.sort(fail, new Comparator<double[]>() {
			@Override
			public int compare(double[] o1, double[] o2) {
				if ((o1[0] - o2[0]) > 0)
					return -1;
				else if (o1[0] == o2[0])
					return 0;
				
				return 1;
			}
		});
		//스테이지 번호를 정답 배열에 옮겨 담는다.
		int[] ans = new int[N];
		for (int i = 0; i < N; i++) {
			ans[i] = (int) fail[i][1];
		}
		System.out.println(Arrays.toString(ans));
	}

}
