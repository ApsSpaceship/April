import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int b = sc.nextInt();

        int[][] board = new int[n][m];

        int sum = 0;
        int minH = 256;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                board[i][j] = sc.nextInt();
                sum += board[i][j];
                minH = Math.min(minH, board[i][j]);
            }
        }

        int maxH = (sum + b) / (n * m);
        int ansT = 987654321;
        int ansH = -1;
        for (int h = maxH; h >= minH; --h) {
            int t = 0;
            for (int i = 0; i < n; ++i) {
                for (int j = 0; j < m; ++j) {
                    int dh = h - board[i][j];
                    if (dh > 0)
                        t += dh;
                    else
                        t += (-2 * dh);
                }
            }
            if (t < ansT) {
                ansT = t;
                ansH = h;
            }
        }
        System.out.println(ansT + " " + ansH);
    }
}