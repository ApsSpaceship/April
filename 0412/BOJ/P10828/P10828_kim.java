
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class P10828_kim {
	public static class stack {
		static int top = -1;
		static List<Integer> stack = new ArrayList<>();

		public static void push(int num) {
			top++;
			stack.add(num);
		}

		public static boolean isEmpty() {
			if (stack.size() == 0) {
				return true;
			} else {
				return false;
			}
		}

		public static int pop() {
			if (stack.size() == 0) {
				return -1;
			} else {
				return stack.remove(top--);
			}
		}

		public static int top() {
			if (stack.size() == 0) {
				return -1;
			} else {
				return stack.get(top);
			}
		}

		public static int size() {
			return stack.size();
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
				stack.push(sc.nextInt());
				break;
			case "top":
				sb.append(stack.top()).append("\n");
				break;
			case "size":
				sb.append(stack.size()).append("\n");
				break;
			case "empty":
				if (stack.isEmpty()) {
					sb.append(1).append("\n");
				} else {
					sb.append(0).append("\n");
				}
				break;
			case "pop":
				sb.append(stack.pop()).append("\n");
				break;
			}
		}
		System.out.println(sb.toString());
	}

}
