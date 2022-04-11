import java.util.Scanner;

public class bj_10828_스택 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		int[] stack = new int[N];

		StringBuilder sb = new StringBuilder();

		int size = -1;

		while (N > 0) {

			String order = sc.next();

			switch (order) {

			case "push":
				stack[++size] = sc.nextInt();

				break;
			case "pop":
				if (size > -1) {
					sb.append(stack[size]).append("\n");
					// System.out.println(stack[size]);
					size--;

				} else {
					sb.append(-1).append("\n");
					// System.out.println(-1);
				}
				break;

			case "size":
				sb.append(size + 1).append("\n");
				// System.out.println(size+1);
				break;

			case "empty":
				if (size > -1) {
					sb.append(0).append("\n");
					// System.out.println(0);
				} else {
					sb.append(1).append("\n");
					// System.out.println(1);
				}
				break;

			case "top":
				if (size > -1) {
					sb.append(stack[size]).append("\n");
					// System.out.println(stack[size]);
				} else {
					sb.append(-1).append("\n");
					// System.out.println(-1);
				}

				break;
			}

			N--;

		} // while

		System.out.println(sb.toString());

	}

}
