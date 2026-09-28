import java.util.*;

public class ran {

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    Node head;
    void insertAtFront(int value) {
        Node newNode = new Node(value);

        newNode.next = head;
        head = newNode;
    }

    void insertAtEnd(int value) {
        Node newNode = new Node(value);

        if (head == null) {
            head = newNode;
            return;
        }

        Node temp = head;

        while (temp.next != null) {
            temp = temp.next;
        }

        temp.next = newNode;
    }
    void insertAtMiddle(int value, int position) {
        Node newNode = new Node(value);

        if (position == 1) {
            newNode.next = head;
            head = newNode;
            return;
        }

        Node temp = head;

        for (int i = 1; i < position - 1 && temp != null; i++) {
            temp = temp.next;
        }

        if (temp == null) {
            System.out.println("Invalid position");
            return;
        }

        newNode.next = temp.next;
        temp.next = newNode;
    }
    void deleteAtFront() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        head = head.next;
    }

    void deleteAtEnd() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        if (head.next == null) {
            head = null;
            return;
        }

        Node temp = head;

        while (temp.next.next != null) {
            temp = temp.next;
        }

        temp.next = null;
    }

    void deleteAtMiddle(int position) {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        if (position == 1) {
            head = head.next;
            return;
        }

        Node temp = head;

        for (int i = 1; i < position - 1 && temp != null; i++) {
            temp = temp.next;
        }

        if (temp == null || temp.next == null) {
            System.out.println("Invalid position");
            return;
        }

        temp.next = temp.next.next;
    }
    void display() {
        Node temp = head;

        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }

        System.out.println("null");
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ran list = new ran();

        while (true) {

            System.out.println("\n----- MENU -----");
            System.out.println("1. Insert At Front");
            System.out.println("2. Insert At End");
            System.out.println("3. Insert At Middle");
            System.out.println("4. Delete At Front");
            System.out.println("5. Delete At End");
            System.out.println("6. Delete At Middle");
            System.out.println("7. Display");
            System.out.println("8. Exit");

            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter value: ");
                    int frontValue = sc.nextInt();
                    list.insertAtFront(frontValue);
                    break;

                case 2:
                    System.out.print("Enter value: ");
                    int endValue = sc.nextInt();
                    list.insertAtEnd(endValue);
                    break;

                case 3:
                    System.out.print("Enter value: ");
                    int middleValue = sc.nextInt();

                    System.out.print("Enter position: ");
                    int position = sc.nextInt();

                    list.insertAtMiddle(middleValue, position);
                    break;

                case 4:
                    list.deleteAtFront();
                    break;

                case 5:
                    list.deleteAtEnd();
                    break;

                case 6:
                    System.out.print("Enter position: ");
                    int deletePosition = sc.nextInt();

                    list.deleteAtMiddle(deletePosition);
                    break;

                case 7:
                    list.display();
                    break;

                case 8:
                    System.out.println("Program ended.");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}