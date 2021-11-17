package computerNetworks.lab8;

import java.io.*; import java.net.*; 
class udpClient{
    public static void main(String args[]) throws Exception{
        try{
            DatagramSocket client=new DatagramSocket(); 
            InetAddress addr =InetAddress.getByName("127.0.0.1"); 
            byte[]sendbyte=new byte[1024];
            byte[]receivebyte=new byte[1024];

            BufferedReader in = new BufferedReader(new InputStreamReader(System.in)); System.out.println("Enter DOMAIN NAME OR IP address");
            String str=in.readLine(); 
            sendbyte=str.getBytes(); 
            DatagramPacket sender=new DatagramPacket(sendbyte,sendbyte.length,addr,1309); 
            client.send(sender);
            DatagramPacket receiver= new DatagramPacket(receivebyte,receivebyte.length); 
            client.receive(receiver);
            
            String s=new String(receiver.getData());
            System.out.println("IP adddress or DOMAIN NAME :"+s.trim()); 
            client.close();

        }catch(Exception e){
            System.out.println(e);
        }
        
        InetAddress dnsresult[] = InetAddress.getAllByName("google.com");
            for (int i=0; i<dnsresult.length; i++)
            System.out.println (dnsresult[i]);
    }
}
