import java.util.*;

public class Main {

    // Q1: Recursive Palindrome Check
    static boolean isPalindromeRec(String s, int left, int right) {
        if (left >= right) return true;
        if (s.charAt(left) != s.charAt(right)) return false;
        return isPalindromeRec(s, left + 1, right - 1);
    }

    // Q2: GCD via Euclidean Algorithm
    static int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }

    // Q3: Letter Combinations of Phone Number
    static void backtrackPhone(String digits, int index, StringBuilder current,
                                 String[] mapping, List<String> result) {
        if (index == digits.length()) {
            result.add(current.toString());
            return;
        }
        String letters = mapping[digits.charAt(index) - '0'];
        for (char c : letters.toCharArray()) {
            current.append(c);
            backtrackPhone(digits, index + 1, current, mapping, result);
            current.deleteCharAt(current.length() - 1); // undo
        }
    }

    static List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits.isEmpty()) return result;
        String[] mapping = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        backtrackPhone(digits, 0, new StringBuilder(), mapping, result);
        return result;
    }

    // Q4: Combination Sum (unlimited reuse)
    static void backtrackSum(int[] candidates, int target, int start,
                               List<Integer> current, List<List<Integer>> result) {
        if (target == 0) {
            result.add(new ArrayList<>(current)); // store a COPY, not a reference
            return;
        }
        if (target < 0) return; // prune

        for (int i = start; i < candidates.length; i++) {
            current.add(candidates[i]);
            // note: pass 'i' (not i+1) to allow reusing the same element
            backtrackSum(candidates, target - candidates[i], i, current, result);
            current.remove(current.size() - 1); // undo
        }
    }

    static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        backtrackSum(candidates, target, 0, new ArrayList<>(), result);
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // --- Q1 ---
        System.out.println("Q1:");
        String s1 = sc.nextLine();
        System.out.println(isPalindromeRec(s1, 0, s1.length() - 1));

        // --- Q2 ---
        System.out.println("Q2:");
        int a = sc.nextInt(), b = sc.nextInt();
        System.out.println(gcd(a, b));

        // --- Q3 ---
        System.out.println("Q3:");
        sc.nextLine();
        String digits3 = sc.nextLine();
        System.out.println(letterCombinations(digits3));

        // --- Q4 ---
        System.out.println("Q4:");
        int n4 = sc.nextInt();
        int[] candidates = new int[n4];
        for (int i = 0; i < n4; i++) candidates[i] = sc.nextInt();
        int target4 = sc.nextInt();
        System.out.println(combinationSum(candidates, target4));

        // --- Q5 (conceptual, printed as text) ---
        System.out.println("Q5: All three follow the same structural template: DIVIDE the problem into smaller subproblem(s) of the same type (halve the search range, halve the array, halve the exponent), CONQUER each subproblem recursively (trusting the recursive call solves it correctly), and COMBINE the results (pick a half, merge two halves, square and multiply). The shared insight is that halving the problem size each step yields O(log n) recursion depth instead of O(n), even though the specific 'combine' operation differs completely between search, sorting, and arithmetic.");
    }
}