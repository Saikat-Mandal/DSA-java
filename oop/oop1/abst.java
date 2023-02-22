public class abst {

    public static void main(String[] args) {
        Cow c = new Cow();
        c.eat();
        c.walk();
    }
}

abstract class Animal {
    void eat() {
        System.out.println("Eats");
    }

    abstract void walk();
}

class Cow extends Animal {
    void walk() {
        System.out.println("walks");
    }
}