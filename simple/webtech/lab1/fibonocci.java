package webtech.lab1;

public class fibonocci{
    public static void main(String[] args) {
        int a = 0 ,b = 1;
        for(int i = 0; i < 10; i++){
            System.out.println(a);
            int t = b;
            b = a+b;
            a = t;
        }

    }
}
