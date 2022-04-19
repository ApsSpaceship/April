import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int n = sc.nextInt();
        int[] arr = new int[n + 1];
        int[] sorted = new int[n + 1];
        int[] cnt = new int[10001];
        for (int i = 1; i <= n; ++i) {
            arr[i] = sc.nextInt();
            ++cnt[arr[i]];
        }

        for (int i = 1; i <= 10000; ++i)
            cnt[i] += cnt[i - 1];
        for (int i = n; i >= 1; --i)
            sorted[cnt[arr[i]]--] = arr[i];

        for (int i = 1; i <= n; ++i)
            sb.append(sorted[i] + "\n");
        System.out.print(sb);
    }
}