import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class swea_10989_수정렬2 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
	    int[] count = new int[10001]; // 최대가 10000이라 10001로 배열 생성
	    for(int i = 0; i < arr.length; i++) {
	    	count[arr[i]]++;
	    }
	    
	    //누적 합 구하기
	    for(int i = 1; i < count.length; i++) {
	    	count[i] += count[i-1];
	    }
		
	    int[] ans = new int[n];
	    for(int i = n-1; i >=0; i--) {
	    	ans[--count[arr[i]]] = arr[i];
	    }
	    
	    for(int i = 0; i < ans.length; i++) {
			sb.append(ans[i]).append("\n");
		}	
		
		System.out.println(sb.toString());	
	}
}
