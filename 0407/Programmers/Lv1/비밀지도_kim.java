package study_0407;

import java.util.Scanner;

public class programmers_비밀지도 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		String[] map1 = new String[n];
		String[] map2 = new String[n];
		int[] map1info = new int[n];
		int[] map2info = new int[n];
		for(int i = 0; i < n; i++) {
			map1info[i] = sc.nextInt();
		}
		for(int j = 0; j < n; j++) {
			map2info[j] = sc.nextInt();
		}
		String[] ans = new String[n];
		for(int i = 0; i < n; i++) {
			String b = Integer.toBinaryString(map1info[i]); // 이진수로 표현
			String c = Integer.toBinaryString(map2info[i]); // 이진수로 표현
			// map의 길이와 일치할 때 까지 앞에 0을 붙인다.
			while(b.length()!=n) {
				b = "0"+b;
			}
			while(c.length()!=n) {
				c = "0"+c;
			}
			String hint = "";
			for(int j = 0; j < n; j++) {
				if(b.charAt(j)=='1'||c.charAt(j)=='1') {
					hint += "#";
				}else if(b.charAt(j)=='0'&& c.charAt(j)=='0') {
					hint += " ";
				}
			}
			ans[i] = hint;
		}		
	}

}
