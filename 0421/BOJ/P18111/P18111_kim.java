package study0421;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class baekjoon_18111 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken()); // 가로
		int m = Integer.parseInt(st.nextToken()); // 세로
		int b = Integer.parseInt(st.nextToken()); // 인벤토리 블록 수
		int[][] map = new int[n][m];
		int max = 0;
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				max = Math.max(map[i][j], max);
				min = Math.min(map[i][j], min);
			}
		}
		int anstime = Integer.MAX_VALUE;
		int height = 0;
		// 땅의 높이가 될 수 있는 범위
		for (int i = min; i <= max; i++) {
			int block = b;
			int time = 0;
			for (int j = 0; j < n; j++) {
				for (int k = 0; k < m; k++) {
					if (map[j][k] > i) { // 깎아야 함
						block += (map[j][k] - i); // 깎은 블록 인벤토리에 저장
						time += (map[j][k] - i) * 2; // 깎는데 블록 하나당 2초씩 걸림
					} else {
						block -= (i - map[j][k]); // 쌓아야 하는 높이만큼 인벤토리에 블록 제거
						time += (i - map[j][k]); // 쌓는데 1초씩 걸림
					}
		 		}
			}
		    //인벤토리에 블록이 0 이상이여야만 평탄화가 잘 진행된 것! && 높이의 최댓값을 구하는 것이라 시간 비교에 등호가 들어간다.
			if (block >= 0 && anstime >= time) {
				anstime = time;
				height = i;
			}
		}
		System.out.println(anstime + " " + height);
	}

}
