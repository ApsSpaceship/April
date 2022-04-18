import java.util.Scanner;

public class BOJ_15829_Hashing {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long sum = 0;
		long pow = 1;
		int M = 1234567891;

		int L = sc.nextInt();
		String str = sc.next();
		char[] nums = str.toCharArray();

		for (int i = 0; i < L; i++) { // (A * B) mod M = ((A mod M) * (B mod M)) mod M
			sum += (nums[i] - 'a' + 1) * pow % M;
			pow = pow * 31 % M;
		}

		System.out.print(sum % M);
	}
}