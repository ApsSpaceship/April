import java.util.Scanner;

public class bj_10866_덱 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		StringBuilder sb = new StringBuilder();

		int N = sc.nextInt();

		int[] deck = new int[2 * N];

		int size = 0; // 없으면 0

		int st = N;
		int ed = N;

		while (N > 0) {

			String order = sc.next();

			switch (order) {
			case "push_front":

				deck[st--] = sc.nextInt();
				size++;

				break;

			case "push_back":

				deck[++ed] = sc.nextInt();
				size++;
				break;

			case "pop_front":
				if (size > 0) {
					sb.append(deck[st+1]).append("\n");
					size--;
					st++;
				} else {
					sb.append(-1).append("\n");
				}

				break;

			case "pop_back":
				if (size > 0) {
					sb.append(deck[ed]).append("\n");
					size--;
					ed--;
				} else {
					sb.append(-1).append("\n");
				}

				break;

			case "size":
				sb.append(size).append("\n");

				break;

			case "empty":
				if (size > 0) {
					sb.append(0).append("\n");

				} else {
					sb.append(1).append("\n");
				}

				break;

			case "front":
				if (size > 0) {
					sb.append(deck[st+1]).append("\n");

				} else {
					sb.append(-1).append("\n");
				}

				break;

			case "back":

				if (size > 0) {
					sb.append(deck[ed]).append("\n");

				} else {
					sb.append(-1).append("\n");
				}
				break;
			}
			
			N--;

		} // while

		System.out.println(sb.toString());

	}

}
