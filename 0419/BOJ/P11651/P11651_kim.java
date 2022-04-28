import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class swea_P11651_좌표정렬하기2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[][] map = new int[n][2];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < 2; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		Arrays.sort(map, new Comparator<int[]>() {
			public int compare(int[] o1, int[] o2) {
				if (o1[1] == o2[1]) {
					return o1[0] - o2[0];
				} else {
					return o1[1] - o2[1];
				}
			}

		});

		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < 2; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}

}
