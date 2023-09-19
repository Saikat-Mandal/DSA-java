public class palindrome {
    public static int isDigitSumPalindrome(int N) {
        int sum = 0;
        while (N != 0) {
            sum += N % 10;
            N /= 10;
        }

        return isPalindrome(sum);
    }

    public static int isPalindrome(int n) {

        int rev = 0;
        int cur = n;
        while (cur != 0) {
            rev = rev * 10 + cur % 10;
            cur /= 10;

        }
        return n == rev ? 1 : 0;
    }

    public static void main(String[] args) {
        System.out.println(isDigitSumPalindrome(56));
    }
}
