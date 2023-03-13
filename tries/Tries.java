import java.util.ArrayList;

public class Tries {
    static class Node {
        Node[] children = new Node[26];
        boolean eow = false;

        Node() {
            for (int i = 0; i < children.length; i++) {
                children[i] = null;
            }
        }
    }

    public static Node root = new Node();

    // insert in trie
    public static void insert(String word) { // O(L)
        Node cur = root;
        for (int l = 0; l < word.length(); l++) {
            int idx = word.charAt(l) - 'a';
            if (cur.children[idx] == null) {
                cur.children[idx] = new Node();
            }
            cur = cur.children[idx];
        }
        cur.eow = true;
    }

    // search in trie
    public static boolean search(String target) { // O(L)
        Node cur = root;
        for (int l = 0; l < target.length(); l++) {
            int idx = target.charAt(l) - 'a';
            if (cur.children[idx] == null) {
                return false;
            }
            cur = cur.children[idx];
        }
        return (cur != null && cur.eow);
    }

    public static boolean wordBreak(String A, ArrayList<String> B) {
        for (int i = 0; i < B.size(); i++) {
            insert(B.get(i));
        }

        return wordBreakUtil(A);
    }

    public static boolean wordBreakUtil(String A) {
        int size = A.length();
        if (size == 0)
            return true;
        for (int i = 1; i <= size; i++) {
            if (search(A.substring(0, i)) && wordBreakUtil(A.substring(i, size))) {
                return true;
            }

        }
        return false;
    }

    public static void main(String[] args) {
        String s[] = { "i", "like", "sam", "sung", "samsung",
                "mobile", "ice", "cream", "icecream", "man",
                "go", "mango" };
        System.out.println(wordBreak(null, null));

    }
}