import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;


public class lv1_실패율 {
	public static void main(String[] args) {
		
		int N = 5;
		
		int[] stages = {2, 1, 2, 6, 2, 4, 3, 3};	
		
		int[] user = new int[N+2];
		
		int[] sum = new int[N+2];
		
		for(int i = 0; i<stages.length; i++) {
			
			user[stages[i]]++;
			
			for(int j = 1; j<=stages[i]; j++) {
				
				sum[j]++;
			}
		}
		
		Map<Double, Integer> map = new HashMap<>();
		
		Double[] fail = new Double[N];
		
		for(int i = 0; i<N; i++) {
			if(sum[i+1] != 0) {
				fail[i] = (user[i+1]/(double)sum[i+1]);
			}else {
				fail[i] = (double) 0;
			}
			
			map.put(fail[i], i+1);
		}
		
		Arrays.sort(fail, Collections.reverseOrder());
		
		System.out.println(Arrays.toString(fail));

		for(int i=0; i<fail.length; i++) {
			System.out.print(map.get(fail[i]));
		}
	
		// 아차... 실패율 같은게 있으니  맵 저장 저렇게 하면 안되지...라는걸 깨달은게 8시 57분..
		
	}
	

}
