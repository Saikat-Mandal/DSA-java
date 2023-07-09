import java.util.ArrayList;
import java.util.List;

public class practice {
    public static List<List<String>> solveNQueens(int n) {
        char board[][] = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }

        List<List<String>> res = new ArrayList<>();

        mainLogic(board, res, 0);

        return res;
    }

    public static void mainLogic(char board[][], List<List<String>> res, int row) {

        if (row == board.length) {
            saveBoard(board, res);
            return;
        }

        for (int j = 0; j < board.length; j++) {
            if (isSafe(board, row, j)) {
                board[row][j] = 'Q';
                mainLogic(board, res, row + 1);
                board[row][j] = '.';
            }
        }
    }

    public static boolean isSafe(char board[][], int row, int col) {
        // up
        for (int i = row - 1; i >= 0; i--) {
            if (board[i][col] == 'Q') {
                return false;
            }
        }
        // left up
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }
        // up
        for (int i = row - 1, j = col + 1; i >= 0 && j < board.length; i--, j++) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }
        return true;
    }

    public static void saveBoard(char board[][], List<List<String>> res) {
        String s = "";
        List<String> temp = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            s = "";
            for (int j = 0; j < board.length; j++) {
                if (board[i][j] == 'Q') {
                    s += 'Q';
                } else {
                    s += '.';
                }
            }
            temp.add(s);
        }
        res.add(temp);
    }

    public static void main(String[] args) {
        System.out.println(solveNQueens(4));
    }
}
