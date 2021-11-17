package webtech.Theory;

class z{
    z(int a ){System.out.println("hi");}
    void run(){System.out.println("z");}
}

class d extends z{
    d(){super(1);}
    void run(){ System.out.println("d"); }
}

public class trialInheritance {
    public static void main(String[] args) {
        d x = new d();
        // d l = new z();
        z u = new z(1);
        z y = new d();

        x.run(); u.run(); y.run();
        d l = (d)y;
        l.run();

        // z y = x;
        // d l = u;
    }
}
