import java.util.Arrays;
import java.util.Comparator;

public class fractionalKnapsack {

    public static void knapsack(int val[], int wt[], int W) {
        double[][] ratio = new double[val.length][2];
        for (int i = 0; i < val.length; i++) {
            ratio[i][0] = i;
            ratio[i][1] = val[i] / (double) wt[i];
        }

        Arrays.sort(ratio, Comparator.comparingDouble(o -> o[1]));

        int max = 0;
        int capacity = W;
        for (int i = ratio.length - 1; i >= 0; i--) {
            int idx = (int) ratio[i][0];
            if (capacity >= wt[idx]) {
                capacity -= wt[idx];
                max += val[idx];
            } else if (capacity <= wt[idx]) {
                max += ratio[i][1] * capacity;
                capacity = 0;
                break;
            }
        }
        System.out.println("the max capacity is : " + max);
    }

    public static void main(String[] args) {
        int val[] = { 60, 100, 120 };
        int wt[] = { 10, 20, 30 };
        int W = 50;

        knapsack(val, wt, W);

    }
}
