public class DoublyList {
    static class Node {
        int data;
        Node next;
        Node prev;

        Node(int data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    public static Node head;
    public static Node tail;
    public static int size = 0;

    public void addLast(int data) {
        Node n = new Node(data);
        size++;
        if (head == null) {
            head = tail = n;
            return;
        }
        tail.next = n;
        n.prev = tail;
        tail = n;
    }

    public void addFirst(int data) {
        Node n = new Node(data);
        size++;
        if (head == null) {
            head = tail = n;
            return;
        }
        n.next = head;
        head.prev = n;
        head = n;
    }

    public void removeFirst() {
        if (head == null) {
            return;
        }
        if (size == 1) {
            head = tail = null;
            size--;
            return;
        }
        head = head.next;
        head.prev = null;
        size--;
    }

    public void removeLast() {
        if (head == null) {
            return;
        }
        if (size == 1) {
            head = tail = null;
            size--;
            return;
        }
        tail = tail.prev;
        tail.next = null;
    }

    public void print() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " <-> ");
            temp = temp.next;
        }
        System.out.println();
    }

    // reverse a doubly linked list
    public void reverse() {
        Node prev = null;
        Node cur = head;
        Node nxt;
        while (cur != null) {
            nxt = cur.next;
            cur.prev = nxt;
            cur.next = prev;
            prev = cur;
            cur = nxt;
        }
        head = prev;
    }

    public static void main(String[] args) {
        DoublyList l = new DoublyList();
        l.addLast(1);
        l.addLast(2);
        l.addLast(3);
        l.print();
        l.reverse();
        l.print();
    }
}
