import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class practice {

    public static boolean isSafe(char board[][], int row, int col) {
        // up
        for (int i = row - 1; i >= 0; i--) {
            if (board[i][col] == 'Q')
                return false;
        }

        // diagonal right
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q')
                return false;
        }
        // diagonal left
        for (int i = row - 1, j = col + 1; i >= 0 && j < board.length; i--, j++) {
            if (board[i][j] == 'Q')
                return false;
        }
        return true;
    }

    public static void nQueens(char board[][], int row) {
        if (row == board.length) {
            display(board);
            return;
        }
        for (int j = 0; j < board.length; j++) {
            if (isSafe(board, row, j)) {
                board[row][j] = 'Q';
                nQueens(board, row + 1);
                board[row][j] = '.';
            }
        }
    }

    public static void display(char board[][]) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();

        }
        System.out.println("--------------------------");
    }

    // permutations
    public static void permutation(String ip, String op) {
        if (ip.length() == 0) {
            System.out.println(op);
            return;
        }
        for (int i = 0; i < ip.length(); i++) {

            String newString = ip.substring(0, i) + ip.substring(i + 1);

            permutation(newString, op + ip.charAt(i));

        }

    }

    public static ArrayList<String> permutation2(String S) {
        ArrayList<String> res = new ArrayList<>();

        perm(S, "", res);

        return res;

    }

    public static void perm(String ip, String op, ArrayList<String> res) {
        if (ip.length() == 0) {
            res.add(op);
            return;
        }

        for (int i = 0; i < ip.length(); i++) {
            String newString = ip.substring(0, i) + ip.substring(i + 1);
            perm(newString, op + ip.charAt(i), res);
        }
    }

    public static void main(String[] args) {
        int n = 4;
        char board[][] = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }

        // nQueens(board, 0);
        // System.out.println(permutation2("abc"));
        System.out.println(5 / 2);

    }
}
