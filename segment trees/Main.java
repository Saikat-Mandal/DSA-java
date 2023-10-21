class Main {

    static class Node {
        int data;
        int leftInterval,
        int rightInterval;
        Node left, right;

        public Node(int leftInterval, int rightInterval) {
            // this.data = data;
            this.leftInterval = leftInterval;
            this.rightInterval = rightInterval;
        }

    }

    Node root;

    public Main(int arr[]) {
        // create a tree using this array
        this.root = constructTree(arr, 0, arr.length - 1);
    }

    public static Node constructTree(int[] arr, int start, int end) {
        if (start == end) {
            Node leaf = new Node(start, end);
            lead.data = arr[start];
            return leaf;
        }

    //     Node node = new Node(start, end);
    //     int mid = (s + e) / 2;
    //     node.left = this.constructTree(arr, start, mid);
    //     node.right = this.constructTree(arr, mid + 1, end);
    //     node.data = node.left.data + node.right.data;
    //     return node;

    // }

    // public void display(){
    //     display(this.root);
    // }
    // private void display(Node root){
    //     String str = "";
    // }




    public static void main(String[] args) {
        int arr[] = { 3, 8, 6, 7, -2, -8, 4, 9 };

    }
}