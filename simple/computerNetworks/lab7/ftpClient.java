package computerNetworks.lab7;

import java.net.*;
import java.util.Scanner;
import java.io.*; 

public class ftpClient {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter file name : ");
        String fname = sc.nextLine();


        Socket s = new Socket( "localhost" , 1234);
        var din = new DataInputStream(s.getInputStream()); 
        var dout = new DataOutputStream(s.getOutputStream());

        dout.writeUTF( fname );
        
        System.out.print("Enter location to save : ");
        String loc =  sc.nextLine();

        String filecon;
        FileOutputStream fos = new FileOutputStream( loc );
        System.out.println("Transferring File	");
        
        while(true){
            int ch;
            try{
                filecon = din.readUTF(); 
            }catch(Exception e){
                break;
            }

            ch = Integer.parseInt(filecon); 
            if( ch != -1 )fos.write(ch);
            else break;
        }
        
            
        fos.close();
        sc.close();
        s.close();
    }
}
