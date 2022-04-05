import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();

		for (int tc = 1; tc <= t; ++tc) {
			char[] arr = sc.next().toCharArray();
			int cnt = 0;
			String ans = "YES";

			for (int i = 0; i < arr.length; ++i)
				if (arr[i] == '(')
					++cnt;
				else if (arr[i] == ')') {
					if (cnt == 0) {
						ans = "NO";
						break;
					} else
						--cnt;
				}

			if (cnt != 0)
				ans = "NO";
			System.out.println(ans);
		}
	}
}
