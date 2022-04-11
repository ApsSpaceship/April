class Solution {
	public int solution(int[][] board, int[][] skill) {
		int answer = 0;

		int n = board.length;
		int m = board[0].length;
		int[][] degreeSum = new int[n + 2][m + 2];

		for (int i = 0; i < skill.length; ++i) {
			int r1 = skill[i][1] + 1;
			int c1 = skill[i][2] + 1;
			int r2 = skill[i][3] + 1;
			int c2 = skill[i][4] + 1;
			int degree = skill[i][5];
			if (skill[i][0] == 1)
				degree *= -1;

			degreeSum[r1][c1] += degree;
			degreeSum[r1][c2 + 1] -= degree;
			degreeSum[r2 + 1][c1] -= degree;
			degreeSum[r2 + 1][c2 + 1] += degree;
		}
		for (int i = 1; i <= n; ++i)
			for (int j = 1; j <= m; ++j) {
				degreeSum[i][j] += (degreeSum[i - 1][j] + degreeSum[i][j - 1] - degreeSum[i - 1][j - 1]);
				board[i - 1][j - 1] += degreeSum[i][j];
				if (board[i - 1][j - 1] >= 1)
					++answer;
			}
		return answer;
	}
}
