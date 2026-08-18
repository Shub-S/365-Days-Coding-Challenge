import java.util.Scanner;

public class Main {

    static class Node {
        int data;
        Node next;
        Node(int data) { this.data = data; }
    }

    static boolean hasCycle(Node head) {
        Node slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) return true;
        }
        return false;
    }

    static Node detectCycleStart(Node head) {
        Node slow = head, fast = head;
        boolean hasCycle = false;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                hasCycle = true;
                break;
            }
        }

        if (!hasCycle) return null;

        slow = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow; // cycle start node
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] values = new int[n];
        for (int i = 0; i < n; i++) values[i] = sc.nextInt();
        int pos = sc.nextInt();

        Node[] nodes = new Node[n];
        for (int i = 0; i < n; i++) nodes[i] = new Node(values[i]);
        for (int i = 0; i < n - 1; i++) nodes[i].next = nodes[i + 1];

        if (pos != -1) {
            nodes[n - 1].next = nodes[pos]; // manually create the cycle
        }

        Node head = nodes[0];

        boolean cycleExists = hasCycle(head);
        System.out.println(cycleExists);

        if (cycleExists) {
            Node start = detectCycleStart(head);
            System.out.println(start.data);
        } else {
            System.out.println(-1);
        }
    }
}
