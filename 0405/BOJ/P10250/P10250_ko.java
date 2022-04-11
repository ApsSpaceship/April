import java.util.Scanner;

public class BOJ_10250_ACM호텔 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int H = sc.nextInt(); // 층 수
			sc.nextInt(); // 방 수 버림
			int N = sc.nextInt(); // 손님 순서
			int ho = N / H; // 호 수
			int floor = N % H; // 층 수

			if (floor > 0) {
				ho++;
			} else
				floor = H;

			System.out.print(floor); // 층 수

			if (ho < 10)
				System.out.print(0);
			System.out.println(ho);
		}
	}

}
