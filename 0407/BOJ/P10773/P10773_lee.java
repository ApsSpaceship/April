import java.util.Scanner;
import java.util.Stack;

public class P10773 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int K = sc.nextInt();
		Stack<Integer> stack = new Stack<>();
		for(int i = 0; i <K; i++) {
			int num = sc.nextInt();
			if(num ==0 ) {
				if(stack.isEmpty()) {
					stack.add(0);
				}else {
					stack.pop();
				}
			}else {
				stack.add(num);
			}
		}
		int ans = 0;
		while(!stack.isEmpty()) {
			ans += stack.pop();
		}
		System.out.println(ans);
	}
}
