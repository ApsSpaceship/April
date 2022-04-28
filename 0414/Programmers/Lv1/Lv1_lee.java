import java.util.Stack;

class Lv1_lee {
	public int solution(int[][] board, int[] moves) {
		// 인형 뽑기 상자 N * N board 5<= N <= 30
		int N = board[0].length;
		// 인형 종류 0 <= x <= 100
		// 0은 빈칸
		// 바구니
		Stack<Integer> stack = new Stack<Integer>();

		// 이동
		int cnt = 0;
		for (int i = 0; i < moves.length; i++) {
			int c = moves[i] - 1;
			for (int j = 0; j <= N - 1; j++) {
				int pick = board[j][c];
				board[j][c] = 0;
				if (pick == 0)
					continue;
				else if (pick > 0) {
					if (stack.isEmpty()) {
						stack.push(pick);
						break;
					} else {
						if (stack.peek() == pick) {
							// 점수 2점 증가
							cnt += 2;
							stack.pop();
						} else
							stack.add(pick);
						break;
					}
				}
			}
		}
		return cnt;
	}
}