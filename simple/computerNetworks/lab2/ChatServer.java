package computerNetworks.lab2;

import java.net.ServerSocket;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;


public class ChatServer {
    public static void main(String[] args) throws Exception{
        ServerSocket ss = new ServerSocket(9999);
        Socket s = ss.accept();


        BufferedReader socketin = new BufferedReader( new InputStreamReader( s.getInputStream() ) );
        PrintStream socketout = new PrintStream( s.getOutputStream() );

        BufferedReader stdin = new BufferedReader( new InputStreamReader(System.in ) );
        String msg , inp;

        while( true ){
            msg = socketin.readLine();
            if( msg.equals("bye") ){
                socketout.println("bye");
                break;
            }

            System.out.print( "Client : " + msg + "\n");
            System.out.print( "Server : " );
            inp = stdin.readLine();

            socketout.println(inp);
        }
        
        s.close();
        socketin.close(); socketout.close();
        ss.close();
    }
}
