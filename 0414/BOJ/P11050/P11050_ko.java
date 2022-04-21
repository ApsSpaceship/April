import java.util.Scanner;

public class BOJ_11050_이항계수 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		K = K < N - K ? K : N - K; // nCk에서 k
		int ans = 1;
		for (int i = N; i > N - K; i--) { // 분자
			ans *= i;
		}
		for (int i = 1; i <= K; i++) { // 분모
			ans /= i;
		}
		
		System.out.print(ans);
	}
}