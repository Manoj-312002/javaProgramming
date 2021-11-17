package com.it.computerNetwork;

import org.xbill.DNS.*;

public class dnsServer {
    public static void main(String[] args) throws Exception{
        Name name = Name.fromString("google.com");
        Lookup lk = new Lookup(name);

        lk.run();

        System.out.println( lk.getAnswers()  );

    }
}
