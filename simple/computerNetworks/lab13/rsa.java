package computerNetworks.lab13;

import java.math.BigDecimal;
import java.math.BigInteger;

public class rsa {
    static int gcd(int e, int z){
        if (e == 0) return z;
        else return gcd(z % e, e);
    }
    
    public static void main(String[] args) {
        int p, q, n, z, d = 0, e, i;
        int msg = 12; double c;
        BigInteger msgback;
        
        // prime numbers ( 3 x 11 = 33 )
        p = 3; q = 11;
        n = p * q;
        
        // taking it on 20 hour clock
        z = (p - 1) * (q - 1);
        System.out.println("the value of z = " + z);
 
        for (e = 2; e < z; e++) {
            // e is for public key exponent
            if (gcd(e, z) == 1) break;
        }

        System.out.println("the value of e = " + e);

        // d should be found from 20 hour clock
        // e x d should be 1 on 20 hour clock
        for (i = 0; i <= 9; i++) {
            int x = 1 + (i * z);
            // d is for private key exponent
            if (x % e == 0) {
                d = x / e;
                break;
            }
        }

        // on applying little fermats on both 2 ( 3-1 ) and 10 ( 11 -1  )
        // so if m raised to e ( which will be done by client side )
        // e is first transferred to client by server 
        // the raised by e msg is sent back to server
        // server then raises to power d to get the decrypted data

        System.out.println("the value of d = " + d);
        c = (Math.pow(msg, e)) % n;
        System.out.println("Encrypted message is : " + c);
 
        // converting int value of n to BigInteger
        BigInteger N = BigInteger.valueOf(n);
 
        // converting float value of c to BigInteger
        BigInteger C = BigDecimal.valueOf(c).toBigInteger();
        msgback = (C.pow(d)).mod(N);
        System.out.println("Decrypted message is : " + msgback);
    }        
    
}
