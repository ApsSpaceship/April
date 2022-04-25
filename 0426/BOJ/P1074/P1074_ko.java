import java.util.Scanner;

public class BOJ_1074_Z {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = (int) Math.pow(2, sc.nextInt()) / 2;
		int r = sc.nextInt();
		int c = sc.nextInt();
		int x = 0; // 현재 좌표
		int y = 0;
		int ans = 0; // 현재 값

		while (N > 0) { // 4사분면 중 해당하는 곳으로 이동
			if (r >= x + N && c < y + N) { // 3사분면
				ans += N * N * 2;
				x += N;
			} else if (r >= x + N) { // 4사분면
				ans += N * N * 3;
				x += N;
				y += N;
			} else if (c >= y + N) { // 2사분면
				ans += N * N;
				y += N;
			}
			N /= 2;
		}

		System.out.print(ans);
	}

}