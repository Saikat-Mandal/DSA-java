import java.util.Arrays;

public class minAbsDifference {
    public static void diff(int[] a, int[] b) {
        Arrays.sort(a);
        Arrays.sort(b);

        int min = 0;
        for (int i = 0; i < a.length; i++) {
            min += Math.abs(a[i] - b[i]);
        }
        System.out.println(min);
    }

    public static void main(String[] args) {
        int[] a = { 1, 2, 3 };
        int[] b = { 2, 1, 3 };
        diff(a, b);
    }
}
