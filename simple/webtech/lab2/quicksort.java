package webtech.lab2;

import java.util.Scanner;

public class quicksort {
    static void swap( int arr[] , int i , int j ){
        int t = arr[i];
        arr[i]= arr[j];
        arr[j] = t;
    }

    static void quick( int arr[] , int s , int e ){
        if( s > e ) return; 
        int pi = arr[e];
        int i = s-1;
        for( int j = s; j < e; j++ ){
            if( arr[j] < pi ){
                i++; swap( arr , i , j );
            }
        }

        i++;
        swap(arr, i, e );
        quick(arr, s, i-1);
        quick(arr, i+1, e);

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("number of elements : ");
        int n = sc.nextInt();
        
        int arr[] = new int[n];
        for( int i = 0; i < n; i++ ) arr[i] = sc.nextInt();
        quick( arr, 0 , n-1 );
        
        for( int i = 0; i< n; i++ ) System.out.print( arr[i] + " " );
        sc.close();
    }    
}
