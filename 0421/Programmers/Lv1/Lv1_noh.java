class Solution {
    public String solution(int[] numbers, String hand) {
        String answer = "";
        StringBuilder sb = new StringBuilder();

        int[][] pos = { { 3, 1 }, { 0, 0 }, { 0, 1 }, { 0, 2 }, { 1, 0 }, { 1, 1 }, { 1, 2 }, { 2, 0 }, { 2, 1 },
                { 2, 2 } };

        int[] leftPos = { 3, 0 };
        int[] rightPos = { 3, 2 };
        for (int i = 0; i < numbers.length; ++i) {
            // 2580
            if (numbers[i] % 3 == 2 || numbers[i] == 0) {
                // 거리가 같을때
                if (dist(leftPos, pos[numbers[i]]) == dist(rightPos, pos[numbers[i]])) {
                    // 왼손잡이면
                    if (hand.equals("left")) {
                        sb.append("L");
                        leftPos[0] = pos[numbers[i]][0];
                        leftPos[1] = pos[numbers[i]][1];
                    }
                    // 오른손잡이면
                    else {
                        sb.append("R");
                        rightPos[0] = pos[numbers[i]][0];
                        rightPos[1] = pos[numbers[i]][1];
                    }
                }
                // 왼손이 가까울때
                else if (dist(leftPos, pos[numbers[i]]) < dist(rightPos, pos[numbers[i]])) {
                    sb.append("L");
                    leftPos[0] = pos[numbers[i]][0];
                    leftPos[1] = pos[numbers[i]][1];
                }
                // 오른손이 가까울때
                else if (dist(leftPos, pos[numbers[i]]) > dist(rightPos, pos[numbers[i]])) {
                    sb.append("R");
                    rightPos[0] = pos[numbers[i]][0];
                    rightPos[1] = pos[numbers[i]][1];
                }
            }
            // 147
            else if (numbers[i] % 3 == 1) {
                sb.append("L");
                leftPos[0] = pos[numbers[i]][0];
                leftPos[1] = pos[numbers[i]][1];
            }
            // 369
            else if (numbers[i] % 3 == 0) {
                sb.append("R");
                rightPos[0] = pos[numbers[i]][0];
                rightPos[1] = pos[numbers[i]][1];
            }
        }
        answer = sb.toString();
        return answer;
    }

    static int dist(int[] a, int[] b) {
        return Math.abs(a[0] - b[0]) + Math.abs(a[1] - b[1]);
    }
}