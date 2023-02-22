interface Mylambda {
    void display(String s);
}

public class methodRefrence {
    public static void reverse(String s) {
        s += "e";
        System.out.println(s);
    }

    public static void main(String[] args) {
        Mylambda m = methodRefrence::reverse;

        m.display("saikat");
    }
}
