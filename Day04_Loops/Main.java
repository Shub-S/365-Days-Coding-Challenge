import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        StringBuilder sb = new StringBuilder();
        long sum = 0;

        for (int i = 1; i <= n; i++) {
            sb.append(i);
            if (i != n) sb.append(" ");
            sum += i;
        }

        System.out.println(sb.toString());
        System.out.println(sum);
    }
}