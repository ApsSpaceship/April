class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.setLength(0);
            int num1 = arr1[i];
            int num2 = arr2[i];
            int cnt = 0;
            while (cnt != n) {
                if (cnt == n)
                    break;
                if (num1 == 0 && num2 == 0) {
                    sb.insert(0, " ");
                } else {
                    if (num1 % 2 + num2 % 2 > 0) {
                        sb.insert(0, "#");
                    } else {
                        sb.insert(0, " ");
                    }
                    num1 /= 2;
                    num2 /= 2;
                }
                cnt++;
            }
            answer[i] = sb.toString();
        }
        return answer;
    }
}