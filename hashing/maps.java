import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class maps {
    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();
        HashSet<Integer> set = new HashSet<>();
        map.put("china", 150);
        map.put("India", 100);
        map.put("japan", 30);
        map.put("US", 80);
        map.put("brazil", 50);

        set.add(1);
        set.add(1);
        set.add(2);
        set.add(4);
        set.add(6);
        // Set<String> set = map.keySet();
        // for (String i : set) {
        // System.out.println(i + " " + map.get(i));
        // }

        Iterator<Integer> i = set.iterator();

        while (i.hasNext()) {
            System.out.println(i.next());
        }
    }
}