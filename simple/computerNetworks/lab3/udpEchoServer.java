package computerNetworks.lab3;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class udpEchoServer {
    public static void main(String[] args) throws Exception{
        DatagramSocket serverSocket = new DatagramSocket(9999);
        byte[] sendData = new byte[1024];
        byte[] receiveData = new byte[1024];
        
        while( true ){
            receiveData = new byte[1024];
            DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
            serverSocket.receive(receivePacket);

            String msg = new String( receivePacket.getData() );
            if( msg.equals("bye") ) break;

            InetAddress ip = receivePacket.getAddress();
            int port = receivePacket.getPort();

            System.out.println("client : " + msg );
            sendData = msg.getBytes();

            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length , ip , port );
            serverSocket.send(sendPacket);
        }

        serverSocket.close();
    }
}
