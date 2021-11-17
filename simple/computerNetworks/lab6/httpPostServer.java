package computerNetworks.lab6;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class httpPostServer {

    public static void main( String[] args ) throws Exception {
        try (ServerSocket serverSocket = new ServerSocket(8000) ) {
            while (true) {
                try (Socket client = serverSocket.accept()) {
                    handleClient(client);
                }
            }
        }
    }

    private static void handleClient(Socket client) throws IOException {

        InputStream is = client.getInputStream();
        InputStreamReader isReader = new InputStreamReader(is);
        BufferedReader br = new BufferedReader(isReader);
        byte[] content = "<h1> Not Found </h1>".getBytes();
        
        String headerLine = null; 
        while((headerLine = br.readLine()).length() != 0){
            // Checking if it is a get request
            if( headerLine.substring(0,3).equals("GET") ){
                send(client, "200" , "text/html", content);
                return;
            }
            System.out.println(headerLine);
        }
        System.out.println("\n");

        // reading payload
        StringBuilder payload = new StringBuilder();
        while(br.ready()) payload.append((char) br.read());
        String[] args = payload.toString().split("&");
                    
        // creating response according to payload
        if( args.length != 0 && args[0].substring(0,2).equals("id")  ){
            content = ("<h1>" + args[0].substring(3, args[0].length() ) + "</h1>").getBytes();
        }
        
        send(client, "200" , "text/html", content);
    }

    // to create response message
    private static void send(Socket s, String status, String Type, byte[] content) throws IOException {
        OutputStream opt = s.getOutputStream();
        opt.write(("HTTP/1.1 " + status +  "\n" ).getBytes());
        opt.write(("ContentType: " + Type + "\r\n").getBytes());
        opt.write("\r\n".getBytes());
        opt.write(content);
        opt.write("\r\n\r\n".getBytes());
        opt.flush();
        s.close();
    }

}