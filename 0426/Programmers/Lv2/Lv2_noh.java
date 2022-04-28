import java.util.LinkedList;
import java.util.Queue;

class Solution {
    static final int[] dy = { 1, -1, 0, 0 };
    static final int[] dx = { 0, 0, 1, -1 };
    static char[][] board;
    static boolean[][] visited;

    public int[] solution(String[][] places) {
        int[] answer = {};
        answer = new int[5];

        for (int room = 0; room < 5; ++room) {
            board = new char[5][5];
            for (int y = 0; y < 5; ++y)
                board[y] = places[room][y].toCharArray();

            int ans = 1;
            for (int i = 0; i < 5; ++i)
                for (int j = 0; j < 5; ++j)
                    if (board[i][j] == 'P' && ans != 0)
                        ans *= bfs(i, j);

            answer[room] = ans;
        }

        return answer;
    }

    static int bfs(int i, int j) {
        visited = new boolean[5][5];
        Queue<int[]> q = new LinkedList<int[]>();
        q.add(new int[] { i, j });

        int dist = 0;
        while (!q.isEmpty() && (dist++) <= 1) {
            int size = q.size();
            for (int s = 0; s < size; ++s) {
                int y = q.peek()[0];
                int x = q.poll()[1];

                if (visited[y][x])
                    continue;
                visited[y][x] = true;

                for (int d = 0; d < 4; ++d) {
                    int ny = y + dy[d];
                    int nx = x + dx[d];

                    if (ny < 0 || 5 <= ny || nx < 0 || 5 <= nx || visited[ny][nx])
                        continue;
                    if (board[ny][nx] == 'P')
                        return 0;
                    if (board[ny][nx] == 'O') {
                        q.add(new int[] { ny, nx });
                    }
                }
            }
        }
        return 1;
    }
}