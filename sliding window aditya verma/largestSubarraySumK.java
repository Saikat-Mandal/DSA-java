public class largestSubarraySumK {
    // not work for negative numbers
    public static int lenOfLongSubarr(int A[], int N, int K) {
        int i = 0, j = 0;
        int ans = Integer.MIN_VALUE;
        int sum = 0;
        while (j < N) {
            sum += A[j];
            if (sum < K) {
                j++;
            } else if (sum == K) {
                ans = Math.max(ans, (j - i + 1));
                j++;
            } else if (sum > K) {
                while (sum > K) {
                    sum -= A[i];
                    i++;
                }
                if (sum == K) {
                    ans = Math.max(ans, j - i + 1);
                }
                j++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] A = { 10, 5, 2, 7, 1, 9 };
        System.out.println(lenOfLongSubarr(A, A.length, 15));
    }
}
