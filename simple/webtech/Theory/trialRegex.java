package webtech.Theory;
// import java.io.File;
// import java.io.FileOutputStream;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

interface a {
    int b = 3;
    void run(); 
}

abstract class b{
    public abstract void t();
}

class c extends b{
    c(){
        // b x = new b();
    }
    // void print(){
    //     b x = new b();
    // }
    public void t(){
        System.out.println("hi");
    }
}

// class c extends b{

// }

public class trialRegex {
    public static void main( String[] args ) throws Exception{
        
        // b x = new b();
        // File f = new File("sdf");
        // FileOutputStream fs = new FileOutputStream(f);

        Pattern p = Pattern.compile("[abc]+");
        Matcher c = p.matcher("aaaaaadfadsfccd");
        while( c.find() ){
            System.out.println(c.start() + " " + c.end() + " " +  c.group() );
        }
        
        System.out.println( Pattern.matches("[abc]", "ab") );   // false
        System.out.println( Pattern.matches("[abc]", "a") );    // true
        System.out.println( Pattern.matches("[abc]*", "aadsf") );    // false
        System.out.println( Pattern.matches("[abc]*", "aabc") );    // false
        System.out.println( Pattern.matches("[abc]?", "aabc") );    // false
        System.out.println( Pattern.matches("[abc]?", "aabc") );    // false
        System.out.println( Pattern.matches("^(?=.*[A-Za-z])(?=.*\\d).*", "aabc2") );   // true
        
    }    
}
