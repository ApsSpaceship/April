import java.util.HashMap;
import java.util.Map;

class Solution {
    static final String[] numbers = { "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine" };

    public int solution(String s) {
        int answer = 0;

        Map<String, Integer> mp = new HashMap<String, Integer>();
        for (int i = 0; i <= 9; ++i)
            mp.put(numbers[i], i);

        String temp = new String();
        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            if ('0' <= c && c <= '9') {
                answer *= 10;
                answer += c - '0';
                continue;
            }
            temp += c;
            if (mp.get(temp) != null) {
                answer *= 10;
                answer += mp.get(temp);
                temp = new String();
            }
        }

        return answer;
    }
}
