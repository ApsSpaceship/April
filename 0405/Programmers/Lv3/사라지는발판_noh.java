class Solution {
	static int[] dy = { 1, -1, 0, 0 };
	static int[] dx = { 0, 0, 1, -1 };
	static int Y, X;

	public int solution(int[][] board, int[] aloc, int[] bloc) {
		int answer = -1;
		Y = board.length;
		X = board[0].length;
		answer = solve(0, 0, board, aloc, bloc).cnt;
		return answer;
	}

	public Pair solve(int toggle, int cnt, int[][] board, int[] aloc, int[] bloc) {
		boolean move = false;
		boolean same = false;
		if (aloc[0] == bloc[0] && aloc[1] == bloc[1])
			same = true;

		Pair ret = new Pair(2, 0);
		if (toggle == 0) {
			int y = aloc[0];
			int x = aloc[1];
			for (int i = 0; i < 4; ++i) {
				int ny = y + dy[i];
				int nx = x + dx[i];
				if (0 <= ny && ny < Y && 0 <= nx && nx < X && board[ny][nx] == 1) {
					move = true;
					if (move && same)
						return new Pair(toggle, cnt + 1);
					board[y][x] = 0;
					aloc[0] = ny;
					aloc[1] = nx;
					ret = select(toggle, ret, solve(1 - toggle, cnt + 1, board, aloc, bloc));
					board[y][x] = 1;
					aloc[0] = y;
					aloc[1] = x;
				}
			}
		} else {
			int y = bloc[0];
			int x = bloc[1];
			for (int i = 0; i < 4; ++i) {
				int ny = y + dy[i];
				int nx = x + dx[i];
				if (0 <= ny && ny < Y && 0 <= nx && nx < X && board[ny][nx] == 1) {
					move = true;
					if (move && same)
						return new Pair(toggle, cnt + 1);
					board[y][x] = 0;
					bloc[0] = ny;
					bloc[1] = nx;
					ret = select(toggle, ret, solve(1 - toggle, cnt + 1, board, aloc, bloc));
					board[y][x] = 1;
					bloc[0] = y;
					bloc[1] = x;
				}
			}
		}

		if (!move)
			return new Pair(1 - toggle, cnt);
		return ret;
	}

	public Pair select(int toggle, Pair p1, Pair p2) {
		if (p1.winner == 2)
			return p2;

		Pair ret1 = new Pair(-1, -1);
		Pair ret2 = new Pair(-1, -1);
		if (p1.winner == 0 && p2.winner == 0) {
			if (p1.cnt < p2.cnt) {
				ret1 = p1;
				ret2 = p2;
			} else {
				ret1 = p2;
				ret2 = p1;
			}
		} else if (p1.winner == 0 && p2.winner == 1) {
			ret1 = p1;
			ret2 = p2;
		} else if (p1.winner == 1 && p2.winner == 0) {
			ret1 = p2;
			ret2 = p1;
		} else if (p1.winner == 1 && p2.winner == 1) {
			if (p1.cnt > p2.cnt) {
				ret1 = p1;
				ret2 = p2;
			} else {
				ret1 = p2;
				ret2 = p1;
			}
		}
		if (toggle == 0)
			return ret1;
		return ret2;
	}

	class Pair {
		int winner;// 0이면 a, 1이면 b
		int cnt;

		public Pair(int winner, int cnt) {
			super();
			this.winner = winner;
			this.cnt = cnt;
		}
	}
}
