import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class subs {
    public static String getSmallestAndLargest(String s, int k) {
        ArrayList<String> l = new ArrayList<>();

        for (int i = 0; i < s.length() - 2; i++) {
            String temp = "";
            for (int j = i; j < i + k; j++) {
                temp += s.charAt(j);
            }
            l.add(temp);
        }
        Collections.sort(l);
        return l.get(0) + "\n" + l.get(l.size() - 1);
    }

    public static void main(String[] args) {
        // Scanner sc = new Scanner(System.in);
        // String s = sc.next();
        // int k = sc.nextInt();
        System.out.print(getSmallestAndLargest("welcome", 3));
    }
}
