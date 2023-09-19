class Node {
    Node right, left;
    int data;

    Node(int data) {
        this.data = data;
    }
}

public class Main {

    public static Node insert(Node root, int val) {
        if (root == null) {
            root = new Node(val);
            return root;
        }

        if (val < root.data) {
            root.left = insert(root.left, val);
        } else {

            root.right = insert(root.right, val);
        }
        return root;
    }

    // inorder triversal
    public static void inorder(Node root) {
        if (root == null)
            return;
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    // delete in a bst
    public static Node delete(Node root, int val) {
        if (root.data < val) {
            root.right = delete(root.right, val);
        } else if (root.data > val) {
            root.left = delete(root.left, val);
        } else {
            // voila
            // case 1 (leaf node)
            if (root.left == null && root.right == null) {
                return null;
            }
            // case 2 (single child)
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }

            // case 3
            Node IS = fintInOrderSuccessor(root, val);
            root.data = IS.data;
            delete(root.right, IS.data);
        }
        return root;
    }

    public static Node fintInOrderSuccessor(Node root, int val) {
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }

    public static void main(String[] args) {
        int arr[] = { 8, 5, 3, 1, 4, 6, 10, 11, 14 };
        Node root = null;
        for (int i = 0; i < arr.length; i++) {
            root = insert(root, arr[i]);
        }
        inorder(root);
        System.out.println();
        root = delete(root, 1);
        inorder(root);
    }
}
