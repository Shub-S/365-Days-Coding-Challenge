import java.util.Scanner;

public class Main {

    // Q2: factorial using loop
    static long factorial(int n) {
        long result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    // Q3: prime check (from Day 6)
    static boolean isPrime(int n) {
        if (n <= 1) return false;
        if (n == 2) return true;
        if (n % 2 == 0) return false;
        for (int i = 3; (long) i * i <= n; i += 2) {
            if (n % i == 0) return false;
        }
        return true;
    }

    // Q4: overloaded power
    static int power(int base, int exp) {
        int result = 1;
        for (int i = 0; i < exp; i++) result *= base;
        return result;
    }

    static double power(double base, int exp) {
        double result = 1.0;
        for (int i = 0; i < exp; i++) result *= base;
        return result;
    }

    // Q5: isEven helper
    static boolean isEven(int x) {
        return x % 2 == 0;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // --- Q1 ---
        System.out.println("Q1:");
        int a = sc.nextInt(), b = sc.nextInt();
        if (a > b) System.out.println(a);
        else if (b > a) System.out.println(b);
        else System.out.println("Equal");

        // --- Q2 ---
        System.out.println("Q2:");
        int n2 = sc.nextInt();
        System.out.println(factorial(n2));

        // --- Q3 ---
        System.out.println("Q3:");
        int n3 = sc.nextInt();
        StringBuilder primes = new StringBuilder();
        for (int i = 2; i <= n3; i++) {
            if (isPrime(i)) primes.append(i).append(" ");
        }
        System.out.println(primes.toString().trim());

        // --- Q4 ---
        System.out.println("Q4:");
        int base4 = sc.nextInt(), exp4 = sc.nextInt();
        System.out.println(power(base4, exp4));
        System.out.println(power((double) base4, exp4));

        // --- Q5 ---
        System.out.println("Q5:");
        int n5 = sc.nextInt();
        StringBuilder pattern = new StringBuilder();
        for (int i = 1; i <= n5; i++) {
            StringBuilder row = new StringBuilder();
            for (int j = 2; j <= 2 * i; j += 2) {
                if (isEven(j)) row.append(j).append(" ");
            }
            pattern.append(row.toString().trim()).append("\n");
        }
        System.out.print(pattern);
    }
}
