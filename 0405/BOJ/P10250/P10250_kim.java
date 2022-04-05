package study_0405;

import java.util.Scanner;

public class BOJ_P10250_ACM호텔 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		for (int tn = 1; tn <= tc; tn++) {
			int h = sc.nextInt(); // 층 수
			int w = sc.nextInt(); // 방 수
			int n = sc.nextInt(); // 몇 번째 손님
			int resulth = 0; // 손님이 묵을 층 수
			int resultw = 0; // 손님이 묵을 방 호수
			// n % h : 층수 
			// ex) h = 6, n = 6 이면 손님은 6층에 묵어야 하는데 0 이 나오므로 n%h == 0일때는 층 수에 h를 넣어준다
			// (n/h) + 1 : 호수
			// ex) h = 6, n = 6 이면 손님은 1호에 묵어야 하는데 2호가  나오므로 n%h == 0일때는 호수에 1을 더하지 않는다.
			if (n % h == 0) {
				resulth = h * 100;
				resultw = n / h;
			} else {
				resulth = (n % h) * 100;
				resultw = (n / h) + 1;
			}
			System.out.println(resulth + resultw);
		}
	}

}
