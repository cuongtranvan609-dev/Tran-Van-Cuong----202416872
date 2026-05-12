package hust.soict.hedspi.aims.store;

import hust.soict.hedspi.aims.media.Media;

import java.util.ArrayList;

public class Store {

    private ArrayList<Media> itemsInStore = new ArrayList<Media>();

    // ================= ADD =================
    public void addMedia(Media media) {
        if (itemsInStore.contains(media)) {
            System.out.println("The media is already in the store");
        } else {
            itemsInStore.add(media);
            System.out.println("The media has been added to store");
        }
    }

    // ================= REMOVE =================
    public void removeMedia(Media media) {
        if (itemsInStore.contains(media)) {
            itemsInStore.remove(media);
            System.out.println("The media has been removed from store");
        } else {
            System.out.println("The media was not found in store");
        }
    }

    // ================= SEARCH =================
    public Media searchByTitle(String title) {
        for (Media m : itemsInStore) {
            if (m.getTitle().equalsIgnoreCase(title)) {
                return m;
            }
        }
        return null;
    }

    // ================= PRINT =================
    public void print() {
        System.out.println("*****************STORE*****************");
        for (int i = 0; i < itemsInStore.size(); i++) {
            System.out.println((i + 1) + ". " + itemsInStore.get(i).toString());
        }
        System.out.println("***************************************");
    }

    // ================= MISC =================
    public ArrayList<Media> getItemsInStore() {
        return itemsInStore;
    }
}