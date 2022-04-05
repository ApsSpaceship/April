class Solution {
	static int[] cnt = new int[11];
	static int[] ans = new int[11];
	static int maxV = 1;
	static boolean flag = false;

	public int[] solution(int n, int[] info) {
		int[] answer = {};
		solve(0, n, info);
		if (!flag) {
			ans = new int[1];
			ans[0] = -1;
		}
		answer = ans;
		return answer;
	}

	public void solve(int idx, int remain, int[] info) {
		if (remain == 0 || idx == 11) {
			int scoreDiff = 0;
			for (int i = 0; i < 10; ++i) {
				if (cnt[i] == 0 && info[i] == 0)
					continue;
				if (cnt[i] > info[i])
					scoreDiff += (10 - i);
				else
					scoreDiff -= (10 - i);
			}
			if (scoreDiff > maxV) {
				maxV = scoreDiff;
				for (int i = 0; i < 11; ++i)
					ans[i] = cnt[i];
				flag = true;
			} else if (scoreDiff == maxV) {
				for (int i = 10; i >= 0; --i) {
					if (ans[i] == cnt[i])
						continue;
					if (ans[i] > cnt[i])
						break;
					if (ans[i] < cnt[i]) {
						for (int j = 0; j < 11; ++j)
							ans[j] = cnt[j];
						break;
					}
				}
				flag = true;
			}
			return;
		}

		if (idx == 10) {
			cnt[idx] = remain;
			solve(idx + 1, 0, info);
			cnt[idx] = 0;
		} else {
			for (int i = remain; i >= 0; --i) {
				cnt[idx] = i;
				solve(idx + 1, remain - i, info);
				cnt[idx] = 0;
			}
		}
	}
}
