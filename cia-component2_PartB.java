import java.util.Scanner;

// Class to represent a Book
class Book {
    public int bookId;
    public String title, author;

    // Method to set book details
    void setBookDetails(int bookId, String title, String author) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
    }

    // Method to get book details
    void getBookDetails() {
        System.out.println("Book ID: " + bookId);
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
    }
}

// Specialized class for ReferenceBook
class ReferenceBook extends Book {
    public int edition;

    // Method to display detailed book information for ReferenceBook
    void displayDetails() {
        getBookDetails();
        System.out.println("Edition: " + edition);
    }
}

// Specialized class for FictionBook
class FictionBook extends Book {
    public String genre;

    // Method to display detailed book information for FictionBook
    void displayDetails() {
        getBookDetails();
        System.out.println("Genre: " + genre);
    }
}
class Periodical extends ReferenceBook {
    String issueFrequency;
    void displayDetails() {
        super.displayDetails();
        System.out.println("Issue Frequency: " + issueFrequency);
    }
}
