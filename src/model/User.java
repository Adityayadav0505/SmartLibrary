package model;

import services.Borrowable;
import java.util.*;

public class User implements Borrowable {
    private String userId;
    private String name;
    private List<String> borrowedBooks = new ArrayList<>();

    public User(String userId, String name){
        this.userId = userId;
        this.name = name;
    }

    @Override
    public void borrowBook(String bookId){
        borrowedBooks.add(bookId);
    }

    @Override
    public void returnBook(String bookId){
        borrowedBooks.remove(bookId);
    }

    public List<String> getBorrowedBooks(){
        return borrowedBooks;
    }

    public String getUserId(){
        return userId;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId='" + userId + '\'' +
                ", name='" + name + '\'' +
                ", borrowedBooks=" + borrowedBooks +
                '}';
    }
}
