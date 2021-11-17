package com.it.computerNetwork;

import java.io.Console;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class smtpMsg{
    public static void main(String[] args) throws Exception{
        Console cs = System.console();
        
        String to = cs.readLine("To : ");
        String from = cs.readLine("From : ");
        
        String host = "smtp.gmail.com";
        Properties properties = System.getProperties();

        // Setup mail server
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", "465");
        properties.put("mail.smtp.ssl.enable", "true");
        properties.put("mail.smtp.auth", "true");

        Session session = Session.getInstance(properties, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                String pass = new String( cs.readPassword("Password : ") );
                return new PasswordAuthentication( from , pass );
            }

        });

        // session.setDebug(true);

        MimeMessage message = new MimeMessage(session);
        message.setFrom(new InternetAddress(from));
        message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

        String sub = cs.readLine("Subject : "); message.setSubject(sub);
        String msg = cs.readLine("Message : "); message.setText(msg);

        System.out.println("Sending");
        Transport.send(message);
        System.out.println("Message sent");

    }

}