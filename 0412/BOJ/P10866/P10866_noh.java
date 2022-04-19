import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int n = sc.nextInt();
        Deque<Integer> dq = new ArrayDeque<Integer>();
        for (int i = 0; i < n; ++i) {
            String str = sc.next();
            switch (str) {
                case "push_front":
                    int a = sc.nextInt();
                    dq.addFirst(a);
                    break;
                case "push_back":
                    int b = sc.nextInt();
                    dq.addLast(b);
                    break;
                case "pop_front":
                    if (dq.isEmpty())
                        sb.append("-1\n");
                    else
                        sb.append(dq.pollFirst() + "\n");
                    break;
                case "pop_back":
                    if (dq.isEmpty())
                        sb.append("-1\n");
                    else
                        sb.append(dq.pollLast() + "\n");
                    break;
                case "size":
                    sb.append(dq.size() + "\n");
                    break;
                case "empty":
                    if (dq.isEmpty())
                        sb.append("1\n");
                    else
                        sb.append("0\n");
                    break;
                case "front":
                    if (dq.isEmpty())
                        sb.append("-1\n");
                    else
                        sb.append(dq.peekFirst() + "\n");
                    break;
                case "back":
                    if (dq.isEmpty())
                        sb.append("-1\n");
                    else
                        sb.append(dq.peekLast() + "\n");
                    break;
            }
        }
        System.out.print(sb);
    }
}