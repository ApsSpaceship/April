import java.util.Scanner;

public class Main {
    static int ans = -1;
    static int r;
    static int c;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        r = sc.nextInt();
        c = sc.nextInt();

        int size = (int) Math.pow(2, n);
        solve(size - 1, size - 1, size, 0);

        System.out.println(ans);
    }

    static void solve(int y, int x, int size, int lo) {
        if (size == 1) {
            ans = lo;
            return;
        }
        int half = size / 2;
        if (r <= y - half) {
            if (c <= x - half) {
                solve(y - half, x - half, half, lo);
            } else {
                solve(y - half, x, half, lo + half * half);
            }
        } else {
            if (c <= x - half) {
                solve(y, x - half, half, lo + 2 * half * half);
            } else {
                solve(y, x, half, lo + 3 * half * half);
            }
        }
    }
}