import java.util.Scanner;

public class Main {

    static boolean isSorted(int[] arr, int index) {
        if (index >= arr.length - 1) return true; // base case: 0 or 1 pairs left to check
        return arr[index] <= arr[index + 1] && isSorted(arr, index + 1);
    }

    static int findMax(int[] arr, int index) {
        if (index == arr.length - 1) return arr[index]; // base case: last element
        int maxOfRest = findMax(arr, index + 1);
        return Math.max(arr[index], maxOfRest);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = sc.nextInt();

        System.out.println(isSorted(arr, 0));
        System.out.println(findMax(arr, 0));
    }
}