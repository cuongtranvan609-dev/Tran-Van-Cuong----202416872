package LAB03;

public class Store {
    private static final int MAX_ITEMS_IN_STORE = 50;

    private DigitalVideoDisc[] itemsInStore = new DigitalVideoDisc[MAX_ITEMS_IN_STORE];
    private int qtyInStore = 0;

    // ================= ADD =================
    public void addDVD(DigitalVideoDisc disc) {
        if (qtyInStore < MAX_ITEMS_IN_STORE) {
            itemsInStore[qtyInStore] = disc;
            qtyInStore++;
            System.out.println("DVD has been added to store");
        } else {
            System.out.println("Store is full");
        }
    }

    // ================= REMOVE =================
    public void removeDVD(DigitalVideoDisc disc) {
        boolean found = false;

        for (int i = 0; i < qtyInStore; i++) {
            if (itemsInStore[i] == disc) {
                found = true;

                for (int j = i + 1; j < qtyInStore; j++) {
                    itemsInStore[j - 1] = itemsInStore[j];
                }

                itemsInStore[qtyInStore - 1] = null;
                qtyInStore--;

                System.out.println("DVD has been removed from store");
                break;
            }
        }

        if (!found) {
            System.out.println("DVD not found in store");
        }
    }
}