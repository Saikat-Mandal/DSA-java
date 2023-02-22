public class power {
    public static int findPower(int x, int n) {
        if (n == 1)
            return x;
        return x * findPower(x, n - 1);
    }

    // optimised
    public static int calcPower(int x, int n) {
        if (n == 1)
            return x;
        int var = calcPower(x, n / 2);
        int half = var * var;
        if ((n & 1) == 1) {
            half = half * x;
        }
        return half;
    }

    public static void main(String[] args) {
        System.out.println(calcPower(2, 10));
    }
}
