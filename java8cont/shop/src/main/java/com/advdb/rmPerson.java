package com.advdb;

import java.util.Scanner;

public class rmPerson {
    public static void main(String[] args) {
        connect c = new connect();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Person name");
        String uname = sc.nextLine();
        c.delteUser(uname);
        sc.close();
    }
}
