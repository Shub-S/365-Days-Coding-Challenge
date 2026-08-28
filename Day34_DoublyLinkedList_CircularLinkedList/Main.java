import java.util.Scanner;

public class Main {

    static class Node {
        int data;
        Node next;
        Node prev;
        Node(int data) { this.data = data; }
    }

    static class DoublyLinkedList {
        Node head = null;
        Node tail = null;

        void insertAtEnd(int val) {
            Node newNode = new Node(val);
            if (head == null) {
                head = newNode;
                tail = newNode;
            } else {
                tail.next = newNode;
                newNode.prev = tail;
                tail = newNode;
            }
        }

        void deleteNode(Node node) {
            if (node.prev != null) {
                node.prev.next = node.next;
            } else {
                head = node.next; // node was the head
            }

            if (node.next != null) {
                node.next.prev = node.prev;
            } else {
                tail = node.prev; // node was the tail
            }
        }

        Node getNodeAt(int pos) {
            Node current = head;
            for (int i = 0; i < pos; i++) {
                current = current.next;
            }
            return current;
        }

        void printForward() {
            StringBuilder sb = new StringBuilder();
            Node current = head;
            while (current != null) {
                sb.append(current.data);
                if (current.next != null) sb.append(" ");
                current = current.next;
            }
            System.out.println(sb.toString());
        }

        void printBackward() {
            StringBuilder sb = new StringBuilder();
            Node current = tail;
            while (current != null) {
                sb.append(current.data);
                if (current.prev != null) sb.append(" ");
                current = current.prev;
            }
            System.out.println(sb.toString());
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        DoublyLinkedList dll = new DoublyLinkedList();
        for (int i = 0; i < n; i++) {
            dll.insertAtEnd(sc.nextInt());
        }

        int pos = sc.nextInt();
        Node nodeToDelete = dll.getNodeAt(pos);
        dll.deleteNode(nodeToDelete);

        dll.printForward();
        dll.printBackward();
    }
}