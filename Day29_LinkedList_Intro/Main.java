import java.util.Scanner;

public class Main {

    static class Node {
        int data;
        Node next;
        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    static class LinkedList {
        Node head = null;
        Node tail = null;
        int size = 0;

        void insertAtEnd(int val) {
            Node newNode = new Node(val);
            if (head == null) {
                head = newNode;
                tail = newNode;
            } else {
                tail.next = newNode;
                tail = newNode;
            }
            size++;
        }

        void printList() {
            StringBuilder sb = new StringBuilder();
            Node current = head;
            while (current != null) {
                sb.append(current.data);
                if (current.next != null) sb.append(" ");
                current = current.next;
            }
            System.out.println(sb.toString());
        }

        int size() {
            return size;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        LinkedList list = new LinkedList();
        for (int i = 0; i < n; i++) {
            list.insertAtEnd(sc.nextInt());
        }

        list.printList();
        System.out.println(list.size());
    }
}