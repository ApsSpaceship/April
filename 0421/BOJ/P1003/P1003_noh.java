import java.util.Scanner;

public class Main {
    static long[][] cache = new long[41][2];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        fib(40);
        int t = sc.nextInt();
        for (int tc = 1; tc <= t; ++tc) {
            int n = sc.nextInt();

            System.out.println(cache[n][0] + " " + cache[n][1]);
        }
    }

    static void fib(int n) {
        if (n == 0) {
            cache[0][0] = 1;
            return;
        }
        if (n == 1) {
            cache[1][1] = 1;
            return;
        }
        if (cache[n][0] != 0 || cache[n][1] != 0) {
            return;
        }

        fib(n - 1);
        fib(n - 2);
        cache[n][0] = cache[n - 1][0] + cache[n - 2][0];
        cache[n][1] = cache[n - 1][1] + cache[n - 2][1];
    }
}