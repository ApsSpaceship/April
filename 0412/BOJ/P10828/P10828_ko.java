import java.util.ArrayList;
import java.util.Scanner;

public class P10828_ko {
	static ArrayList<Integer> stack = new ArrayList<>();
	static int top = -1;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int N = sc.nextInt();
		for (int i = 0; i < N; i++) {
			switch (sc.next()) {
			case "push":
				push(sc.nextInt());
				break;
			case "pop":
				sb.append(pop() + "\n");
				break;
			case "size":
				sb.append((top + 1) + "\n");
				break;
			case "empty":
				sb.append(empty() + "\n");
				break;
			case "top":
				sb.append(top() + "\n");
				break;
			}
		}
		System.out.println(sb.toString());
	}// main

	static void push(int X) {
		stack.add(++top, X);
	}

	static int pop() {
		if (top == -1)
			return -1;
		return stack.get(top--);
	}

	static int empty() {
		if (top == -1)
			return 1;
		else
			return 0;
	}

	static int top() {
		if (top == -1)
			return -1;
		else
			return stack.get(top);
	}

}
