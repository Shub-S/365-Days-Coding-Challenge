import java.util.Scanner;

public class Main {

    static class Node {
        int data;
        Node next;
        Node(int data) { this.data = data; }
    }

    static Node mergeTwoLists(Node l1, Node l2) {
        Node dummy = new Node(-1);
        Node tail = dummy;

        while (l1 != null && l2 != null) {
            if (l1.data <= l2.data) {
                tail.next = l1;
                l1 = l1.next;
            } else {
                tail.next = l2;
                l2 = l2.next;
            }
            tail = tail.next;
        }

        // attach whichever list still has remaining nodes
        tail.next = (l1 != null) ? l1 : l2;

        return dummy.next;
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

        int n1 = sc.nextInt();
        int[] values1 = new int[n1];
        for (int i = 0; i < n1; i++) values1[i] = sc.nextInt();

        int n2 = sc.nextInt();
        int[] values2 = new int[n2];
        for (int i = 0; i < n2; i++) values2[i] = sc.nextInt();

        Node l1 = buildList(values1);
        Node l2 = buildList(values2);

        Node merged = mergeTwoLists(l1, l2);

        System.out.println(toStringList(merged));
    }
}