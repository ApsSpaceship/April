class Solution {
    static int lk;
    static int rk;
    static final int[][] KEYPADS = {{3, 1}, {0, 0}, {0, 1}, {0, 2}, {1, 0}, {1, 1}, {1, 2}, {2, 0}, {2, 1}, {2, 2}, {3, 0}, {3, 2}};
    static boolean h;
    public String solution(int[] numbers, String hand) {
        StringBuilder sb = new StringBuilder();
        // 출발 위치 초기화
        // *
        lk = 10;
        // #
        rk = 11;
        h = hand.charAt(0) == 'r' ? true : false;
        for(int i : numbers) {
            switch(i) {
                case 1: 
                case 4:
                case 7:
                    lk = i;
                    sb.append("L");
                    break;
                case 3:
                case 6:
                case 9:
                    rk = i;
                    sb.append("R");
                    break;
                case 2:
                case 5:
                case 8:
                case 0:
                    sb.append(checkHand(i));
                    break;
            }
        }
        return sb.toString();
    }
    public String checkHand(int key) {
        int rd = 0;
        int ld = 0;
        for(int i =0; i <2 ;i++) {
            rd += Math.abs(KEYPADS[rk][i] - KEYPADS[key][i]);
            ld += Math.abs(KEYPADS[lk][i] - KEYPADS[key][i]);
        }
        if(rd > ld) {
            lk = key;
            return "L";
        }
        else if (rd < ld) {
            rk = key; 
            return "R";
        }
        else {
            if(h) {
                rk = key;
                return "R";
            }
            else {
                lk = key;
                return "L";
            }        
        }
    }
}