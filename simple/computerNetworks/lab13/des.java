package computerNetworks.lab13;

import java.io.*;  
import java.security.spec.AlgorithmParameterSpec;  
import javax.crypto.*;
import javax.crypto.spec.IvParameterSpec;

public class des{  
    //creating an instance of the Cipher class for encryption  
    private static Cipher encrypt;  
    //creating an instance of the Cipher class for decryption  
    private static Cipher decrypt;  
    //initializing vector  
    private static final byte[] initialization_vector = { 22, 33, 11, 44, 55, 99, 66, 77 };  
    
    public static void main(String[] args) throws Exception {  

        //path of the file that we want to encrypt  
        String textFile = "C:/Users/Anubhav/Desktop/DemoData.txt";  
        //path of the encrypted file that we get as output  
        String encryptedData = "C:/Users/Anubhav/Desktop/encrypteddata.txt";  
        //path of the decrypted file that we get as output  
        String decryptedData = "C:/Users/Anubhav/Desktop/decrypteddata.txt";  
        SecretKey scrtkey = KeyGenerator.getInstance("DES").generateKey();  
        AlgorithmParameterSpec aps = new IvParameterSpec(initialization_vector);  
        //setting encryption mode  
        encrypt = Cipher.getInstance("DES/CBC/PKCS5Padding");  
        encrypt.init(Cipher.ENCRYPT_MODE, scrtkey, aps);  
        //setting decryption mode  
        decrypt = Cipher.getInstance("DES/CBC/PKCS5Padding");  
        decrypt.init(Cipher.DECRYPT_MODE, scrtkey, aps);  
        //calling encrypt() method to encrypt the file  
        encryption(new FileInputStream(textFile), new FileOutputStream(encryptedData));  
        //calling decrypt() method to decrypt the file  
        decryption(new FileInputStream(encryptedData), new FileOutputStream(decryptedData));  
        //prints the stetment if the program runs successfully  
        System.out.println("The encrypted and decrypted files have been created successfully.");  
    }  


    //method for encryption  
    private static void encryption(InputStream input, OutputStream output) throws IOException {  
        output = new CipherOutputStream(output, encrypt);  
        //calling the writeBytes() method to write the encrypted bytes to the file   
        writeBytes(input, output);  
    }   
    //method for decryption  
    private static void decryption(InputStream input, OutputStream output) throws IOException {  
        input = new CipherInputStream(input, decrypt);  
        //calling the writeBytes() method to write the decrypted bytes to the file    
        writeBytes(input, output);  
    }  


    //method for writting bytes to the files   
    private static void writeBytes(InputStream input, OutputStream output) throws IOException {  
        byte[] writeBuffer = new byte[512];  
        int readBytes = 0;  
        while ((readBytes = input.read(writeBuffer)) >= 0) output.write(writeBuffer, 0, readBytes);    
        //closing the output stream  
        output.close();  
        //closing the input stream  
        input.close();  
    }   
}  