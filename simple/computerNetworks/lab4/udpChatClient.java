package computerNetworks.lab4;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class udpChatClient {
    public static void main(String[] args) throws Exception{
        byte[] sendData = new byte[1024];
        byte[] receiveData = new byte[1024];
        Scanner sc = new Scanner(System.in);
        int port = 9999;
        DatagramSocket ds = new DatagramSocket();
        InetAddress ip = InetAddress.getLocalHost();
        
        while( true ){
            
            System.out.print("client : " );
            String msg = new String( sc.nextLine() );
            
            sendData = msg.getBytes();
            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length , ip , port );
            ds.send(sendPacket);

            receiveData = new byte[1024];
            DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
            ds.receive(receivePacket);

            String str = new String( receivePacket.getData() );
            System.out.println( "server : " + str );

            if( msg.equals("bye") ) break;
        }

        sc.close(); ds.close();

    }
}
