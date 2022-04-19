import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static class Pos implements Comparable<Pos> {
        int x;
        int y;

        public Pos(int x, int y) {
            super();
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Main.Pos o) {
            if (this.x == o.x)
                return this.y - o.y;
            return this.x - o.x;
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int n = sc.nextInt();
        Pos[] arr = new Pos[n];
        for (int i = 0; i < n; ++i)
            arr[i] = new Pos(sc.nextInt(), sc.nextInt());
        Arrays.sort(arr);
        for (int i = 0; i < n; ++i)
            sb.append(arr[i].x + " " + arr[i].y + "\n");
        System.out.print(sb);
    }
}