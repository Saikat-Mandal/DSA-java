import java.util.*;
import java.util.LinkedList;

public class Main {
    // pattern 1

    public static void pattern1(int n) {
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
    // *
    // * *
    // * * *
    // * * * *
    // * * * * *

    // pattern 2

    public static void pattern2(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    // * * * * *
    // * * * * *
    // * * * * *
    // * * * * *
    // * * * * *

    public static void pattern3(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    // * * * * *
    // * * * *
    // * * *
    // * *
    // *
    public static void pattern4(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }

    static Queue<Integer> q = new LinkedList<>();

    public static void rev(Stack<Integer> st) {

        if (!st.isEmpty()) {
            q.add(st.pop());

        } else {
            return;
        }
        System.out.println(q);  
        while (!q.isEmpty()) {
            st.push(q.remove());
        }
    }

    public static void main(String[] args) {
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < 5; i++) {
            st.push(i);
        }
        rev(st);

    }
}