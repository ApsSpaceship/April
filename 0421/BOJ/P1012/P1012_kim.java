package study0421;

import java.util.Scanner;

public class baekjoon_1012 {
	static int[][] map;
	static int m,n;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		for(int tn = 1; tn <= tc; tn++) {
			m = sc.nextInt(); // 배추밭 가로길이
			n = sc.nextInt(); // 배추밭 세로길이
			int k = sc.nextInt(); // 배추의 개수
			int ans = 0;
			map = new int[m][n];
			for(int i = 0; i < k; i++) {
				map[sc.nextInt()][sc.nextInt()] = 1; // 배추 위치 표시
			}
			for(int i = 0; i < m; i++) {
				for(int j = 0; j < n; j++) {
					if(map[i][j]==0) continue;
					search(i,j);
					ans++;
					
				}
			}
			System.out.println(ans);
		}

	}
    static int[] dr=  {-1, 1, 0, 0}; // 상하좌우
    static int[] dc = {0, 0, -1, 1}; // 상하좌우
	private static void search(int r, int c) {
		map[r][c] = 0;
		for(int k = 0; k < 4; k++) {
			int nr = r + dr[k];
			int nc = c + dc[k];
			if(nr >=0 && nr < m && nc >= 0 && nc < n && map[nr][nc]==1) {
				search(nr,nc);
			}
		}
		
	}

}
