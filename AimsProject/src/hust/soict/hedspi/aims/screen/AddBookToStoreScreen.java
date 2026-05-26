package hust.soict.hedspi.aims.screen;

import hust.soict.hedspi.aims.store.Store;
import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.media.Book;

import javax.swing.*;

public class AddBookToStoreScreen extends AddMediaToStoreScreen {
    private JTextField tfId;
    private JTextField tfTitle;
    private JTextField tfCategory;
    private JTextField tfCost;
    private JTextField tfAuthors;

    public AddBookToStoreScreen(Store store, Cart cart) {
        super(store, cart, "Add Book to Store");

        tfId = new JTextField();
        tfTitle = new JTextField();
        tfCategory = new JTextField();
        tfCost = new JTextField();
        tfAuthors = new JTextField();

        addFormField("ID:", tfId, 0);
        addFormField("Title:", tfTitle, 1);
        addFormField("Category:", tfCategory, 2);
        addFormField("Cost ($):", tfCost, 3);
        addFormField("Authors (comma-separated):", tfAuthors, 4);
    }

    @Override
    protected boolean handleAdd() throws Exception {
        String idStr = tfId.getText().trim();
        String title = tfTitle.getText().trim();
        String category = tfCategory.getText().trim();
        String costStr = tfCost.getText().trim();
        String authorsStr = tfAuthors.getText().trim();

        if (idStr.isEmpty() || title.isEmpty() || costStr.isEmpty()) {
            throw new Exception("ID, Title, and Cost are required fields.");
        }

        int id = Integer.parseInt(idStr);
        float cost = Float.parseFloat(costStr);

        Book book = new Book(id, title, category, cost);
        if (!authorsStr.isEmpty()) {
            String[] authors = authorsStr.split(",");
            for (String author : authors) {
                if (!author.trim().isEmpty()) {
                    book.addAuthor(author.trim());
                }
            }
        }

        store.addMedia(book);
        return true;
    }
}
