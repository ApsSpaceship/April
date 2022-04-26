import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static List<Integer>[] adj;
    static boolean[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        adj = new ArrayList[n + 1];
        for (int i = 1; i <= n; ++i)
            adj[i] = new ArrayList<Integer>();
        int m = sc.nextInt();
        int v = sc.nextInt();
        for (int i = 0; i < m; ++i) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            adj[a].add(b);
            adj[b].add(a);
        }
        for (int i = 1; i <= n; ++i)
            Collections.sort(adj[i]);
        visited = new boolean[n + 1];
        dfs(v);
        System.out.println();
        visited = new boolean[n + 1];
        bfs(v);
    }

    static void dfs(int cur) {
        if (visited[cur])
            return;
        visited[cur] = true;
        System.out.print(cur + " ");
        for (int next : adj[cur])
            dfs(next);
    }

    static void bfs(int cur) {
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(cur);
        while (!q.isEmpty()) {
            int c = q.poll();
            if (visited[c])
                continue;
            visited[c] = true;
            System.out.print(c + " ");
            for (int next : adj[c])
                q.add(next);
        }
    }
}