package computerNetworks.lab12;

import java.net.InetAddress;
import java.util.Scanner;

public class traceroute {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter host name : ");
        String ip = sc.nextLine();
        InetAddress ad = InetAddress.getByName(ip);
        System.out.println(ad);
        

        // var x = ad.isReachable( NetworkInterface.getByName("wlp1s") , 1 , 1000);
        
        Process qr = Runtime.getRuntime().exec("traceroute " + ad.getHostAddress());
        var st = qr.getInputStream();
        // BufferedReader br = new BufferedReader( new InputStreamReader( qr.getInputStream() ));
        // br.readLine();

        StringBuilder route = new StringBuilder();
        
        int r;
        while( (r = st.read() )!= -1 ) route.append( (char)r );
        
        System.out.println(route);
        sc.close();
    }    
}
