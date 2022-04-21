import java.util.HashMap;
import java.util.Scanner;

public class P10816 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		HashMap<Integer, Integer> hm = new HashMap<>();
		int N = sc.nextInt();
		for(int i = 0; i < N; i++) {
			int key = sc.nextInt();
			// HashMap.getOrDefault(key, default value)
			// key 없으면 default value 반환, key 있으면 저장된 value 반환
			hm.put(key, hm.getOrDefault(key, 0)+1);
		}
		int M = sc.nextInt();
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < M; i++) {
			int key = sc.nextInt();
			sb.append(hm.getOrDefault(key, 0)).append(" ");
		}
		System.out.println(sb);
		
	}
}
