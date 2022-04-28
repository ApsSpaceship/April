import java.util.Stack;

public class PRO_lv1_크레인인형뽑기게임 {

	public int solution(int[][] board, int[] moves) {
		int answer = 0;
		Stack<Integer> stack = new Stack<>(); // 뽑은 인형
		int bSize = board[0].length;
		int mSize = moves.length;
		int[] top = new int[bSize]; // 맨 위 인형 위치
		for (int i = 0; i < bSize; i++) {
			int idx = -1;
			while (++idx < bSize && board[idx][i] == 0) {
			}
			top[i] = idx;
		}
		for (int i = 0; i < mSize; i++) {
			int point = moves[i] - 1; // moves 값이 1에서 시작

			if (top[point] < bSize) { // 인형이 남았다면
				if (!stack.isEmpty() && board[top[point]][point] == stack.peek()) {
					stack.pop(); // 스택의 맨 위 인형과 일치하면 없어짐
					answer += 2;
				} else // 스택에 저장
					stack.add(board[top[point]][point]);
				top[point]++; // 맨 위 인형 위치 변경
			}
		}
		return answer;
	}

}