import java.util.Scanner;

public class bj_10845_큐 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		StringBuilder sb = new StringBuilder();

		int N = sc.nextInt();

		int[] queue = new int[N];

		int size = -1;
		int st = 0;
		int ed = -1;

		while (N > 0) {

			String order = sc.next();

			switch (order) {
			case "push":

				queue[++ed] = sc.nextInt();
				size++;
				break;

			case "pop":

				if (size>= 0) {
					sb.append(queue[st]).append("\n");
					st++;
					size--;
				} else {
					sb.append(-1).append("\n");
				}

				break;

			case "size":
				sb.append(size + 1).append("\n");
				break;

			case "empty":
				if (size >= 0) {
					sb.append(0).append("\n");
				} else {
					sb.append(1).append("\n");
				}

				break;

			case "front":

				if (size >= 0) {
					sb.append(queue[st]).append("\n");
				} else {
					sb.append(-1).append("\n");
				}
				break;

			case "back":
				if (size >= 0) {
					sb.append(queue[ed]).append("\n");
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
