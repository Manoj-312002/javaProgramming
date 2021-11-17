package webtech.Theory;

import java.io.*;

class ser implements Serializable{
    public int a;
    public String b;
    public ser(int a, String b){
        this.a = a;
        this.b = b;
    }
  
}
  
public class serialiable {
    public static void main(String[] args) throws Exception{
        ser obj = new ser(1,"a");
        String fname = "/media/ssmj/File/Programming/java programming/simple/webtech/Theory/trialSerial.txt";
        ObjectOutputStream out = new ObjectOutputStream( new FileOutputStream(fname));
        out.writeObject(obj);
        out.close();

        ObjectInputStream oin = new ObjectInputStream(new FileInputStream(fname));
        ser obj2 = (ser)oin.readObject();
        oin.close();

        System.out.println( obj2.a + " " + obj2.b );
    }  
}
