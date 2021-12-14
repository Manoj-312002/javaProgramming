package com.advdb;

import java.util.Scanner;

public class buy {
    public static void main(String[] args) {
        connect c = new connect();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter username , item number and quatity");
        String uname = sc.nextLine();
        String item = sc.nextLine();
        int qty = sc.nextInt();
        c.purchase(c.getpid(uname), c.getiid(item) , qty);
        sc.close();
    }
}
