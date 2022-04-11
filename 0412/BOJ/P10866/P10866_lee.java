import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class P10866 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		Deque<Integer> deque = new LinkedList<>();
		StringTokenizer str;
		for (int n = 0; n < N; n++) {
			sb.setLength(0);
			str = new StringTokenizer(br.readLine(), " ");
			switch (str.nextToken()) {
			case "push_front":
				deque.offerFirst(Integer.parseInt(str.nextToken()));
				break;
			case "push_back":
				deque.offerLast(Integer.parseInt(str.nextToken()));
				break;
			case "pop_front":
				if (deque.isEmpty())
					sb.append(-1).append('\n');
				else
					sb.append(deque.pollFirst()).append('\n');
				break;
			case "pop_back":
				if (deque.isEmpty())
					sb.append(-1).append('\n');
				else
					sb.append(deque.pollLast()).append('\n');
				break;
			case "front":
				if (deque.isEmpty())
					sb.append(-1).append('\n');
				else
					sb.append(deque.peekFirst()).append('\n');
				break;
			case "back":
				if (deque.isEmpty())
					sb.append(-1).append('\n');
				else
					sb.append(deque.peekLast()).append('\n');
				break;
			case "size":
				sb.append(deque.size()).append('\n');
				break;
			case "empty":
				if (deque.isEmpty())
					sb.append(1).append('\n');
				else
					sb.append(0).append('\n');
				break;

			}
			System.out.print(sb);
		}
	}
}
