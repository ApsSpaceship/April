import java.util.Scanner;

public class bj_10250_ACM호텔 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int tc = 0; tc < T; tc++) {

			int H = sc.nextInt(); // 층수
			int W = sc.nextInt(); // 방수
			int N = sc.nextInt(); // 몇번째 손님

			int nh = 0;
			int nw = 1;

			while (N != 0) {

				nh++;

				if (nh > H) {
					nh = 1;
					nw++;
				}

				N--;
			}
			
			System.out.printf("%d%02d\n", nh,nw);  // 출력 유의하기. nw가 두자리면 0이 안붙음
		} // tc

	}

}
