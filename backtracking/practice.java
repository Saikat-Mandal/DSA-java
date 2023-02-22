import java.util.ArrayList;
import java.util.List;

public class practice {

    public static int traveller(int row, int col, int n, int m) {
        if (row == n - 1 || col == m - 1) {
            return 1;
        }
        return traveller(row + 1, col, n, m) + traveller(row, col + 1, n, m);
    }

    public static void main(String[] args) {
        System.out.println(traveller(0, 0, 3, 3));
    }
}
