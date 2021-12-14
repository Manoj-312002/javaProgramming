package com.advdb;
import com.orientechnologies.orient.core.db.ODatabaseSession;
import com.orientechnologies.orient.core.db.OrientDB;
import com.orientechnologies.orient.core.db.OrientDBConfig;
import com.orientechnologies.orient.core.sql.executor.OResult;
import com.orientechnologies.orient.core.sql.executor.OResultSet;


public class connect {
    ODatabaseSession db;
    OrientDB orient;
    connect(){
        orient = new OrientDB("remote:192.168.1.201", OrientDBConfig.defaultConfig());
        db = orient.open("online_shop", "root", "dbpass");
    }

    void addPerson( String name , String city , String email , String addr ){
        db.query( "create vertex person set name=" + name + " , email="+ email + " , address="+ addr + " , add="+";" ); 
    }

    void purchase( String p , String i , int qty ){
        db.command( "create edge has_ordered from "+ p + " TO " + i +  " set qty="+  qty +" , time=DATE();" ); 
        this.redqty(qty, i);
    }

    String getpid(String p ){
        OResultSet rs = db.query("select @RID from person where name='" + p + "';" ); 
        while(rs.hasNext()){ 
            OResult item = rs.next(); 
            return ""+ item.getProperty("@RID");
        }
        rs.close();
        return "null";
    }

    String getiid(String i ){
        OResultSet rs = db.query("select @RID from item where name='" + i + "';" ); 
        while(rs.hasNext()){ 
            OResult item = rs.next(); 
            return ""+ item.getProperty("@RID");
        }
        rs.close();
        return "null";
    }

    String getsid(String s ){
        OResultSet rs = db.query("select @RID from supplier where city='" + s + "';" ); 
        while(rs.hasNext()){ 
            OResult item = rs.next(); 
            return ""+ item.getProperty("@RID");
        }
        rs.close();
        return "null";
    }

    void redqty(int qty , String i){
        db.command( "update item set tot_qty=tot_qty - "+qty+ " where name="+i ); 
    }    

    void addItem(String item , String sup ){
        db.command( "create edge supplied_by from "+ item + " TO " + sup +  ";" ); 
    }

    void delteUser(String name){
        db.command( "delete vertex person where name = "+name+";" ); 
    }
}
