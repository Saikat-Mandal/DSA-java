import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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

    // makeTree
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

    // print inorder
    public static void inorder(Node root) {
        if (root == null)
            return;

        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    // delete function
    public static Node delete(Node root, int val) {
        if (root.data < val) {
            root.right = delete(root.right, val);
        }
        if (root.data > val) {
            root.left = delete(root.left, val);
        } else {
            // case 1 - leaf node
            if (root.left == null && root.right == null)
                return null;

            // case 2 - single child
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }

            // case 3 both children
            Node IS = findInorderSuccessor(root.right);
            root.data = IS.data;
            root.right = delete(root.right, IS.data);
        }
        return root;
    }

    // find inorder successor
    public static Node findInorderSuccessor(Node root) {
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }

    // print in range
    public static void printInRange(Node root, int k1, int k2) {
        if (root == null)
            return;
        if (root.data >= k1 && root.data <= k2) {
            printInRange(root.left, k1, k2);
            System.out.print(root.data + " ");
            printInRange(root.right, k1, k2);
        } else if (root.data < k1) {
            printInRange(root.right, k1, k2);
        } else {
            printInRange(root.left, k1, k2);
        }
    }

    public static void printPath(Node root, List<Integer> l) {
        if (root == null) {
            return;
        }
        l.add(root.data);
        if (root.left == null && root.right == null) {
            System.out.print(l);
        }

        printPath(root.left, l);

        printPath(root.right, l);

        l.remove(l.size() - 1);
    }

    // validate bst
    public static boolean isValid(Node root, Node min, Node max) {
        if (root == null)
            return true;
        if (min != null && root.data <= min.data) {
            return false;
        } else if (max != null && root.data >= max.data)
            return false;

        return isValid(root.left, min, root) && isValid(root.right, root, max);
    }

    public static Node mirror(Node root) {
        if (root == null)
            return null;

        Node l = mirror(root.left);
        Node r = mirror(root.right);
        root.left = r;
        root.right = l;
        return root;
    }

    // norma bst to balanced bst
    public static Node makeBstTree(int nums[], int s, int e) {
        int mid = (s + e) / 2;
        Node root = new Node(nums[mid]);
        root.left = makeBstTree(nums, s, mid - 1);
        root.right = makeBstTree(nums, mid + 1, e);

        return root;
    }

    // inorder
    public static void inorder(Node root, List<Integer> l) {
        if (root == null)
            return;

        inorder(root.left, l);
        l.add(root.data);
        inorder(root.right, l);
    }

    // merge two bst
    public static Node createBst(List<Integer> l, int s, int e) {
        int mid = (s + e) / 2;
        Node root = new Node(l.get(mid));

        root.left = createBst(l, s, mid - 1);
        root.right = createBst(l, mid + 1, e);

        return root;
    }

    public List<Integer> merge(Node root1, Node root2) {
        List<Integer> l1 = new ArrayList<>();
        List<Integer> l2 = new ArrayList<>();
        List<Integer> res = new ArrayList<>();

        inorder(root1, l1);
        inorder(root2, l2);
        int i = 0, j = 0;
        while (i < l1.size() && j < l2.size()) {
            if (l1.get(i) <= l2.get(j)) {
                res.add(l1.get(i));
                i++;
            } else {
                res.add(l2.get(j));
                j++;
            }
        }
        while (i < l1.size()) {
            res.add(l1.get(i));
            i++;
        }
        while (j < l2.size()) {
            res.add(l2.get(j));
            j++;
        }

        Node root = createBst(res, 0, res.size() - 1);

    }

    public static void main(String[] args) {
        int[] arr = { 8, 5, 3, 6, 10, 11, 14 };
        Node root = null;

        for (int i = 0; i < arr.length; i++) {
            root = makeTree(root, arr[i]);
        }
        printPath(root, new ArrayList<>());
    }
}