package webtech.lab5;
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

        int  n1 , n2 ;

        n1 = Integer.parseInt( socketin.readLine() );
        n2 = Integer.parseInt( socketin.readLine() ); 

        System.out.println( "Server calculating " );
        socketout.println( n1 + n2 );
        
        s.close();
        socketin.close(); socketout.close();
        ss.close();
    }
}
