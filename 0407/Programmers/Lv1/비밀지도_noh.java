class Solution {
	public String[] solution(int n, int[] arr1, int[] arr2) {
		String[] answer = new String[n];

		for (int i = 0; i < n; ++i) {
			arr1[i] |= arr2[i];
			StringBuilder str = new StringBuilder();
			for (int j = n - 1; j >= 0; --j) {
				if ((arr1[i] & (1 << j)) != 0)
					str.append("#");
				else
					str.append(" ");
			}
			answer[i] = str.toString();
		}

		return answer;
	}
}
