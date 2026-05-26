package hust.soict.hedspi.aims;

import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.exception.LimitExceededException;
import hust.soict.hedspi.aims.exception.PlayerException;
import hust.soict.hedspi.aims.media.*;
import hust.soict.hedspi.aims.store.Store;

import java.util.Scanner;

public class Aims {

    private static Store store = new Store();
    private static Cart cart = new Cart();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // Seed some data
        seedStore();

        boolean running = true;
        while (running) {
            showMenu();
            int choice = readInt();
            switch (choice) {
                case 1: viewStore(); break;
                case 2: updateStore(); break;
                case 3: seeCart(); break;
                case 0: running = false; System.out.println("Goodbye!"); break;
                default: System.out.println("Invalid choice.");
            }
        }
    }

    // ─── Menus ───────────────────────────────────────────────

    public static void showMenu() {
        System.out.println("\nAIMS: ");
        System.out.println("--------------------------------");
        System.out.println("1. View store");
        System.out.println("2. Update store");
        System.out.println("3. See current cart");
        System.out.println("0. Exit");
        System.out.println("--------------------------------");
        System.out.print("Please choose a number: 0-1-2-3: ");
    }

    public static void storeMenu() {
        System.out.println("\nOptions: ");
        System.out.println("--------------------------------");
        System.out.println("1. See a media's details");
        System.out.println("2. Add a media to cart");
        System.out.println("3. Play a media");
        System.out.println("4. See current cart");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.print("Please choose a number: 0-1-2-3-4: ");
    }

    public static void mediaDetailsMenu() {
        System.out.println("\nOptions: ");
        System.out.println("--------------------------------");
        System.out.println("1. Add to cart");
        System.out.println("2. Play");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.print("Please choose a number: 0-1-2: ");
    }

    public static void cartMenu() {
        System.out.println("\nOptions: ");
        System.out.println("--------------------------------");
        System.out.println("1. Filter medias in cart");
        System.out.println("2. Sort medias in cart");
        System.out.println("3. Remove media from cart");
        System.out.println("4. Play a media");
        System.out.println("5. Place order");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.print("Please choose a number: 0-1-2-3-4-5: ");
    }

    // ─── View Store ──────────────────────────────────────────

    private static void viewStore() {
        store.print();
        boolean back = false;
        while (!back) {
            storeMenu();
            int choice = readInt();
            switch (choice) {
                case 1: seeMediaDetails(); break;
                case 2: addMediaToCart(); break;
                case 3: playMediaFromStore(); break;
                case 4: cart.print(); break;
                case 0: back = true; break;
                default: System.out.println("Invalid choice.");
            }
        }
    }

    private static void seeMediaDetails() {
        System.out.print("Enter media title: ");
        String title = scanner.nextLine().trim();
        Media media = store.searchByTitle(title);
        if (media == null) {
            System.out.println("Media not found.");
            return;
        }
        System.out.println("\n" + media.toString());

        boolean back = false;
        while (!back) {
            mediaDetailsMenu();
            int choice = readInt();
            switch (choice) {
                case 1:
                    try {
                        cart.addMedia(media);
                    } catch (LimitExceededException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 2:
                    if (media instanceof Playable) {
                        try {
                            ((Playable) media).play();
                        } catch (PlayerException e) {
                            System.out.println(e.getMessage());
                        }
                    } else {
                        System.out.println("This media type cannot be played.");
                    }
                    break;
                case 0:
                    back = true;
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    private static void addMediaToCart() {
        System.out.print("Enter media title to add to cart: ");
        String title = scanner.nextLine().trim();
        Media media = store.searchByTitle(title);
        if (media == null) {
            System.out.println("Media not found.");
        } else {
            try {
                cart.addMedia(media);
                System.out.println("Cart now has " + cart.getItemsOrdered().size() + " item(s).");
            } catch (LimitExceededException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static void playMediaFromStore() {
        System.out.print("Enter media title to play: ");
        String title = scanner.nextLine().trim();
        Media media = store.searchByTitle(title);
        if (media == null) {
            System.out.println("Media not found.");
        } else if (media instanceof Playable) {
            try {
                ((Playable) media).play();
            } catch (PlayerException e) {
                System.out.println(e.getMessage());
            }
        } else {
            System.out.println("This media type cannot be played.");
        }
    }

    // ─── Update Store ─────────────────────────────────────────

    private static void updateStore() {
        System.out.println("\n1. Add media to store");
        System.out.println("2. Remove media from store");
        System.out.print("Choose: ");
        int choice = readInt();
        if (choice == 1) {
            System.out.println("Choose type: 1. DVD  2. CD  3. Book");
            int type = readInt();
            if (type == 1) addDVDToStore();
            else if (type == 2) addCDToStore();
            else if (type == 3) addBookToStore();
        } else if (choice == 2) {
            System.out.print("Enter title of media to remove: ");
            String title = scanner.nextLine().trim();
            Media media = store.searchByTitle(title);
            if (media == null) System.out.println("Media not found.");
            else store.removeMedia(media);
        }
    }

    private static void addDVDToStore() {
        System.out.print("ID: "); int id = readInt();
        System.out.print("Title: "); String title = scanner.nextLine().trim();
        System.out.print("Category: "); String category = scanner.nextLine().trim();
        System.out.print("Director: "); String director = scanner.nextLine().trim();
        System.out.print("Length (mins): "); int length = readInt();
        System.out.print("Cost: "); float cost = readFloat();
        store.addMedia(new DigitalVideoDisc(id, title, category, cost, length, director));
    }

    private static void addCDToStore() {
        System.out.print("ID: "); int id = readInt();
        System.out.print("Title: "); String title = scanner.nextLine().trim();
        System.out.print("Category: "); String category = scanner.nextLine().trim();
        System.out.print("Artist: "); String artist = scanner.nextLine().trim();
        System.out.print("Director: "); String director = scanner.nextLine().trim();
        System.out.print("Cost: "); float cost = readFloat();
        store.addMedia(new CompactDisc(id, title, category, cost, director, artist));
    }

    private static void addBookToStore() {
        System.out.print("ID: "); int id = readInt();
        System.out.print("Title: "); String title = scanner.nextLine().trim();
        System.out.print("Category: "); String category = scanner.nextLine().trim();
        System.out.print("Cost: "); float cost = readFloat();
        Book book = new Book(id, title, category, cost);
        System.out.print("How many authors? "); int n = readInt();
        for (int i = 0; i < n; i++) {
            System.out.print("Author " + (i + 1) + ": ");
            book.addAuthor(scanner.nextLine().trim());
        }
        store.addMedia(book);
    }

    // ─── Cart ─────────────────────────────────────────────────

    private static void seeCart() {
        cart.print();
        boolean back = false;
        while (!back) {
            cartMenu();
            int choice = readInt();
            switch (choice) {
                case 1: filterCart(); break;
                case 2: sortCart(); break;
                case 3: removeFromCart(); break;
                case 4: playFromCart(); break;
                case 5: placeOrder(); break;
                case 0: back = true; break;
                default: System.out.println("Invalid choice.");
            }
        }
    }

    private static void filterCart() {
        System.out.println("Filter by: 1. ID   2. Title");
        int opt = readInt();
        if (opt == 1) {
            System.out.print("Enter ID: ");
            int id = readInt();
            Media m = cart.searchById(id);
            System.out.println(m != null ? m.toString() : "Not found.");
        } else {
            System.out.print("Enter title: ");
            String title = scanner.nextLine().trim();
            Media m = cart.searchByTitle(title);
            System.out.println(m != null ? m.toString() : "Not found.");
        }
    }

    private static void sortCart() {
        System.out.println("Sort by: 1. Title then Cost   2. Cost then Title");
        int opt = readInt();
        if (opt == 1) cart.sortByTitleCost();
        else cart.sortByCostTitle();
        cart.print();
    }

    private static void removeFromCart() {
        System.out.print("Enter title of media to remove: ");
        String title = scanner.nextLine().trim();
        Media media = cart.searchByTitle(title);
        if (media == null) System.out.println("Media not found in cart.");
        else cart.removeMedia(media);
    }

    private static void playFromCart() {
        System.out.print("Enter title of media to play: ");
        String title = scanner.nextLine().trim();
        Media media = cart.searchByTitle(title);
        if (media == null) System.out.println("Media not found in cart.");
        else if (media instanceof Playable) {
            try {
                ((Playable) media).play();
            } catch (PlayerException e) {
                System.out.println(e.getMessage());
            }
        }
        else System.out.println("This media cannot be played.");
    }

    private static void placeOrder() {
        System.out.println("Order placed successfully! Your cart has been cleared.");
        cart.clear();
    }

    // ─── Helpers ─────────────────────────────────────────────

    private static int readInt() {
        try {
            int val = Integer.parseInt(scanner.nextLine().trim());
            return val;
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    private static float readFloat() {
        try {
            return Float.parseFloat(scanner.nextLine().trim());
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    private static void seedStore() {
        DigitalVideoDisc dvd = new DigitalVideoDisc(1, "Inception", "Sci-Fi", 9.99f, 148, "Nolan");
        DigitalVideoDisc dvd2 = new DigitalVideoDisc(2, "Avatar", "Action", 7.99f, 162, "Cameron");

        CompactDisc cd = new CompactDisc(3, "Thriller", "Pop", 12.99f, "Landis", "Michael Jackson");
        cd.addTrack(new Track("Wanna Be Startin' Somethin'", 363));
        cd.addTrack(new Track("Thriller", 358));
        cd.addTrack(new Track("Beat It", 258));

        Book book = new Book(4, "Clean Code", "Technology", 29.99f);
        book.addAuthor("Robert C. Martin");

        Book book2 = new Book(5, "Effective Java", "Technology", 34.99f);
        book2.addAuthor("Joshua Bloch");

        store.addMedia(dvd);
        store.addMedia(dvd2);
        store.addMedia(cd);
        store.addMedia(book);
        store.addMedia(book2);
    }
}