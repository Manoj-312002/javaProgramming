package com.advdb;

import java.util.Scanner;

public class stock {
    public static void main(String[] args) {
        connect c = new connect();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter item and supplier");
        String item = sc.nextLine();
        String suppr = sc.nextLine();
        c.addItem(c.getiid(item), c.getsid(suppr) );
        sc.close();
    }
}
