package computerNetworks.lab8;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class dnsClient {
    private static final String dnsServer = "8.8.8.8";
    private static final int dnsPort = 53;

    public static void main(String[] args) throws IOException {
        System.out.println("Enter domain name : ");
        Scanner sc = new Scanner(System.in);
        String domain = sc.nextLine();
        InetAddress ipAddress = InetAddress.getByName(dnsServer);

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        DataOutputStream dos = new DataOutputStream(baos);

        // building dns
        // Identifier - to keep track of message
        dos.writeShort(0x1234);
        // Write Query Flags
        dos.writeShort(0x0100);
        // Question Count
        dos.writeShort(0x0001);
        // Answer Record Count
        dos.writeShort(0x0000);
        // Authority Record Count: Specifies the number of resource records in the Authority section of 
        dos.writeShort(0x0000);
        // Additional Record Count
        dos.writeShort(0x0000);


        String[] domainParts = domain.split("\\.");

        // writing individual domain parts
        for (int i = 0; i < domainParts.length; i++) {
            byte[] domainBytes = domainParts[i].getBytes("UTF-8");
            dos.writeByte(domainBytes.length);
            dos.write(domainBytes);
        }
        // No more parts
        dos.writeByte(0x00);
        // Type 0x01 = A (Host Request)
        dos.writeShort(0x0001);
        // Class 0x01 = IN
        dos.writeShort(0x0001);

        byte[] dnsFrame = baos.toByteArray();

        // request
        DatagramSocket socket = new DatagramSocket();
        DatagramPacket dnsReqPacket = new DatagramPacket(dnsFrame, dnsFrame.length, ipAddress, dnsPort);
        socket.send(dnsReqPacket);

        // response
        byte[] buf = new byte[1024];
        DatagramPacket packet = new DatagramPacket(buf, buf.length);
        socket.receive(packet);


        DataInputStream din = new DataInputStream(new ByteArrayInputStream(buf));
        System.out.println("Transaction ID: 0x" + String.format("%x", din.readShort()));
        System.out.println("Flags: 0x" + String.format("%x", din.readShort()));
        System.out.println("Questions: " + String.format("%d", din.readShort()));
        System.out.println("Answers RRs: " + String.format("%d", din.readShort()));
        System.out.println("Authority RRs: " + String.format("%d", din.readShort()));
        System.out.println("Additional RRs: " + String.format("%d", din.readShort()));

        int recLen = 0;
        String qs = "";
        while ((recLen = din.readByte()) > 0) {
            byte[] record = new byte[recLen];

            for (int i = 0; i < recLen; i++) {
                record[i] = din.readByte();
            }
            qs += new String( record , "utf-8" ) + ".";
        }

        System.out.println("Input query: " + qs );
        System.out.println("Record Type: " + String.format("%d", din.readShort()));
        System.out.println("Class: " + String.format("%d", din.readShort()));
        
        din.readShort();
        System.out.println("Type: " + String.format("%d", din.readShort()));
        System.out.println("Class: " + String.format("%d", din.readShort()));
        System.out.println("TTL: " + String.format("%d", din.readInt()));
        
        short addrLen = din.readShort();
        System.out.println("Len: " + String.format("%d", addrLen));

        System.out.print("Address: ");
        for (int i = 0; i < addrLen; i++ ) {
            System.out.print("" + String.format("%d", (din.readByte() & 0xFF)) + ".");
        }

        socket.close();
        sc.close();
    }
}