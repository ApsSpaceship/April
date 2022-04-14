import java.util.PriorityQueue;
import java.util.Scanner;

public class BOJ_10989_수정렬하기3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();// 수 개수
		StringBuilder sb = new StringBuilder();
		PriorityQueue<Integer> q = new PriorityQueue<>(); 
		
		for (int i = 0; i < N; i++) {
			q.add(sc.nextInt());
		}

		sb.append(q.poll()).append("\n");

		System.out.print(sb);
	}
}