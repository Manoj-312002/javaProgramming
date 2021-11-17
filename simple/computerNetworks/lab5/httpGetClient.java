package computerNetworks.lab5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.*;
import java.util.Scanner;

public class httpGetClient {
    private static final String USER_AGENT = "Google Chrome";  
    public static void main(String[] args) throws Exception {
        System.out.print("Enter id : ");
        Scanner sc = new Scanner(System.in);
        String id = sc.nextLine();
        
        URL obj = new URL("http://localhost/" + "?id="+ id );  
        
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();  
        con.setRequestMethod("GET");
        con.setRequestProperty("User-Agent", USER_AGENT);  
        int rcode = con.getResponseCode();  
        
        System.out.println("GET Response Code : " + rcode );

        if ( rcode == HttpURLConnection.HTTP_OK ) {  
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));  
            String inputLine;  
            StringBuffer response = new StringBuffer();

            while ((inputLine = in.readLine()) != null) response.append(inputLine);  
            in.close();  
            System.out.println(response.toString());  
        }else{  
            System.out.println("GET request not worked");  
        }
        
        sc.close();
    }
}
