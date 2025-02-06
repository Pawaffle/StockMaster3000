package org.example;

import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<String> books;

    public Library() {
        books = new ArrayList<String>();
    }

    public void addBook(String book) {
        if (!book.isEmpty()) {
            books.add(book);
        }
    }

    public void removeBook(String book) {
        books.remove(book);
    }

    public List<String> getBooks() {
        return books;
    }
}
