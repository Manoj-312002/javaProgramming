package computerNetworks.lab13;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Arrays;

public class sendSliding{
    /* 
    assumptions:
        - ini seq = 20
        - pck_size is always same (2)
        - window size is 5
    */
    private int window_size = 5;
    private ArrayList<String> data = new ArrayList<>( Arrays.asList( "The" , "quick" , "brown" , "fox" , "jumps" , "over" , "the" , "lazy" , "dog" ) );
    
    private int send_base;      // last packet successfully acked
    private int next_seq_num;   // next seq number to send
    
    private int ini_seq = 20;
    private int pck_size = 2;
    
    private Socket s;
    private BufferedReader sin ;
    private PrintStream sout ;


    public void send_pck(int i){
        // Sends data over TCP - only seq number is sent next line data
        sout.println( ini_seq + pck_size*i );
        sout.println( data.get(i) );
    }

    public void rcv_pck() throws Exception {
        int rcv_ack = (Integer.valueOf( sin.readLine() ) - ini_seq )/pck_size;
        send_base = Math.max(send_base , rcv_ack );
    }

    public void run() throws Exception{
        while( send_base < data.size() ){
            
            int s = (next_seq_num - ini_seq)/pck_size;
            for(int i = s; i < Math.min(data.size() , send_base + window_size ) ; i++ ) send_pck(i);
            
            // This is wrong it waits for all the 5 packets to be received
            // need to implement 2 thread which send separately and receive separately
            // need not manually call rcv_pck -> but if new pck recvd update
            int st = Math.min( send_base + window_size , data.size() );
            for(int i = s; i < st ; i++ ) rcv_pck();

            // resend single packet in tcp
            if( send_base < st ) send_pck(send_base);
            next_seq_num = ini_seq + (st+1)*pck_size;
            
            System.out.println("Next seq num " + next_seq_num );
            System.out.println("Send base " + send_base );
            
        }
    }

    sendSliding() throws Exception {
        s = new Socket("localhost" , 9999);
        send_base = 0;
        next_seq_num = 20;
        
        sin = new BufferedReader( new InputStreamReader( s.getInputStream() ) );
        sout = new PrintStream( s.getOutputStream() );

    }
    public static void main(String[] args) throws Exception {
        sendSliding sslidng = new sendSliding();
        sslidng.run();
    }
}
