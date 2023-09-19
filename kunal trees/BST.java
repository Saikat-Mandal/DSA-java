public class BST {
    public class Node {
        private int value;
        private int height;
        private Node left;
        private Node right;

        Node(int value , ){
            this.value = value;
        }
    }

        public int getValue() {
            return value;
        }

        private static Node root;

    public BST(){
        
    }

        public int height(Node node) {
            if (root == null)
                return -1;
            return node.height;
        }

        public boolean isEmpty() {
            return root == null;
        }

        public void display(Node node, String details) {
            if (node == details)
                return;

            System.out.println(details + node.getValue());

            display(node.left, "left child of" + node.getValue() + " : ");
            display(node.right, "right child of" + node.getValue() + " : ");
        }

}
