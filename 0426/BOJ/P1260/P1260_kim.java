package study0426;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class baekjoon_P1260_dfsbfs {
	static boolean[] visited;
	static List<Integer>[] list;
	static StringBuilder sb;
	public static void main(String[] args) {
		sb = new StringBuilder();
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); // 정점의 개수
		int m = sc.nextInt(); // 간선의 개수
		int v = sc.nextInt(); // 시작 정점
		list = new ArrayList[n+1]; // 인접 리스트
		for(int i = 1; i < list.length; i++) {
			list[i] = new ArrayList<>();
		}
		
		for(int i = 0; i < m; i++) {
			int st = sc.nextInt();
			int ed = sc.nextInt();
			list[st].add(ed); // 간선이 양방향이라 두 방향 다 넣어 줌.
			list[ed].add(st);
		}
		for(int i = 1; i < n+1; i++) {
			Collections.sort(list[i]);
		}
		visited = new boolean[n+1];
		dfs(v);
		sb.append("\n");
		//System.out.println(sb.toString());
		visited = new boolean[n+1]; // 방문처리 다시 초기화!
		Queue<Integer> queue = new LinkedList<>();
		queue.add(v);
		visited[v]=true;
		while(!queue.isEmpty()) {
			int node = queue.poll();
			sb.append(node+" ");
			for(int i = 0; i < list[node].size(); i++) {
				if(!visited[list[node].get(i)]) {
					queue.add(list[node].get(i));
					visited[list[node].get(i)]=true;
				}
			}			
		}
		System.out.println(sb.toString());
	}

	private static void dfs(int v) {
		sb.append(v+" ");
		visited[v] = true;
		for(int i = 0; i < list[v].size(); i++) {
			if(!visited[list[v].get(i)]) {
				dfs(list[v].get(i));
			}
		}	
	}
}
