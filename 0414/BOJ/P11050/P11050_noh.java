import java.util.Scanner;

public class Main {
    static int[][] cache = new int[11][11];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        for (int i = 1; i <= n; ++i)
            cache[i][0] = 1;
        for (int j = 0; j <= k; ++j)
            cache[j][j] = 1;
        for (int i = 2; i <= n; ++i)
            for (int j = 1; j < i; ++j)
                cache[i][j] = cache[i - 1][j] + cache[i - 1][j - 1];

        System.out.println(cache[n][k]);
    }
}