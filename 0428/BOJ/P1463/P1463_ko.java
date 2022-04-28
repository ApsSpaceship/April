import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] nums = new int[N + 2]; // N까지 사용
		Arrays.fill(nums, 30); // 초기화
		nums[0] = 0;
		nums[1] = 0;
		nums[2] = 1;

		for (int i = 3; i <= N; i++) {
			if (i % 3 == 0)
				nums[i] = nums[i / 3] + 1;
			if (i % 2 == 0)
				nums[i] = Math.min(nums[i], nums[i / 2] + 1);
			nums[i] = Math.min(nums[i], Math.min(nums[i - 1] + 1, nums[i - 2] + 2));
		}

		System.out.print(nums[N]);
	}

}