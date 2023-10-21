import java.util.*;

class Main {
    // q1
    public static void q1(int arr[], int dist[], int n) {
        int cost = 0;
        int index = -1;
        for (int i = 0; i < n; i++) {
            if (arr[i] == 1) {
                if (index != -1) {
                    cost += dist[i] - dist[index];
                }
                index = i;
            }
        }
        System.out.println(cost);
    }

    public static void q2(int s1, int s2, int s3) {
        if (s1 < s2) {
            System.out.println("Good");
        } else if (s1 >= s2 && s1 <= s3) {
            System.out.println("Best");

        } else {
            System.out.println("Can do better");
        }
    }

    public static void q3(int speed[], int track) {
        int res[] = new int[speed.length];
        int time = Integer.MAX_VALUE;
        for (int i = 0; i < speed.length; i++) {
            res[i] = track / (int) speed[i];
            time = Math.min(time, res[i]);
        }
        System.out.println(time);
    }

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

        return count > 2 ? false : true;
    }

    public static void calculateDiscount(int n) {
        int sum = 0;
        while (n != 0) {
            int digit = n % 10;
            if (isPrime(digit)) {
                sum += digit;
            }
            n /= 10;
        }
        System.out.println(sum);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // int track = sc.nextInt();

        // int arr[] = new int[n];
        int dist[] = new int[3];
        // for (int i = 0; i < n; i++) {
        // arr[i] = sc.nextInt();
        // }
        // for (int i = 0; i < 3; i++) {
        // dist[i] = sc.nextInt();
        // }
        calculateDiscount(84302);

    }
}