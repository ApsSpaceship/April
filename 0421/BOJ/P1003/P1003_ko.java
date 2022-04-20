import java.util.Scanner;

public class BOJ_1003_피보나치함수 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int N;
		int[] nums;
		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt(); // 수
			nums = new int[N + 2]; // 이전 값 저장
			nums[0] = 1; // 0은 1, 1은 0으로 초기화
			for (int i = 2; i <= N + 1; i++) // 피보나치
				nums[i] = nums[i - 1] + nums[i - 2];

			System.out.println(nums[N] + " " + nums[N + 1]);
		}

	}

}