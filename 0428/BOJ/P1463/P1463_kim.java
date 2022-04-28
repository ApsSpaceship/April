package study0428;

import java.util.Scanner;

public class backjoon_P1463_1로만들기2 {
	public static int ans = Integer.MAX_VALUE;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		check(n,0);
		System.out.println(ans);
	}

	private static void check(int n, int count) {
		if(n == 1) {
			ans = Math.min(ans, count);
			return;
		}if(n <1) {
			return;
		}
		if(count >= ans) { // 가지치기!
			return;
		}		
		if(n % 3 == 0) {
			check(n/3,count+1);
		}
		if(n % 2 == 0) {
			check(n/2, count+1);
		}
		check(n-1, count+1);
		
	}

}
