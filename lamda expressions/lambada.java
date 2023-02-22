public class lambada {
    public static void main(String[] args) {
        Demo d = new Demo();
        d.method1();
    }
}

interface Mylambda {
    void display();
}

class UseLambda {
    void callLambda(Mylambda m) {
        m.display();
    }
}

class Demo {
    void method1() {
        UseLambda m = new UseLambda();
        m.callLambda(() -> System.out.println("hi"));
    }
}
