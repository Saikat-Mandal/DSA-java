public class firstOcuurence {
    public static int occurence(int[] arr, int key) {
        return helper(arr, 0, key);
    }

    // public static int helper(int[] arr, int i, int key) {
    // if (i == arr.length)
    // return -1;
    // if (arr[i] == key) {
    // return i;
    // }
    // return helper(arr, i + 1, key);
    // }

    public static int Loccurence(int[] arr, int key) {
        return helper(arr, arr.length - 1, key);
    }

    public static int helper(int[] arr, int i, int key) {
        if (i == 0)
            return -1;
        if (arr[i] == key)
            return i;
        return helper(arr, i - 1, key);
    }

    public static void main(String[] args) {
        int[] arr = { 8, 3, 6, 9, 5, 10, 2, 5, 3 };
        System.out.println(Loccurence(arr, 16));
    }
}
