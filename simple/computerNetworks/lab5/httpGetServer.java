package computerNetworks.lab5;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class httpGetServer {

    public static void main( String[] args ) throws Exception {
        try (ServerSocket serverSocket = new ServerSocket(80) ) {
            while (true) {
                try (Socket client = serverSocket.accept()) {
                    handleClient(client);
                }
            }
        }
    }

    private static void handleClient(Socket client) throws IOException {
        
        BufferedReader br = new BufferedReader( new InputStreamReader(client.getInputStream()) );
        StringBuilder requestBuilder = new StringBuilder();
        String line;
        
        while (!(line = br.readLine()).isBlank()) {
            System.out.println(line);
            requestBuilder.append(line + "\r\n");
        }
        System.out.println("\n");
        
        // getting the path from response 
        String request = requestBuilder.toString();
        String path = request.split("\r\n")[0].split(" ")[1];
        String[] args = {};
        if(path.length() > 2 ) args = path.substring(2).split("&");
        
        
        byte[] content = "<h1>Not Found </h1>".getBytes();
        if( args.length != 0 && args[0].substring(0,2).equals("id")  ){
            content = ("<h1>" + args[0].substring(3, args[0].length() ) + "</h1>").getBytes();
        }
        
        send(client, "200" , "text/html", content);
    }

    // creating response message
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