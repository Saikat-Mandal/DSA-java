import java.util.Arrays;

public class pow {
    // public static int pow(int n, int r) {
    // int i = 1, num = 1;

    // while (i <= r) {
    // num *= n;
    // i++;
    // }
    // return num;
    // }

    // public static int po\\'''/w2(int n, int r) {
    // if (r == 0) {
    // return 1;
    // }

    // return n * pow2(n, r - 1);
    // }

    public static int pow(int x, int n) {
        if (n == 1)
            return 1;

        return x * pow(x, n - 1);
    }
    

    public static void main(String[] args) {
        System.out.println(pow(2, 6));
       
    }
}
