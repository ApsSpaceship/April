import java.util.Arrays;

class Solution {
	public int solution(int n, int k) {
		StringBuilder sb = new StringBuilder();
		if (k == 10) {
			sb.append(n);

		} else {
			while (n > 0) {
				sb.insert(0, n % k);
				n /= k;
			}
		}
        int answer = 0;
        // 0이 한개 이상 있다
        String[] numK = sb.toString().split("0+");
        // 소수 판별
        for(String num : numK) {
        	if(isPrime(Long.parseLong(num))) 
                answer++;
        }

		// n을 k진수로 바꿨을 때, 변환된 수 안에서 찾을 수 있는 위 조건에 맞는 소수의 개수를 return
		return answer;
	}

	static boolean isPrime(long num) {
        if(num <= 1)
            return false;
        if(num == 2)
            return true;
        
		boolean isPrime = true;
        int sqrtV = (int) Math.sqrt(num) +1;
		for (int p = 2; p < sqrtV; p++) {
			// 1과 num 자신 외에 나누어지는 수가 있는지 확인
			if (num % p == 0) {
				// 나누어지는 수가 있을 경우 소수가 아님
				isPrime = false;
				break;
			}
		}
		return isPrime;
	}
}