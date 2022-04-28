import java.util.ArrayList;
class Solution {
    static char[] opArr = {'+', '-', '*'};
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


        // 우승자가 제출한 숫자를 우승상금으로 지급
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < expression.length(); i++) {
            char c = expression.charAt(i);
            // 숫자가 아닌 경우
            if(c < 48 || c > 58) {
                list.add(sb.toString());
                sb.setLength(0);
                switch(c) {
                    case '+':
                        opCnt[0]++;
                        break;
                    case '-':
                        opCnt[1]++;
                        break;
                    case '*':
                        opCnt[2]++;
                        break;  
                }
                list.add(Character.toString(c));     
            // 마지막까지 다 돌았는데, 숫자이고, sb가 비어있거나 조금 채워져 있는 경우
                // else if(sb.length() >= 0 && i == expression.length()-1) {
            }else if(i == expression.length()-1) {
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
    // 순열 
    static void perm(int depth) {
        if(depth == 3) {
            // 연산
            ArrayList<String> exList = (ArrayList<String>) list.clone();
            long calcVal = 0;
            for(int opIdx : opOrder) {
                String op = Character.toString(opArr[opIdx]);
                int cnt = opCnt[opIdx];
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
                        // preIdx, idx, nextIdx 는 삭제되어야 한는 인덱스
                        // 삭제될 인덱스 중 가장 작은 인덱스에 위치한 값을 현재 계산한 값으로 갱신 
                        exList.set(preIdx, String.valueOf(calcVal));   
                        // 연산자 삭제
                        exList.remove(idx);
                        // 앞에 연산자가 삭제되면서 인덱스가 한 칸씩 당겨졌으므로 동일한 idx 한 번 더 삭제 
                        // (기존 exList,get(nextIdx) 값)
                        exList.remove(idx);
                        cnt--;
                        // 연산자인 경우 인덱스가 당겨졌으므로 idx 갱신 필요 없음
                    }else {
                        // 연산자가 아닐 경우 idx 증가
                        idx++;
                    }
                }
            }
            // 음수이면 절댓값으로 변환하여 제출 
            // 제출 숫자가 가장 큰 참가자가 우승자
            if(calcVal < 0)
                calcVal = Math.abs(calcVal);
            answer = Math.max(answer, calcVal);
            return;
        }
        for(int i =0 ; i < 3; i++) {
            if(visited[i] != true) {
                visited[i] = true;
                opOrder[depth] = i;
                perm(depth+1);
                visited[i] = false;
            }
        }
    }
}