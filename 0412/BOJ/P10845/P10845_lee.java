import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P10845 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		Queue<Integer> queue = new LinkedList<>();
		StringTokenizer str;
		int lastIn = 0;
		for (int n = 0; n < N; n++) {
			sb.setLength(0);
			str = new StringTokenizer(br.readLine(), " ");
			switch (str.nextToken()) {
			case "push":
				int tmp = Integer.parseInt(str.nextToken());
				queue.offer(tmp);
				lastIn = tmp;
				break;
			case "pop":
				if (queue.isEmpty())
					sb.append(-1).append('\n');
				else
					sb.append(queue.poll()).append('\n');
				break;
			case "front":
				if (queue.isEmpty())
					sb.append(-1).append('\n');
				else
					sb.append(queue.peek()).append('\n');
				break;
			case "back":
				if (queue.isEmpty())
					sb.append(-1).append('\n');
				else
					sb.append(lastIn).append('\n');
				break;
			case "size":
				sb.append(queue.size()).append('\n');
				break;
			case "empty":
				if (queue.isEmpty())
					sb.append(1).append('\n');
				else
					sb.append(0).append('\n');
				break;

			}
			System.out.print(sb);
		}
	}
}
