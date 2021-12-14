package com.it.swing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class user {
    public Map<String , ArrayList<String> > userDetails;

    public user() {
        this.userDetails = new HashMap<>();
    }
    
    public void addItem( String user , String cont ){
        ArrayList<String> s;
        if( userDetails.containsKey(user) ){
            s = userDetails.get(user);
            s.add( cont );
        }else{
            s = new ArrayList<String>();
            s.add(cont);
            userDetails.put(user, s);
        }
        System.out.println( userDetails.toString() );
    }
    
    public ArrayList<String> getDetails( String user ){
        return userDetails.get(user);
    }
}
