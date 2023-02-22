import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class practice {
    public static int count(char a, String s2) {

        int c = 0;
        for (int i = 0; i < s2.length(); i++) {
            char ch = s2.charAt(i);
            if (ch == a) {
                c++;
            }
        }
        return c;

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char ch = sc.next().charAt(0);
        String s = sc.next();
        System.out.println(count(ch, s));
    }
}
