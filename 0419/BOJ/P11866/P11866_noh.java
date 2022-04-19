import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int n = sc.nextInt();
        int k = sc.nextInt();
        Queue<Integer> q = new LinkedList<Integer>();
        for (int i = 1; i <= n; ++i)
            q.add(i);

        sb.append("<");
        for (int i = 0; i < k - 1; ++i)
            q.add(q.poll());
        sb.append(q.poll());
        while (!q.isEmpty()) {
            for (int i = 0; i < k - 1; ++i)
                q.add(q.poll());
            sb.append(", " + q.poll());
        }
        sb.append(">");
        System.out.print(sb);
    }
}