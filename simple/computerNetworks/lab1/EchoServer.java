package computerNetworks.lab1;
import java.net.ServerSocket;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

public class EchoServer {
    public static void main(String[] args) throws Exception{
        ServerSocket ss = new ServerSocket(9999);
        Socket s = ss.accept();


        BufferedReader socketin = new BufferedReader( new InputStreamReader( s.getInputStream() ) );
        PrintStream socketout = new PrintStream( s.getOutputStream() );

        String msg;

        while( true ){
            msg = socketin.readLine();
            if( msg.equals("bye") ){
                socketout.println("bye");
                break;
            }

            System.out.print( "Client : " + msg + "\n");
            System.out.println( "Server Echoing " );
            socketout.println(msg);
        }
        
        s.close();
        socketin.close(); socketout.close();
        ss.close();
    }
}
