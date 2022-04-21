import java.util.Scanner;

public class bj_11050_이항계수1 {
	
	static int ans;
	static int N, K;
	static int[] narr;
	static int[] sel;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		
		K = sc.nextInt();
		
		ans = 0;
		
		narr = new int[N];

		sel = new int[K];
		
		combination(0, 0);
		
		System.out.println(ans);
	}
	
	static void combination(int idx, int sidx) {
		
		if(sidx == K) {
			ans++;
		}else if(idx >= N) {
			return;
		}else {
			
			sel[sidx] = narr[idx];
			combination(idx+1, sidx+1);
			combination(idx+1, sidx);
		}
	}

}
