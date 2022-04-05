import java.util.Scanner;

public class BOJ_9012_괄호 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			char[] str = sc.next().toCharArray();
			int size = str.length;
			int num = 0; // 짝 못 찾은 열린 괄호 개수
			String ans = "YES";

			for (int i = 0; i < size; i++) {
				if (str[i] == '(')
					num++;
				else if (num > 0)
					num--;
				else {
					ans = "NO";
					break;
				}
			}

			if (num > 0)
				ans = "NO";

			System.out.println(ans);
		}
	}

}
