package webtech.lab6;
import java.net.*;
import java.util.ArrayList;

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
        System.out.println(this.getName() + " " + conn.getResponseCode());
        conn.getInputStream();
    }

    public void run(){
        try { attack(); } 
        catch (Exception e) { }
    }
}

public class thread2{
    public static void main(String[] args) throws Exception {
        ArrayList<ddos> t1s = new ArrayList<>() , t2s = new ArrayList<>();

        for(int i = 0; i < 100 ; i++ ){
            ddos t1 = new ddos("http://localhost:8000");
            ddos t2 = new ddos("http://localhost:8001");
            
            t1.start();
            t2.start();

            t1.setPriority(10);
            t1s.add(t1); t2s.add(t2);
        }

        System.out.println("Number of active threads : " + Thread.activeCount() );
        for( int i = 0; i < t1s.size() ; i++ ) t1s.get(i).join();
        System.out.println("localhost 8000 finished");
        
        
        
        System.out.println("Making the last thread wait");
        Thread.sleep(100);

        for( int i = 0; i < t1s.size() ; i++ ) t1s.get(i).interrupt();
    }
}
