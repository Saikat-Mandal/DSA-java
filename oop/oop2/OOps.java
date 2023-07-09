import javax.print.DocFlavor.STRING;

public class OOps {
    public static void main(String[] args) {
        Pen p1 = new Pen("blue", 1);
        System.out.println(p1.tip);
    }
}

class Pen {
    String color;
    int tip;

    public Pen(String color, int tip) {
        this.color = color;
        this.tip = tip;
    }
}