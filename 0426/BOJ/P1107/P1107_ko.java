import java.util.Scanner;

public class BOJ_1107_리모컨 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		boolean broken[] = new boolean[10]; // 버튼 0~9
		int ans = Math.abs(N - 100); // 100에서 시작해서 +-버튼으로만 움직일 때로 초기화

		for (int i = 0; i < M; i++) // 고장난 버튼 입력
			broken[sc.nextInt()] = true;

		for (int i = 0; i <= 1000000; i++) { // i까지 숫자 버튼으로 가고 +-버튼으로 움직일 때
			String now = String.valueOf(i);
			int len = now.length();

			boolean isBroken = false; // 고장난 버튼 번호가 있는지 확인
			for (int j = 0; j < len; j++)
				if (broken[now.charAt(j) - '0']) { // 있으면 그만
					isBroken = true;
					break;
				}

			if (!isBroken) // 고장난 버튼 번호 없으면 최솟값 비교
				ans = Math.min(Math.abs(N - i) + len, ans); // i와 N사이 거리 + 버튼 누른 횟수
		}

		System.out.print(ans);
	}
}