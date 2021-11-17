package webtech.lab6;

class sum  extends Thread{
    public int a , b;
    public int ans = 0;
    sum(int a, int b){
        this.a = a; 
        this.b = b;
    }
    public void run(){
        System.out.println("sum from " + a + " to " + b );
        for(int i = a; i < b; i++ ){ ans += i; } 
        
    }
}

public class threads1 {
    public static void main(String[] args) throws Exception{
        sum t1 = new sum(1, 1000);
        sum t2 = new sum(1000, 2000);

        t2.setPriority(10);
        t1.setPriority(1);

        t2.start();
        t1.start();

        t1.join();
        t2.join();

        System.out.println( t1.ans * t2.ans);
    }
}
