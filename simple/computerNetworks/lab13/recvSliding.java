package computerNetworks.lab13;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class recvSliding{
    
    private int window_size = 5;
    private int data_size = 9;
    
    private ArrayList<String> data;
    private ArrayList<Boolean> acked;
    
    private int ini_seq = 20;
    private int pck_size = 2;
    private int rcv_base = 0;

    private ServerSocket ss;
    private Socket s;
    private BufferedReader sin ;
    private PrintStream sout ;


    public void chk_acked(){
        int i = 0;
        for(  i = 0 ; i < data_size; i++ ) if( !acked.get(i) ) break ;
        rcv_base = i;
    }
    public void rcv_pck() throws Exception {
        int rcv_seq = (Integer.valueOf( sin.readLine() ) - ini_seq )/pck_size;
        acked.set(rcv_seq, true);
        chk_acked();

        String data_pck = sin.readLine();
        data.set(rcv_seq, data_pck);
        sout.println( ini_seq + pck_size*(rcv_base+1) );
    }

    public void run() throws Exception {
        int s;
        while( rcv_base < data_size ){
            int st = rcv_base;
            for( s = 0 ; s < st + window_size; s++ ) rcv_pck();
        }
    }

    recvSliding() throws Exception {
        ss = new ServerSocket(9999);
        s = ss.accept();
        data = new ArrayList<>(); 
        acked = new ArrayList<>(9);
        for(int i = 0; i < 9 ; i++ ){ data.add(""); acked.add(false); }
        System.out.println(data  + " " + acked );

        sin = new BufferedReader( new InputStreamReader( s.getInputStream() ) );
        sout = new PrintStream( s.getOutputStream() );

    }
    public static void main(String[] args) throws Exception{
        recvSliding rslidng = new recvSliding();
        rslidng.run();
    }
}