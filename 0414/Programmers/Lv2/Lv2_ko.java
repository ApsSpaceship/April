public class PRO_lv2_N진수게임 {

	class Solution {
		public String solution(int n, int t, int m, int p) {
			int size = t * m;
			StringBuilder sb1 = new StringBuilder();
			StringBuilder sb2 = new StringBuilder();
			for (int i = 0; i <= size; i++) { // 진법 변환
				sb1.append(Integer.toString(i, n));
			}

			for (int i = p - 1; i < size; i += m) { // 튜브 순서
				sb2.append(sb1.charAt(i));
			}

			return sb2.toString().toUpperCase(); // 대문자로 변환
		}
	}

}