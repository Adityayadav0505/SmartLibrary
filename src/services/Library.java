package services;

import model.Book;
import model.User;
import java.util.*;

public class Library {
    private Map<String, Book> books = new HashMap<>();
    private Map<String, User> users = new HashMap<>();

    public void addBook(Book book){
        books.put(book.getId(), book);
    }

    public void registerUser(User user) {
        users.put(user.getUserId(), user);
    }

    public void borrowBook(String userId, String bookId){
        User user = users.get(userId);
        Book book = books.get(bookId);

        if (user == null || book == null) {
            System.out.println("User or Book not found.");
            return;
        }

        if (book.isBorrowed()) {
            System.out.println("Book is already borrowed.");
            return;
        }

        book.borrow();
        user.borrowBook(bookId);
        System.out.println(user.getUserId() + " borrowed: " + book);
    }

    public void returnBook(String userId, String bookId){
        User user = users.get(userId);
        Book book = books.get(bookId);

        if (user != null && book != null && book.isBorrowed()) {
            book.returnBook();
            user.returnBook(bookId);
            System.out.println(user.getUserId() + " returned: " + book);
        } else {
            System.out.println("Return failed. Either user/book not found or book wasn't borrowed.");
        }
    }

    public void showAllBooks() {
        for (Book book : books.values()) {
            System.out.println(book);
        }
    }

    public void showUserBooks(String userId) {
        User user = users.get(userId);
        if (user != null) {
            System.out.println("Books borrowed by " + user.getUserId() + ":");
            for (String bookId : user.getBorrowedBooks()) {
                System.out.println(books.get(bookId));
            }
        } else {
            System.out.println("User not found.");
        }
    }
}
