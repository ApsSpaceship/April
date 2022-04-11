import java.util.Scanner;
import java.util.Stack;

public class bj_10773_제로 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int K = sc.nextInt();

		Stack<Integer> s = new Stack<>();

		for (int i = 0; i < K; i++) {

			int num = sc.nextInt();

			if (num == 0) {

				s.pop();
			} else {

				s.add(num);
			}

		} // 과정 끝

		int sum = 0;

		while (!s.isEmpty()) {

			sum += s.pop();
		}

		System.out.println(sum);

	}

}
