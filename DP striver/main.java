import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

class main {

    // subsequences
    public static void subsequences(int[] arr, int i, ArrayList<ArrayList<Integer>> res, ArrayList<Integer> temp) {
        if (i == arr.length) {
            res.add(new ArrayList<>(temp));
            return;
        }

        temp.add(arr[i]);
        subsequences(arr, i + 1, res, temp);
        temp.remove(temp.size() - 1);
        subsequences(arr, i + 1, res, temp);

    }

    // sum
    // public static void sum(int[] arr, int i, ArrayList<ArrayList<Integer>> res,
    // ArrayList<Integer> temp, int sum,
    // int k) {
    // if (i == arr.length) {
    // if (sum == k) {
    // res.add(new ArrayList<>(temp));
    // }
    // return;
    // }

    // sum += arr[i];
    // temp.add(arr[i]);
    // sum(arr, i + 1, res, temp, sum, k);
    // temp.remove(temp.size() - 1);
    // sum -= arr[i];
    // sum(arr, i + 1, res, temp, sum, k);

    // }

    // print only one sum
    public static boolean sum(int[] arr, int i, ArrayList<ArrayList<Integer>> res, ArrayList<Integer> temp, int sum,
            int k) {
        if (i == arr.length) {
            if (sum == k) {
                res.add(new ArrayList<>(temp));
                return true;
            }
            return false;
        }

        sum += arr[i];
        temp.add(arr[i]);
        if (sum(arr, i + 1, res, temp, sum, k))
            return true;
        temp.remove(temp.size() - 1);
        sum -= arr[i];
        if (sum(arr, i + 1, res, temp, sum, k))
            return true;

        return false;
    }

    // print no of subsequences
    public static int sum3(int[] arr, int i, int sum,
            int k) {
        if (i == arr.length) {
            if (sum == k) {
                return 1;
            }
            return 0;
        }

        sum += arr[i];
        int l = sum3(arr, i + 1, sum, k);
        sum -= arr[i];
        int r = sum3(arr, i + 1, sum, k);

        return l + r;
    }

    public static void main(String[] args) {
        int arr[] = { 1, 2, 1 };
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        // sum(arr, 0, res, new ArrayList<>(), 0, 2);
        System.out.println(sum3(arr, 0, 0, 2));

    }
}