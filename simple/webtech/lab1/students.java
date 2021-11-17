package webtech.lab1;

import java.util.Scanner;

public class students {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Number of students :");
        
        int n = sc.nextInt();
        for(int i=0 ; i < n ; i++){
            System.out.print("Name:"); String name = sc.next();
            System.out.print("CGPA :"); float roll =sc.nextFloat();
            
            System.out.println( "Hey " + name + " your cgpa is " + roll );

        }
        sc.close();
    }
}
