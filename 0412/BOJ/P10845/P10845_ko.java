import java.util.ArrayList;
import java.util.Scanner;

public class P10845_ko {
	static int front = -1; // 맨 앞 인덱스 -1
	static int back = -1; // 맨 뒤 인덱스
	static ArrayList<Integer> queue = new ArrayList<>();

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
				sb.append((back - front) + "\n");
				break;
			case "empty":
				sb.append(empty() + "\n");
				break;
			case "front":
				sb.append(front() + "\n");
				break;
			case "back":
				sb.append(back() + "\n");
				break;
			}
		}
		System.out.println(sb.toString());
	}// main

	static void push(int X) {
		queue.add(++back, X);
	}

	static int pop() {
		if (front == back)
			return -1;
		return queue.get(++front);
	}

	static int empty() {
		if (front == back)
			return 1;
		return 0;
	}

	static int front() {
		if (front == back)
			return -1;
		return queue.get(front + 1);
	}

	static int back() {
		if (front == back)
			return -1;
		return queue.get(back);
	}

}