package computerNetworks.lab7;

import java.net.*; 
import java.io.*; 

public class ftpServer{
    public static void main(String[] args) throws Exception{
        var ss=new ServerSocket(9999); 
        var soc=ss.accept();
        var din = new DataInputStream(soc.getInputStream()); 
        var dout = new DataOutputStream(soc.getOutputStream());
        
        var fname = din.readUTF(); 
        System.out.println("File name :" + fname);

        var recfile = new File(fname);

        if(recfile.exists()){
            // dout.writeUTF("Y");
            
            FileInputStream fos=new FileInputStream(recfile); int ch;
            System.out.println("Transferring File	");
            while(true){
                ch=fos.read();
                if(ch!=-1) dout.writeUTF(String.valueOf(ch));
                else break;
            }
            fos.close();
            System.out.println("File Transferring Completed .");
        }else{
            System.out.println(" Not Found"); dout.writeUTF("N");
        }
        ss.close();
        
    }
} 

// /home/ssmj/Programming/java programming/webtech/Theory/mk.md
// /home/ssmj/Programming/java programming/computerNetworks/lab7/trial.md