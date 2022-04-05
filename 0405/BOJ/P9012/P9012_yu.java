import java.util.Scanner;
import java.util.Stack;

public class bj_9012_괄호 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int tc = 0; tc < T; tc++) {

			String[] ps = sc.next().split("");

			Stack<String> stack = new Stack<>();

			boolean vps = true;

			for (int i = 0; i < ps.length; i++) {

				switch (ps[i]) {
				case "(":
					stack.add(ps[i]);
					break;

				case ")":
					if (stack.isEmpty() || !stack.peek().equals("(")) {
						vps = false;
					} else {
						stack.pop();
					}
					break;
				}

			} // for

			if (!stack.isEmpty() || !vps) {
				System.out.println("NO");
			} else {
				System.out.println("YES");
			}

		} // tc

	}

}
