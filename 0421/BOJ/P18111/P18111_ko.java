import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_18111_마인크래프트 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] brSub = br.readLine().split(" ");
		int N = Integer.parseInt(brSub[0]); // 세로
		int M = Integer.parseInt(brSub[1]); // 가로
		int B = Integer.parseInt(brSub[2]); // 인벤토리 안 블럭 개수
		int[][] vMap = new int[N][M];
		int vMin = 256; // 블럭 높이 최소
		int vMax = 0; // 블럭 높이 최대
		int time = Integer.MAX_VALUE; // 시간 최대
		int high = 0; // 높이 최소

		for (int i = 0; i < N; i++) {
			brSub = br.readLine().split(" ");

			for (int j = 0; j < M; j++) {
				vMap[i][j] = Integer.parseInt(brSub[j]);
				vMax = Math.max(vMax, vMap[i][j]);
				vMin = Math.min(vMin, vMap[i][j]);
			}
		}

		for (int i = vMax; i >= vMin; i--) { // 맞출 높이

			int nTime = 0; // 이번에 걸린 시간 초기화
			int inventory = B; // 인벤토리 초기화

			for (int j = 0; j < vMap.length; j++) {
				for (int k = 0; k < vMap[j].length; k++) {
					int d = vMap[j][k] - i; // 높이 차
					int dAbs = Math.abs(d); // 차이나는 블럭 개수

					if (d > 0) { // 블럭 제거
						nTime += dAbs * 2; // 2초 * 블럭개수
						inventory += dAbs;
					} else { // 인벤토리에 추가
						nTime += dAbs; // 1초 * 블럭 개수
						inventory -= dAbs;
					}
				}
			}

			if (inventory >= 0 && nTime < time) { // 인벤토리 이상 없으면 시간 최솟값 비교
				time = nTime;
				high = i;
			}
		}

		System.out.print(time + " " + high);
	}

}