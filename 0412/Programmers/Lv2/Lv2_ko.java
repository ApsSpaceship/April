class Solution {
    public int solution(int n, int k) {
		int answer = 0;
		int nowBaby;
		int cnt = 0; // 자릿수
		long now = 0;
		while (n > 0) {
			nowBaby = n % k; // k진법 변환
			if (nowBaby != 0) { // 0이 아니면
				now += nowBaby * Math.pow(10, cnt++);
			} else {
				if (isPrime(now)) // 0이면 소수 판별
					answer++;
				cnt = 0;
				now = 0;
			}
			n /= k;
		}
		if (isPrime(now)) // 남은 소수 있는지 확인
			answer++;

		return answer;
	}

	static boolean isPrime(long n) { // 소수 판별
		if (n < 2)
			return false;
		for (long i = 2; i * i <= n; i++) { // 나눠지는 수 있는지 제곱근까지 확인
			if (n % i == 0)
				return false;
		}
		return true;
	}
}
