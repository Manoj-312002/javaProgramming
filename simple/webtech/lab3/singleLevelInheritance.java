package webtech.lab3;

import java.util.ArrayList;

class library{
    public static ArrayList <Integer>  prices = new ArrayList<Integer>();
    library( int price ){
        prices.add(price);
    } 

    void printList(){
        System.out.println("Prices of all books : \n");
        for( var v : prices ){
            System.out.println( v );
        }
    }
}

class book extends library{
    String name; int price;
    book( String name , int price ){
        super( price );
        this.name = name;
        this.price = price;
    }

    void printBook(){
        System.out.println("Book details : \n\nName : " + this.name + "\nPrice : " + this.price );
    }
}

public class singleLevelInheritance {
    public static void main(String[] args) {
        book[] bks = { new book("Abc" , 100 ) , new book("Xyz" , 1000) , new book("Mno" , 500)  };
        
        bks[0].printBook();
        bks[0].printList();
    }
}
