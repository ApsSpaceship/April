import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int minA;
	static boolean[] visit;
	static List<ArrayList<Integer>> list = new ArrayList<>();
	static int N;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt(); // 친구 수
		int M = sc.nextInt(); // 관계 수
		minA = N * M;
		int ans = 0;
		for (int i = 0; i <= N; i++) // 관계 리스트 초기화
			list.add(new ArrayList<>());
		for (int i = 0; i < M; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			list.get(a).add(b);
			list.get(b).add(a);
		}

		for (int i = 1; i <= N; i++) { // 모든 정점에서 출발하기
			int result = bfs(i);
			if (minA > result) { // 최솟값 비교
				minA = result;
				ans = i;
			}
		}

		System.out.print(ans);
	}

	static int bfs(int start) {
		int ret = 0;
		int cnt = 0;
		visit = new boolean[N + 1];

		Queue<Integer> q = new LinkedList<>();
		q.add(start);
		visit[start] = true;
		while (!q.isEmpty() && minA > ret) { // 이미 최솟값보다 크면 그만
			int size = q.size();
			for (int i = 0; i < size; i++) { // 사이즈로 묶어서 확인
				int now = q.poll();

				for (int c : list.get(now)) // 갈 수 있는 정점들 넣기
					if (!visit[c]) {
						q.add(c);
						visit[c] = true; // 방문처리
						ret += cnt; // 케빈 베이컨 수 더하기
					}
			}
			cnt++; // 거리 증가
		}

		return ret;
	}

}