import java.util.ArrayList;
import java.util.List;

public class spiralMatrix {

    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> l = new ArrayList<>();
        int rStart = 0, rEnd = matrix.length - 1, cStart = 0, cEnd = matrix[0].length - 1;
        while (rStart <= rEnd && cStart <= cEnd) {
            // add top
            for (int j = cStart; j <= cEnd; j++) {
                l.add(matrix[rStart][j]);
            }
            // add right
            for (int i = rStart + 1; i <= rEnd; i++) {
                l.add(matrix[i][cEnd]);
            }

            // add bottom

            for (int m = cEnd - 1; m >= cStart; m--) {
                if (rStart == rEnd) {
                    break;
                }
                l.add(matrix[rEnd][m]);
            }
            // add left

            for (int z = rEnd - 1; z >= rStart + 1; z--) {
                if (cStart == cEnd) {
                    break;
                }
                l.add(matrix[z][cStart]);
            }

            cStart++;
            rStart++;
            rEnd--;
            cEnd--;
        }

        return l;
    }

    public static void main(String[] args) {
        int matix[][] = {
                { 1, 2, 3, 4 },
                { 5, 6, 7, 8 },
                { 9, 10, 11, 12 }
        };
        System.out.println(spiralOrder(matix));

    }
}
