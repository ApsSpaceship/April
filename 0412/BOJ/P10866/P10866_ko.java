import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class P10866_ko {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int N = sc.nextInt();
		Deque<Integer> deque = new LinkedList<>();

		for (int i = 0; i < N; i++) {
			switch (sc.next()) {
			case "push_front":
				deque.addFirst(sc.nextInt());
				break;
			case "push_back":
				deque.addLast(sc.nextInt());
				break;
			case "pop_front":
				if (deque.isEmpty())
					sb.append("-1\n");
				else
					sb.append(deque.pollFirst() + "\n");
				break;
			case "pop_back":
				if (deque.isEmpty())
					sb.append("-1\n");
				else
					sb.append(deque.pollLast() + "\n");
				break;
			case "size":
				sb.append(deque.size() + "\n");
				break;
			case "empty":
				if (deque.isEmpty())
					sb.append("1\n");
				else
					sb.append("0\n");
				break;
			case "front":
				if (deque.isEmpty())
					sb.append("-1\n");
				else
					sb.append(deque.peekFirst() + "\n");
				break;
			case "back":
				if (deque.isEmpty())
					sb.append("-1\n");
				else
					sb.append(deque.peekLast() + "\n");
				break;
			}
		}
		System.out.println(sb.toString());
	}// main

}
