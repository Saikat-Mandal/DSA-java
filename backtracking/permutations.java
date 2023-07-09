import java.util.ArrayList;
import java.util.List;

public class permutations {
    // public static void perm(String ip, String op) {
    // if (ip.isEmpty()) {
    // System.out.println(op);
    // return;
    // }
    // for (int i = 0; i < ip.length(); i++) {
    // String op1 = ip.substring(0, i) + ip.substring(i + 1);
    // perm(op1, op + ip.charAt(i));
    // }
    // }

    public static void perm(String ip, String op) {
        if (ip.length() == 0) {
            System.out.print(op + " ");
            return;
        }
        for (int i = 0; i < ip.length(); i++) {
            String newStr = ip.substring(0, i) + ip.substring(i + 1);
            perm(newStr, op + ip.charAt(i));
        }
    }

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> l = new ArrayList<>();
        helper(l, nums, new ArrayList<>());
        return l;
    }

    public static void helper(List<List<Integer>> l, int[] nums, List<Integer> temp) {
        if (temp.size() == nums.length) {
            l.add(new ArrayList<>(temp));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!temp.contains(nums[i])) {
                temp.add(nums[i]);
                helper(l, nums, temp);
                temp.remove(temp.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = { 1, 2, 3 };
        // System.out.println(permute(nums));
        perm("abc", "");
    }
}
