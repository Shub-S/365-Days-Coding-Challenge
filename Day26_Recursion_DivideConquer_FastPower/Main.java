import java.util.Scanner;

public class Main {

    static final long MOD = 1_000_000_007L;

    static long fastPower(long x, long n) {
        if (n == 0) return 1;

        long half = fastPower(x, n / 2) % MOD;
        long result = (half * half) % MOD;

        if (n % 2 == 1) {
            result = (result * (x % MOD)) % MOD;
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long x = sc.nextLong();
        long n = sc.nextLong();

        System.out.println(fastPower(x, n));
    }
}