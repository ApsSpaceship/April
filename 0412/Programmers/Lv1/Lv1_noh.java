import java.util.PriorityQueue;

class Solution {
    static class stageInfo implements Comparable<stageInfo> {
        int stage;
        double failRate;

        public stageInfo(int stage, double failRate) {
            super();
            this.stage = stage;
            this.failRate = failRate;
        }

        @Override
        public int compareTo(Solution.stageInfo o) {
            if (this.failRate == o.failRate)
                return this.stage - o.stage;
            return (o.failRate - this.failRate) > 0 ? 1 : -1;
        }

    }

    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];

        int[] cnt = new int[N + 2];
        for (int i = 0; i < stages.length; ++i)
            ++cnt[stages[i]];

        for (int i = 1; i <= N + 1; ++i)
            cnt[i] += cnt[i - 1];

        PriorityQueue<stageInfo> pq = new PriorityQueue<Solution.stageInfo>();
        for (int i = 1; i <= N; ++i)
            pq.add(new stageInfo(i,
                    cnt[N + 1] == cnt[i - 1] ? 0 : ((double) cnt[i] - cnt[i - 1]) / (cnt[N + 1] - cnt[i - 1])));

        for (int i = 0; i < N; ++i)
            answer[i] = pq.poll().stage;

        return answer;
    }
}