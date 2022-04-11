class Solution {
	public int[] solution(int[] fees, String[] records) {
		int[] time = new int[10000];
		for (int i = 0; i < 10000; ++i)
			time[i] = -2;
		int[] sum = new int[10000];
		int cnt = 0;
		for (int i = 0; i < records.length; ++i) {
			int h = Integer.parseInt(records[i].substring(0, 2));
			int m = Integer.parseInt(records[i].substring(3, 5));
			int carNum = Integer.parseInt(records[i].substring(6, 10));
			char inOut = records[i].charAt(11);

			if (inOut == 'I') {
				if (time[carNum] == -2)
					++cnt;
				time[carNum] = timeToMinute(h, m);
			} else {
				sum[carNum] += (timeToMinute(h, m) - time[carNum]);
				time[carNum] = -1;
			}
		}
		int[] answer = new int[cnt];

		int idx = 0;
		for (int i = 0; i < 10000; ++i) {
			if (time[i] == -2)
				continue;
			if (time[i] != -1) {
				sum[i] += (timeToMinute(23, 59) - time[i]);
				time[i] = -1;
			}
			answer[idx++] = feeCal(sum[i], fees);
		}
		return answer;
	}

	static int timeToMinute(int h, int m) {
		return h * 60 + m;
	}

	static int feeCal(int minute, int[] fees) {
		int ret = 0;
		minute -= fees[0];
		ret += fees[1];

		if (minute <= 0)
			return ret;

		ret += ((minute - 1) / fees[2] + 1) * fees[3];
		return ret;
	}
}
