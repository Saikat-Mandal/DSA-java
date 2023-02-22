import java.util.HashMap;

public class iternary {
    public static void findPath(HashMap<String, String> dataSet) {
        HashMap<String, String> map = new HashMap<>();
        for (String i : dataSet.keySet()) {
            map.put(dataSet.get(i), i);
        }
        String start = "";
        for (String i : dataSet.keySet()) {
            if (!map.containsKey(i)) {
                start = i;
            }
        }
        for (String i : dataSet.keySet()) {
            if (dataSet.containsKey(start)) {
                System.out.print(start + "->" + dataSet.get(start));
            }
            System.out.println();
            start = dataSet.get(start);
        }

    }

    public static void main(String[] args) {
        HashMap<String, String> dataSet = new HashMap<String, String>();
        dataSet.put("Chennai", "Banglore");
        dataSet.put("Bombay", "Delhi");
        dataSet.put("Goa", "Chennai");
        dataSet.put("Delhi", "Goa");
        findPath(dataSet);

    }
}
