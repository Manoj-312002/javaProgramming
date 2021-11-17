package webtech.Theory;
import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;
import java.util.regex.*;


public class regex {
    public static void main(String[] args) throws Exception{
        
        String [] pts = { "^#{4}(.*)"  ,"^#{3}(.*)"  , "^#{2}(.*)"  , "^#{1}(.*)"  ,  "\\[(.*)\\]\\('(.*)'\\)"   , "\\.\\.\\.", "^ - (.*)"     , "[\\n](.*)[\\n]"};
        String [] rpl = { "<h4>$1</h4>","<h3>$1</h3>", "<h2>$1</h2>", "<h1>$1</h1>",  "<a href=\"$2\"> $1 </a> " , "<hr>"     , "<li> $1 </li>", "\n<p> $1 </p>\n"};

        File f = new File("/media/ssmj/Files/Programming/java programming/webtech/Theory/mk.md");
        Scanner sc = new Scanner(f);
        
        sc.useDelimiter("\\Z");
        String string = sc.next();


        for( int i = 0 ; i < pts.length ; i++  ){
            Pattern pattern = Pattern.compile( pts[i] , Pattern.MULTILINE);
            Matcher matcher = pattern.matcher(string);
            string = matcher.replaceAll( rpl[i] );
        }
 
        string = "<html> \n" + string  + "\n</html>";
        
        FileWriter fw = new FileWriter("/media/ssmj/Files/Programming/java programming/webtech/Theory/ans.html");
        fw.write(string);
        
        fw.close();sc.close();
    }
}