package study_0405;

import java.util.Arrays;
import java.util.Scanner;

public class programmers_양궁대회3 {
	public static int[] apeach;
	public static int[] ans;
	public static int[] now;
	public static int n;
	public static int max;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		apeach = new int[11];
		now = new int[11];
		ans = new int[11];
		for(int i = 0; i < 11; i++) {
			apeach[i] = sc.nextInt();
		}
		max = 0;	
		search(1);
		System.out.println(Arrays.toString(ans));
	}	
	public static void search(int num) {
		if(num == n+1) {
			int apeachget = 0;
			int lionget = 0;
			for(int i = 0; i < 11; i++) {
				if(apeach[i] != 0 && apeach[i] >= now[i]) {
					apeachget += 10-i;
				}else if(now[i] != 0 && now[i] > apeach[i]) {
					lionget += 10-i;
				}
			}
			if(lionget > apeachget && lionget-apeachget >= max) {
				max = lionget-apeachget;
				for(int i = 0; i < 11; i++) {
					ans[i] = now[i]; // 정답 배열에 값 복사.
				}
			}
			return;
		}
		//apeach보다 많이 맞춰야 lion이 점수를 획득해서 now[i] <= apeach[i] 까지 조건을 줌
		for(int i = 0; i < 11 && now[i] <= apeach[i] ; i++) {
			now[i]++;
			search(num+1);
			now[i]--;
		}
	}

}
