import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String input = sc.next();
		int len = input.length();
		int ans = 0;
		int isMinus = 1; // - 안 만난 경우로 초기화
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < len; i++) {
			if (input.charAt(i) >= '0') // 숫자면
				sb.append(input.charAt(i));
			else { // 기호면
				ans += Integer.parseInt(sb.toString()) * isMinus;
				sb.setLength(0); // 스트링빌더 초기화
				if (input.charAt(i) == '-') // -이후론 다 음수로 계산
					isMinus = -1;
			}
		}
		ans += Integer.parseInt(sb.toString()) * isMinus; // 마지막 숫자 계산

		System.out.print(ans); // 출력
	}

}