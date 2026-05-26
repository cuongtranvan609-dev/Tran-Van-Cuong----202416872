package hust.soict.hedspi.aims.media;

import java.util.ArrayList;
import java.util.List;

public class Book extends Media {

    private List<String> authors = new ArrayList<>();

    public Book() {
        super();
    }

    public Book(int id, String title, String category, float cost) {
        super(id, title, category, cost);
    }

    public void addAuthor(String authorName) {
        if (authors.contains(authorName)) {
            System.out.println("Author '" + authorName + "' is already in the book.");
        } else {
            authors.add(authorName);
            System.out.println("Author '" + authorName + "' added.");
        }
    }

    public void removeAuthor(String authorName) {
        if (!authors.contains(authorName)) {
            System.out.println("Author '" + authorName + "' is not in the book.");
        } else {
            authors.remove(authorName);
            System.out.println("Author '" + authorName + "' removed.");
        }
    }

    @Override
    public String toString() {
        return "Book - Title: " + getTitle()
            + " | Category: " + getCategory()
            + " | Authors: " + authors.toString()
            + " | Cost: " + getCost() + "$";
    }
}