package hust.soict.hedspi.aims.screen;

import hust.soict.hedspi.aims.store.Store;
import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.media.CompactDisc;
import hust.soict.hedspi.aims.media.Track;

import javax.swing.*;

public class AddCDToStoreScreen extends AddMediaToStoreScreen {
    private JTextField tfId;
    private JTextField tfTitle;
    private JTextField tfCategory;
    private JTextField tfCost;
    private JTextField tfDirector;
    private JTextField tfArtist;
    private JTextField tfTracks;

    public AddCDToStoreScreen(Store store, Cart cart) {
        super(store, cart, "Add CD to Store");

        tfId = new JTextField();
        tfTitle = new JTextField();
        tfCategory = new JTextField();
        tfCost = new JTextField();
        tfDirector = new JTextField();
        tfArtist = new JTextField();
        tfTracks = new JTextField();

        addFormField("ID:", tfId, 0);
        addFormField("Title:", tfTitle, 1);
        addFormField("Category:", tfCategory, 2);
        addFormField("Cost ($):", tfCost, 3);
        addFormField("Director:", tfDirector, 4);
        addFormField("Artist:", tfArtist, 5);
        addFormField("Tracks (Format: Name:Length, ...):", tfTracks, 6);
    }

    @Override
    protected boolean handleAdd() throws Exception {
        String idStr = tfId.getText().trim();
        String title = tfTitle.getText().trim();
        String category = tfCategory.getText().trim();
        String costStr = tfCost.getText().trim();
        String director = tfDirector.getText().trim();
        String artist = tfArtist.getText().trim();
        String tracksStr = tfTracks.getText().trim();

        if (idStr.isEmpty() || title.isEmpty() || costStr.isEmpty()) {
            throw new Exception("ID, Title, and Cost are required fields.");
        }

        int id = Integer.parseInt(idStr);
        float cost = Float.parseFloat(costStr);

        CompactDisc cd = new CompactDisc(id, title, category, cost, director, artist);

        if (!tracksStr.isEmpty()) {
            String[] trackItems = tracksStr.split(",");
            for (String item : trackItems) {
                String[] parts = item.split(":");
                if (parts.length == 2) {
                    String trackTitle = parts[0].trim();
                    int trackLength = Integer.parseInt(parts[1].trim());
                    if (!trackTitle.isEmpty()) {
                        cd.addTrack(new Track(trackTitle, trackLength));
                    }
                } else {
                    throw new Exception("Invalid track format. Use: TrackName:Length, AnotherTrack:Length");
                }
            }
        }

        store.addMedia(cd);
        return true;
    }
}
