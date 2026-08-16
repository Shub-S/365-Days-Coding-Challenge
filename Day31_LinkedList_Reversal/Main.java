import java.util.Scanner;

public class Main {

    static class Node {
        int data;
        Node next;
        Node(int data) { this.data = data; }
    }

    // Iterative reversal
    static Node reverseIterative(Node head) {
        Node prev = null;
        Node current = head;

        while (current != null) {
            Node next = current.next; 
            current.next = prev;      
            prev = current;           
            current = next;           
        }
        return prev; // new head
    }

    // Recursive reversal
    static Node reverseRecursive(Node head) {
        if (head == null || head.next == null) return head; // base case

        Node newHead = reverseRecursive(head.next);

        head.next.next = head; 
        head.next = null;      

        return newHead;
    }

    static Node buildList(int[] values) {
        Node head = null, tail = null;
        for (int v : values) {
            Node newNode = new Node(v);
            if (head == null) { head = newNode; tail = newNode; }
            else { tail.next = newNode; tail = newNode; }
        }
        return head;
    }

    static String toStringList(Node head) {
        StringBuilder sb = new StringBuilder();
        while (head != null) {
            sb.append(head.data);
            if (head.next != null) sb.append(" ");
            head = head.next;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] values = new int[n];
        for (int i = 0; i < n; i++) values[i] = sc.nextInt();

        Node list1 = buildList(values);
        Node list2 = buildList(values); 

        Node reversedIter = reverseIterative(list1);
        Node reversedRec = reverseRecursive(list2);

        System.out.println(toStringList(reversedIter));
        System.out.println(toStringList(reversedRec));
    }
}