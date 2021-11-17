package webtech.Theory;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class trialFile {
    public static void main(String[] args) throws Exception{
        File f = new File( "/media/ssmj/File/Programming/java programming/simple/webtech/Theory/trial.txt" );
        PrintWriter pw = new PrintWriter( f );
        pw.println("Hello From vs code");
        pw.flush(); pw.close();

        FileOutputStream fos = new FileOutputStream(f);
        fos.write( "Manoj".getBytes() );
        fos.close();

        Scanner sc = new Scanner(f);
        System.out.println(sc.nextLine());
        sc.close();

        FileInputStream fis = new FileInputStream(f);
        String s = new String(fis.readAllBytes());
        System.out.println(s);
        fis.close();


    }    
}
