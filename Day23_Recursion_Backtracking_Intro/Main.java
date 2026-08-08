import java.util.*;

public class Main {

    static void backtrack(int index, int n, List<Integer> current, StringBuilder output) {
        if (index > n) {
            StringBuilder line = new StringBuilder();
            for (int i = 0; i < current.size(); i++) {
                line.append(current.get(i));
                if (i != current.size() - 1) line.append(" ");
            }
            output.append(line).append("\n");
            return;
        }

        // Choice 1: Include 'index'
        current.add(index);
        backtrack(index + 1, n, current, output);
        current.remove(current.size() - 1); // undo (backtrack step)

        // Choice 2: Exclude 'index'
        backtrack(index + 1, n, current, output);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        StringBuilder output = new StringBuilder();
        backtrack(1, n, new ArrayList<>(), output);

        System.out.print(output);
    }
}