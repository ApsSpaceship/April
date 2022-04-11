import java.util.Scanner;

public class bj_10816_숫자카드2 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		StringBuilder sb = new StringBuilder();

		int N = sc.nextInt();

		int[] plus = new int[10000001];
		int[] minus = new int[10000001];

		for (int i = 0; i < N; i++) {

			int num = sc.nextInt();

			if (num < 0) {
				
				num = Math.abs(num);
				minus[num]++;
			} else {
				plus[num]++;
			}

		}

		int M = sc.nextInt();

		for (int i = 0; i < M; i++) {

			int check = sc.nextInt();

			if (check < 0) {

				check = Math.abs(check);
				sb.append(minus[check]).append(" ");
			} else {
				sb.append(plus[check]).append(" ");
			}

		}
		
		System.out.println(sb.toString());

	}

}
