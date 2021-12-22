package computerNetworks.lab13;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class rarpClient {
    public static void main(String[] args) throws Exception {
        Socket s = new Socket("localhost" , 9999 );
        BufferedReader sin = new BufferedReader(new InputStreamReader(s.getInputStream()));
        PrintStream sout = new PrintStream(s.getOutputStream());
        
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Mac to find ip");
        String ip = sc.nextLine();

        sout.println(ip);
        System.out.println("ip addr : " + sin.readLine() );
        sout.println("-1");
        sc.close();
        s.close();
    }
}
