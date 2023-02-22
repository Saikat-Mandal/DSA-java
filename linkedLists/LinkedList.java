import java.util.Iterator;

public class LinkedList {
    public static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static Node head;
    public static Node tail;
    public static int size = 0;

    // add at first
    public void addFirst(int data) {
        Node n = new Node(data);
        size++;
        if (head == null) {
            head = tail = n;
            return;
        }
        n.next = head;
        head = n;
    }

    // add at last
    public void addLast(int data) {
        size++;
        Node n = new Node(data);
        if (head == null) {
            head = tail = n;
            return;
        }
        tail.next = n;
        tail = n;
    }

    // print the list
    public void print() {
        if (head == null)
            return;
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
        System.out.println();
    }

    // add to middle
    public void addMiddle(int index, int data) {
        size++;
        if (index == 0) {
            addFirst(data);
            return;
        }

        Node temp = head;
        Node n = new Node(data);

        for (int i = 0; i < index - 1; i++) {
            temp = temp.next;
        }
        n.next = temp.next;
        temp.next = n;
    }

    // reomve from first

    public void removeFirst() {

        if (size == 0)
            return;
        if (size == 1) {
            head = tail = null;
            size = 0;
            return;
        }
        head = head.next;
        size--;
    }

    // remove from last
    public void removeLast() {

        if (size == 0)
            return;
        if (size == 1) {
            head = tail = null;
            size = 0;
            return;
        }
        Node temp = head;
        while (temp.next.next != null) {
            temp = temp.next;
        }
        temp.next = null;
        tail = temp;
        size--;
    }

    // search iteratively
    public int searchList(int val) {
        Node temp = head;
        while (temp != null) {
            if (temp.data == val) {
                return 1;
            }
            temp = temp.next;
        }
        return 0;
    }

    // search recursively
    public int recursive(int val) {
        return recursiveSearch(val, head);
    }

    public int recursiveSearch(int val, Node head) {
        if (head == null) {
            return -1;
        }
        if (head.data == val) {
            return 0;
        }
        int idx = recursiveSearch(val, head.next);
        if (idx == -1)
            return -1;
        return idx + 1;
    }

    // reverse a list
    public void reverse() {
        Node prev = null;
        Node cur = tail = head;
        Node nxt;
        while (cur != null) {
            nxt = cur.next;
            cur.next = prev;
            prev = cur;
            cur = nxt;
        }
        head = prev;
    }

    // delete from last code
    public void deleteFromLast(int val) {
        int size = fsize(head);
        if (head == null)
            return;
        if (val == size) {

            head = head.next;
            return;
        }

        Node temp = head;
        int t = size - val;
        for (int i = 0; i < t - 1; i++) {
            temp = temp.next;
        }
        temp.next = temp.next.next;
    }

    // calculate size
    public int fsize(Node head) {
        int size = 0;
        Node temp = head;
        while (temp != null) {
            temp = temp.next;
            size++;
        }
        return size;
    }

    // find middle of LL
    public Node middle(Node head) {
        Node f = head;
        Node s = head;
        while (f != null && f.next != null) {
            s = s.next;
            f = f.next.next;
        }
        return s;
    }

    // plaindrome or not
    public boolean isPalindrome() {
        // base case
        if (head == null || head.next == null) {
            return true;
        }

        // find mid
        Node mid = middle(head);

        // reverse 2nd half
        Node prev = null;
        Node cur = mid;
        Node nxt;
        while (cur != null) {
            nxt = cur.next;
            cur.next = prev;
            prev = cur;
            cur = nxt;

        }
        Node right = prev;
        Node left = head;

        // check whether palindrome or not
        while (right != null) {
            if (left.data != right.data) {
                return false;
            }
            left = left.next;
            right = right.next;
        }
        return true;
    }

    // detect cycle
    public boolean isCycle() {
        Node s = head;
        Node f = head;

        while (f != null && f.next != null) {
            s = s.next;
            f = f.next.next;
            if (s == f)
                return true;
        }
        return false;
    }

    // remove cycle
    public void removeCycle() {
        Node s = head;
        Node f = head;
        boolean cycle = false;
        while (f != null && f.next != null) {
            s = s.next;
            f = f.next.next;
            if (s == f) {
                cycle = true;
                break;
            }
        }
        if (!cycle) {
            return;
        }
        s = head;
        Node prev = null;
        while (s != f) {
            prev = f;
            s = s.next;
            f = f.next;
        }
        prev.next = null;
    }

    public static void main(String[] args) {
        LinkedList l = new LinkedList();
        l.addLast(1);
        l.addLast(2);
        l.addLast(2);
        l.addLast(1);
        l.addLast(1);

        System.out.println(l.isPalindrome());
    }

    public Iterator iterator() {
        return null;
    }
}