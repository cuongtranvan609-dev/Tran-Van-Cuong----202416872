package hust.soict.hedspi.aims.cart;

import hust.soict.hedspi.aims.media.Media;

import java.util.ArrayList;
import java.util.Collections;

public class Cart {
    public static final int MAX_NUMBERS_ORDERED = 20;

    private ArrayList<Media> itemsOrdered = new ArrayList<Media>();

    // ================= ADD =================
    public void addMedia(Media media) {
        if (itemsOrdered.size() >= MAX_NUMBERS_ORDERED) {
            System.out.println("The cart is full");
            return;
        }
        if (itemsOrdered.contains(media)) {
            System.out.println("The media is already in the cart");
        } else {
            itemsOrdered.add(media);
            System.out.println("The media has been added");
        }
    }

    // ================= REMOVE =================
    public void removeMedia(Media media) {
        if (itemsOrdered.contains(media)) {
            itemsOrdered.remove(media);
            System.out.println("The media has been removed");
        } else {
            System.out.println("The media was not found");
        }
    }

    // ================= TOTAL COST =================
    public double totalCost() {
        double sum = 0;
        for (Media m : itemsOrdered) {
            sum += m.getCost();
        }
        return sum;
    }

    // ================= SEARCH =================
    public Media searchById(int id) {
        for (Media m : itemsOrdered) {
            if (m.getId() == id) {
                System.out.println("Found: " + m.toString());
                return m;
            }
        }
        System.out.println("No matching media found");
        return null;
    }

    public Media searchByTitle(String title) {
        for (Media m : itemsOrdered) {
            if (m.getTitle().equalsIgnoreCase(title)) {
                System.out.println("Found: " + m.toString());
                return m;
            }
        }
        System.out.println("No matching media found");
        return null;
    }

    // ================= SORT =================
    public void sortByTitleCost() {
        Collections.sort(itemsOrdered, Media.COMPARE_BY_TITLE_COST);
        System.out.println("Cart sorted by title then cost");
    }

    public void sortByCostTitle() {
        Collections.sort(itemsOrdered, Media.COMPARE_BY_COST_TITLE);
        System.out.println("Cart sorted by cost then title");
    }

    // ================= PRINT =================
    public void print() {
        System.out.println("***************CART***************");
        for (int i = 0; i < itemsOrdered.size(); i++) {
            System.out.println((i + 1) + ". " + itemsOrdered.get(i).toString());
        }
        System.out.println("Total cost: " + totalCost());
        System.out.println("**********************************");
    }

    // ================= MISC =================
    public void clear() {
        itemsOrdered.clear();
    }

    public ArrayList<Media> getItemsOrdered() {
        return itemsOrdered;
    }
}