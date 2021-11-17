package webtech.lab3;

import java.util.Scanner;

class polygon{
    public int n;
    polygon( int n ){
        this.n = n;
    }
    void printSides(){
        System.out.println("Number of sides in polygon = " + n );
    }
}

class rectangle extends polygon{
    public int l , b;
    rectangle(int a , int b){
        super(4);
        this.l = a; this.b = b;
    }
}

class square extends rectangle{
    square(int a){
        super(a, a);
    }

    int area(){
        return l*b;
    }
}

public class MultiLevelInheritance {
    public static void main(String[] args) {
        System.out.println("Enter side of square : ");
        Scanner sc = new Scanner(System.in);

        square sq = new square( sc.nextInt() );
        System.out.println(" The area of given square is : " + sq.area() );
        
        sq.printSides();
        sc.close();

    }
}
