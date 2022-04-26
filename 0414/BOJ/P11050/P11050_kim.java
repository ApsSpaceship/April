import java.util.Scanner;

public class swea_11050_이항계수 {
	public static int num = 0;
	public static void main(String[] args) {
		//자연수 n과 정수 k가 주어졌을 때 이항 계수 구하기.
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		comb(n,k); // nCk = n-1Ck-1 + n-1Ck
		System.out.println(num);
	}

	private static void comb(int n, int k) {
		if(k == 0) {
			num++;
			return;
		}else if(n < k) {
			return;
		}else {
			comb(n-1, k-1); // k를 뽑고가고
			comb(n-1, k); // k를 안뽑고가고
		}
		
	}

}
