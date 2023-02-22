import java.util.Arrays;
import java.util.Comparator;

public class chainOfPairs {
    public static void maxPairs(int[][] pairs) {

        Arrays.sort(pairs, Comparator.comparingDouble(o -> o[1]));
        int chainLength = 1;
        int endTime = pairs[0][1];
        for (int i = 1; i < pairs.length; i++) {
            if (pairs[i][0] > endTime) {
                chainLength++;
                endTime = pairs[i][1];
            }
        }
        System.out.println(chainLength);

    }

    public static void main(String[] args) {
        int[][] pairs = { { 5, 24 }, { 39, 60 }, { 5, 28 }, { 27, 40 }, { 50, 90 } };
        maxPairs(pairs);
    }
}
