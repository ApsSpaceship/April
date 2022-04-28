import java.util.Stack;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;

        int h = board.length;
        int w = board[0].length;
        Stack<Integer> st = new Stack<Integer>();

        for (int i = 0; i < moves.length; ++i) {
            int x = moves[i] - 1;
            for (int y = 0; y < h; ++y) {
                if (board[y][x] != 0) {
                    if (!st.empty() && st.peek() == board[y][x]) {
                        answer += 2;
                        st.pop();
                    } else
                        st.add(board[y][x]);
                    board[y][x] = 0;
                    break;
                }
            }
        }
        return answer;
    }
}