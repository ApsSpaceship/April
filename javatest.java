import java.util.Arrays;
import java.util.Scanner;

public class javatest {
	public static void main(String[] args) {
		Scanner sc = new Scanner(input);

		int V = sc.nextInt(); // 정점의 갯수
		int E = sc.nextInt();

		// 간선의 정보를 저장을 해야되는데
		// 인접 행렬? 인접 리스트?
		int[][] adjArr = new int[V][V];

		for (int i = 0; i < E; i++) {
			int st = sc.nextInt();
			int ed = sc.nextInt();
			int w = sc.nextInt();

			adjArr[st][ed] = w;
			adjArr[ed][st] = w;
		}

		boolean[] visited = new boolean[V];// 박문철2 용도
		int[] dist = new int[V]; // key 라고 불렸던 친구들
		int[] p = new int[V]; // 부모도 저장을 하자.

		// dist 라는 배열을 임의의 아주 큰값으로 채워 놓자.
		Arrays.fill(dist, Integer.MAX_VALUE);
		// 시작정점을 골라야하는데 0번 부터 하께용
		dist[0] = 0;
		p[0] = -1;

		int min, idx, ans = 0; // 최소값, 최솟값 인덱스, 비용의 총합
		for (int i = 0; i < V - 1; i++) {
			min = Integer.MAX_VALUE;
			idx = -1;
			// 아직 안고른 친구들 중에서 제일 거리가 작은 값을 뽑아보장.
			for (int j = 0; j < V; j++) {
				if (!visited[j] && dist[j] < min) {
					min = dist[j];
					idx = j;
				}
			}
			visited[idx] = true;// 제일 작은값을 가지고 있는 친구 쳌
			for (int j = 0; j < V; j++) {
				// 갱신을 하자. 방문하지 않았아고, 간선이 있고오,
				if (!visited[j] && adjArr[idx][j] != 0 && dist[j] > adjArr[idx][j]) {
					p[j] = idx;
					dist[j] = adjArr[idx][j];
				}
			}
		}

		for (int i = 0; i < V; i++) {
			ans += dist[i];
		}
		System.out.println(ans);

	}// main

	static String input = "7 11 \r\n" + "0 1 32\r\n" + "0 2 31\r\n" + "0 5 60\r\n" + "0 6 51\r\n" + "1 2 21\r\n"
			+ "2 4 46\r\n" + "2 6 25\r\n" + "3 4 34\r\n" + "4 6 51\r\n" + "5 3 18\r\n" + "5 4 40\r\n";
}
