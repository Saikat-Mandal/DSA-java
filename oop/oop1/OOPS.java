import java.util.Arrays;

public class OOPS {
    public static void main(String[] args) {
        // Pen p2 = new Pen("blue", 3);

        // System.out.println(p2.color);
        // BankAcount b = new BankAcount();
        // b.username = "Saikat";
        // b.setPassword("1234");
        // System.out.println(b.getPassword());

        Pen p = new Pen("red", 2);
        p.marks[0] = 3;
        p.marks[1] = 34;
        p.marks[2] = 10;

        System.out.println(Arrays.toString(p.marks));
        Pen p2 = new Pen(p);
        System.out.println(Arrays.toString(p2.marks));
        p.marks[0] = 5;
        System.out.println(Arrays.toString(p.marks));
        System.out.println(Arrays.toString(p2.marks));

    }
}

class BankAcount {
    public String username;
    private String password;

    public void setPassword(String pwd) {
        password = pwd;
    }

    public String getPassword() {
        return this.password;
    }
}

class Pen {
    String color;
    int tip = 2;
    int marks[];

    Pen(String color, int tip) {
        this.color = color;
        this.tip = tip;
        this.marks = new int[3];
    }

    Pen(String color) {
        this.color = color;
        this.marks = new int[3];
    }

    Pen(int tip) {
        this.tip = tip;
        this.marks = new int[3];
    }

    // shallow copy
    // Pen(Pen p3) {
    // this.color = p3.color;
    // this.tip = p3.tip;
    // this.marks = p3.marks;
    // }

    // deep copy
    Pen(Pen p3) {
        marks = new int[3];
        this.color = p3.color;
        this.tip = p3.tip;
        for (int i = 0; i < marks.length; i++) {
            this.marks[i] = p3.marks[i];
        }
    }
}
