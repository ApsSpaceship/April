import java.util.Scanner;

public class swea_15829_hasing {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int m = 1234567891;
		int n = sc.nextInt();
		String words = sc.next();
		long ans = 0;
		long r = 1;
		for(int i = 0; i < n; i++) {
			char c = words.charAt(i);
			int num = c-'a'+1; // 아스키코드 이용! a가 1이어야 해서 +1 해주었다.
			ans += ((num*r)%m);
			r = (r * 31) % m; // Math.pow(31, i) 로 했을 시  나중에 long의 범위를 벗어남! 따라서 연산마다 나눠줌
		}
		
		System.out.println(ans%m);
	}

}
