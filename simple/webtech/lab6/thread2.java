package webtech.lab6;
import java.net.*;

class ddos extends Thread{
    private final URL url;

    ddos(String req ) throws Exception {
        this.url = new URL(req);
    }

    public void attack() throws Exception{
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setDoOutput(true);
        conn.setDoInput(true);
        conn.setRequestMethod("GET");
        System.out.println(this + " " + conn.getResponseCode());
        conn.getInputStream();
    }

    public void run(){
        try { attack(); } 
        catch (Exception e) { }
    }
}

public class thread2{
    public static void main(String[] args) throws Exception {
        for(int i = 0; i < 100 ; i++ ){
            ddos t = new ddos("http://localhost:8000");
            t.start();
        }
    }
}
