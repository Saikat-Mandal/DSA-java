import java.util.Scanner;

public class BinaryTree {
    static class Node {
        int val;
        Node left, right;

        public Node(int val) {
            this.val = val;
            // this.left = right = null;
        }
    }

    private static Node root;

    public static void populate(Scanner sc) {
        System.out.println("enter the root node");
        int val = sc.nextInt();
        root = new Node(val);
        populate(sc, root);
    }

    private static void populate(Scanner sc, Node node) {
        System.out.println("do you want left of " + node.val);
        boolean left = sc.nextBoolean();
        if (left) {
            System.out.println("enter the left :");
            int val = sc.nextInt();
            node.left = new Node(val);
            populate(sc, node.left);
        }

        System.out.println("do you want right of " + root.val);
        boolean right = sc.nextBoolean();
        if (right) {
            System.out.println("enter the right :");
            int val = sc.nextInt();            node.right = new Node(val);
            populate(sc, node.right);
        }
    }

    public static void display(Node node) {
        if (node == null)
            return;
        System.out.print(node.val + " ");
        display(node.left);
        display(node.right);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BinaryTree b = new BinaryTree();
        b.populate(sc);
        b.display(root);
    }
}
