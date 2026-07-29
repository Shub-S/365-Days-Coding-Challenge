import java.util.*;

public class Main {

    // Q1: Second largest in O(n)
    static int secondLargest(int[] arr) {
        int first = Integer.MIN_VALUE, second = Integer.MIN_VALUE;
        for (int x : arr) {
            if (x > first) {
                second = first;
                first = x;
            } else if (x > second && x != first) {
                second = x;
            }
        }
        return second;
    }

    // Merge Sort (reused from Day 12)
    static void merge(int[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1, n2 = right - mid;
        int[] L = new int[n1], R = new int[n2];
        for (int i = 0; i < n1; i++) L[i] = arr[left + i];
        for (int j = 0; j < n2; j++) R[j] = arr[mid + 1 + j];
        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) arr[k++] = (L[i] <= R[j]) ? L[i++] : R[j++];
        while (i < n1) arr[k++] = L[i++];
        while (j < n2) arr[k++] = R[j++];
    }
    static void mergeSort(int[] arr, int left, int right) {
        if (left >= right) return;
        int mid = left + (right - left) / 2;
        mergeSort(arr, left, mid);
        mergeSort(arr, mid + 1, right);
        merge(arr, left, mid, right);
    }

    // Binary Search (reused from Day 9)
    static int binarySearch(int[] arr, int x) {
        int low = 0, high = arr.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == x) return mid;
            else if (arr[mid] < x) low = mid + 1;
            else high = mid - 1;
        }
        return -1;
    }

    // Quick Sort (reused from Day 13)
    static int partition(int[] arr, int low, int high) {
        int pivot = arr[high], i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                int t = arr[i]; arr[i] = arr[j]; arr[j] = t;
            }
        }
        int t = arr[i + 1]; arr[i + 1] = arr[high]; arr[high] = t;
        return i + 1;
    }
    static void quickSort(int[] arr, int low, int high) {
        if (low >= high) return;
        int pi = partition(arr, low, high);
        quickSort(arr, low, pi - 1);
        quickSort(arr, pi + 1, high);
    }

    // Q3: Count pairs with sum == target (two-pointer on sorted array)
    static int countPairs(int[] arr, int target) {
        quickSort(arr, 0, arr.length - 1);
        int left = 0, right = arr.length - 1, count = 0;
        while (left < right) {
            int sum = arr[left] + arr[right];
            if (sum == target) {
                count++;
                left++;
                right--;
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
        return count;
    }

    // Q5: Dedup + sort + binary search
    static int[] dedupSorted(int[] arr) {
        int[] copy = arr.clone();
        mergeSort(copy, 0, copy.length - 1);
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < copy.length; i++) {
            if (i == 0 || copy[i] != copy[i - 1]) result.add(copy[i]);
        }
        int[] out = new int[result.size()];
        for (int i = 0; i < out.length; i++) out[i] = result.get(i);
        return out;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // --- Q1 ---
        System.out.println("Q1:");
        int n1 = sc.nextInt();
        int[] arr1 = new int[n1];
        for (int i = 0; i < n1; i++) arr1[i] = sc.nextInt();
        System.out.println(secondLargest(arr1));

        // --- Q2 ---
        System.out.println("Q2:");
        int n2 = sc.nextInt();
        int[] arr2 = new int[n2];
        for (int i = 0; i < n2; i++) arr2[i] = sc.nextInt();
        int x2 = sc.nextInt();
        mergeSort(arr2, 0, n2 - 1);
        StringBuilder sb2 = new StringBuilder();
        for (int v : arr2) sb2.append(v).append(" ");
        System.out.println(sb2.toString().trim());
        System.out.println(binarySearch(arr2, x2));

        // --- Q3 ---
        System.out.println("Q3:");
        int n3 = sc.nextInt();
        int[] arr3 = new int[n3];
        for (int i = 0; i < n3; i++) arr3[i] = sc.nextInt();
        int target3 = sc.nextInt();
        System.out.println(countPairs(arr3, target3));

        // --- Q4 (conceptual, printed as text) ---
        System.out.println("Q4: Insertion Sort would perform best (near O(n)) since the array is nearly sorted — only ~2 misplaced elements means minimal shifting. Merge Sort still does full O(n log n) regardless of input order. Quick Sort (last-element pivot) risks degrading toward O(n^2) on nearly-sorted data due to unbalanced partitions.");

        // --- Q5 ---
        System.out.println("Q5:");
        int n5 = sc.nextInt();
        int[] arr5 = new int[n5];
        for (int i = 0; i < n5; i++) arr5[i] = sc.nextInt();
        int target5 = sc.nextInt();
        int[] deduped = dedupSorted(arr5);
        StringBuilder sb5 = new StringBuilder();
        for (int v : deduped) sb5.append(v).append(" ");
        System.out.println(sb5.toString().trim());
        System.out.println(binarySearch(deduped, target5));
    }
}