import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class bj_10989_수정렬하기3 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		int[] arr = new int[T];
		
		for(int i=0; i<T; i++) {
			
			arr[i] = Integer.parseInt(br.readLine());
			
		}
		
		Arrays.sort(arr);
		
		StringBuilder sb = new StringBuilder();
		
		for(int x : arr) {
			sb.append(x).append("\n");
		}
		
		System.out.println(sb);
	}

}
