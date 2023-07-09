import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class practice {
    public static long[] printFirstNegativeInteger(long A[], int N, int k) {
        int i = 0, j = 0;
        long ans[] = new long[A.length + k - 1];
        int p = 0;
        Queue<Long> q = new LinkedList();
        while (j < N) {
            if (A[j] < 0) {
                q.add(A[j]);
            } else if ((j - i + 1) < k) {
                j++;
            }
            if ((j - i + 1) == k) {
                if (q.isEmpty()) {
                    ans[p++] = 0;
                }

                else {
                    if (q.peek() == A[i]) {
                        ans[p++] = q.peek();
                    }
                    q.remove();
                }
            }
            i++;
            j++;
        }
        return ans;
    }

    public static void main(String[] args) {
        long arr[] = { -8, 2, 3, -6, 10 };
        System.out.println(Arrays.toString(printFirstNegativeInteger(arr, 5, 2)));
    }
}
