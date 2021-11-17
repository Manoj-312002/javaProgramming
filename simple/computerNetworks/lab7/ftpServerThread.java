package computerNetworks.lab7;

import java.net.*; 
import java.io.*; 

public class ftpServerThread {
    public static void main(String[] args) throws Exception {
        ServerSocket ss = null;
        try{
            ss = new ServerSocket(1234);
            ss.setReuseAddress(true);
            
            while (true) {
                Socket client = ss.accept();
                Thread td = new Thread( new ftpHandler(client) );
                td.start();
            }
        }finally{
            ss.close();
        }
    }
}


class ftpHandler implements Runnable{
    private final Socket soc ;
    public ftpHandler( Socket s ){
        this.soc = s;
    }

    public void run() {
        try{
            
            var din = new DataInputStream(soc.getInputStream()); 
            var dout = new DataOutputStream(soc.getOutputStream());
            
            var fname = din.readUTF(); 
            System.out.println("File name :" + fname);

            var recfile = new File(fname);

            if(recfile.exists()){
                
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
        }catch( Exception e ){
            e.printStackTrace();
        }   
        
    }
}