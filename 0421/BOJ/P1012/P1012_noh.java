import java.util.Scanner;

public class Main {
    static final int[] dy = { 1, -1, 0, 0 };
    static final int[] dx = { 0, 0, 1, -1 };
    static int m, n;
    static int[][] board;
    static boolean[][] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int tc = 1; tc <= t; ++tc) {
            m = sc.nextInt();
            n = sc.nextInt();
            board = new int[n][m];
            visited = new boolean[n][m];
            int k = sc.nextInt();
            for (int i = 0; i < k; ++i) {
                int x = sc.nextInt();
                int y = sc.nextInt();
                board[y][x] = 1;
            }

            int ans = 0;
            for (int i = 0; i < n; ++i)
                for (int j = 0; j < m; ++j)
                    if (board[i][j] == 1 && !visited[i][j]) {
                        dfs(i, j);
                        ++ans;
                    }
            System.out.println(ans);
        }
    }

    static void dfs(int y, int x) {
        if (visited[y][x])
            return;
        visited[y][x] = true;

        for (int d = 0; d < 4; ++d) {
            int ny = y + dy[d];
            int nx = x + dx[d];
            if (0 <= ny && ny < n && 0 <= nx && nx < m && board[ny][nx] == 1)
                dfs(ny, nx);
        }
    }
}