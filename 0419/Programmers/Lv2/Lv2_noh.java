class Solution {
    public int solution(String s) {
        int slen = s.length();
        int answer = slen;

        for (int i = 1; i <= slen / 2; ++i) {
            int len = 0;
            len += (slen % i);
            String temp = s.substring(0, slen - (slen % i));
            int tempLen = temp.length();
            int cnt = 1;
            for (int j = i; j < tempLen; j += i) {
                // 이전 문자열과 같을때
                if (temp.substring(j, j + i).equals(temp.substring(j - i, j))) {
                    ++cnt;
                }
                // 다를때
                else {
                    len += (Integer.toString(cnt).length() + i);
                    if (cnt == 1)
                        --len;
                    cnt = 1;
                }
            }
            len += (Integer.toString(cnt).length() + i);
            if (cnt == 1)
                --len;
            answer = Math.min(answer, len);
        }
        return answer;
    }
}