import java.util.Scanner;

public class BOJ_7568_덩치 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // 전체 사람 수
		int[] x = new int[N]; // 몸무게
		int[] y = new int[N]; // 키
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			x[i] = sc.nextInt();// 몸무게
			y[i] = sc.nextInt();// 키
		}
		for (int i = 0; i < N; i++) {
			int sum = 1;
			for (int j = 0; j < N; j++)
				if (x[i] < x[j] && y[i] < y[j])
					sum++;

			sb.append(sum + " ");
		}
		System.out.println(sb);
	}

}
