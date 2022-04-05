
import java.util.Scanner;

public class bj_7568_덩치 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		StringBuilder sb = new StringBuilder();

		int T = sc.nextInt();

		int[] weight = new int[T];
		int[] hight = new int[T];

		for (int i = 0; i < T; i++) {

			weight[i] = sc.nextInt();
			hight[i] = sc.nextInt();

		} // tc

		for (int i = 0; i < T; i++) {

			int cnt = 0;

			for (int j = 0; j < T; j++) {

				if (weight[i] < weight[j] && hight[i] < hight[j]) {
					cnt++;
				}
			}

			sb.append(cnt+1).append(" ");

		}

		System.out.println(sb.toString());
	}

}
