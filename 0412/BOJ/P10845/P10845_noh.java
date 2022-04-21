import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int n = sc.nextInt();
        Queue<Integer> q = new LinkedList<Integer>();
        int temp = -1;
        for (int i = 0; i < n; ++i) {
            String str = sc.next();
            switch (str) {
                case "push":
                    int a = sc.nextInt();
                    q.add(a);
                    temp = a;
                    break;
                case "pop":
                    if (q.isEmpty())
                        sb.append("-1\n");
                    else
                        sb.append(q.poll() + "\n");
                    break;
                case "size":
                    sb.append(q.size() + "\n");
                    break;
                case "empty":
                    if (q.isEmpty())
                        sb.append("1\n");
                    else
                        sb.append("0\n");
                    break;
                case "front":
                    if (q.isEmpty())
                        sb.append("-1\n");
                    else
                        sb.append(q.peek() + "\n");
                    break;
                case "back":
                    if (q.isEmpty())
                        sb.append("-1\n");
                    else
                        sb.append(temp + "\n");
                    break;
            }
        }
        System.out.print(sb);
    }
}