static class Point {
    int x;
    int y;

    public Point(int x, int y) {
        super();
        this.x = x;
        this.y = y;
    }

}

public String solution(int[] numbers, String hand) {
    String answer = "";
    StringBuilder sb = new StringBuilder();
    int nSize = numbers.length;
    Point pR = new Point(3, 2); // 오른손#위치 초기화
    Point pL = new Point(3, 0); // 왼손*위치 초기화
    char base = hand.charAt(0); // 왼손잡이? 오른손잡이?

    for (int i = 0; i < nSize; i++) {
        if (numbers[i] == 0)
            numbers[i] = 11;
        switch (numbers[i] % 3) {
        case 0: // 3,6,9이므로 오른손
            sb.append("R");
            pR.x = numbers[i] / 3 - 1;
            pR.y = 2;
            break;

        case 1: // 1,4,7이므로 왼손
            sb.append("L");
            pL.x = numbers[i] / 3;
            pL.y = 0;
            break;

        default: // 2,5,8,0
            Point now = new Point((numbers[i] + 1) / 4, 1);
            int disR = loc(now, pR);
            int disL = loc(now, pL);

            if (disR > disL || (disR == disL && base == 'l')) { // L이 더 가깝거나 같은데 왼손잡이면
                pL.x = now.x;
                pL.y = now.y;
                sb.append("L");
            } else {
                pR.x = now.x;
                pR.y = now.y;
                sb.append("R");
            }
            break;
        }

    }

    answer = sb.toString();
    return answer;
}

static int loc(Point a, Point b) { // 두 좌표 거리
    return Math.abs(a.x - b.x) + Math.abs(a.y - b.y);
}