package LAB03;
public class Cart {
    public static final int MAX_NUMBERS_ORDERED = 20;

    private DigitalVideoDisc[] itemsOrdered = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
    private int qtyOrdered = 0;

    // ================= ADD =================

    // 1. Add 1 DVD
    public void addDigitalVideoDisc(DigitalVideoDisc disc) {
        if (qtyOrdered < MAX_NUMBERS_ORDERED) {
            itemsOrdered[qtyOrdered] = disc;
            qtyOrdered++;
            System.out.println("The disc has been added");
        } else {
            System.out.println("The cart is full");
        }
    }

    // 2. Add 2 DVDs
    public void addDigitalVideoDisc(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2) {
        addDigitalVideoDisc(dvd1);
        addDigitalVideoDisc(dvd2);
    }

    // 3. Add array of DVDs
    public void addDigitalVideoDisc(DigitalVideoDisc[] dvdList) {
        for (DigitalVideoDisc dvd : dvdList) {
            if (dvd != null) {
                addDigitalVideoDisc(dvd);
            }
        }
    }

    // 4. Add multiple DVDs (varargs)
    public void addDigitalVideoDisc(DigitalVideoDisc... dvds) {
        for (DigitalVideoDisc dvd : dvds) {
            if (dvd != null) {
                addDigitalVideoDisc(dvd);
            }
        }
    }

    // ================= REMOVE =================

    public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
        boolean found = false;

        for (int i = 0; i < qtyOrdered; i++) {
            if (itemsOrdered[i] == disc) {
                found = true;

                // shift left
                for (int j = i + 1; j < qtyOrdered; j++) {
                    itemsOrdered[j - 1] = itemsOrdered[j];
                }

                itemsOrdered[qtyOrdered - 1] = null; // clear
                qtyOrdered--;

                System.out.println("The disc has been removed");
                break;
            }
        }

        if (!found) {
            System.out.println("The disc was not found");
        }
    }

    // ================= TOTAL COST =================

    public double totalCost() {
        double sum = 0;

        for (int i = 0; i < qtyOrdered; i++) {
            sum += itemsOrdered[i].getCost();
        }

        return sum;
    }
}