class Solution {
    public String solution(int n, int t, int m, int p) {
        String answer = "";
        StringBuilder str = new StringBuilder();
        for (int i = 0; str.length() < t * m; ++i)
            str.append(Integer.toString(i, n));
        StringBuilder ans = new StringBuilder();
        for (int i = p - 1; ans.length() < t; i += m) {
            char c = str.charAt(i);
            if ('a' <= c && c <= 'f')
                c += ('A' - 'a');
            ans.append(c);
        }
        answer = ans.toString();
        return answer;
    }
}