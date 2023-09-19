public class pascalFirst {

    public static int calcCombination(int n, int r) {
        int res = 1;
        for (int i = 0; i < r; i++) {
            res = res * (n - i);
            res = res / (i + 1);
        }
        return res;
    }

    public static void pascal(int n) {
        for (int i = 1; i <= n; i++) {
            System.out.print(calcCombination(n - 1, i - 1) + " ");
        }
    }

    public static void main(String[] args) {
        pascal(5);
    }
}
