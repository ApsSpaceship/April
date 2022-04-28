import java.util.PriorityQueue;
import java.util.Scanner;

public class BOJ_11651_좌표정렬하기2 {
	static class Point implements Comparable<Point> { // 좌표
		int x;
		int y;

		public Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

		@Override
		public int compareTo(Point o) { // 정렬
			if (this.y == o.y)
				return this.x - o.x;
			return this.y - o.y;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		PriorityQueue<Point> q = new PriorityQueue<>();
		Point now;

		for (int i = 0; i < N; i++) // 입력
			q.add(new Point(sc.nextInt(), sc.nextInt()));

		for (int i = 0; i < N; i++) { // 출력
			now = q.poll();
			System.out.println(now.x + " " + now.y);
		}
	}

}