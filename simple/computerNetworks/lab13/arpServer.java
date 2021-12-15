package computerNetworks.lab13;

import java.util.HashMap;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.*;

public class arpServer {
    // This process would mimic code in switch
    public static void main(String[] args) throws Exception {
        HashMap<String,String> arp = new HashMap<>();
        ServerSocket ss = new ServerSocket(9999);

        Socket s = ss.accept();
        BufferedReader sin = new BufferedReader(new InputStreamReader(s.getInputStream()));
        PrintStream sout = new PrintStream(s.getOutputStream());
        
        HashMap<String,String> arps = new HashMap<>();
        arps.put("192.168.1.1", "23:12:54:54:23");
        arps.put("192.168.1.2", "75:12:55:54:23");
        arps.put("192.168.1.3", "43:12:55:54:43");
        
        String msg = "";
        while( true ){
            msg = sin.readLine();
            System.out.println(msg);
            if( arp.containsKey(msg) ) sout.println( arp.get(msg) );
            else if ( msg.equals("-1") ) break;
            else{
                // here need to send arp broadcast request ( which involves sending packet in ethernet lvl )
                // wait for response from specific ip address
                // instead used embedded map
                if( arps.containsKey(msg) ) { sout.println( arps.get(msg) );  arp.put(msg, arps.get(msg) ); }
                else sout.println("null");
            }
        }
        
        sin.close(); sout.close(); s.close(); ss.close();
    }
}
