static class Point {
    int y;
    int x;

    public Point(int y, int x) {
        super();
        this.y = y;
        this.x = x;
    }
}

static int cnt;
static int[][][] map; // 0 : 기둥, 1 : 보
static int N;

public int[][] solution(int n, int[][] build_frame) {
    int bfSize = build_frame.length; // 입력 횟수
    map = new int[2][n + 1][n + 1];
    cnt = 0;
    N = n;

    for (int t = 0; t < bfSize; t++) {
        Point p = new Point(build_frame[t][1], build_frame[t][0]);
        switch (build_frame[t][2]) {
        case 0: // 기둥 삽입 성공하거나 삭제 실패하면
            if ((build_frame[t][3] == 1 && cPIn(p)) || (build_frame[t][3] == 0 && !cPRem(p))) { // 삽입 성공
                map[0][p.y][p.x] = 1;
                cnt++;
            }
            break;

        default: // 보 삽입 성공하거나 삭제 실패하면
            if ((build_frame[t][3] == 1 && cBIn(p)) || (build_frame[t][3] == 0 && !cBRem(p))) {
                map[1][p.y][p.x] = 1;
                cnt++;
            }
        }
    }

    int[][] answer = new int[cnt][3];
    int idx = 0;
    for (int i = 0; i < n + 1; i++)
        for (int j = 0; j < n + 1; j++)
            for (int who = 0; who < 2; who++)
                if (map[who][j][i] > 0)
                    inAns(answer, idx++, j, i, who);

    return answer;

}

static void inAns(int[][] answer, int idx, int j, int i, int k) {
    answer[idx][0] = i;
    answer[idx][1] = j;
    answer[idx][2] = k;
}

static boolean cPIn(Point p) { // 기둥 삽입
    if (p.y == 0) // 바닥인 경우
        return true;
    if (map[0][p.y - 1][p.x] == 1) // 아래에 기둥 있는 경우
        return true;

    if (p.x > 0 && (map[1][p.y][p.x - 1] == 1)) // 왼쪽에 보 있는 경우
        return true;
    if (map[1][p.y][p.x] == 1)// 지금 보인 경우
        return true;

    return false;
}

static boolean cPRem(Point p) { // 기둥 삭제
    map[0][p.y][p.x] = 0;
    cnt--;

    // 내 기둥 꼭대기 양 옆 보랑 위 기둥 확인 필요
    if (p.y + 1 <= N) {
        if (map[0][p.y + 1][p.x] == 1 && !cPIn(new Point(p.y + 1, p.x)))
            return false;
        if (map[1][p.y + 1][p.x] == 1 && !cBIn(new Point(p.y + 1, p.x)))
            return false;
        if (p.x > 0 && map[1][p.y + 1][p.x - 1] == 1 && !cBIn(new Point(p.y + 1, p.x - 1)))
            return false;
    }
    return true;
}

static boolean cBIn(Point p) { // 보 삽입
    if (p.y > 0) {
        if (map[0][p.y - 1][p.x] == 1) // 내 위치 아래에 기둥 있는 경우
            return true;
        if (p.x + 1 <= N && map[0][p.y - 1][p.x + 1] == 1) // 하나 오른쪽아래에 기둥 있는 경우
            return true;
    }

    if (p.x > 0 && (map[1][p.y][p.x - 1] == 1) && p.x + 1 <= N && map[1][p.y][p.x + 1] == 1) // 왼쪽에 보가 있으면서 오른쪽에 보
        return true;

    return false;
}

static boolean cBRem(Point p) { // 보 삭제
    map[1][p.y][p.x] = 0;
    cnt--;

    // 양 옆 보랑 위 기둥 오른쪽 위 기둥 확인 필요
    if (map[0][p.y][p.x] == 1 && !cPIn(new Point(p.y, p.x))) // 내 위 기둥
        return false;
    if (p.x + 1 <= N) {
        if (map[0][p.y][p.x + 1] == 1 && !cPIn(new Point(p.y, p.x + 1))) // 내 오른쪽 위 기둥
            return false;
        if (map[1][p.y][p.x + 1] == 1 && !cBIn(new Point(p.y, p.x + 1))) // 내 오른쪽 보
            return false;
    }
    if (p.x > 0 && map[1][p.y][p.x - 1] == 1 && !cBIn(new Point(p.y, p.x - 1))) // 내 왼쪽 보
        return false;

    return true;
}