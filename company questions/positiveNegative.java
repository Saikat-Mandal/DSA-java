import java.util.Arrays;

class positiveNegative {

    // positive or negative
    public static void sign(int n) {
        if (n < 0) {
            System.out.println("-ve");
        } else {
            System.out.println("+ve");
        }
    }

    // sum of first n natural numbers
    public static void natural(int n) {
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            ans += i;
        }
        System.out.println(ans);
    }

    // leap year
    public static void leap(int n) {
        if (n % 400 == 0) {
            System.out.println("leap");
        } else if (n % 4 == 0 && n % 100 != 0) {
            System.out.println("leap");
        } else {
            System.out.println("not leap");
        }
    }

    // prime number
    public static boolean isPrime(int n) {
        if (n < 2) {
            return false;
        }
        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                count++;
            }
        }

        if (count > 2) {
            return false;
        }
        return true;
    }

    public static void primeInRange(int s, int e) {
        for (int i = s; i <= e; i++) {
            if (isPrime(i)) {
                System.out.print(i + " ");
            }
        }
    }

    // sum of digits
    public static void sum(int n) {
        int sum = 0;
        while (n != 0) {
            sum += n % 10;
            n /= 10;
        }
        System.out.println(sum);
    }

    // reverse a number
    public static void rev(int n) {
        int rev = 0;

        while (n != 0) {
            rev = (rev * 10) + (n % 10);
            n /= 10;
        }
        System.out.println(rev);
    }

    // armstrong number
    public static void armstrong(int n) {
        int sum = 0;
        int num = n;
        while (num != 0) {
            int cur = num % 10;
            sum += cur * cur * cur;
            num /= 10;
        }
        if (sum == n) {
            System.out.println("armstrong");
        } else {
            System.out.println("not armstrong");
        }
    }

    // fibonacci
    public static int fib(int n) {
        if (n <= 1)
            return n;

        return fib(n - 1) + fib(n - 2);
    }

    // fibonacci in a given range
    public static void fibRange(int n) {
        int f = 0;
        int s = 1;
        System.out.print(f + " " + s + " ");
        int num;
        for (int i = 2; i <= n; i++) {
            num = f + s;
            f = s;
            s = num;
            System.out.print(num + " ");
        }
    }

    // factorial
    public static int factorial(int n) {
        if (n == 0)
            return 1;

        return n * factorial(n - 1);
    }

    // factorial using for loop
    public static int factorial2(int n) {
        int f = 1;

        for (int i = 1; i <= n; i++) {
            f *= i;
        }
        return f;
    }

    // power of a number ]
    public static int power(int n, int p) {
        if (p == 0)
            return 1;
        return n * power(n, p - 1);
    }

    // strong number
    public static int strong(int n) {
        int sum = 0;
        while (n != 0) {
            sum += factorial2(n % 10);
            n /= 10;
        }
        return sum;
    }

    /////////////////////////////////////////////////////////////////////////////////////////
    // recursion questions

    // largest element in an array recursion

    public static int largest(int arr[], int max) {
        if (arr.length == 0) {
            return max;
        }
        max = Math.max(max, arr[arr.length - 1]);
        arr = Arrays.copyOfRange(arr, 0, arr.length - 1);
        return largest(arr, max);
    }

    public static int reverseR(int n, int rev) {
        if (n == 0)
            return rev;

        rev = rev * 10 + n % 10;
        return reverseR(n / 10, rev);
    }

    public static void permutations(String ip, String op) {
        if (ip.isEmpty()) {
            System.out.print(op + " ");
            return;
        }
        for (int i = 0; i < ip.length(); i++) {

            String str = ip.substring(0, i) + ip.substring(i + 1);
            permutations(str, op + ip.charAt(i));
        }
    }

    public static int lengthOfString(String s) {
        if (s.isEmpty())
            return 0;

        return 1 + lengthOfString(s.substring(1));
    }

    public static void main(String[] args) {
        int arr[] = { 58, 3, 2, 4, 7 };

        System.out.println(lengthOfString("abcdflw"));

    }
}