import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        List<Integer> list = new ArrayList<Integer>();

        int sign = 1;
        int idx = 0;
        for (int i = 0; i < str.length(); ++i) {
            char c = str.charAt(i);
            if (c == '+' || c == '-') {
                list.add(sign * Integer.parseInt(str.substring(idx, i)));
                if (c == '-')
                    sign = -1;
                idx = i + 1;
            }
        }
        list.add(sign * Integer.parseInt(str.substring(idx, str.length())));

        int ans = 0;
        for (int x : list)
            ans += x;
        System.out.println(ans);
    }
}