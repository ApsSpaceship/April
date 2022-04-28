import java.util.ArrayList;
import java.util.List;

class Solution {
    static boolean[] child = new boolean[17];
    static int nodeCnt;
    static List<Integer>[] adj;

    public int solution(int[] info, int[][] edges) {
        int answer = 0;

        nodeCnt = info.length;
        adj = new ArrayList[nodeCnt];
        for (int i = 0; i < nodeCnt; ++i)
            adj[i] = new ArrayList<Integer>();
        for (int i = 0; i < edges.length; ++i)
            adj[edges[i][0]].add(edges[i][1]);
        answer = dfs(0, 1, 0, info);

        return answer;
    }

    static int dfs(int cur, int sheep, int wolf, int[] info) {
        if (sheep == wolf)
            return 0;

        for (int i = 0; i < adj[cur].size(); ++i)
            child[adj[cur].get(i)] = true;
        child[cur] = false;

        int ret = sheep;

        for (int c = 0; c < nodeCnt; ++c) {
            if (child[c]) {
                if (info[c] == 0)// 양
                    ret = Math.max(ret, dfs(c, sheep + 1, wolf, info));
                else// 늑대
                    ret = Math.max(ret, dfs(c, sheep, wolf + 1, info));
            }
        }

        for (int i = 0; i < adj[cur].size(); ++i)
            child[adj[cur].get(i)] = false;
        child[cur] = true;
        return ret;
    }
}