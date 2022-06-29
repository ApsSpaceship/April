import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_1012_유기농배추 {

	static class Point {
		int x;
		int y;

		public Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int[] dx = { -1, 1, 0, 0 }; // 상하좌우
		int[] dy = { 0, 0, -1, 1 };
		for (int tc = 1; tc <= T; tc++) {
			int M = sc.nextInt();// 가로길이
			int N = sc.nextInt();// 세로길이
			int K = sc.nextInt();// 배추개수
			int cnt = 0; // 지금까지 만난 배추 수
			int ans = 0; // 배추 묶음
			int[][] cMap = new int[M][N];

			for (int i = 0; i < K; i++) // 입력
				cMap[sc.nextInt()][sc.nextInt()]++;

			Queue<Point> q = new LinkedList<Point>();
			for (int i = 0; i < M && cnt < K; i++) { // bfs
				for (int j = 0; j < N; j++) {
					if (cMap[i][j] == 0)
						continue;

					cMap[i][j] = 0; // 방문처리
					cnt++; // 배추 만남
					q.add(new Point(i, j));
					while (!q.isEmpty()) {
						Point nowP = q.poll();
						for (int d = 0; d < 4; d++) {
							int nr = nowP.x + dx[d];
							int nc = nowP.y + dy[d];

							if (nr < 0 || nc < 0 || nr == M || nc == N || cMap[nr][nc] == 0)
								continue;
							cMap[nr][nc] = 0; // 방문처리
							cnt++; // 배추 만남
							q.add(new Point(nr, nc));
						}
					}
					ans++; // 묶음 개수 증가
				}
			} // bfs

			System.out.println(ans);

		} // tc

	}

}