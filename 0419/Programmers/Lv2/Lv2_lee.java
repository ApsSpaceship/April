class Solution {
    // 문자열에서 같은 값이 연속해서 나타나는 것을 그 문자의 개수와 반복되는 값으로 표현하여 
    // 더 짧은 문자열로 줄여서 표현하는 알고리즘
    // 문자열을 1개 이상의 단위로 잘라서 압축하여 더 짧은 문자열로 표현
    public int solution(String s) {
        int minV = Integer.MAX_VALUE;

        for(int i = 1; i <= s.length(); i++) {
            minV = Math.min(minV, checkMinV(i, s));
        }
        return minV;
    }
    public int checkMinV(int cNum, String s) {
        StringBuilder sb = new StringBuilder();
        int len = s.length();
        int st = 0;
        int ed = cNum;
        int cnt = 1;
        String preStr = "";

        while(true) {
            // 전체 길이만큼 자를 때
            if(st==0 && ed == s.length()) {
                sb.append(s);
                break;
            }
            String str = "";
            // 끝점이 길이보다 길 때,
            // 남은 문자열
            if(ed > len) {
                str = s.substring(st);
            }
            else {
                // 아닐 때, 자르기
                str = s.substring(st, ed);
            }
            // 앞 문자열이 비어있지 않을 때,
            if(preStr.length() != 0) {
                // 현재 문자열이 앞 문자열과 같을 때
                if(str.equals(preStr)) {
                    // cnt 개수 증가
                    cnt++;
                }else {
                    // 앞 문자열과 다를 때,
                    // 1개이상인 경우, 지금까지의 개수 입력
                    if(cnt > 1) {
                        sb.append(cnt);
                        cnt = 1;
                    }
                    // 앞 문자열 입력
                    sb.append(preStr);
                    // 앞 문자열 갱신 : 현재의 문자열로 ( cnt 1개 유지 )
                    preStr = str;
                }
                // 마지막인 경우
                if(ed >= len) {
                    // 남은 거 입력해서 끝
                    if(cnt > 1) {
                        sb.append(cnt);
                    }
                    // 앞 문자열 입력
                    sb.append(preStr);
                    break;
                }
                // 마지막이 아니면, idx 갱신
                st = ed;
                ed += cNum;
            }else {
                // 비어있으면, 현재 str로 preStr 갱신
                preStr = str;
                // idx 갱신
                st = ed;
                ed += cNum;
            }
        }
        return sb.toString().length();     
    }
}