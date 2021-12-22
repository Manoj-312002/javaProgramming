package computerNetworks.lab13;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class recvSliding{
    
    private int window_size = 5;
    private int data_size = 13;
    
    private ArrayList<String> data;
    private ArrayList<Boolean> acked;
    
    private int ini_seq = 20;
    private int pck_size = 2;
    private int rcv_base = 0;

    private ServerSocket ss;
    private Socket s;
    private BufferedReader sin ;
    private PrintStream sout ;

    // private boolean error = true;

    public void chk_acked(){
        int i = 0;
        for(  i = 0 ; i < data_size; i++ ) if( !acked.get(i) ) break ;
        rcv_base = i;
    }
    public void rcv_pck() throws Exception {
        int rcv_seq = (Integer.valueOf( sin.readLine() ) - ini_seq )/pck_size;
        // if( error && rcv_seq == 7 ){ error = false; return ; }
        acked.set(rcv_seq, true);
        chk_acked();

        String data_pck = sin.readLine();
        System.out.println(data_pck + " " +  rcv_seq + " " + acked );
        data.set(rcv_seq, data_pck);
        sout.println( ini_seq + pck_size*(rcv_base+1) );
    }

    public void run() throws Exception {
        int s = 0;
        while( rcv_base < data_size ){
            int st = rcv_base;
            for(  ; s < Math.min(st+window_size , data_size ) ; s++ ) rcv_pck(); 
        }
    }

    recvSliding() throws Exception {
        ss = new ServerSocket(9999);
        s = ss.accept();
        data = new ArrayList<>(); 
        acked = new ArrayList<>(data_size);
        for(int i = 0; i < data_size ; i++ ){ data.add(""); acked.add(false); }

        sin = new BufferedReader( new InputStreamReader( s.getInputStream() ) );
        sout = new PrintStream( s.getOutputStream() );

    }
    public static void main(String[] args) throws Exception{
        recvSliding rslidng = new recvSliding();
        rslidng.run();
    }
}