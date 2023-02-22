public class binaryStrings {
    public static void binaryS(int n, int lastPlace, String sb) {
        if (n == 0) {
            System.out.println(sb);
            return;
        }

        // if (lastPlace == 0) {

        // binary(n - 1, 0, sb.append("0"));
        // binary(n - 1, 1, sb.append("1"));
        // }
        binaryS(n - 1, 0, sb + "0");

        if (lastPlace == 0) {

            binaryS(n - 1, 1, sb + "1");
        }

    }

    public static void main(String[] args) {
        binaryS(3, 0, "");
    }
}
