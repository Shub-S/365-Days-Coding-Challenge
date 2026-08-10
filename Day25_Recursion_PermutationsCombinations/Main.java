import java.util.*;

public class Main {

    static void backtrack(int[] arr, List<Integer> current, boolean[] used, StringBuilder output) {
        if (current.size() == arr.length) {
            StringBuilder line = new StringBuilder();
            for (int i = 0; i < current.size(); i++) {
                line.append(current.get(i));
                if (i != current.size() - 1) line.append(" ");
            }
            output.append(line).append("\n");
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            if (used[i]) continue; // skip already-used elements

            used[i] = true;
            current.add(arr[i]);

            backtrack(arr, current, used, output);

            // undo (backtrack step)
            current.remove(current.size() - 1);
            used[i] = false;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = sc.nextInt();

        StringBuilder output = new StringBuilder();
        backtrack(arr, new ArrayList<>(), new boolean[n], output);

        System.out.print(output);
    }
}