package study0426;

import java.util.Scanner;

public class baekjoon1107_리모컨 {  
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); // 이동할 번호
		int none = sc.nextInt(); // 누를 수 없는 숫자 개수
		boolean[] not = new boolean[10]; // 누를 수 없는 숫자들
		for(int i = 0; i < none; i++) {
			not[sc.nextInt()] = true;
		}
		int check = Math.abs(100-n); // +,- 버튼으로 번호까지 이동할때 누르는 횟수
		out: for(int i = 0; i < 999999; i++) {
			String num = Integer.toString(i);
			for(int j = 0; j < num.length(); j++) {
				if(not[num.charAt(j)-'0']) {
					continue out;
				}
			}
			check = Math.min(check, num.length()+Math.abs(n-i)); // 현재번호길이 + |이동할번호 - 현재번호|
			
		}
		System.out.println(check);
		
		
		
		
		
		
		
	}

}
