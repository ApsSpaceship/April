package study0414;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class swea_11650_좌표정렬 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[][] map = new int[n][2]; //[0] : x좌표 , [1] : y좌표
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < 2; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		
		// x 좌표 오름차순 정렬 (만약 x 좌표가 같다면 y좌표 오름차순 정렬)
		Arrays.sort(map, new Comparator<int[]>() {
			public int compare(int[] o1, int[] o2) {
				if(o1[0]==o2[0]) {
					return o1[1]-o2[1];
				}else {
					return o1[0] - o2[0];
				}
			}		
		});
		
		for(int i = 0; i < map.length; i++) {
			for(int j = 0; j < 2; j++) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
	}

}
