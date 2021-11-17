package webtech.lab1;

import java.util.Scanner;

public class factorial {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int ans = 1;
        while( n != 0 ){
            ans *= n;
            n--;
        }
        
        System.out.println(ans);
        sc.close();
    }
}
