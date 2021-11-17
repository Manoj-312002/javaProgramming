package com.it.computerNetwork;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMultipart;
import javax.mail.search.FlagTerm;

import java.io.Console;
import java.util.*;


public class popMsg {
    public static void main(String[] args) throws Exception {
        Properties props = new Properties();
        props.put("mail.store.protocol", "pop3s"); // Google uses POP3S not POP3
        String host = "pop.gmail.com";
        
        Console cs = System.console();
        String username = cs.readLine("Mail : ");
        String password = new String( cs.readPassword("Password : ") );
        // String provider = "pop3s";
    
        // Connect to the POP3 server

        Session session = Session.getDefaultInstance(props ); 
        Store store = session.getStore();
        store.connect(host, username, password);
        

        // Open the folder
        Folder inbox = store.getDefaultFolder().getFolder("INBOX");

        if (inbox == null) {
            System.out.println("No INBOX");
            System.exit(1);
        }

        inbox.open(Folder.READ_ONLY);
        // Get the messages from the server 
        Message[] messages = inbox.search( new FlagTerm(new Flags(Flags.Flag.SEEN), true));
        Arrays.sort( messages, ( m1, m2 ) -> {
            try { return m2.getSentDate().compareTo( m1.getSentDate() ); } 
            catch ( MessagingException e ) { throw new RuntimeException( e ); }
        });
        
        for ( Message message : messages ){
            String from = ((InternetAddress) message.getFrom()[0] ).getAddress();
            String content = "";
            if( message.getContent() instanceof MimeMultipart ) {
                MimeMultipart cnt = (MimeMultipart) message.getContent();
                int ct = cnt.getCount();
                for( int i = 0; i< ct ; i++ ){
                    BodyPart bp = cnt.getBodyPart(i);
                    content += (String) bp.getContent();
                }
            }else{ content = (String)message.getContent() ; }
            
            System.out.println("\nFrom : " + from + "\n" + "Subject : " + message.getSubject() + "\n\n" + content +"\n\n"  );
        }
        inbox.close(true);
        store.close();
    }
}