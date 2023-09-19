public class playWithBits {
    // getbit
    public static void getbit(int n, int i) {
        int mask = 1 << i;
        System.out.println(n & mask);
    }

    // setbit
    public static void setBit(int n, int i) {
        int mask = 1 << i;
        System.out.println(n | mask);
    }

    // clearbit
    public static void clearBit(int n, int i) {
        int mask = ~(1 << i);
        System.out.println(n & mask);
    }

    // clear last i bits
    public static void clearLastBits(int n, int i) {
        int mask = ~(0) << i;

        System.out.println(n & mask);
    }

    // clear bits in the range of i and j
    public static void clearInRange(int i, int j, int n) {
        int mask1 = ~(0) << j + 1;
        int mask2 = (1 << i) - 1;

        int finalMask = mask1 | mask2;

        System.out.println(finalMask & n);
    }

    // count n of setbits
    public static void count(int n) {
        int count = 0;
        while (n > 0) {
            if ((n & 1) == 1)
                count++;
            n = n >> 1;
        }
        System.out.println(count);
    }

    // fast exponentiantion
    public static void fast(int n, int a) {
        int ans = 1;

        while (n > 0) {
            if ((n & 1) != 0) {
                ans = ans * a;
            }
            a = a * a;
            n = n >> 1;
        }
        System.out.println(ans);
    }

    public static void main(String[] args) {
        // clearLastBits(15, 2);
        // clearInRange(2, 4, 10);
        // count(16);
        fast(3, 5);
    }
}
