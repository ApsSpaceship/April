import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class P10845_kim {
	public static class queue {
		static List<Integer> queue = new ArrayList<>();
		static int size = 0;

		public static void push(int num) {
			queue.add(num);
			size++;
		}

		public static int pop() {
			if (size == 0) {
				return -1;
			} else {
				size--;
				return queue.remove(0);
			}
		}

		public static int size() {
			return size;
		}

		public static int empty() {
			if (size == 0) {
				return 1;
			} else {
				return 0;
			}
		}

		public static int front() {
			if (size == 0) {
				return -1;
			} else {
				return queue.get(0);
			}
		}

		public static int back() {
			if (size == 0) {
				return -1;
			} else {
				return queue.get(size-1);
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			String a = sc.next();
			switch (a) {
			case "push":
				queue.push(sc.nextInt());
				break;
			case "front":
				sb.append(queue.front()).append("\n");
				break;
			case "back":
				sb.append(queue.back()).append("\n");
				break;
			case "empty":
				sb.append(queue.empty()).append("\n");
				break;
			case "pop":
				sb.append(queue.pop()).append("\n");
				break;
			case "size":
				sb.append(queue.size).append("\n");
				break;
			}
		}
		System.out.println(sb.toString());
	}

}
