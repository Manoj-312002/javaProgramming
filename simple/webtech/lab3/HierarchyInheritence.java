package webtech.lab3;

class Employee{
    Employee(String name ){
        System.out.println( name + " is an employee");
    }
}

class Coder extends Employee{
    Coder(String name ){
        super(name );
        System.out.println( name + " is a coder");
    }
}

class Manager extends Employee {
    Manager(String name ){
        super(name );
        System.out.println( name + " is a Manager");
    }
}
class Tester extends Coder{
    Tester(String name ){
        super(name );
        System.out.println( name + " is a Tester ");
    }
}
class Developer extends Coder{
    Developer(String name ){
        super(name );
        System.out.println( name + " is a Developer ");
    }
}
class Assistant extends Manager{
    Assistant(String name ){
        super(name);
        System.out.println( name + "is a Assistant manager");
    }
}

public class HierarchyInheritence {
    public static void main(String[] args) {
        Developer dv = new Developer("Mr developer");
        System.out.println(dv + "\n" );
        Tester te = new Tester("Mr Tester");
        System.out.println(te + "\n" );
        Assistant as = new Assistant("Mr Assistant");
        System.out.println(as + "\n" );
    }
}
