import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int[][] matrix = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }

        int[][] transposed = new int[m][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                transposed[j][i] = matrix[i][j];
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                sb.append(transposed[i][j]);
                if (j != n - 1) sb.append(" ");
            }
            sb.append("\n");
        }

        if (n == m) {
            long diagSum = 0;
            for (int i = 0; i < n; i++) {
                diagSum += matrix[i][i];
            }
            sb.append(diagSum);
        } else {
            sb.append("N/A");
        }

        System.out.println(sb.toString());
    }
}