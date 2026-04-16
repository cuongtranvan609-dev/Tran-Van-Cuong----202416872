package LAB03;

public class StoreTest {
    public static void main(String[] args) {
        Store store = new Store();

        DigitalVideoDisc dvd1 = new DigitalVideoDisc("A");
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("B");

        // Test add
        store.addDVD(dvd1);
        store.addDVD(dvd2);

        // Test remove
        store.removeDVD(dvd1);
        store.removeDVD(dvd2);
    }
}