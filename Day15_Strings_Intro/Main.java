import java.util.Scanner;

public class Main {

    static boolean isAlphanumeric(char c) {
        return Character.isLetterOrDigit(c);
    }

    static boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;

        while (left < right) {
            while (left < right && !isAlphanumeric(s.charAt(left))) left++;
            while (left < right && !isAlphanumeric(s.charAt(right))) right--;

            char cLeft = Character.toLowerCase(s.charAt(left));
            char cRight = Character.toLowerCase(s.charAt(right));

            if (cLeft != cRight) return false;

            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        System.out.println(isPalindrome(s));
    }
}