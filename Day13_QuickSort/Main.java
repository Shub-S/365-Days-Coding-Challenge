import java.util.Scanner;

public class Main {

    static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }

    static void quickSort(int[] arr, int low, int high) {
        if (low >= high) return;

        int pi = partition(arr, low, high);

        quickSort(arr, low, pi - 1);
        quickSort(arr, pi + 1, high);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = sc.nextInt();

        quickSort(arr, 0, n - 1);

        StringBuilder sb = new StringBuilder();
        for (int idx = 0; idx < n; idx++) {
            sb.append(arr[idx]);
            if (idx != n - 1) sb.append(" ");
        }
        System.out.println(sb.toString());
    }
}