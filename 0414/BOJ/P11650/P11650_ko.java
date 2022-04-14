import java.util.PriorityQueue;
import java.util.Scanner;

public class BOJ_11650_좌표정렬 {
	static class Point implements Comparable<Point> {
		int x;
		int y;

		public Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

		@Override
		public int compareTo(Point o) { // 정렬
			if (this.x == o.x) // x가 같으면 y로 비교
				return Integer.compare(this.y, o.y);
			return Integer.compare(this.x, o.x);
		}

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // 점의 개수
		PriorityQueue<Point> q = new PriorityQueue<>(); // 우선순위 큐

		for (int i = 0; i < N; i++) // 입력
			q.add(new Point(sc.nextInt(), sc.nextInt()));

		for (int i = 0; i < N; i++) { // 출력
			Point p = q.poll();
			System.out.println(p.x + " " + p.y);
		}
	}

}