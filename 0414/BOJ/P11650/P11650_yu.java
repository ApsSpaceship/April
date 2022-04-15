import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class bj_11650_좌표정렬하기 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		int[][] arr = new int[N][2];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < 2; j++) {
				arr[i][j] = sc.nextInt();
			}
		}

		Arrays.sort(arr, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {

				if (o1[0] == o2[0]) { // x좌표값이 같을 때
					 return o1[1] - o2[1];
					//return Integer.compare(o1[1], o2[1]);
				}
				return Integer.compare(o1[0], o2[0]); // x좌표 기준 정렬
			}
		});

		for (int i = 0; i < N; i++) {
			System.out.println(arr[i][0] + " " + arr[i][1]);
		}
	}

}
