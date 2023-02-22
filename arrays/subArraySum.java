public class subArraySum {

    // brute force 0(n3)
    public static int sumarr(int[] arr) {
        int sum = 0;
        int ans = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                sum = 0;
                for (int k = i; k <= j; k++) {
                    sum += arr[k];
                }
                ans = Math.max(ans, sum);
            }
        }
        return ans;
    }

    // prefix sum O(n2)
    public static int prefixSum(int[] arr) {
        int[] p = new int[arr.length];
        p[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            p[i] = p[i - 1] + arr[i];
        }

        int ans = 0;
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum = 0;
            for (int j = i; j < arr.length; j++) {
                if (i > 0) {
                    sum = p[j] - p[i - 1];
                }
                sum = p[j];
            }
            ans = Math.max(ans, sum);
        }
        return ans;
    }

    // kadanes algo O(n)
    public static int kadanes(int[] arr) {

        int ans = 0;
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            ans = Math.max(ans, sum);
            if (arr[i] < 0) {
                sum = 0;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = { 2, 4, 6, 8, 10 };
        System.out.println(kadanes(arr));
    }
}
