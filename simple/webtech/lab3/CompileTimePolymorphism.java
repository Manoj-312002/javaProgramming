package webtech.lab3;

import java.util.Scanner;

public class CompileTimePolymorphism {
    public static void sum( int a , int b ){
        System.out.println("Sum of ints : " + (a+b) );
    }

    public static void sum( float a , float b  ){
        System.out.println("Sum of Floats : " + (a+b) );
    }
    public static void sum( int a , int b , float x , float y){
        System.out.println("Sum of all numbers : " + (a+b+x+y) );
    }

    public static void main(String[] args) {
        System.out.println("Enter two ints : ");
        Scanner sc = new Scanner(System.in);
        
        int a = sc.nextInt(), b = sc.nextInt();
        sum(a,b);
        
        System.out.println("Enter two Floats : ");
        float x  = sc.nextFloat() , y = sc.nextFloat();
        sum(x,y);
        
        sum(a,b,x,y);
        sc.close();
    }
}
