package study0426;

import java.util.Scanner;

public class baekjoon_P1074_Z {
	public static int ans = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); // 2^n * 2^n 의 배열
		int r = sc.nextInt(); // 행
		int c = sc.nextInt(); // 열
		ans = 0; // 몇 번째 방문인지 저장
		int width = (int) Math.pow(2, n);
		dfs(width, r, c);
		System.out.println(ans);

	}

	private static void dfs(int width, int r, int c) {
		if (width == 1) { // 너비가 1이 되면 내가 찾는 바로 그 위치이므로 return 시킨다.
			return;
		}

		if (r < width / 2 && c < width / 2) { // 1사분면
			dfs(width / 2, r, c);
		} else if (r < width / 2 && width / 2 <= c) { // 2사분면
			ans += (width * width) / 4; // 1사분면의 값을 더한다.
			dfs(width / 2, r, c - (width / 2)); // 2사분면을 시작점으로 잡아야 해서 c-(width/2)값을 해 줌!
		} else if (width / 2 <= r && c < width / 2) { // 3사분면
			ans += (width * width) / 4 * 2; // 1,2사분면의 값을 더함
			dfs(width/2, r-(width/2),c); // 3사분면을 시작점으로 잡으려고 r-(width/2) 한다.
		}else {
			ans += (width * width) / 4 * 3; // 1,2,3사분면의 값을 더함
			dfs(width/2, r-(width/2),c - (width / 2));
		}
	}

}
