import java.util.Scanner;

public class Main {
    static final int MOD = 1234567891;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int L = sc.nextInt();
        char[] str = sc.next().toCharArray();
        System.out.println(HashFunc(str));
    }

    static int HashFunc(char[] str) {
        long ret = 0;
        for (int i = 0; i < str.length; ++i) {
            ret += (long) (str[i] - 'a' + 1) * Pow(31, i);
            ret %= MOD;
        }
        return (int) ret;
    }

    static int Pow(int r, int n) {
        long ret = 1;
        for (int i = 0; i < n; ++i) {
            ret *= r;
            ret %= MOD;
        }
        return (int) ret;
    }
}