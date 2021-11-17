package webtech.lab1;

public class divs {
    public static void main(String[] args) {
        int ans = 0;
        for(int i = 100 ; i < 200 ;i++ ){
            if( i%4 == 0 ) ans += i;
        }
        System.out.println(ans);
    }
}
