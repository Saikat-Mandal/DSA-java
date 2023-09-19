import java.io.*;
import java.util.*;

public class practice {
    public static boolean isAnagram(String a, String b) {
        if (a.length() != b.length())
            return false;
        HashMap<Character, Integer> map = new HashMap<>();
        String a1 = a.toLowerCase();
        String b2 = b.toLowerCase();
        for (int i = 0; i < a1.length(); i++) {
            char ch = a1.charAt(i);
            if (map.containsKey(ch)) {
                map.put(ch, map.get(ch) + 1);
            } else {
                map.put(ch, 1);
            }
        }

        for (int i = 0; i < b2.length(); i++) {
            char ch = b2.charAt(i);
            if (map.containsKey(ch)) {
                map.put(ch, map.get(ch) - 1);
            }

        }

        for (char name : map.keySet()) {
            // search for value
            int val = map.get(name);
            System.out.println("Key = " + name + ", Value = " + val);
        }

        return true;

    }

    public static void main(String[] args) {
        String a = "anagramm";
        String b = "marganaa";

        if (isAnagram(a, b)) {
            System.out.println("Anagrams");
        } else {
            System.out.println("Not Anagrams");

        }
    }
}
