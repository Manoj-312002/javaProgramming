package webtech.lab2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class binarysearch {

    public static int binaryrfind( ArrayList<Integer> ar , int v ){
        int s = 0, e = ar.size() - 1 ;
        while( s <= e ){
            int m = s + (e-s)/2;
            if( ar.get(m) == v ) return m;
            else if( ar.get(m) > v ) e = m-1;
            else s = m+1;
        }
        return -1;
    }
    public static void main(String[] args) {
        ArrayList<Integer> ar = new ArrayList<Integer>();
        System.out.println( "Enter elements or -1 to exit : " );
        Scanner sc = new Scanner(System.in);
        int v ;

        while( true ){
            v = sc.nextInt();
            if( v == -1  ) break;
            ar.add(v);
        }

        Collections.sort(ar);
        System.out.println( "sorted array : " + ar );
        
        int s , si;

        System.out.print("Enter value to remove: " );
        s = sc.nextInt(); si = ar.indexOf(s);
        if( si == -1 ) System.out.println("Element not found");
        else{
            ar.remove(si);
            System.out.println("New array : " + ar);
        }


        System.out.print("Enter value to remove: " );
        s = sc.nextInt(); si = binaryrfind(ar, s);
        if( si == -1 ) System.out.println("Element not found");
        else{
            ar.remove(si);
            System.out.println("New array : " + ar);
        }

        sc.close();
    }
}
