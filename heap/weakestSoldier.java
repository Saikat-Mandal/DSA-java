import java.util.Arrays;
import java.util.PriorityQueue;

public class weakestSoldier {
    static class row implements Comparable<row> {
        int soldiers;
        int index;

        public row(int soldiers, int index) {
            this.soldiers = soldiers;
            this.index = index;
        }

        @Override
        public int compareTo(row r1) {
            if (this.soldiers == r1.soldiers) {
                return this.index - r1.index;
            }
            return this.soldiers - r1.soldiers;
        }
    }

    public static int[] kWeakestRows(int[][] mat, int k) {
        int ans[] = new int[k];
        int p = 0;
        PriorityQueue<row> q = new PriorityQueue<>();
        for (int i = 0; i < mat.length; i++) {
            int count = 0;
            for (int j = 0; j < mat[0].length; j++) {
                count += mat[i][j] == 1 ? 1 : 0;
            }
            q.add(new row(count, i));
        }
        for (int i = 0; i < k; i++) {
            ans[p++] = q.remove().index;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] mat = { { 1, 1, 0, 0, 0 },
                { 1, 1, 1, 1, 0 },
                { 1, 0, 0, 0, 0 },
                { 1, 1, 0, 0, 0 },
                { 1, 1, 1, 1, 1 } };

        System.out.println(Arrays.toString(kWeakestRows(mat, 3)));
    }
}
