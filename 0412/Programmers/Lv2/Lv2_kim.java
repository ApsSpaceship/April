import java.util.Stack;

public class programmers_k진수에서소수개수구하기 {
	public static int answer;
	public static void main(String[] args) {
		int n = 110011;
		int k = 10;
		StringBuilder sb = new StringBuilder();
		Stack<Integer> stack = new Stack<>();
		answer = 0;
		
		//k 진수로 변환
		while(n !=0) {
			stack.add(n%k);
			n = n/k;
		}
		while(!stack.isEmpty()) {
			sb.append(stack.pop());
		}
		String nums = sb.toString();
		
		//0을 기준으로 자른다.
		String[] num = nums.split("0");
		for(int i = 0; i < num.length; i++) {
			//1은 소수가 아니므로 지나가고 0을 기준으로 잘라서 0이 연속으로 나오는 수는 공백이 생기므로 공백인 부분도 지나감
			if(num[i].equals("1") || num[i].equals(""))
				continue;
			Long l = Long.parseLong(num[i]);
			check(l);		
		}
		System.out.println(answer);
	}
	
	//소수 판별 함수
	public static void check(long num) {
		boolean flag = true;
		//제곱을 기준으로 하여 제곱이 num보다 작은 경우에만 소수 판별을 한다.
		for(long i = 2; i*i <= num; i++) {
			if(num % i == 0) {
				flag = false; // 나누어 떨어지는 수가 있으면 소수가 아니므로 false로 바꾼다.
				break;
			}
		}
		//소수면 answer++
		if(flag) {
			answer++; 
		}
	}
}
