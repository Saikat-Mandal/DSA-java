
@FunctionalInterface
interface Mylambda {
    int sum(int a, int b);
}

// class My implements Mylambda {
// public void display() {
// System.out.println("hello world");
// }
// }

public class lambadaDemo {

    // making inner class instead of class outside

    public static void main(String[] args) {
        Mylambda m = (a, b) -> a + b;

        System.out.println(m.sum(1, 2));
    }
}