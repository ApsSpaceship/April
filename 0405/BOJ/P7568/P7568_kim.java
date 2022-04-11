package study_0405;

import java.util.Scanner;

public class BAEKJOON_P7568_덩치 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); // 사람 수
		int[][] size = new int[n][2];
		for(int i=0; i < n; i++) {
			size[i][0] = sc.nextInt(); // 몸무게
			size[i][1] = sc.nextInt(); // 키
		}
		int check = 0;
		while(check < n) {
			int grade = 1;
			for(int i = 0; i < n; i++) {
				if(check == i) continue; // 나 자신은 비교할 필요가 없으니까
				if(size[check][0] < size[i][0] && size[check][1] < size[i][1]) {
					grade++;
				}
			}
			System.out.print(grade+" ");
			check++;
		}		
	}

}
