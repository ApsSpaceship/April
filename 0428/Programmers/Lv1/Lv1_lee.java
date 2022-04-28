import java.util.ArrayList;
class Solution {
    static int[] opArr = {0, 1, 2};
    static int[] opOrder;
    static long answer;
    static ArrayList<String> list;
    static boolean[] visited;
    static int[] opCnt;
    public long solution(String expression) {
        answer = 0;
        list = new ArrayList<>();
        opOrder = new int[3];
        opCnt = new int[3];
        visited = new boolean[3];
        // 순열 
        // 음수이면 절댓값으로 변환하여 제출 
        // 제출 숫자가 가장 큰 참가자가 우승자
        // 우승자가 제출한 숫자를 우승상금으로 지급
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < expression.length(); i++) {
            char c = expression.charAt(i);
            // 숫자가 아닌 경우
            if(c < 48 || c > 58) {
                list.add(sb.toString());
                sb.setLength(0);
                String op = expression.substring(i, i+1);
                if(op.equals("+"))
                    opCnt[0]++;
                else if(op.equals("-"))
                    opCnt[1]++;
                else if(op.equals("*"))
                    opCnt[2]++;
                list.add(op);     
            }else if(sb.length() >= 0 && i == expression.length()-1) {
                sb.append(c);
                list.add(sb.toString());
                sb.setLength(0);
            }else {
                sb.append(c);
            }
        }
        perm(0);
        return answer;
    }
    static void perm(int depth) {
        if(depth == 3) {
            ArrayList<String> exList = (ArrayList<String>) list.clone();
            long calcVal = 0;
            for(int opIdx : opOrder) {
                String op = "";
                switch(opIdx) {
                    case 0:
                        op = "+";
                        break;
                    case 1:
                        op = "-";
                        break;
                    case 2:
                        op = "*";
                        break;   
                }
                int cnt = opCnt[opIdx];
                System.out.println(op + " " +cnt);
                int idx = 0;
                while(true) {
                    if(cnt == 0 || idx == exList.size())
                        break;
                    if(exList.get(idx).equals(op)) {
                        int preIdx = idx-1;
                        int nextIdx = idx+1;
                        switch(op) {
                            case "+":
                                calcVal = Long.valueOf(exList.get(preIdx)) + Long.valueOf(exList.get(nextIdx));
                                break;
                            case "-":
                                calcVal = Long.valueOf(exList.get(preIdx)) - Long.valueOf(exList.get(nextIdx));
                                break;
                            case "*":
                                calcVal = Long.valueOf(exList.get(preIdx)) * Long.valueOf(exList.get(nextIdx));
                                break;
                        }
                        // list.remove(preIdx);
                        exList.set(preIdx, String.valueOf(calcVal));   
                        exList.remove(idx);
                        exList.remove(idx);
                        cnt--;
                    }else {
                        idx++;
                    }
                }
            }
            if(calcVal < 0)
                calcVal = Math.abs(calcVal);
            answer = Math.max(answer, calcVal);
            return;
        }
        for(int i =0 ; i < 3; i++) {
            if(visited[i] != true) {
                visited[i] = true;
                opOrder[depth] = opArr[i];
                perm(depth+1);
                visited[i] = false;
            }
        }
    }
}