public class dBinary {
    public static boolean search(int matrix[][], int n, int m, int x) {
        int i = 0;
        int j = m - 1;
        while (i >= 0 && i < n && j >= 0 && j < m) {
            if (matrix[i][j] == x)
                return true;
            else if (matrix[i][j] > x)
                j--;
            else if (matrix[i][j] < x)
                i++;

        }
        return false;
    }

    public static void main(String[] args) {
        int matrix[][] = { { 18, 21, 27, 38, 55, 67 } };
        System.out.println(search(matrix, 1, 3, 55));
    }
}
