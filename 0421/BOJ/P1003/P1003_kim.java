package study0421;

import java.util.Scanner;

public class baekjoon_P1003_피보나치함수 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		for (int tn = 1; tn <= tc; tn++) {
			int[][] save = new int[41][2];// N: 최대 40, [0]: 0의 개수 , [1] : 1의 개수
			int num = sc.nextInt();
			save[0][0] = 1; 
			save[0][1] = 0; 
			save[1][0] = 0; 
			save[1][1] = 1;
		
			for(int i = 2; i <= num; i++) {
				save[i][0] = save[i-1][0]+save[i-2][0];
				save[i][1] = save[i-1][1]+save[i-2][1];
			}
			System.out.println(save[num][0]+" "+save[num][1]);
		}
	}

}
