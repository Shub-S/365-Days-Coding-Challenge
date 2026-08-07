import java.util.Scanner;

public class Main {

    static long factorial(int n) {
        if (n <= 1) return 1; // base case
        return n * factorial(n - 1); // recursive case
    }

    static long fib(int k) {
        if (k == 0) return 0; // base case 1
        if (k == 1) return 1; // base case 2
        return fib(k - 1) + fib(k - 2); // recursive case
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        System.out.println(factorial(n));
        System.out.println(fib(k));
    }
}