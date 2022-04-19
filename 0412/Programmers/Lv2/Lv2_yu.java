import java.util.Scanner;
import java.util.Stack;

public class lv2_k진수에서소수개수구하기 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		int k = sc.nextInt();

		Stack<Integer> stack = new Stack<>();

		while (n > 0) {

			stack.add(n % k);

			n = n / k;

		}

		String num = "";

		while (!stack.isEmpty()) {
			num += stack.pop();
		}

		String[] split = num.split("0");

		int answer = 0;

		for (int i = 0; i < split.length; i++) {

			if (!split[i].equals("") && isPrime(split[i])) {
				answer++;
			}
		}

		System.out.println(answer);

	}// main

	public static boolean isPrime(String word) {

		long N = Long.parseLong(word); // 여기가 원래는 int

		if (N == 1) {
			return false;
		} else if (N == 2) {
			return true;
		}

		for (long i = 2; i <= Math.sqrt(N); i++) {
			if (N % i == 0)
				return false;
		}

		return true;
	}

}
