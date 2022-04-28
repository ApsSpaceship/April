import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] cache = new int[n + 1];

        cache[1] = 0;
        for (int i = 2; i <= n; ++i) {
            cache[i] = cache[i - 1] + 1;
            if (i % 3 == 0)
                cache[i] = Math.min(cache[i], cache[i / 3] + 1);
            if (i % 2 == 0)
                cache[i] = Math.min(cache[i], cache[i / 2] + 1);
        }
        System.out.println(cache[n]);
    }
}