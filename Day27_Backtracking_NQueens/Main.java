import java.util.Scanner;

public class Main {

    static int count = 0;
    static int n;

    static void solve(int row, boolean[] cols, boolean[] diag1, boolean[] diag2) {
        if (row == n) {
            count++;
            return;
        }

        for (int col = 0; col < n; col++) {
            int d1 = row - col + n - 1;
            int d2 = row + col;

            if (cols[col] || diag1[d1] || diag2[d2]) continue; // pruning: conflict detected

            // place queen
            cols[col] = diag1[d1] = diag2[d2] = true;

            solve(row + 1, cols, diag1, diag2);

            // undo (backtrack)
            cols[col] = diag1[d1] = diag2[d2] = false;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        boolean[] cols = new boolean[n];
        boolean[] diag1 = new boolean[2 * n - 1];
        boolean[] diag2 = new boolean[2 * n - 1];

        solve(0, cols, diag1, diag2);

        System.out.println(count);
    }
}