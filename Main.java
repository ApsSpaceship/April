import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int n = sc.nextInt();
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < n; ++i) {
            String str = sc.next();
            switch (str) {
                case "push":
                    int a = sc.nextInt();
                    st.push(a);
                    break;
                case "pop":
                    if (st.empty())
                        sb.append("-1\n");
                    else
                        sb.append(st.pop() + "\n");
                    break;
                case "size":
                    sb.append(st.size() + "\n");
                    break;
                case "empty":
                    if (st.empty())
                        sb.append("1\n");
                    else
                        sb.append("0\n");
                    break;
                case "top":
                    if (st.empty())
                        sb.append("-1\n");
                    else
                        sb.append(st.peek() + "\n");
                    break;
            }
        }
        System.out.print(sb);
    }
}