import java.util.ArrayList;
import java.util.List;

public class twoStacks {
    public static int twoStacks(int maxSum, List<Integer> a, List<Integer> b) {
        return twoStacksUtil(maxSum, a, b, 0, 0) - 1;
    }

    public static int twoStacksUtil(int maxSum, List<Integer> a, List<Integer> b, int sum, int count) {
        if (count > maxSum) {
            return count;
        }
        if (a.size() == 0 || b.size() == 0)
            return count;

        int ans1 = twoStacksUtil(maxSum, new ArrayList(a.subList(1, a.size())), b, sum + a.get(0), count + 1);
        int ans2 = twoStacksUtil(maxSum, a, new ArrayList(b.subList(1, b.size())), sum + b.get(0), count + 1);

        return Math.max(ans1, ans2);
    }

    public static void main(String[] args) {
        List<Integer> a = new ArrayList<>();
        List<Integer> b = new ArrayList<>();

        System.out.println(twoStacks(0, a, b));
    }
}
