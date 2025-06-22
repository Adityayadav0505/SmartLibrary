package app;

import model.Book;
import model.User;
import services.Library;
import java.util.Scanner;

public class LibraryApp {
    public static void main(String[] args){
        Library lib = new Library();
        Scanner sc = new Scanner(System.in);

        // Sample data
        lib.addBook(new Book("B1", "1984", "George Orwell"));
        lib.addBook(new Book("B2", "The Alchemist", "Paulo Coelho"));
        lib.registerUser(new User("U1", "Alice"));
        lib.registerUser(new User("U2", "Bob"));

        while (true) {
            System.out.println("\n=== Library Menu ===");
            System.out.println("1. Show all books");
            System.out.println("2. Borrow book");
            System.out.println("3. Return book");
            System.out.println("4. Show user's books");
            System.out.println("0. Exit");
            System.out.print("Choose: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    lib.showAllBooks();
                    break;
                case 2:
                    System.out.print("Enter user ID: ");
                    String userId = sc.nextLine();
                    System.out.print("Enter book ID: ");
                    String bookId = sc.nextLine();
                    lib.borrowBook(userId, bookId);
                    break;
                case 3:
                    System.out.print("Enter user ID: ");
                    userId = sc.nextLine();
                    System.out.print("Enter book ID: ");
                    bookId = sc.nextLine();
                    lib.returnBook(userId, bookId);
                    break;
                case 4:
                    System.out.print("Enter user ID: ");
                    userId = sc.nextLine();
                    lib.showUserBooks(userId);
                    break;
                case 0:
                    System.out.println("Goodbye!");
                    return;
            }
        }
    }
}
