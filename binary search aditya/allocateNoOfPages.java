public class allocateNoOfPages {
    public static int pages(int[] A, int M) {
        if (A.length < M)
            return -1;
        int s = max(A);
        int e = sum(A);
        int res = -1;
        while (s <= e) {
            int mid = s + (e - s) / 2;
            if (isValid(A, M, mid)) {
                res = mid;
                e = mid - 1;
            } else {
                s = mid + 1;
            }
        }
        return res;
    }

    public static int max(int[] A) {
        int ans = Integer.MIN_VALUE;
        for (int i : A) {
            ans = Math.max(ans, i);
        }
        return ans;
    }

    public static int sum(int[] A) {
        int ans = 0;
        for (int i : A) {
            ans += i;
        }
        return ans;
    }

    public static boolean isValid(int A[], int M, int mid) {
        int student = 1;
        int sum = 0;
        for (int i : A) {
            if (sum + i > mid) {
                student++;
                sum = i;
            } else {
                sum += i;
            }
        }
        return student <= M;
    }

    public static void main(String[] args) {
        int A[] = { 10, 20, 30, 40 };
        System.out.println(pages(A, 2));
    }
}
