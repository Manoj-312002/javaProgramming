package webtech.lab1;
import java.util.*;

public class armstrong {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int t = n;
        int ans = 0;
        while( t != 0 ){
            int r = t%10;
            ans += (r*r*r);
            t /= 10;
        }

        if( ans == n ) System.out.println("Armstrong number");
        else System.out.println("Not Armstrong");
        sc.close();
    }
}