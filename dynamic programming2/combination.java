import java.util.ArrayList;

public class combination {
    static ArrayList<String> l = new ArrayList<>();

    public static ArrayList<String> comb(String ip, String op) {
        if (ip.isEmpty()) {
            l.add(op);
            return l;
        }
        comb(ip.substring(1), op);
        comb(ip.substring(1), op + ip.charAt(0));
        return l;
    }

    public static void main(String[] args) {

        System.out.println(comb("abc", ""));
    }
}
