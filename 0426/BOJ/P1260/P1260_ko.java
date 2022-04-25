import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_1260_DFS와BFS {
	static List<ArrayList<Integer>> list = new ArrayList<>();;
	static StringBuilder sb = new StringBuilder();
	static boolean[] visit;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // 정점 개수
		int M = sc.nextInt(); // 간선 개수
		int V = sc.nextInt(); // 탐색 시작 정점
		visit = new boolean[N + 1]; // 사용하는 정점 1~N

		for (int i = 0; i <= N; i++)
			list.add(new ArrayList<>());

		for (int i = 0; i < M; i++) { // 양방향 그래프 정점 입력
			int a = sc.nextInt();
			int b = sc.nextInt();
			list.get(a).add(b);
			list.get(b).add(a);
		}

		for (int i = 1; i <= N; i++) // 정렬
			Collections.sort(list.get(i));

		dfs(V);
		sb.append("\n");
		bfs(V, N);

		System.out.print(sb);
	}

	static void dfs(int now) {
		visit[now] = true;
		sb.append(now).append(" ");
		for (int baby : list.get(now))
			if (!visit[baby]) {
				dfs(baby);
			}
	}

	static void bfs(int V, int N) {
		visit = new boolean[N + 1];
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(V);
		visit[V] = true;
		while (!q.isEmpty()) {
			int now = q.poll();
			sb.append(now).append(" ");

			for (int baby : list.get(now))
				if (!visit[baby]) {
					q.add(baby);
					visit[baby] = true;
				}
		}
	}

}