package hust.soict.hedspi.aims.test.screen;

import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.media.*;
import hust.soict.hedspi.aims.screen.StoreScreen;
import hust.soict.hedspi.aims.store.Store;

public class ScreenTest {
    public static void main(String[] args) {
        Store store = new Store();
        Cart cart = new Cart();

        // Seed Store Data
        DigitalVideoDisc dvd1 = new DigitalVideoDisc(1, "Inception", "Sci-Fi", 9.99f, 148, "Christopher Nolan");
        DigitalVideoDisc dvd2 = new DigitalVideoDisc(2, "Avatar", "Action", 7.99f, 162, "James Cameron");
        DigitalVideoDisc dvd3 = new DigitalVideoDisc(3, "The Dark Knight", "Action", 14.99f, 152, "Christopher Nolan");

        CompactDisc cd1 = new CompactDisc(4, "Thriller", "Pop", 12.99f, "John Landis", "Michael Jackson");
        cd1.addTrack(new Track("Wanna Be Startin' Somethin'", 363));
        cd1.addTrack(new Track("Thriller", 358));
        cd1.addTrack(new Track("Beat It", 258));

        Book book1 = new Book(5, "Clean Code", "Technology", 29.99f);
        book1.addAuthor("Robert C. Martin");

        Book book2 = new Book(6, "Effective Java", "Technology", 34.99f);
        book2.addAuthor("Joshua Bloch");

        store.addMedia(dvd1);
        store.addMedia(dvd2);
        store.addMedia(dvd3);
        store.addMedia(cd1);
        store.addMedia(book1);
        store.addMedia(book2);

        // Open Store Screen
        new StoreScreen(store, cart);
    }
}
