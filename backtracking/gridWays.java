public class gridWays {
    public static int count(int r, int c, int n, int m) {

        if (r == n - 1 || c == m - 1)
            return 1;
        else if (r == n || c == m) {
            return 0;
        }
        int down = count(r + 1, c, n, m);
        int right = count(r, c + 1, n, m);
        return down + right;
    }

    public static void Printcount(int r, int c, int n, int m, String s) {

        if (r == n - 1 && c == m - 1) {
            System.out.println(s);
            return;
        }
        if (r < n - 1) {

            Printcount(r + 1, c, n, m, s + 'R');
        }

        if (c < m - 1) {

            Printcount(r, c + 1, n, m, s + 'D');
        }

    }

    public static void main(String[] args) {
        Printcount(0, 0, 3, 3, "");
    }
}
