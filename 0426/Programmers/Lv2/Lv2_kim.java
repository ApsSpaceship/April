package study0426;

import java.util.Arrays;

public class programmers_lv2_거리두기확인하기 {
	static int[] dr = {-1, 0, 1, 0,}; // 12,3,6,9시 시계방향
	static int[] dc = {0, 1, 0, -1};
	static int[] drx = {-1, 1, 1, -1}; // 대각선 시계방향
	static int[] dcx = {1, 1, -1, -1};
	
	static boolean flag;
	static char[][] check;
	public static void main(String[] args) {
		String[][] places = { { "POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP" },
				{ "POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP" }, { "PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX" },
				{ "OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO" }, { "PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP" } };
		
		int[] ans = new int[5]; // 정답배열
		for(int i = 0; i < places.length; i++) {
			check = new char[5][5]; // 5*5 사이즈 배열에 값 저장
			for(int j =0 ; j< 5; j++) {
				String a = places[i][j];
				for(int k = 0; k < a.length(); k++) {
					check[j][k] = a.charAt(k);
				}
			}
			flag = true; // 거리두기 준수 여부
			for(int j = 0; j <5; j++) {
				for(int k = 0; k <5; k++) {
					if(check[j][k] == 'P' && flag == true) { // 사람이 있고 현재까지 거리두기 준수하면 확인
						confirm(j,k);
					}
				}
			}
			if(flag == true) { // 거리두기가 지켜졌으면 1 아니면 0 담기
				ans[i] = 1;
			}else {
				ans[i] = 0;
			}			
		}
		System.out.println(Arrays.toString(ans));
	
	}
	private static void confirm(int r, int c) {
		// 상하좌우 각 2칸 체크
		for(int i = 0; i < 4; i++) { 
			boolean block = false; // 칸막이 여부
			for(int j = 1; j <=2; j++) {
				int nr = r + dr[i]*j;
				int nc = c + dc[i]*j;
				if(nr >= 0 && nr < 5&& nc >=0&& nc < 5) {
					if(check[nr][nc] == 'P' && block == false) { // 사람이 있는데 칸막이가 없으면
						flag = false; // 거리두기 안지켜짐
						return;
					}else if(check[nr][nc] == 'X') {
					   block = true; // 칸막이 있음
					}
				}
			}
		}
		
		for(int i = 0; i < 4; i++) { // 대각선 4방향 탐색
			int xr = r + drx[i];
			int xc = c + dcx[i];
			if(xr >= 0 && xr < 5&& xc >=0&& xc < 5 && check[xr][xc]=='P') {
				for(int j = i;j <= (i+1)%4 ; j++) {
					if(check[r+dr[j]][c+dc[j]]!='X') { // 인접한 칸에 칸막이가 없으면
						flag = false; // 거리두기 안지켜짐
						return;
					}
				}
			}
		}
		
	}

}
