import java.util.PriorityQueue;

class Solution {
    static class Structure implements Comparable<Structure> {
        int y;
        int x;
        int what;

        public Structure(int y, int x, int what) {
            super();
            this.y = y;
            this.x = x;
            this.what = what;
        }

        @Override
        public int compareTo(Solution.Structure o) {
            if (this.y == o.y && this.x == o.x)
                return this.what - o.what;
            if (this.x == o.x)
                return this.y - o.y;
            return this.x - o.x;
        }

    }

    public int[][] solution(int n, int[][] build_frame) {
        int[][] answer = {};

        boolean[][][] board = new boolean[n + 2][n + 5][2];// [0]기둥, [1]보
        for (int i = 0; i < build_frame.length; ++i) {
            int x = build_frame[i][0] + 2;
            int y = build_frame[i][1] + 1;
            // 기둥
            if (build_frame[i][2] == 0) {
                // 설치
                if (build_frame[i][3] == 1) {

                    // 바닥 위거나 기둥 위거나 보 위면
                    if (y == 1 || board[y - 1][x][0] || board[y][x][1] || board[y][x - 1][1]) {
                        // 기둥 설치
                        board[y][x][0] = true;
                    }
                }
                // 삭제
                else {
                    // 위에 기둥이 있고 기둥 지지해줄 보가 없거나
                    if (board[y + 1][x][0] && (!board[y + 1][x - 1][1] && !board[y + 1][x][1]))
                        continue;
                    // 보의 한쪽끝이 있고 보의 반대편에 고정이 안돼있으면 삭제못함
                    if (board[y + 1][x - 1][1]
                            && (!board[y][x - 1][0] && !(board[y + 1][x - 2][1] && board[y + 1][x][1])))
                        continue;
                    if (board[y + 1][x][1]
                            && (!board[y][x + 1][0] && !(board[y + 1][x - 1][1] && board[y + 1][x + 1][1])))
                        continue;
                    board[y][x][0] = false;
                }
            }
            // 보
            else {
                // 설치
                if (build_frame[i][3] == 1) {
                    // 한쪽 끝이 기둥위거나 양쪽끝이 다른보면
                    if ((board[y - 1][x][0] || board[y - 1][x + 1][0]) || (board[y][x - 1][1] && board[y][x + 1][1]))
                        board[y][x][1] = true;
                }
                // 삭제
                else {
                    // 한쪽끝에 기둥이 있고 아래쪽에 기둥이 없고 반대쪽에도 보가 없으면
                    if (board[y][x][0] && (!board[y - 1][x][0] && !board[y][x - 1][1]))
                        continue;
                    if (board[y][x + 1][0] && (!board[y - 1][x + 1][0] && !board[y][x + 1][1]))
                        continue;
                    // 양쪽끝에 보가 있고 보의 기둥이 없으면 삭제못함
                    if (board[y][x - 1][1] && (!board[y - 1][x - 1][0] && !board[y - 1][x][0]))
                        continue;
                    if (board[y][x + 1][1] && (!board[y - 1][x + 1][0] && !board[y - 1][x + 2][0]))
                        continue;
                    board[y][x][1] = false;
                }
            }
        }
        PriorityQueue<Structure> pq = new PriorityQueue<Solution.Structure>();

        for (int i = 0; i < n + 2; ++i)
            for (int j = 0; j < n + 5; ++j) {
                if (board[i][j][0])
                    pq.add(new Structure(i - 1, j - 2, 0));
                if (board[i][j][1])
                    pq.add(new Structure(i - 1, j - 2, 1));
            }

        answer = new int[pq.size()][3];
        int idx = 0;
        while (!pq.isEmpty()) {
            Structure str = pq.poll();
            answer[idx][0] = str.x;
            answer[idx][1] = str.y;
            answer[idx][2] = str.what;
            ++idx;
        }
        return answer;
    }
}