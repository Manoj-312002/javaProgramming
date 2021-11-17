package webtech.lab5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

public class EchoClient {
    public static void main(String[] args) throws Exception {
        Socket s = new Socket( "localhost" , 9999 );
       
        BufferedReader socketin = new BufferedReader( new InputStreamReader( s.getInputStream() ) );
        PrintStream socketout = new PrintStream( s.getOutputStream() );

        BufferedReader stdin = new BufferedReader( new InputStreamReader(System.in ) );
        String msg , inp;
        

        System.out.print( "Num 1 : " );
        inp = stdin.readLine();
        socketout.println(inp);

        System.out.print( "Num 2 : " );
        inp = stdin.readLine();
        socketout.println(inp);

        msg = socketin.readLine();
        System.out.println( "Server Echo: " + msg  );

        s.close();
        socketin.close(); socketout.close();

    }   
}
