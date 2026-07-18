import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int marks = sc.nextInt();
        String grade;

        if (marks >= 90) {
            grade = "A+";
        } else if (marks >= 75) {
            grade = "A";
        } else if (marks >= 60) {
            grade = "B";
        } else if (marks >= 45) {
            grade = "C";
        } else if (marks >= 33) {
            grade = "D";
        } else {
            grade = "F";
        }

        System.out.println(grade);
    }
}