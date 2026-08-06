import java.util.*;

public class Main {

    // Q1: Group Anagrams
    static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);
            map.computeIfAbsent(key, k -> new ArrayList<>()).add(s);
        }
        return new ArrayList<>(map.values());
    }

    // Q2: First non-repeating character index
    static int firstUniqChar(String s) {
        int[] freq = new int[26];
        for (char c : s.toCharArray()) freq[c - 'a']++;
        for (int i = 0; i < s.length(); i++) {
            if (freq[s.charAt(i) - 'a'] == 1) return i;
        }
        return -1;
    }

    // Q3: Row-wise duplicate check (ignoring 0s)
    static boolean validRows(int[][] matrix) {
        for (int[] row : matrix) {
            Set<Integer> seen = new HashSet<>();
            for (int val : row) {
                if (val == 0) continue;
                if (!seen.add(val)) return false; // add() returns false if already present
            }
        }
        return true;
    }

    // Q4: Can rearrange into palindrome
    static boolean canBePalindrome(String s) {
        int[] freq = new int[26];
        for (char c : s.toCharArray()) freq[c - 'a']++;
        int oddCount = 0;
        for (int f : freq) {
            if (f % 2 != 0) oddCount++;
        }
        return oddCount <= 1; // at most one odd-frequency character allowed
    }

    // Q5: Rotate + search
    static void rotate(int[][] matrix, int n) {
        for (int i = 0; i < n; i++)
            for (int j = i + 1; j < n; j++) {
                int t = matrix[i][j]; matrix[i][j] = matrix[j][i]; matrix[j][i] = t;
            }
        for (int i = 0; i < n; i++) {
            int left = 0, right = n - 1;
            while (left < right) {
                int t = matrix[i][left]; matrix[i][left] = matrix[i][right]; matrix[i][right] = t;
                left++; right--;
            }
        }
    }

    static int[] searchMatrix(int[][] matrix, int target) {
        for (int i = 0; i < matrix.length; i++)
            for (int j = 0; j < matrix[0].length; j++)
                if (matrix[i][j] == target) return new int[]{i, j};
        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // --- Q1 ---
        System.out.println("Q1:");
        int n1 = sc.nextInt(); sc.nextLine();
        String[] strs = new String[n1];
        for (int i = 0; i < n1; i++) strs[i] = sc.nextLine();
        System.out.println(groupAnagrams(strs));

        // --- Q2 ---
        System.out.println("Q2:");
        String s2 = sc.nextLine();
        System.out.println(firstUniqChar(s2));

        // --- Q3 ---
        System.out.println("Q3:");
        int n3 = sc.nextInt();
        int[][] matrix3 = new int[n3][n3];
        for (int i = 0; i < n3; i++)
            for (int j = 0; j < n3; j++)
                matrix3[i][j] = sc.nextInt();
        System.out.println(validRows(matrix3));

        // --- Q4 ---
        System.out.println("Q4:");
        sc.nextLine();
        String s4 = sc.nextLine();
        System.out.println(canBePalindrome(s4));

        // --- Q5 ---
        System.out.println("Q5:");
        int n5 = sc.nextInt();
        int[][] matrix5 = new int[n5][n5];
        for (int i = 0; i < n5; i++)
            for (int j = 0; j < n5; j++)
                matrix5[i][j] = sc.nextInt();
        int target5 = sc.nextInt();
        rotate(matrix5, n5);
        StringBuilder sb = new StringBuilder();
        for (int[] row : matrix5) {
            for (int v : row) sb.append(v).append(" ");
            sb.append("\n");
        }
        System.out.print(sb);
        int[] pos = searchMatrix(matrix5, target5);
        System.out.println(pos[0] + " " + pos[1]);
    }
}