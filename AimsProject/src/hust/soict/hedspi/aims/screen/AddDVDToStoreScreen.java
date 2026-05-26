package hust.soict.hedspi.aims.screen;

import hust.soict.hedspi.aims.store.Store;
import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;

import javax.swing.*;

public class AddDVDToStoreScreen extends AddMediaToStoreScreen {
    private JTextField tfId;
    private JTextField tfTitle;
    private JTextField tfCategory;
    private JTextField tfCost;
    private JTextField tfDirector;
    private JTextField tfLength;

    public AddDVDToStoreScreen(Store store, Cart cart) {
        super(store, cart, "Add DVD to Store");

        tfId = new JTextField();
        tfTitle = new JTextField();
        tfCategory = new JTextField();
        tfCost = new JTextField();
        tfDirector = new JTextField();
        tfLength = new JTextField();

        addFormField("ID:", tfId, 0);
        addFormField("Title:", tfTitle, 1);
        addFormField("Category:", tfCategory, 2);
        addFormField("Cost ($):", tfCost, 3);
        addFormField("Director:", tfDirector, 4);
        addFormField("Length (mins):", tfLength, 5);
    }

    @Override
    protected boolean handleAdd() throws Exception {
        String idStr = tfId.getText().trim();
        String title = tfTitle.getText().trim();
        String category = tfCategory.getText().trim();
        String costStr = tfCost.getText().trim();
        String director = tfDirector.getText().trim();
        String lengthStr = tfLength.getText().trim();

        if (idStr.isEmpty() || title.isEmpty() || costStr.isEmpty()) {
            throw new Exception("ID, Title, and Cost are required fields.");
        }

        int id = Integer.parseInt(idStr);
        float cost = Float.parseFloat(costStr);
        int length = 0;
        if (!lengthStr.isEmpty()) {
            length = Integer.parseInt(lengthStr);
        }

        DigitalVideoDisc dvd = new DigitalVideoDisc(id, title, category, cost, length, director);
        store.addMedia(dvd);
        return true;
    }
}
