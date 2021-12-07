package computerNetworks.lab12;
import java.util.Scanner;

public class ping2 {
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter host name : ");
        String ip = sc.nextLine();
        System.out.print("Enter number of packets : ");
        int np = sc.nextInt();

        Process p = Runtime.getRuntime().exec("ping -c " + np + " " + ip );
        var st = p.getInputStream();
        StringBuilder route = new StringBuilder();
        int r;
        while( (r = st.read() )!= -1 ) route.append( (char)r );
        
        System.out.println(route);
        sc.close();
    }
}
