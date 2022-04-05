import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();

		for (int tc = 1; tc <= t; ++tc) {
			int h = sc.nextInt();
			int w = sc.nextInt();
			int n = sc.nextInt();

			int ans = 0;
			ans += (((n - 1) % h + 1) * 100);
			ans += ((n - 1) / h + 1);
			System.out.println(ans);
		}
	}
}
