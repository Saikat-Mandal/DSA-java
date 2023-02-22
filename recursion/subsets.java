public class subsets {
    public static void sets(String ip, String op) {
        if (ip.isEmpty()) {
            System.out.println(op);
            return;
        }
        String op1 = op;
        String op2 = op;
        op1 += ip.charAt(0);
        op2 = op;
        sets(ip.substring(1), op1);
        sets(ip.substring(1), op2);
    }

    public static void main(String[] args) {
        sets("123", "");
    }
}