package webtech.lab3;
class numbers{
    int i , j;
    numbers(int a , int b ){
        i = a; j = b;
    }

    void print(){
        System.out.println("Two numbers : " + i + " " + j);
    }
}
class complex extends numbers{
    complex(int i , int j ){
        super(i , j);
    }
    void print(){
        System.out.println(i + " + " + j + "i");
    }
    @Override
    public boolean equals(Object obj ){
        if( !(obj instanceof complex ) ) return false;
        var other = (complex) obj;
        return other.i == i && other.j == j;
    }
}

public class RunTimePolymorphism {
    public static void main(String[] args) {
        complex c = new complex(3, 4);
        c.print();

        complex c1 = new complex(3, 4);
        c1.print();

        numbers n1 = new numbers(3, 4);
        n1.print();


        System.out.println( c1.equals(c) );
        System.out.println( n1.equals(c) );
    }
}
