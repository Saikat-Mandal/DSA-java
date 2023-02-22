import java.util.*;

public class prac {
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static Node head;
    public static Node tail;

    public void addLast(int data) {
        Node n = new Node(data);
        if (head == null) {
            head = tail = n;
            return;
        }
        tail.next = n;
        tail = n;
    }

    public void print() {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.data + " ");
            temp = temp.next;
        }
    }

    public void reverse() {
        Node prev = null;
        Node cur = head;
        Node next;
        while (cur != null) {
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        head = prev;
    }

    public static void main(String[] args) {
        LinkedList l = new LinkedList();
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 3; i++) {
            l.addLast(sc.nextInt());
        }

        l.print();
        l.reverse();
        l.print();
    }
}
