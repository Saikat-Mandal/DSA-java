import java.util.ArrayList;
import java.util.List;

public class nQueensList {

    public static boolean isSafe(char board[][], int row, int col) {
        // upper
        for (int i = row - 1; i >= 0; i--) {
            if (board[i][col] == 'Q') {
                return false;
            }
        }
        // diagonal left
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {

            if (board[i][j] == 'Q') {
                return false;
            }
        }

        // diagonal right
        for (int i = row - 1, j = col + 1; i >= 0 && j < board.length; i--, j++) {

            if (board[i][j] == 'Q') {
                return false;
            }
        }
        return true;
    }

    public static int queens(char board[][], int row) {
        if (row == board.length) {
            // saveBoard(board, l);

            return 1;
        }
        int count = 0;

        for (int j = 0; j < board.length; j++) {
            if (isSafe(board, row, j)) {
                board[row][j] = 'Q';
                count += queens(board, row + 1);
                board[row][j] = 'x';
            }
        }
        return count;
    }

    // public static void saveBoard(char board[][], List<List<String>> l) {
    // String row = "";
    // List<String> temp = new ArrayList<>();
    // for (int i = 0; i < board.length; i++) {
    // row = "";
    // for (int j = 0; j < board[0].length; j++) {
    // if (board[i][j] == 'Q') {
    // row += 'Q';
    // } else {
    // row += '.';
    // }
    // }
    // temp.add(row);
    // }
    // l.add(temp);
    // }

    // public static List<List<String>> solveNQueens(int n) {
    // char board[][] = new char[n][n];
    // for (int i = 0; i < n; i++) {
    // for (int j = 0; j < n; j++) {
    // board[i][j] = 'x';
    // }
    // }

    // List<List<String>> l = new ArrayList<>();

    // queens(board, 0, l);
    // return l;

    // }

    public static int solveNQueens(int n) {
        char board[][] = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = 'x';
            }
        }
        return queens(board, 0);

    }

    ///////////////////////////////////////////////////////////////////////

    public static void main(String[] args) {
        System.out.println(solveNQueens(2));
    }
}
