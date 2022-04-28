import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        List<Integer>[] adj = new ArrayList[n + 1];
        for (int i = 1; i <= n; ++i) {
            adj[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < m; ++i) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            adj[a].add(b);
            adj[b].add(a);
        }

        int ans = 0;
        int minV = 100;
        for (int i = 1; i <= n; ++i) {
            int baconNum = 0;

            Queue<Integer> q = new LinkedList<Integer>();
            boolean[] visited = new boolean[n + 1];

            q.add(i);
            int dist = 0;
            while (!q.isEmpty()) {
                int size = q.size();
                for (int j = 0; j < size; ++j) {
                    int cur = q.poll();
                    if (visited[cur])
                        continue;
                    visited[cur] = true;

                    baconNum += dist;

                    for (int next : adj[cur])
                        q.add(next);
                }
                ++dist;
            }
            if (minV > baconNum) {
                minV = baconNum;
                ans = i;
            }
        }
        System.out.println(ans);
    }
}