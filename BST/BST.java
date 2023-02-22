public class BST {
    static class Node {
        Node right;

        Node left;
        int data;

        Node(int data) {
            this.data = data;
            left = right = null;
        }
    }

    public static Node makeTree(Node root, int val) {
        if (root == null) {
            root = new Node(val);
            return root;
        }
        if (root.data > val) {
            root.left = makeTree(root.left, val);
        } else {
            root.right = makeTree(root.right, val);
        }
        return root;
    }

    public static void inorder(Node root) {
        if (root == null)
            return;

        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    public static void main(String[] args) {
        int[] arr = { 5, 1, 3, 4, 2, 7 };
        Node root = null;

        for (int i = 0; i < arr.length; i++) {
            root = makeTree(root, arr[i]);
        }
        inorder(root);
    }
}