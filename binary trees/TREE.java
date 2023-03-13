import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class TREE {

    static class Node {
        Node right;
        Node left;
        int data;

        Node(int data) {
            this.left = left;
            this.right = right;
            this.data = data;
        }
    }

    static class BinaryTree {
        static int idx = -1;

        public static Node buildTree(int Nodes[]) {
            idx++;
            if (Nodes[idx] == -1)
                return null;
            Node n = new Node(Nodes[idx]);
            n.left = buildTree(Nodes);
            n.right = buildTree(Nodes);

            return n;
        }

        // DFS using stack
        public void DFS(Node root) {
            Stack<Node> st = new Stack<>();
            if (root == null)
                return;
            st.push(root);
            while (!st.isEmpty()) {
                Node cur = st.pop();
                System.out.print(cur.data + " ");
                if (cur.right != null) {
                    st.push(cur.right);
                }
                if (cur.left != null) {
                    st.push(cur.left);
                }
            }

        }

        // preorder
        public void preorder(Node root) {
            if (root == null)
                return;
            System.out.print(root.data + " ");
            preorder(root.left);
            preorder(root.right);
        }

        // inorder
        public void ineorder(Node root) {
            if (root == null)
                return;
            ineorder(root.left);
            System.out.print(root.data + " ");
            ineorder(root.right);
        }

        // postorder
        public void postorder(Node root) {
            if (root == null)
                return;
            postorder(root.left);
            postorder(root.right);
            System.out.print(root.data + " ");
        }

        // BFS using queue
        public void BFS(Node root) {
            Queue<Node> q = new LinkedList<>();
            if (root == null)
                return;
            q.add(root);
            while (!q.isEmpty()) {
                Node cur = q.remove();
                System.out.print(cur.data + " ");

                if (cur.left != null) {
                    q.add(cur.left);
                }
                if (cur.right != null) {
                    q.add(cur.right);
                }
            }
        }

        // treeSum using recursion
        public int isSum(Node root) {
            if (root == null)
                return 0;

            return root.data + isSum(root.left) + isSum(root.right);
        }

        // treesum using queues
        public int isSum2(Node root) {
            if (root == null)
                return 0;

            Queue<Node> q = new LinkedList<>();

            int sum = 0;
            q.add(root);
            while (!q.isEmpty()) {
                Node cur = q.remove();
                sum += cur.data;
                if (cur.right != null) {
                    q.add(cur.right);
                }
                if (cur.left != null) {
                    q.add(cur.left);
                }
            }
            return sum;
        }

        // min val recursive
        public int minVal(Node root) {
            if (root == null)
                return Integer.MAX_VALUE;

            return Math.min(root.data, Math.min(minVal(root.left), minVal(root.right)));
        }

        // using stack
        public int minVal2(Node root) {

            Stack<Node> st = new Stack<>();
            int minNo = Integer.MAX_VALUE;
            st.push(root);
            while (!st.isEmpty()) {
                Node cur = st.pop();
                if (cur.data < minNo)
                    minNo = cur.data;
                if (cur.right != null) {
                    st.push(cur.right);
                }
                if (cur.left != null) {
                    st.push(cur.left);
                }
            }
            return minNo;
        }

        // max sum
        public int sum(Node root) {
            if (root == null) {
                return Integer.MIN_VALUE;
            }
            if (root.left == null && root.right == null) {
                return root.data;
            }
            return root.data + Math.max(sum(root.left), sum(root.right));
        }

        // left view
        public ArrayList<Integer> leftView(Node root) {
            ArrayList<Integer> ans = new ArrayList<>();
            right(root, ans);
            return ans;
        }

        public void left(Node root, ArrayList<Integer> ans) {
            if (root == null)
                return;
            Queue<Node> q = new LinkedList<>();
            q.add(root);
            while (!q.isEmpty()) {
                int k = q.size();
                int val = -1;
                for (int i = 0; i < k; ++i) {
                    Node temp = q.poll();
                    if (temp.left != null)
                        q.add(temp.left);
                    if (temp.right != null)
                        q.add(temp.right);
                    if (val == -1)
                        val = temp.data;
                }
                ans.add(val);
            }
        }

        // right view
        public void right(Node root, ArrayList<Integer> ans) {
            if (root == null)
                return;
            Queue<Node> q = new LinkedList<>();
            q.add(root);
            while (!q.isEmpty()) {
                int k = q.size();
                int val = -1;
                for (int i = 0; i < k; ++i) {
                    Node temp = q.poll();

                    if (temp.right != null)
                        q.add(temp.right);
                    if (temp.left != null)
                        q.add(temp.left);
                    if (val == -1)
                        val = temp.data;
                }
                ans.add(val);
            }
        }

        // count nodes
        public int count(Node root) {
            if (root == null)
                return 0;
            return 1 + count(root.left) + count(root.right);
        }

        // diameter O(n2)

        public int height(Node root) {
            if (root == null)
                return 0;
            return 1 + Math.max(height(root.left), height(root.right));
        }

        public int diameter1(Node root) {
            if (root == null)
                return 0;

            int ld = diameter1(root.left);
            int lh = height(root.left);
            int rd = diameter1(root.right);
            int rh = height(root.right);

            int self = lh + rh + 1;
            return Math.max(self, Math.max(ld, rd));
        }

        // top view

        static class Info {
            Node node;
            int dist;

            Info(Node node, int dist) {
                this.node = node;
                this.dist = dist;
            }
        }

        public void topView(Node root) {
            Queue<Info> q = new LinkedList<>();
            HashMap<Integer, Node> map = new HashMap<>();
            int min = 0, max = 0;
            if (root == null) {
                return;
            } else {
                q.add(new Info(root, 0));
            }

            while (!q.isEmpty()) {
                Info cur = q.remove();

                if (!map.containsKey(cur.dist)) {
                    map.put(cur.dist, cur.node);
                }
                if (cur.node.left != null) {
                    q.add(new Info(cur.node.left, cur.dist - 1));
                    min = Math.min(min, cur.dist - 1);
                }
                if (cur.node.right != null) {
                    q.add(new Info(cur.node.right, cur.dist + 1));
                    max = Math.max(max, cur.dist + 1);
                }
            }
            for (int i = min; i <= max; i++) {
                System.out.print(map.get(i).data + " ");
            }
        }

        // bottom view

        public void bottomView(Node root) {
            Queue<Info> q = new LinkedList<>();
            HashMap<Integer, Node> map = new HashMap<>();
            int min = 0, max = 0;
            if (root == null) {
                return;
            } else {
                q.add(new Info(root, 0));
            }

            while (!q.isEmpty()) {
                Info cur = q.remove();

                map.put(cur.dist, cur.node);

                if (cur.node.left != null) {
                    q.add(new Info(cur.node.left, cur.dist - 1));
                    min = Math.min(min, cur.dist - 1);
                }
                if (cur.node.right != null) {
                    q.add(new Info(cur.node.right, cur.dist + 1));
                    max = Math.max(max, cur.dist + 1);
                }
            }
            for (int i = min; i <= max; i++) {
                System.out.print(map.get(i).data + " ");
            }
        }
        // print nodes at kth level
        // public static void printNodes(Node root, int k) {
        // if (root == null)
        // return;
        // int level = 0;
        // Queue<Node> q = new LinkedList<>();
        // ArrayList<Integer> l = new ArrayList<>();
        // q.add(root);
        // while (!q.isEmpty()) {
        // level++;
        // Node cur = q.remove();

        // if (cur.left != null) {
        // q.add(cur.left);
        // }

        // if (cur.right != null) {
        // q.add(cur.right);
        // }

        // if (level == k) {
        // l.add(cur.data);
        // if (!q.isEmpty()) {
        // while (!q.isEmpty()) {
        // l.add(q.remove().data);
        // }
        // }
        // break;
        // }

        // }
        // System.out.println(l);
        // }

        // nodes at kth level
        public static void printNodes(Node root, int level, int k) {
            if (root == null)
                return;
            if (level == k) {
                System.out.print(root.data + " ");
            }
            printNodes(root.left, level + 1, k);
            printNodes(root.right, level + 1, k);
        }

        // LCA using list
        public static Node LCA(Node root, int n1, int n2) {
            ArrayList<Node> path1 = new ArrayList<>();
            ArrayList<Node> path2 = new ArrayList<>();

            // getPath(root, path1, n1);
            // getPath(root, path2, n2);
            int i = 0;
            for (; i < path1.size() && i < path2.size(); i++) {
                if (path1.get(i) != path2.get(i)) {
                    break;
                }
            }
            Node lca = path1.get(i - 1);
            return lca;
        }

        // LCA recursively without list
        public static Node LCA2(Node root, int n1, int n2) {
            if (root == null || root.data == n1 || root.data == n2) {
                return root;
            }
            Node leftLca = LCA2(root.left, n1, n2);
            Node rightLca = LCA2(root.right, n1, n2);

            if (leftLca == null)
                return rightLca;
            if (rightLca == null)
                return leftLca;

            return root;
        }

        // distance between 2 nodes
        public static int getPath(Node root, int a) {
            if (root == null)
                return -1;
            if (root.data == a)
                return 0;
            int l = getPath(root.left, a);
            int r = getPath(root.right, a);
            return 1 + (l != 0 ? l : r);
        }

        public static int findDist(Node root, int a, int b) {
            Node lca = LCA2(root, a, b);
            int path1 = getPath(lca, a);
            int path2 = getPath(lca, b);

            return path1 + path2;
        }

        // path sum

        public boolean hasPathSum(Node root, int targetSum) {
            return helper(root, targetSum, 0);
        }

        public boolean helper(Node root, int targetSum, int sum) {
            if (root == null)
                return false;
            sum += root.data;
            if (sum == targetSum && (root.left == null && root.right == null))
                return true;

            return helper(root.left, targetSum, sum) || helper(root.right, targetSum, sum);
        }

        // path sum II

        public List<List<Integer>> pathSum(Node root, int targetSum) {
            List<List<Integer>> res = new ArrayList<>();
            if (root == null)
                return res;
            helper2(root, targetSum, 0, new ArrayList<>(), res);
            return res;
        }

        public void helper2(Node root, int targetSum, int sum, List<Integer> temp, List<List<Integer>> res) {

            sum += root.data;
            temp.add(root.data);
            if (sum == targetSum && (root.left == null && root.right == null)) {
                List<Integer> sub = new ArrayList<>(temp);
                sub.add(root.data);
                res.add(sub);
                return;
            }

            if (root.left != null)
                helper2(root.left, targetSum, sum, temp, res);
            if (root.right != null)
                helper2(root.right, targetSum, sum, temp, res);

            temp.remove(temp.size() - 1);

        }

        // kth ancestor

        public static int Kancestor(Node root, int n, int k) {
            if (root == null)
                return -1;
            if (root.data == n)
                return 0;

            int l = Kancestor(root.left, n, k);
            int r = Kancestor(root.right, n, k);
            if (l == -1 && r == -1)
                return -1;
            int max = Math.max(l, r);
            if (max + 1 == k) {
                System.out.println((root.data));
            }
            return max + 1;
        }

        // zigzag transversal
        public ArrayList<Integer> zigZagTraversal(Node root) {
            if (root == null)
                return null;
            ArrayList<Integer> l = new ArrayList<>();
            boolean level = true;
            Queue<Node> q = new LinkedList<>();
            q.add(root);
            while (!q.isEmpty()) {
                Stack<Integer> st = new Stack<>();
                while (!q.isEmpty()) {
                    Node cur = q.remove();
                    if (level) {
                        l.add(root.data);
                    } else {
                        st.push(root.data);
                    }
                    if (cur.left != null) {
                        q.add(cur.left);
                    }
                    if (cur.right != null) {
                        q.add(cur.right);
                    }
                }
                while (!st.isEmpty()) {
                    l.add(st.pop());
                }
                level = !level;
            }
            return l;

        }

    }

    public static void main(String[] args) {
        int Nodes[] = { 1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1 };
        BinaryTree t = new BinaryTree();
        Node root = t.buildTree(Nodes);

    }
}
