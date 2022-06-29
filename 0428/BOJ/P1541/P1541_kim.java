package study0428;

import java.util.Arrays;
import java.util.Scanner;

public class baekjoon_P1541 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String cal = sc.next();
		int sum = 0;
		String[] check = cal.split("-"); // -를 기준으로 나누고 맨 앞에만 더해주고 나머지는 빼준다!
		for (int i = 0; i < check.length; i++) {
			if (i == 0) {
				// split은 정규식을 받기 때문에 +만 하면 에러나서 \\ 표시를 붙여 이스케이프 처리를 해야 한다.
				// 이스케이프 처리할 때 \도 단독으로 출력할 수 없어서 백슬래시 자체도 이스케이프 처리를 해야 해서 \\ 사용한다.
				// -> split 메소드에서 특수문자를 기준으로 분리할 때 \\ 붙여야 함!
				String[] plus = check[i].split("\\+"); 
				for (int j = 0; j < plus.length; j++) {
					sum += Integer.parseInt(plus[j]);
				}
			} else {
				String[] minus = check[i].split("\\+");
				for (int j = 0; j < minus.length; j++) {
					sum -= Integer.parseInt(minus[j]);
				}
			}
		}
		System.out.println(sum);
	}

}
