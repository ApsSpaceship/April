import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class Lv2_noh {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solution(437674, 3));
        // System.out.println(sol.solution(110011, 10));
    }
}

class Solution {
    static List<Long> list = new ArrayList<>();

    public int solution(int n, int k) {
        int answer = 0;

        parseNum(transform(n, k));
        for (long num : list)
            if (isPrime(num))
                ++answer;

        return answer;
    }

    static String transform(int num, int transNum) {
        String ret = new String();
        Stack<String> st = new Stack<>();
        while (num != 0) {
            st.push((num % transNum) + "");
            num /= transNum;
        }
        while (!st.empty())
            ret += st.pop();
        return ret;
    }

    static void parseNum(String str) {
        String[] strArr = str.split("0");
        for (String num : strArr)
            if (!num.equals(""))
                list.add(Long.parseLong(num));
    }

    static boolean isPrime(long num) {
        if (num == 1)
            return false;
        int rt = (int) Math.sqrt(num);
        for (int i = 2; i <= rt; ++i)
            if (num % i == 0)
                return false;
        return true;
    }
}
