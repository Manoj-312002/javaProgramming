package computerNetworks.lab6;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.*;
import java.util.*;

public class httpPostClient {
    private static final String USER_AGENT = "Google Chrome";  
    public static void main(String[] args) throws Exception {
        
        // Getting input from user
        System.out.print("Enter id : ");
        Scanner sc = new Scanner(System.in);
        String id = sc.nextLine();
        
        // creating a post request
        URL obj = new URL("http://localhost/" );
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();  
        con.setRequestMethod("POST");
        con.setRequestProperty("User-Agent", USER_AGENT);  
        con.setDoOutput(true);
        
        // writing output to post
        DataOutputStream out = new DataOutputStream(con.getOutputStream());
        out.writeBytes( "id=" + id );
        out.flush();
        out.close();

        // getting response code
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
