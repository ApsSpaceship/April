import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_11866_요세푸스문제0 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		int idx = 0;
		int now;
		Queue<Integer> q = new LinkedList<>();
		StringBuilder sb = new StringBuilder();
		sb.append("<");

		for (int i = 1; i <= N; i++)
			q.add(i);

		while (q.size() != 0) { // 요세푸스
			now = q.poll();
			if (++idx != K) // K번째 아니면 뒤로
				q.add(now);
			else { // K번째면 출력
				sb.append(now);
				if (q.size() != 0) {
					sb.append(", ");
					idx = 0;
				}
			}
		}

		sb.append(">");
		System.out.print(sb);
	}

}