package webtech.lab4;

class user{
    String name;
    int loginCount;
    user( String name ){
        this.name = name;
        loginCount = 0;
    }
    void log(){ loginCount++ ; }
}
    
public class passByReference {
    static void  printCount( user us ){
        System.out.println("From referenced object ");
        System.out.println(us.loginCount);
    }
    public static void main(String[] args) {
        user us = new user("Abc");
        us.log();
        printCount(us);
    }
}
