package computerNetworks.lab12;

import java.net.InetAddress;
import java.util.Scanner;

public class ping {
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter host name : ");
        String ip = sc.nextLine();
        InetAddress ad = InetAddress.getByName(ip);
        System.out.println(ad);
        if( ad.isReachable(5000) ) System.out.println("The host is reachable");
        else System.out.println("The host is not reachable");
        sc.close();
    }
}
