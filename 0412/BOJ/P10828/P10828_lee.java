import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class P10828 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb= new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		Stack<Integer> stack = new Stack<>();
		StringTokenizer str;
		for (int n = 0; n < N; n++) {
			sb.setLength(0);
			str = new StringTokenizer(br.readLine(), " ");
			switch (str.nextToken()) {
			case "push":
				stack.push(Integer.parseInt(str.nextToken()));
				break;
			case "top":
				if (stack.isEmpty())
					sb.append(-1).append('\n');
				else
					sb.append(stack.peek()).append('\n');
				break;
			case "size":
				sb.append(stack.size()).append('\n');
				break;
			case "empty":
				if (stack.isEmpty())
					sb.append(1).append('\n');
				else
					sb.append(0).append('\n');
				break;
			case "pop":
				if (stack.isEmpty())
					sb.append(-1).append('\n');
				else
					sb.append(stack.pop()).append('\n');
				break;
			}
			System.out.print(sb);
		}
	}
}
