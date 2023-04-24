package language;

import java.util.*;

abstract class Book {
    String title;
    String author;

    Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    abstract void display();
}

class MyBook extends Book {
    private final int price;

    public MyBook(String title, String author, int price) {
        super(title, author);
        this.price = price;
    }

    @Override
    void display() {
        System.out.printf("Title: %s\n", title);
        System.out.printf("Author: %s\n", author);
        System.out.printf("Price: %d\n", price);
    }
}
/**
 *   Method Name: display
 *
 *   Print the title, author, and price in the specified format.
 **/
// Write your method here

// End class

public class AbstractClass {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String title = scanner.nextLine();
        String author = scanner.nextLine();
        int price = scanner.nextInt();
        scanner.close();

        Book book = new MyBook(title, author, price);
        book.display();
    }
}