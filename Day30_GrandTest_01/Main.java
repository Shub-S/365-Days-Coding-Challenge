import java.util.*;

public class Main {

    // Q1: Longest Consecutive Sequence — O(n) using HashSet
    static int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) set.add(num);

        int longest = 0;

        for (int num : set) {
            // Only start counting from the beginning of a sequence
            // (i.e., num-1 is NOT in the set) — avoids redundant re-counting
            if (!set.contains(num - 1)) {
                int currentNum = num;
                int currentLength = 1;

                while (set.contains(currentNum + 1)) {
                    currentNum++;
                    currentLength++;
                }
                longest = Math.max(longest, currentLength);
            }
        }
        return longest;
    }

    // Q2: Case Permutations (recursive backtracking)
    static void backtrackCase(char[] chars, int index, List<String> result) {
        if (index == chars.length) {
            result.add(new String(chars));
            return;
        }

        if (Character.isLetter(chars[index])) {
            // Try lowercase
            chars[index] = Character.toLowerCase(chars[index]);
            backtrackCase(chars, index + 1, result);
            // Try uppercase
            chars[index] = Character.toUpperCase(chars[index]);
            backtrackCase(chars, index + 1, result);
        } else {
            // Digit — no choice, just move on
            backtrackCase(chars, index + 1, result);
        }
    }

    static List<String> letterCasePermutation(String s) {
        List<String> result = new ArrayList<>();
        backtrackCase(s.toCharArray(), 0, result);
        return result;
    }

    // Q3: Word Search (Backtracking on Grid)
    static boolean exist(char[][] board, String word) {
        int rows = board.length, cols = board[0].length;
        boolean[][] visited = new boolean[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (dfs(board, word, 0, i, j, visited)) return true;
            }
        }
        return false;
    }

    static boolean dfs(char[][] board, String word, int idx, int r, int c, boolean[][] visited) {
        if (idx == word.length()) return true;
        if (r < 0 || r >= board.length || c < 0 || c >= board[0].length) return false;
        if (visited[r][c] || board[r][c] != word.charAt(idx)) return false;

        visited[r][c] = true;

        boolean found = dfs(board, word, idx + 1, r + 1, c, visited) ||
                         dfs(board, word, idx + 1, r - 1, c, visited) ||
                         dfs(board, word, idx + 1, r, c + 1, visited) ||
                         dfs(board, word, idx + 1, r, c - 1, visited);

        visited[r][c] = false; // undo (backtrack)
        return found;
    }

    // Q4: Remove all nodes with value k
    static class Node {
        int data;
        Node next;
        Node(int data) { this.data = data; }
    }

    static Node removeElements(Node head, int k) {
        // Use a dummy node to simplify head-removal edge case
        Node dummy = new Node(-1);
        dummy.next = head;
        Node prev = dummy, current = head;

        while (current != null) {
            if (current.data == k) {
                prev.next = current.next; // skip current
            } else {
                prev = current;
            }
            current = current.next;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // --- Q1 ---
        System.out.println("Q1:");
        int n1 = sc.nextInt();
        int[] nums1 = new int[n1];
        for (int i = 0; i < n1; i++) nums1[i] = sc.nextInt();
        System.out.println(longestConsecutive(nums1));

        // --- Q2 ---
        System.out.println("Q2:");
        sc.nextLine();
        String s2 = sc.nextLine();
        System.out.println(letterCasePermutation(s2));

        // --- Q3 ---
        System.out.println("Q3:");
        int rows = sc.nextInt(), cols = sc.nextInt();
        char[][] board = new char[rows][cols];
        sc.nextLine();
        for (int i = 0; i < rows; i++) {
            String row = sc.nextLine();
            for (int j = 0; j < cols; j++) board[i][j] = row.charAt(j);
        }
        String word3 = sc.nextLine();
        System.out.println(exist(board, word3));

        // --- Q4 ---
        System.out.println("Q4:");
        int n4 = sc.nextInt();
        Node head = null, tail = null;
        for (int i = 0; i < n4; i++) {
            Node newNode = new Node(sc.nextInt());
            if (head == null) { head = newNode; tail = newNode; }
            else { tail.next = newNode; tail = newNode; }
        }
        int k4 = sc.nextInt();
        Node result = removeElements(head, k4);
        StringBuilder sb = new StringBuilder();
        while (result != null) {
            sb.append(result.data);
            if (result.next != null) sb.append(" ");
            result = result.next;
        }
        System.out.println(sb.toString());
    }
}