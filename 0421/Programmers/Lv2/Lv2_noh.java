import java.util.Stack;

class Solution {
    public String solution(String p) {
        String answer = "";
        answer = solve(p);
        return answer;
    }

    static String solve(String str) {
        // 빈 문자열이면 그대로 반환
        if (str.equals(""))
            return str;

        // 문자열을 u, v로 분리
        String u = new String();
        String v = new String();
        int cnt = 0;
        for (int i = 0; i < str.length(); ++i) {
            if (str.charAt(i) == '(')
                ++cnt;
            else
                --cnt;
            if (cnt == 0) {
                u = str.substring(0, i + 1);
                v = str.substring(i + 1, str.length());
                break;
            }
        }

        // u가 올바른 문자열이면
        if (isRight(u)) {
            return u + solve(v);
        }
        // u가 올바른 문자열이 아니면
        else {
            String temp = new String();
            for (int i = 1; i < u.length() - 1; ++i)
                if (u.charAt(i) == '(')
                    temp += ')';
                else
                    temp += '(';
            return "(" + solve(v) + ")" + temp;
        }
    }

    static boolean isRight(String str) {
        Stack<Character> st = new Stack<Character>();
        for (int i = 0; i < str.length(); ++i)
            if (str.charAt(i) == '(')
                st.push('(');
            else {
                if (st.empty())
                    return false;
                st.pop();
            }
        return true;
    }
}
