
import java.util.Stack;

public class lv1_크레인인형뽑기게임 {
	public static void main(String[] args) {

		int[][] board = { { 0, 0, 0, 0, 0 }, { 0, 0, 1, 0, 3 }, { 0, 2, 5, 0, 1 }, { 4, 2, 4, 4, 2 },
				{ 3, 5, 1, 3, 1 } };
		int[] moves = { 1, 5, 3, 5, 1, 2, 1, 4 };
		int answer = 0;

		Stack<Integer> pick = new Stack<>(); // 인형들 옮겨질 스택

		int N = board[0].length;

		int[] idx = new int[N];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (board[i][j] != 0) {
					idx[j]++;
				}
			}
		} // 각 열에 인형 몇 개씩 저장되어 있는지 확인

		for (int i = 0; i < moves.length; i++) {
			if (moves[i] != 0) {
				moves[i] -= 1;
			}
		} // 배열과 인덱스 맞춰줌

		for (int i = 0; i < moves.length; i++) {

			if (idx[moves[i]] != 0) { // 인형이 있을 때
				int r = (N-1) - (idx[moves[i]] - 1);
				int c = moves[i];

				int pickup = board[r][c];

				if (!pick.isEmpty() && pick.peek() == pickup) {
					pick.pop(); // 인형없어짐
					answer += 2;

				} else {
					pick.add(pickup);
				}

				board[r][c] = 0; // 초기화
				idx[moves[i]]--; // 인형개수 감소
			}

		} // 인형 옮기기 작업 완료

		System.out.println(answer);
	}

}
